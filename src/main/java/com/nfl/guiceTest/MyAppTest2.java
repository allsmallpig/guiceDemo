package com.nfl.guiceTest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nfl.guiceTest.service.impl.BizService;

/**
 * @author flnie
 *
 */
public class MyAppTest2 {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new LogModule());
		BizService service = injector.getInstance(BizService.class);
		service.doBiz();
		service.doBar();
		service.doFoo();
		service.doSomethingWithParams("this is a param");
		// 因为被代理的类没有实现接口，故使用cglib api生成代理，否则会使用JDK api生成代理
		// class
		// com.nfl.guiceTest.service.impl.BizService$$EnhancerByGuice$$37f61b07
		System.out.println(service.getClass());
	}
}
