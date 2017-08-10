/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��3��28��
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
 * @since 2017��3��28�� ����12:00:32
 * @version   
 */
public interface UserDao {

	/**
	 * ��������û�
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * ͨ��id�����û�
	 * @param id
	 */
	User findUserById(Integer id);
	
	/**
	 * ��ȡ�����û�id
	 * @return
	 */
	Integer getMaxUserId();
	
	/**
	 * ͨ��name�����û�
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
	
	/**
	 * ��ȡ�û�����ƺ�
	 * @param roleId
	 * @return
	 */
	String findUserRoleName(Integer roleId);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * ���������û�
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * ɾ���û�
	 * @param userId
	 */
	void deleteUserByUserId(Integer userId);
}
