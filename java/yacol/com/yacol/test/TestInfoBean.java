package com.yacol.test;

public class TestInfoBean {

	private String userName ;
	private String password ;
	private TestBean tbean ;
	
	public TestInfoBean(String userName,String password,TestBean tbean){
		this.userName = userName ;
		this.password = password ;
		this.tbean = tbean ;
	}
	public TestInfoBean() {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TestBean getTbean() {
		return tbean;
	}
	public void setTbean(TestBean tbean) {
		this.tbean = tbean;
	}
	
	
}
