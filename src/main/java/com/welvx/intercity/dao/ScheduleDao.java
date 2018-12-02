package com.welvx.intercity.dao;


import com.welvx.intercity.entity.Schedule;

import java.util.List;

public interface ScheduleDao {
    /**
     * 保存发布信息
     * @param schedule
     */
    public void saveSchedule(Schedule schedule);

    /**
     * 更新发布信息
     * @param schedule
     * @return
     */
    public boolean updateSchedule(Schedule schedule);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public Schedule findById(String id);

    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    public List<Schedule> findByUser(String userId);

    /**
     * 根据行程查询
     * @return
     */
    public List<Schedule> findReleased(String startCity,String aimCity);

    /**
     * 查询周边
     * @param startCity
     * @return
     */
    public List<Schedule> findPeripheral(String startCity);

    /**
     * 删除发布信息
     * @param id
     */
    public void deleteById(String id);

}
