/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * UserDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.User;


/**
 * 
 * @author tanshangdong
 * @since 2017年3月28日 下午12:00:32
 * @version   
 */
public interface UserDao {

	/**
	 * 保存添加用户
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * 通过id查找用户
	 * @param id
	 */
	User findUserById(Integer id);
	
	/**
	 * 获取最大的用户id
	 * @return
	 */
	Integer getMaxUserId();
	
	/**
	 * 通过name查找用户
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
	
	/**
	 * 获取用户级别称呼
	 * @param roleId
	 * @return
	 */
	String findUserRoleName(Integer roleId);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 删除用户
	 * @param userId
	 */
	void deleteUserByUserId(Integer userId);
}
