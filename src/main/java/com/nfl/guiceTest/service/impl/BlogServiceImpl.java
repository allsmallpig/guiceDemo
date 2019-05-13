package com.nfl.guiceTest.service.impl;

import javax.inject.Inject;

import com.nfl.guiceTest.service.BlogService;
import com.nfl.guiceTest.service.LogService;

public class BlogServiceImpl implements BlogService {

	@Inject
	private LogService logService;

	@Override
	public void add() {
		System.out.println("BlogServiceImpl：" + logService);
		System.out.println("------新增博客");
	}
}
