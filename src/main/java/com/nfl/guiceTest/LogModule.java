package com.nfl.guiceTest;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.nfl.guiceTest.annotation.NeedLog;
import com.nfl.guiceTest.interceptor.LogInterceptor;

/**
 * <p>
 * bindInterceptor方法有两个Matchers的参数，Matcher是一个简单的接口，用来表示是否匹配；在Guice
 * </p>
 * <p>
 * AOP中，需要两个Matcher：一个表示参与的类，另一个代表相关的方法。除any()外，Matchers还提供了
 * </p>
 * 如identicalTo、inPackage、inSubpackage等方法用来匹配，具体用法可参考这里。
 * 
 * @author 网络
 * @see https://blog.csdn.net/benweizhu/article/details/8069860 学习Guice aop
 * @see https://blog.csdn.net/u010834071/article/details/46710745 学习Guice aop
 */
public class LogModule extends AbstractModule {

	@Override
	protected void configure() {
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(NeedLog.class), new LogInterceptor());
	}
}
