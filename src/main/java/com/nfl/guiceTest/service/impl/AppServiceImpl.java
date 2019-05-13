package com.nfl.guiceTest.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
//import com.google.inject.Inject;
//import com.google.inject.name.Named;
import com.nfl.guiceTest.service.AppService;
import com.nfl.guiceTest.service.LogService;
import com.nfl.guiceTest.service.UserService;

/**
 * Guice官方推荐我们首选JSR-330标准的注解
 *
 */
public class AppServiceImpl implements AppService {

	private UserService userService;

	private LogService logService;

	@Inject
	@Named("myPort")
	private String port;

	private int age;

	@Inject
	public void setAge(@Named("myAge") int age) {
		this.age = age;
	}

	private int height;

	@Inject
	public void setHeight(@Named("myHeight") int height) {
		this.height = height;
	}

	@Inject
	public AppServiceImpl(UserService userService, LogService logService) {
		this.userService = userService;
		this.logService = logService;
	}

	@Override
	public void work() {
		System.out.println("端口：" + port);
		System.out.println("年龄：" + age);
		System.out.println("身高：" + height);
		userService.process();
		logService.log("程序正常运行");
	}
}
