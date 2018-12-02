package com.welvx.intercity.controller;

import com.welvx.intercity.entity.Result;
import com.welvx.intercity.entity.Schedule;
import com.welvx.intercity.enums.ResultEnum;
import com.welvx.intercity.service.ScheduleService;
import com.welvx.intercity.utils.DateConverterConfig;
import com.welvx.intercity.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/release")
    public Result<Schedule> releaseSchedule(@Valid Schedule schedule, BindingResult bindingResult){
        /**
         * 测试
         */
        if(schedule.getStartCity()==null||schedule.getAimCity()==null){
            return ResultUtil.result(ResultEnum.CITY_ERROR);
        }

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return ResultUtil.result(ResultEnum.UNKONW_ERROR,bindingResult.toString());
        }
        schedule.setEditTime(new Date());
        schedule.setStatus(0);
        if (schedule.getUserId() == null) {
            schedule.setUserId("admin");
        }

        scheduleService.saveSchedule(schedule);
        System.out.println(schedule.getEditTime());
        return ResultUtil.result(ResultEnum.SUCCESS);
    }

    @GetMapping("/adapter")
    public Result<Schedule> adapter(@RequestParam(value="startCity",required = true,defaultValue = "合肥") String startCity){
        List<Schedule> scheduleList=scheduleService.findPeripheral(startCity);
        System.out.println(scheduleList);
        return ResultUtil.result(ResultEnum.SUCCESS,scheduleList);
    }

    @GetMapping("/cancel/{scheduleId}")
    public Result<Schedule> scrapSchedule(@PathVariable("scheduleId") String scheduleId){
        scheduleService.cancelSchedule(scheduleId);
        return ResultUtil.result(ResultEnum.SUCCESS,"已删除");
    }

    @GetMapping("/issued")
    public Result<Schedule> issued(@RequestParam(value="userId",required = true,defaultValue = "admin") String userId){
        return ResultUtil.result(ResultEnum.SUCCESS,scheduleService.findIssue(userId));
    }
}
