package com.nfl.guiceTest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.nfl.guiceTest.service.LogService;
import com.nfl.guiceTest.service.UserService;

@Singleton
public class UserServiceImpl implements UserService {

	private LogService logService;

	private LogService logService2;

	@Inject
	public UserServiceImpl(LogService logService) {
		this.logService = logService;
	}

	@Inject
	public void aa(LogService logService) {
		this.logService2 = logService;
	}

	@Override
	public void process() {
		System.out.println(logService);
		System.out.println(logService2);
		System.out.println("我需要做一些业务逻辑");
	}
}
