package com.welvx.intercity.service.impl;

import com.welvx.intercity.dao.ScheduleDao;
import com.welvx.intercity.entity.Schedule;
import com.welvx.intercity.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleDao.saveSchedule(schedule);
    }

    @Override
    public List<Schedule> findReleased(String startCity, String aimCity) {
        return scheduleDao.findReleased(startCity,aimCity);
    }

    @Override
    public List<Schedule> findPeripheral(String startCity) {
        return scheduleDao.findPeripheral(startCity);
    }

    @Override
    public boolean modifySchedule(Schedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public void scrapSchedule(String id) {
        Schedule schedule=scheduleDao.findById(id);
        schedule.setStatus(1);
        modifySchedule(schedule);
    }

    @Override
    public void cancelSchedule(String id) {
        scheduleDao.deleteById(id);
    }

    @Override
    public List<Schedule> findIssue(String userId) {
        return scheduleDao.findByUser(userId);
    }
}
