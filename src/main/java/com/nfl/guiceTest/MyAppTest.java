package com.nfl.guiceTest;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nfl.guiceTest.service.AppService;
import com.nfl.guiceTest.service.BlogService;
import com.nfl.guiceTest.service.impl.BlogServiceImpl;

/**
 * <p>
 * 术语
 * </p>
 * <p>
 * Guice：整个框架的门面
 * </p>
 * <p>
 * Injector：一个依赖的管理上下文
 * </p>
 * <p>
 * Binder：一个接口和实现的绑定
 * </p>
 * <p>
 * Module：一组Binder
 * </p>
 * <p>
 * Provider：bean的提供者
 * </p>
 * <p>
 * Key：Binder中对应一个Provider
 * </p>
 * <p>
 * Scope：Provider的作用域
 * </p>
 * <p>
 * Stage：运行方式（为了不同的要求）
 * </p>
 * 
 * @see https://blog.csdn.net/cnhome/article/details/80627123
 * @see https://blog.csdn.net/zhaowen25/article/details/52927193
 */
public class MyAppTest {

	private static Injector injector;

	@BeforeClass
	public static void init() {
		injector = Guice.createInjector(new MyAppModule());
	}

	@Test
	public void testMyApp() {
		// 默认是原型模式
		AppService appServiceImpl = injector.getInstance(AppService.class);
		AppService appServiceImpl2 = injector.getInstance(AppService.class);
		System.out.println(appServiceImpl == appServiceImpl2);
		appServiceImpl.work();
		// 用一个已经有的实例，但依赖的对象为null，这时可以用injector注入依赖对象，但这个实例不会有绑定关系，
		// 所以如果其他有需要依赖这个实例的也无法注入这个实例
		BlogService blogService = new BlogServiceImpl();
		injector.injectMembers(blogService);
		blogService.add();
	}
}
