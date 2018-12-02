package com.welvx.intercity.dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.welvx.intercity.dao.ScheduleDao;
import com.welvx.intercity.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleDaoImpl implements ScheduleDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveSchedule(Schedule schedule) {
        mongoTemplate.save(schedule);
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        Query query=new Query(Criteria.where("scheduleId").is(schedule.getScheduleId()));
        Update update= new Update().set("departure",schedule.getDeparture())
                .set("destination",schedule.getDestination())
                .set("startCity", schedule.getStartCity())
                .set("aimCity", schedule.getAimCity())
                .set("scheduleTime",schedule.getScheduleTime())
                .set("editTime",schedule.getEditTime())
                .set("seat",schedule.getSeat())
                .set("status",schedule.getStatus())
                .set("remark",schedule.getRemark());
        UpdateResult result=mongoTemplate.updateFirst(query,update,Schedule.class);
        return result.isModifiedCountAvailable();
    }

    @Override
    public Schedule findById(String id) {
        Query query=new Query(Criteria.where("ScheduleId").is(id));
        Schedule schedule=mongoTemplate.findOne(query,Schedule.class);
        return schedule;
    }

    @Override
    public List<Schedule> findByUser(String userId) {
        Query query=new Query(Criteria.where("userId").is(userId));
        List<Schedule> schedules=mongoTemplate.find(query,Schedule.class);
        return schedules;
    }

    @Override
    public List<Schedule> findReleased(String startCity, String aimCity) {
        Criteria criteria=new Criteria().andOperator(Criteria.where("startCity").regex(startCity),Criteria.where("aimCity").regex(aimCity),Criteria.where("status").is(0));
        Query query=new Query();
        query.addCriteria(criteria);
        List<Schedule> schedules=mongoTemplate.find(query,Schedule.class);
        return schedules;
    }

    @Override
    public List<Schedule> findPeripheral(String startCity) {
        Query query=new Query(Criteria.where("startCity").regex(startCity));
        List<Schedule> schedules=mongoTemplate.find(query,Schedule.class);
        return schedules;
    }

    @Override
    public void deleteById(String id) {
        Query query=new Query(Criteria.where("scheduleId").is(id));
        mongoTemplate.remove(query,Schedule.class);
    }
}
