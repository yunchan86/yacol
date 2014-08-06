package com.yacol.test;

import java.util.Date;

import com.yacol.reflect.YCReflect;

public class TestReflect {

	public void testSimpleBean() {
		TestBean tb = new TestBean(1,"chy1234","CHY",98.12,new Date()) ;
		Object o = null ;
		o = YCReflect.getProperty(tb, "insertTime") ;
		System.out.println(o);
		YCReflect.setProperty(tb, "userId", "您好");
		YCReflect.getMethodResult(tb, "setUserId","大家好") ;
		o = YCReflect.getMethodResult(tb, "getUserId") ;
		System.out.println(o);
	}
	public void testMultiBean() {
		TestBean tb = new TestBean(1,"chy1234","CHY",95,new Date()) ;
		TestInfoBean tibean = new TestInfoBean("chy","pwd134567",tb) ;
		Object o = YCReflect.getProperty(tibean, "tbean") ;
		System.out.println(o);
		TestBean tbo = (TestBean)o ;
		Object or = YCReflect.getProperty(tbo, "point") ;
		System.out.println(or);
	}
	public static void main(String[] args) {
		TestReflect tref = new TestReflect() ;
		tref.testSimpleBean();
		tref.testMultiBean();
	}

}
