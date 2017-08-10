/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��23��
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.controller
 * AdminController.java
 */
package com.tsdvip.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsdvip.dao.BoardDao;
import com.tsdvip.dao.NoticeDao;
import com.tsdvip.dao.PostDao;
import com.tsdvip.dao.UserDao;
import com.tsdvip.entity.Notice;
import com.tsdvip.entity.User;
import com.tsdvip.service.AdminService;
import com.tsdvip.service.BoardService;
import com.tsdvip.service.PostService;
import com.tsdvip.service.UserService;
import com.tsdvip.util.DateUtil;
import com.tsdvip.util.JsonResult;


/**
 * ��̨����
 * @author tanshangdong
 * @since 2017��4��23�� ����2:13:14
 * @version   
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController{
	
	@Resource
	private UserService userService;
	
	@Resource
	private PostService postService;
	@Resource
	private AdminService adminService;
	@Resource
	private BoardService boardService;
	
	@Resource
	private UserDao userDao;
	@Resource
	private BoardDao boardDao;
	@Resource
	private PostDao postDao;
	@Resource
	private NoticeDao noticeDao;
	
	/**
	 * ����û��Ƿ���к�̨����Ȩ��
	 * @return
	 */
	@RequestMapping("/checkRoot.do")
	@ResponseBody
	public JsonResult<String> checkRoot(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("userId")){
				userId = cookies[i].getValue();
			}
		}
		//�ж��Ƿ��¼
		if(userId==null){
			return new JsonResult<String>("����Ȩ�޲��㣡");
		}
		
		User user = userService.findUser(Integer.valueOf(userId));
		//�ж��Ƿ�Ϊ����Ա
		if(user.getRoleId()!=1){
			return new JsonResult<String>("����Ȩ�޲��㣡");
		}
		return new JsonResult<String>("success");
	}
	
	/**
	 * ����ȥ����̨����ҳ��
	 * @return
	 */
	@RequestMapping("/toIndex.do")
	public ModelAndView toAdminIndex(){
		ModelAndView mav = new ModelAndView("page_admin/adminPage");
		return mav;
	}
	
	/**
	 * �û�����ҳ��
	 * @return
	 */
	@RequestMapping("/toUserManager.do")
	public ModelAndView toUserManager(){
		ModelAndView mav = new ModelAndView("page_admin/adminPage");
		List<Map<String,Object>> userList = adminService.getAllUser();
		mav.addObject("users", userList);
		mav.addObject("view", "userManager");
		return mav;
	}
	
	/**
	 * ɾ���û�
	 * @param userId
	 * @return
	 */
	@RequestMapping("/deleteUser.do")
	@ResponseBody
	public JsonResult<String> deleteUser(Integer userId){
		if(userId==null){
			return new JsonResult<String>("δ֪�������Ժ����ԣ�");
		}
		User user = userDao.findUserById(userId);
		if(user.getRoleId()==1){
			return new JsonResult<String>("��Ȩɾ������Ա��");
		}
		userDao.deleteUserByUserId(userId);
		return new JsonResult<String>("success");
	}
	
	/**
	 * ������ҳ��
	 * @return
	 */
	@RequestMapping("/toBoardManager.do")
	public ModelAndView toboardManager(){
		ModelAndView mav = new ModelAndView("page_admin/adminPage");
		List<Map<String,Object>> boardList = adminService.getAllBoards();
		mav.addObject("boards", boardList);
		mav.addObject("view", "boardManager");
		return mav;
	}
	
	/**
	 * ɾ�����
	 * @param boardId
	 * @return
	 */
	@RequestMapping("/deleteBoard.do")
	@ResponseBody
	public JsonResult<String> deleteBoard(Integer boardId){
		if(boardId==null){
			return new JsonResult<String>("δ֪�������Ժ����ԣ�");
		}
		adminService.deleteBoardByBoardId(boardId);
		
		return new JsonResult<String>("success");
	}
	
	/**
	 * ���ӹ������
	 * @return
	 */
	@RequestMapping("/toPostManager.do")
	public ModelAndView toPostManager(){
		ModelAndView mav = new ModelAndView("page_admin/adminPage");
		List<Map<String,Object>> postList = adminService.getAllPosts();
		mav.addObject("posts", postList);
		mav.addObject("view", "postManager");
		return mav;
	}
	
	/**
	 * ��̨����ɾ������
	 * @param postId
	 * @return
	 */
	@RequestMapping("/deletePost.do")
	@ResponseBody
	public JsonResult<String> deletePost(Integer postId){
		if(postId==null){
			return new JsonResult<String>("δ֪�������Ժ����ԣ�");
		}
		postService.deletePostById(postId);
		
		return new JsonResult<String>("success");
	}
	
	/**
	 * ������
	 * @param boardId
	 * @param boardName
	 * @param description
	 * @param masterName
	 * @return
	 */
	@RequestMapping("boardManager.do")
	@ResponseBody
	public JsonResult<String> boardManager(Integer boardId,String boardName,String description,String masterName){
		if(boardName.isEmpty() || boardName == null){
			return new JsonResult<String>("������Ʋ���Ϊ�գ�");
		}
		User user = userDao.findUserByName(masterName);
		if(user == null){
			return new JsonResult<String>("���ð������û��������ڣ�");
		}
		adminService.boardManager(boardId, user.getUserId(), boardName, description, masterName);
		return new JsonResult<String>("success");
	}
	
	/**
	 * ȥ������������
	 * @return
	 */
	@RequestMapping("/toNoticeManager.do")
	public ModelAndView toNoticeManager(){
		ModelAndView mav = new ModelAndView("page_admin/adminPage");
		List<Notice> noticeList = noticeDao.findAllNotice();
		mav.addObject("notices", noticeList);
		mav.addObject("view", "noticeManager");
		return mav;
	}
	
	/**
	 * ɾ������
	 * @param boardId
	 * @return
	 */
	@RequestMapping("/deleteNotice.do")
	@ResponseBody
	public JsonResult<String> deleteNotice(Integer noticeId){
		if(noticeId==null){
			return new JsonResult<String>("δ֪�������Ժ����ԣ�");
		}
		noticeDao.deleteNotice(noticeId);
		
		return new JsonResult<String>("success");
	}
	
	/**
	 * ������
	 * @param noticeId
	 * @param content
	 * @param ymd
	 * @return
	 */
	@RequestMapping("noticeManager.do")
	@ResponseBody
	public JsonResult<String> noticeManager(Integer noticeId,String content,String ymd){
		if(content.isEmpty() || content == null){
			return new JsonResult<String>("�������ݲ���Ϊ�գ�");
		}
		if(ymd.isEmpty() || ymd == null){
			return new JsonResult<String>("�������ڲ���Ϊ�գ�");
		}
		adminService.noticeManager(noticeId, content, ymd);
		return new JsonResult<String>("success");
	}
	
	/**
	 * ����ͳ��ҳ��
	 * @return
	 */
	@RequestMapping("/toPostCount.do")
	public ModelAndView toPostCount(String startDate,String endDate){
		ModelAndView mav = new ModelAndView("page_admin/adminPage");
		if(startDate==null || startDate.isEmpty()){
			endDate = DateUtil.getCureDateStr("yyyyMMdd");
			startDate = DateUtil.getMoveDay(endDate, -7, "yyyyMMdd");
		}else{
			startDate = DateUtil.getStrDate(DateUtil.getDate(startDate, "MM/dd/yyyy"), "yyyyMMdd");
			endDate = DateUtil.getStrDate(DateUtil.getDate(endDate, "MM/dd/yyyy"), "yyyyMMdd");
		}
		List<String> dates = DateUtil.getListBetweenDay(startDate, endDate, "yyyyMMdd");
		List<Integer> postNum = adminService.getPostNum(dates);
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		for(int i=0;i<dates.size();i++){
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("date", dates.get(i));
			dataMap.put("num", postNum.get(i));
			dataList.add(dataMap);
		}
		mav.addObject("datas",dataList);
		mav.addObject("dates", dates);
		mav.addObject("postNum", postNum);
		mav.addObject("view", "postCount");
		return mav;
	}
}
