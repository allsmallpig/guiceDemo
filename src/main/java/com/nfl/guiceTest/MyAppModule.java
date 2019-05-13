package com.nfl.guiceTest;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.nfl.guiceTest.service.AppService;
import com.nfl.guiceTest.service.LogService;
import com.nfl.guiceTest.service.UserService;
import com.nfl.guiceTest.service.impl.LogServiceImpl;
import com.nfl.guiceTest.service.impl.AppServiceImpl;
import com.nfl.guiceTest.service.impl.UserServiceImpl;

/**
 * <p>
 * 模块的支持类，它减少了重复，并使配置更易于阅读。只需扩展com.google.inject.AbstractModule，
 * </p>
 * <p>
 * 实现configure()，并调用继承的方法来镜像活页夹中的那些方法。例如：
 * </p>
 * 
 * <pre>
 * public class MyModule extends AbstractModule {
 * 	protected void configure() {
 * 		bind(Service.class).to(ServiceImpl.class).in(Singleton.class);
 * 		bind(CreditCardPaymentService.class);
 * 		bind(PaymentService.class).to(CreditCardPaymentService.class);
 * 		bindConstant().annotatedWith(Names.named("port")).to(8080);
 * 	}
 * }
 * </pre>
 */
public class MyAppModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LogService.class).to(LogServiceImpl.class);
		bind(UserService.class).to(UserServiceImpl.class);
		bind(AppService.class).to(AppServiceImpl.class);
		bind(String.class).annotatedWith(Names.named("myPort")).toInstance("8080");
		bind(int.class).annotatedWith(Names.named("myAge")).toInstance(18);
		bind(Integer.class).annotatedWith(Names.named("myHeight")).toInstance(199);
	}
}
