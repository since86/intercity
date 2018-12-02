package com.welvx.intercity.dao.impl;

import com.welvx.intercity.dao.UserDao;
import com.welvx.intercity.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void saveUser() {
        UserEntity user=new UserEntity();
        user.setUsername("ddf");
        user.setPassword("123456");
        userDao.saveUser(user);
    }

    @Test
    public void findUserByUserName() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUserById() {
    }
}