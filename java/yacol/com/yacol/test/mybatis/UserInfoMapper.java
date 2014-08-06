package com.yacol.test.mybatis;

public interface UserInfoMapper {

	public UserInfoBean selectOne(String userId) ;
	
	public void insert(UserInfoBean bean) ;
	
	public void insertSelective(UserInfoBean bean) ;
}
