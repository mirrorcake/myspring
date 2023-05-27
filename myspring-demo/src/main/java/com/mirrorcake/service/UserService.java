package com.mirrorcake.service;

import com.mirrorcake.myspring.ioc.annotation.Component;

@Component
public class UserService {

    public void getUser(){
        System.out.println("get user");
    }
}
