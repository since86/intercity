package com.welvx.intercity.controller;

import com.welvx.intercity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public List find(@PathVariable String name){
        List users=userService.findByName(name);
        return users;
    }

    @GetMapping("/")
    public List findAll(){
        List users=userService.findAll();
        return users;
    }
}
