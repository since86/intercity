package com.welvx.intercity.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "coll_user")
public class User implements Serializable {
    private Long id;
    private String userName;
    private String passWord;
}
