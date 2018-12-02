package com.welvx.intercity.service;

import com.welvx.intercity.entity.Schedule;
import com.welvx.intercity.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    public void saveSchedule(Schedule schedule);

    public List<Schedule> findReleased(String startCity, String aimCity);

    public List<Schedule> findPeripheral(String startCity);

    public boolean modifySchedule(Schedule schedule);

    public void scrapSchedule(String id);

    public void cancelSchedule(String id);

    public List<Schedule> findIssue(String userId);
}
