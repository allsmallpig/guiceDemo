package com.nfl.guiceTest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.nfl.guiceTest.service.LogService;
import com.nfl.guiceTest.service.UserService;

@Singleton
public class LogServiceImpl implements LogService {

    private UserService userService;

    @Inject
    public LogServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void log(String msg) {
        System.out.println(this.userService);
        System.out.println("------LOG:" + msg);
    }
}
