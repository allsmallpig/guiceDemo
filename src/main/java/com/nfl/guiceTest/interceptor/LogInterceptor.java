package com.nfl.guiceTest.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 日志拦截器，MethodInterceptor是aop联盟提供的拦截器api
 * 
 * @author 网络
 *
 */
public class LogInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("log something when " + invocation.getMethod().getName() + " invoked.");
		Object[] args = invocation.getArguments();
		for (Object arg : args) {
			System.out.println("[Argument:" + arg.toString() + "]");
		}

		return invocation.proceed();
	}
}
