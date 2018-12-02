package com.welvx.intercity.controller;


import com.welvx.intercity.entity.User;
import com.welvx.intercity.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api("swaggerController")
@RestController
@RequestMapping(value = "/api/")
public class SwaggerController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "桔合旅行",notes = "获取用户信息")
    @GetMapping(value = "users")
    public List<User> getList(){
        List  users=userService.findAll();
        return users;
    }

    @ApiOperation(value = "桔合旅行",notes = "根据用户姓名获取用户信息")
    @GetMapping(value = "user/{name}")
    public List<User> getUsers(@PathVariable String name){
        List  users=userService.findByName(name);
        return users;
    }
}
