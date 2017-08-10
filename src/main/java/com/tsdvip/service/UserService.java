/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��12��
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
 * @since 2017��4��12�� ����7:42:30
 * @version   
 */
public interface UserService {

	/**
	 * �����û�
	 * @return
	 */
	public User findUser(Integer id);
	
	/**
	 * ��ȡ�����û�id
	 * @return
	 */
	public Integer getMaxUserId();
	
	/**
	 * �����û�
	 * @return
	 */
	public void saveUser(User user);
	
	User login(String name,String password) throws UserNameException,PasswordException;
	
	/**
	 * �༭�û���Ϣ
	 * @param request
	 * @return
	 */
	JsonResult<String> editUserInfo(HttpServletRequest request);
}
