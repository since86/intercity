package com.welvx.intercity.dao;

import com.welvx.intercity.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public void saveUser(UserEntity user);

    public List<UserEntity> findUserByUserName(String username);

    public boolean updateUser(UserEntity user);

    public void deleteUserById(Long id);

    public List<UserEntity> findAll();
}
