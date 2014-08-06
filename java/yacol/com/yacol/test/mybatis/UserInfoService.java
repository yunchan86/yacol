package com.yacol.test.mybatis;

public class UserInfoService {

	private UserInfoMapper userMapper ;
	
	public UserInfoBean get(String userId) {
		UserInfoBean bean = this.userMapper.selectOne(userId) ;
		return bean ;
	}
	
	public String doInsert(UserInfoBean bean) {
		String result = "-1" ;
		this.userMapper.insert(bean);
		result = "0" ;
		return result ;
	}

	public UserInfoMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserInfoMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
}
