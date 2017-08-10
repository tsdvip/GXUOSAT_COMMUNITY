/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月29日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.controller
 * IndexController.java
 */
package com.tsdvip.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsdvip.dao.UserDao;
import com.tsdvip.entity.User;
import com.tsdvip.service.BoardService;
import com.tsdvip.service.PostService;
import com.tsdvip.service.UserService;
import com.tsdvip.util.JsonResult;


/**
 * 用户登录注册
 * @author tanshangdong
 * @since 2017年3月29日 上午10:49:21
 * @version   
 */
@Controller
@RequestMapping("/user")
public class UserController  extends AbstractController{

	@Resource
	private BoardService boardService;
	@Resource
	private UserService userService;
	@Resource
	private PostService postService;
	@Resource
	private UserDao userDao;
	
	@RequestMapping("/reg.do")
	public String goReg(Model model){
		
		model.addAttribute("view", "page_view/userReg");
		return "indexPage";
		
	}
	
	@RequestMapping("/regSave.do")
	public ModelAndView regSave(User user){
		ModelAndView model = new ModelAndView("indexPage");
		model.addObject("view", "page_view/regMessage");
		String reg = "^\\w{2,10}$";
		
		if(user.getUserName() == null || user.getNickname().isEmpty()){
			model.addObject("message", "注册失败！用户名不能为空！");
		}
		else if(!user.getUserName().matches(reg)){
			model.addObject("message", "注册失败！名字不符合规则！");
		}
		else if(user.getPhone() == null || user.getPhone().isEmpty()){
			model.addObject("message", "注册失败！手机号码不能为空！");
		}
		else if(user.getNickname() == null || user.getNickname().isEmpty()){
			model.addObject("message", "注册失败！昵称不能为空！");
		}
		else if(user.getEmail() == null || user.getEmail().isEmpty()){
			model.addObject("message", "注册失败！邮箱不能为空！");
		}else{
			int maxUserId = userService.getMaxUserId();
			user.setUserId(maxUserId+1);
			user.setRoleId(3);
			userService.saveUser(user);
			model.addObject("message", "注册成功！请登录！");
			model.addObject("state","success");
		}
		
		return model;
		
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<User> login(String name,String password){
		
			User user = userService.login(name, password);
			return new JsonResult<User>(user);
	}
	
	@RequestMapping("/getInfo.do")
	public ModelAndView getInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("indexPage");
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("userId")){
				userId = cookies[i].getValue();
			}
		}
		if(userId != null ){
			User user = userService.findUser(Integer.valueOf(userId));
			String roleName = userDao.findUserRoleName(user.getRoleId());
			mav.addObject("roleName", roleName);
			mav.addObject("user", user);
			mav.addObject("view", "page_view/userInfo");
		}
		return mav;
		
	}
	
	/**
	 * 去到编辑用户信息页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toEditInfo.do")
	public ModelAndView toEditInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("indexPage");
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("userId")){
				userId = cookies[i].getValue();
			}
		}
		if(userId != null ){
			User user = userService.findUser(Integer.valueOf(userId));
			mav.addObject("user", user);
			mav.addObject("view", "page_view/editUserInfo");
		}
		return mav;
		
	}
	
	/**
	 * 编辑用户资料
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/editInfo.do")
	@ResponseBody
	public JsonResult<String> editInfo(HttpServletRequest request,HttpServletResponse response){
		
		return userService.editUserInfo(request);
	}
	
}
