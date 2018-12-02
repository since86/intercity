package com.welvx.intercity.service;

import com.welvx.intercity.dao.UserDao;
import com.welvx.intercity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserDao userDao;

    public void saveUser(UserEntity user){
        userDao.saveUser(user);
    }

    public List<UserEntity> findByName(String name){
        return userDao.findUserByUserName(name);
    }

    public List<UserEntity> findAll(){
        return userDao.findAll();
    }

    public boolean update(UserEntity user){
        return userDao.updateUser(user);
    }
}
