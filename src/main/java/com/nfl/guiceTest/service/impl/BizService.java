package com.nfl.guiceTest.service.impl;

import com.nfl.guiceTest.annotation.NeedLog;

/**
 * 此类将会被guice代理
 * 
 * @author 网络
 *
 */
public class BizService {

	@NeedLog
	public void doFoo() {
		System.out.println("do foo");
	}

	public void doBiz() {
		System.out.println("do biz");
	}

	@NeedLog
	public void doBar() {
		System.out.println("do bar");
	}

	@NeedLog
	public void doSomethingWithParams(String param) {
		System.out.println("do something with params: " + param);
	}
}
