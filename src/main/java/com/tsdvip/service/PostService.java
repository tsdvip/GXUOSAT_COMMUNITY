/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月12日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * PostService.java
 */
package com.tsdvip.service;

import java.util.List;
import java.util.Map;

import com.tsdvip.entity.Answer;
import com.tsdvip.entity.Page;
import com.tsdvip.entity.Post;


/**
 * 
 * @author 
 * @since 2017年4月12日 下午8:41:06
 * @version   
 */
public interface PostService {

	/**
	 * 統計版块精华帖子数
	 * @param boardId
	 * @return
	 */
	Integer countGood(Integer boardId);
	
	/**
	 * 统计版块所有帖子数
	 * @param boardId
	 * @return
	 */
	Integer countAllPost(Integer boardId);
	
	/**
	 * 统计当日发帖数
	 * @param date
	 * @param boardId
	 * @return
	 */
	public Integer countTodayPost(String date, Integer boardId);
	
	/**
	 * 根据翻页对象数据查找帖子
	 * @param page
	 * @return
	 */
	public List<Map<String,Object>> getPostByPage(Page page);
	
	/**
	 * 获取帖子的所有内容
	 * @param postId
	 * @return
	 */
	public Map<String,Object> getPostContent(Integer postId);
	
	/**
	 * 获取帖子所有回复
	 * @param postId
	 * @return
	 */
	public List<Map<String, Object>> getPostAnswers(Integer postId);
	
	/**
	 * 保存帖子
	 * @param post
	 */
	public void savePost(Post post);
	
	/**
	 * 保存帖子回复
	 * @param answer
	 */
	public void saveAnswer(Answer answer);
	
	/**
	 * 删除帖子
	 */
	public void deletePostById(Integer postId);
	
	/**
	 * 删除帖子回复
	 * @param answerId
	 */
	public void deletePostAnswer(Integer answerId);
	
}
