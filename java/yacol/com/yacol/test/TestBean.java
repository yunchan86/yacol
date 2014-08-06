package com.yacol.test;

import java.util.Date;

public class TestBean {

	private int id;
	private String userId;
	private String userName ;
	private double point ;
	private Date insertTime ;
	
	public TestBean(){}
	public TestBean(int id,String userId,String userName,double point,Date insertTime) {
		this.id = id ;
		this.userId = userId ;
		this.userName = userName ;
		this.point = point ;
		this.insertTime = insertTime ;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	
	
}
