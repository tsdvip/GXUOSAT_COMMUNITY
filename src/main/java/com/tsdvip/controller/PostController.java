/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��19��
 * 
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.controller
 * PostController.java
 */
package com.tsdvip.controller;

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
import com.tsdvip.dao.PostDao;
import com.tsdvip.entity.Answer;
import com.tsdvip.entity.Board;
import com.tsdvip.entity.Page;
import com.tsdvip.entity.Post;
import com.tsdvip.entity.User;
import com.tsdvip.service.PostService;
import com.tsdvip.service.UserService;
import com.tsdvip.util.JsonResult;

/**
 * �����ӵĲ���
 * 
 * @author tanshangdong
 * @since 2017��4��19�� ����7:53:21
 * @version
 */
@Controller
@RequestMapping("/post")
public class PostController extends AbstractController {

	@Resource
	private PostService postService;

	@Resource
	private PostDao postDao;

	@Resource
	private BoardDao boardDao;

	@Resource
	private UserService userService;

	/**
	 * ��ȡ��һҳ�����б�
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/listPost.do")
	public ModelAndView postList(HttpServletRequest request,
	        HttpServletResponse response) {
		String boardId = request.getParameter("boardId");
		ModelAndView mav = new ModelAndView("indexPage");

		// Ĭ�Ͻ����ǵ�һҳ
		int pageNum = 1;
		Page page = new Page();
		page.setPageNumber(pageNum);
		if (boardId != null) {
			page.setBoardId(Integer.valueOf(boardId));

			List<Map<String, Object>> objList = postService.getPostByPage(page);
			mav.addObject("boardId", boardId);
			mav.addObject("postList", objList);
			mav.addObject("view", "page_view/postList");

		}

		return mav;
	}

	/**
	 * ���ݷ�ҳ��ȡ�����б�
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/pagePost.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> page(
	        HttpServletRequest request, HttpServletResponse response) {
		String boardId = request.getParameter("boardId");
		String pageNum = request.getParameter("pageNum");
		Page page = new Page();
		if (boardId != null) {
			Integer startRow = (Integer.valueOf(pageNum) - 1) * 5 + 1;
			Integer endRow = Integer.valueOf(pageNum) * 5;
			page.setStartRow(startRow);
			page.setEndRow(endRow);
			page.setBoardId(Integer.valueOf(boardId));

			List<Map<String, Object>> objList = postService.getPostByPage(page);
			return new JsonResult<List<Map<String, Object>>>(objList);
		}
		return null;

	}

	/**
	 * ��������
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping("/intoPost.do")
	public ModelAndView intoPost(Integer postId) {
		ModelAndView mav = new ModelAndView("indexPage");

		mav.addObject("postContent", postService.getPostContent(postId));
		mav.addObject("answers", postService.getPostAnswers(postId));
		mav.addObject("view", "page_view/postContent");

		return mav;
	}

	/**
	 * ���뷢������ҳ��
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/publish.do")
	public ModelAndView publish(HttpServletRequest request,
	        HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String boardId = request.getParameter("boardId");
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}

		ModelAndView mav = new ModelAndView("page_view/publish");

		mav.addObject("boardId", boardId);
		mav.addObject("userId", userId);

		return mav;
	}

	@RequestMapping("/addPost.do")
	@ResponseBody
	public JsonResult<String> addPost(Post post) {
		String mes = "�Ƿ�رյ�ǰҳ�棿";
		if (post.getUserId() == null) {
			String message = "����δ��¼�����¼���ٲ�����" + mes;
			return new JsonResult<String>(message);
		}
		if (post.getTitle() == null || post.getTitle().isEmpty()) {
			String message = "���ⲻ��Ϊ��Ŷ��" + mes;
			return new JsonResult<String>(message);
		}
		postService.savePost(post);
		return new JsonResult<String>("����ɹ���" + mes);
	}

	@RequestMapping("/answer.do")
	@ResponseBody
	public JsonResult<String> answer(HttpServletRequest request,
	        HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}
		if (userId == null) {
			return new JsonResult<String>("����δ��¼���Ƿ�ȥ��¼��");
		}
		String postId = request.getParameter("postId");
		String content = request.getParameter("content");
		Answer answer = new Answer();
		answer.setPostId(Integer.valueOf(postId));
		answer.setContent(content);
		answer.setUserId(Integer.valueOf(userId));
		postService.saveAnswer(answer);
		return new JsonResult<String>("success");
	}

	/**
	 * ɾ������
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deletePost.do")
	@ResponseBody
	public JsonResult<String> deletePost(HttpServletRequest request,
	        HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}
		if (userId == null) {
			return new JsonResult<String>("����δ��¼�����ɽ��д˲�����");
		}
		String ownerId = request.getParameter("ownerId");
		String postId = request.getParameter("postId");

		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		Integer roleId = user.getRoleId();
		if (roleId != 1 && board.getMasterId() != user.getUserId()
		        && user.getUserId() != Integer.valueOf(ownerId)) {
			return new JsonResult<String>("����Ȩ�޲��㣡");
		}

		postService.deletePostById(Integer.valueOf(postId));
		return new JsonResult<String>("success");
	}

	
	/**
	 * ���ӼӾ�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addGood.do")
	@ResponseBody
	public JsonResult<String> addGood(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}
		if (userId == null) {
			return new JsonResult<String>("����δ��¼�����ɽ��д˲�����");
		}
		String postId = request.getParameter("postId");
		
		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		if (board.getMasterId() != user.getUserId()) {
			return new JsonResult<String>("����Ȩ�޲��㣡");
		}
		
		postDao.addGood(Integer.valueOf(postId));
		
		return new JsonResult<String>("success");
	}
	
	/**
	 * ȡ���Ӿ�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/cancelGood.do")
	@ResponseBody
	public JsonResult<String> cancelGood(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}
		if (userId == null) {
			return new JsonResult<String>("����δ��¼�����ɽ��д˲�����");
		}
		String postId = request.getParameter("postId");
		
		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		if (board.getMasterId() != user.getUserId()) {
			return new JsonResult<String>("����Ȩ�޲��㣡");
		}
		
		postDao.cancelGood(Integer.valueOf(postId));
		
		return new JsonResult<String>("success");
	}
	
	@RequestMapping("/deleteAnswer.do")
	@ResponseBody
	public JsonResult<String> deleteAnswer(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("userId")) {
				userId = cookies[i].getValue();
			}
		}
		if (userId == null) {
			return new JsonResult<String>("����δ��¼�����ɽ��д˲�����");
		}
		String ownerId = request.getParameter("ownerId");
		String postId = request.getParameter("postId");
		String answerId = request.getParameter("answerId");
		
		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		Integer roleId = user.getRoleId();
		if (roleId != 1 && board.getMasterId() != user.getUserId()
				&& user.getUserId() != Integer.valueOf(ownerId)
				&& user.getUserId() != Integer.valueOf(answerId)) {
			return new JsonResult<String>("����Ȩ�޲��㣡");
		}
		
		postService.deletePostAnswer(Integer.valueOf(answerId));
		return new JsonResult<String>("success");
	}
}
