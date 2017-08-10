/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月23日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * AdminService.java
 */
package com.tsdvip.service;

import java.util.List;
import java.util.Map;


/**
 * 后台管理
 * @author 
 * @since 2017年4月23日 下午6:55:40
 * @version   
 */
public interface AdminService {

	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<Map<String,Object>> getAllUser();
	
	/**
	 * 获取所有版块信息
	 * @return
	 */
	List<Map<String,Object>> getAllBoards();
	
	/**
	 * 删除版块
	 * @param boardId
	 */
	void deleteBoardByBoardId(Integer boardId);
	
	/**
	 * 获取所有帖子信息
	 * @return
	 */
	List<Map<String,Object>> getAllPosts();
	
	/**
	 * 版块管理
	 * @param boardId
	 * @param boardName
	 * @param description
	 * @param masterName
	 */
	void boardManager(Integer boardId,Integer userId ,String boardName,String description,String masterName);
	
	/**
	 * 公告管理
	 * @param noticeId
	 * @param content
	 * @param ymd
	 */
	void noticeManager(Integer noticeId,String content,String ymd);
	
	/**
	 * 获取帖子数
	 * @param dates
	 * @return
	 */
	List<Integer> getPostNum(List<String> dates);
}
