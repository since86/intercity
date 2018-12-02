package com.welvx.intercity.controller;

import com.welvx.intercity.entity.Geom;
import com.welvx.intercity.entity.Result;
import com.welvx.intercity.entity.UserEntity;
import com.welvx.intercity.enums.ResultEnum;
import com.welvx.intercity.service.UserService;
import com.welvx.intercity.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "")
    public String index() {
        return "Hello intercity";
    }

    @RequestMapping(value = "/add")
    public String add() {
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setUsername("demo" + i);
            user.setPassword("123456");
            userService.saveUser(user);
        }
        return "添加结束！";
    }

    @RequestMapping(value = "/find/{name}")
    public List<UserEntity> find(@PathVariable("name") String name) {
        List<UserEntity> users = userService.findByName(name);
        return users;
    }

    @PostMapping(value = "/user/reg")
    public Result<UserEntity> registerUser(@Valid UserEntity userEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.result(ResultEnum.UNKONW_ERROR);
        }
        userService.saveUser(userEntity);
        return ResultUtil.result(ResultEnum.SUCCESS, userEntity);
    }

    @RequestMapping(value = "/all")
    public List<UserEntity> find() {
        return userService.findAll();
    }

    @RequestMapping(value = "/update")
    public String update() {
        List<UserEntity> users = userService.findByName("jack");
        UserEntity user = users.get(0);
        System.out.println(user);
        user.setUsername("修改过的");
        user.setPassword("55555555");
        boolean b = userService.update(user);
        System.out.println(user);
        return b ? "修改成功！" : "失败";
    }

}
