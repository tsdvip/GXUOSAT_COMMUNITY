/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月12日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * UserService.java
 */
package com.tsdvip.service;



import javax.servlet.http.HttpServletRequest;


import com.tsdvip.entity.User;
import com.tsdvip.util.JsonResult;


/**
 * 
 * @author tanshangdong 
 * @since 2017年4月12日 下午7:42:30
 * @version   
 */
public interface UserService {

	/**
	 * 查找用户
	 * @return
	 */
	public User findUser(Integer id);
	
	/**
	 * 获取最大的用户id
	 * @return
	 */
	public Integer getMaxUserId();
	
	/**
	 * 保存用户
	 * @return
	 */
	public void saveUser(User user);
	
	User login(String name,String password) throws UserNameException,PasswordException;
	
	/**
	 * 编辑用户信息
	 * @param request
	 * @return
	 */
	JsonResult<String> editUserInfo(HttpServletRequest request);
}
