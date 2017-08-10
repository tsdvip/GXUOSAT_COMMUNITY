/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月19日
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
 * 对帖子的操作
 * 
 * @author tanshangdong
 * @since 2017年4月19日 下午7:53:21
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
	 * 获取第一页帖子列表
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

		// 默认进来是第一页
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
	 * 根据翻页获取帖子列表
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
	 * 进入帖子
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
	 * 进入发表帖子页面
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
		String mes = "是否关闭当前页面？";
		if (post.getUserId() == null) {
			String message = "您还未登录！请登录后再操作！" + mes;
			return new JsonResult<String>(message);
		}
		if (post.getTitle() == null || post.getTitle().isEmpty()) {
			String message = "标题不能为空哦！" + mes;
			return new JsonResult<String>(message);
		}
		postService.savePost(post);
		return new JsonResult<String>("发表成功！" + mes);
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
			return new JsonResult<String>("您还未登录！是否去登录？");
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
	 * 删除帖子
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
			return new JsonResult<String>("您还未登录！不可进行此操作！");
		}
		String ownerId = request.getParameter("ownerId");
		String postId = request.getParameter("postId");

		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		Integer roleId = user.getRoleId();
		if (roleId != 1 && board.getMasterId() != user.getUserId()
		        && user.getUserId() != Integer.valueOf(ownerId)) {
			return new JsonResult<String>("您的权限不足！");
		}

		postService.deletePostById(Integer.valueOf(postId));
		return new JsonResult<String>("success");
	}

	
	/**
	 * 帖子加精
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
			return new JsonResult<String>("您还未登录！不可进行此操作！");
		}
		String postId = request.getParameter("postId");
		
		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		if (board.getMasterId() != user.getUserId()) {
			return new JsonResult<String>("您的权限不足！");
		}
		
		postDao.addGood(Integer.valueOf(postId));
		
		return new JsonResult<String>("success");
	}
	
	/**
	 * 取消加精
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
			return new JsonResult<String>("您还未登录！不可进行此操作！");
		}
		String postId = request.getParameter("postId");
		
		User user = userService.findUser(Integer.valueOf(userId));
		Post post = postDao.findPostByPostId(Integer.valueOf(postId));
		Board board = boardDao.findBoardByBoardId(post.getBoardId());
		if (board.getMasterId() != user.getUserId()) {
			return new JsonResult<String>("您的权限不足！");
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
			return new JsonResult<String>("您还未登录！不可进行此操作！");
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
			return new JsonResult<String>("您的权限不足！");
		}
		
		postService.deletePostAnswer(Integer.valueOf(answerId));
		return new JsonResult<String>("success");
	}
}
