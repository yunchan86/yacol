package com.yacol.test;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yacol.test.mybatis.UserInfoBean;
import com.yacol.test.mybatis.UserInfoService;

public class TestSpringMybatis {

	public void select() {
		BeanFactory factory = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		UserInfoService test = (UserInfoService)factory.getBean("userService");
		UserInfoBean cus = (UserInfoBean)test.get("12345678");
		System.out.println(cus);

	}
	
	public void insert() {
		BeanFactory factory = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		UserInfoService test = (UserInfoService)factory.getBean("userService");
		UserInfoBean ui = new UserInfoBean() ;
		ui.setInsertTime(new Date());
		ui.setPoint(10); 
		ui.setUserId("12345678");
		ui.setUserName("test");
		String result = test.doInsert(ui) ;
		System.out.println(result);

	}
	
	public static void main(String[] args) {
		TestSpringMybatis tsp = new TestSpringMybatis() ;
		tsp.select();
		//tsp.insert();
	}

}
