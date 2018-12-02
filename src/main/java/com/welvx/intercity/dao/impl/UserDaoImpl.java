package com.welvx.intercity.dao.impl;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import com.welvx.intercity.dao.UserDao;
import com.welvx.intercity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    public List<UserEntity> findUserByUserName(String username) {
        Query query=new Query(Criteria.where("username").is(username));
        //UserEntity user=mongoTemplate.findOne(query,UserEntity.class);
        List<UserEntity> users=mongoTemplate.find(query,UserEntity.class);
        return users;
    }

    @Override
    public boolean updateUser(UserEntity user) {
        Query query=new Query((Criteria.where("id").is(user.getId())));
        Update update= new Update().set("username", user.getUsername()).set("password", user.getPassword());
        UpdateResult result=mongoTemplate.updateFirst(query,update,UserEntity.class);
        return result.isModifiedCountAvailable();
    }

    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }

    @Override
    public List<UserEntity> findAll() {
        return mongoTemplate.findAll(UserEntity.class);
    }
}
