/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月12日
 * 
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * UserServiceImp.java
 */
package com.tsdvip.service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.tsdvip.dao.UserDao;
import com.tsdvip.entity.User;
import com.tsdvip.util.JsonResult;

/**
 * 
 * @author
 * @since 2017年4月12日 下午7:44:20
 * @version
 */
@Service("userService")
public class UserServiceImp implements UserService {

	@Resource
	UserDao userDao;

	public User findUser(Integer id) {
		return userDao.findUserById(id);
	}

	public Integer getMaxUserId() {
		return userDao.getMaxUserId();
	}

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public User login(String name, String password) throws UserNameException,
	        PasswordException {
		// 检验输入参数的合理性
		if (name == null || name.trim().isEmpty()) {
			throw new UserNameException("名字不能为空");
		}
		String reg = "^\\w{2,10}$";
		if (!name.matches(reg)) {
			throw new UserNameException("名字不符合规则");
		}
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("密码不能为空");
		}
		if (!password.matches(reg)) {
			throw new UserNameException("密码不符合规则");
		}
		// 查询用户数据
		User user = userDao.findUserByName(name);
		if (user == null) {
			throw new UserNameException("用户名错误");
		}
		// 比较摘要
		if (user.getPassword().equals(password)) {
			// 登录成功
			return user;
		}
		throw new PasswordException("密码错误");
	}

	public JsonResult<String> editUserInfo(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}
		if (userId == null) {
			return new JsonResult<String>("登录超时");
		}
		User user = userDao.findUserById(Integer.valueOf(userId));

		String oldPwd = request.getParameter("oldPwd");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String face = request.getParameter("face");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		if (!user.getPassword().equals(oldPwd)) {
			return new JsonResult<String>("密码错误！");
		}
		if (!password.isEmpty() && password != null) {
			user.setPassword(password);
		}
		if (!sex.isEmpty() && sex != null) {

			user.setSex(sex);
		}
		if (!face.isEmpty() && face != null) {
			user.setFace(face);

		}
		if (!nickname.isEmpty() && nickname != null) {
			user.setNickname(nickname);

		}
		if (!phone.isEmpty() && phone != null) {
			user.setPhone(phone);

		}
		if (!email.isEmpty() && email != null) {
			user.setEmail(email);

		}
		if (!address.isEmpty() && address != null) {
			user.setAddress(address);

		}
		userDao.updateUser(user);
		return new JsonResult<String>("success");
	}

}
