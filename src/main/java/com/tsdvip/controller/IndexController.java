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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsdvip.dao.NoticeDao;
import com.tsdvip.entity.Board;
import com.tsdvip.entity.Notice;
import com.tsdvip.entity.User;
import com.tsdvip.service.BoardService;
import com.tsdvip.service.PostService;
import com.tsdvip.service.UserService;
import com.tsdvip.util.DateUtil;


/**
 * 首页
 * @author tanshangdong
 * @since 2017年3月29日 上午10:49:21
 * @version   
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@Resource
	private BoardService boardService;
	@Resource
	private UserService userService;
	@Resource
	private PostService postService;
	@Resource
	private NoticeDao noticeDao;
	
	/**
	 * 跳转首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/goIndex.do")
	public String goIndex(Model model){
		
		List<Board> boards = boardService.listBoards();
		List<Map<String,Object>> boardList = new ArrayList<Map<String,Object>>();
		for(Board board : boards){
			Map<String,Object> boardMap = new HashMap<String,Object>();
			User user = userService.findUser(board.getMasterId());
			int allNum = postService.countAllPost(board.getBoardId());
			int goodNum = postService.countGood(board.getBoardId());
			int todayNum = postService.countTodayPost(DateUtil.getCureDateStr("yyyy-MM-dd"), board.getBoardId());
			boardMap.put("boardId", board.getBoardId());
			boardMap.put("boardName", board.getBoardName());
			boardMap.put("description", board.getDescription());
			boardMap.put("masterName", user.getNickname());
			boardMap.put("allNum", allNum);
			boardMap.put("goodNum", goodNum);
			boardMap.put("todayNum", todayNum);
			boardList.add(boardMap);
		}
		model.addAttribute("boards",boardList);
		//mav.addObject("boards",boards);
		return "indexPage";
		
	}
	
	/**
	 * 查看公告
	 * @param model
	 * @return
	 */
	@RequestMapping("/notice.do")
	public String notice(Model model){
		
		Notice notice = noticeDao.findNewNotice();
		model.addAttribute("notice", notice);
		model.addAttribute("view", "notice");
		return "indexPage";
		
	}
	
}
