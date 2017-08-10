/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月12日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * PostDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.Page;
import com.tsdvip.entity.Post;


/**
 * 
 * @author 
 * @since 2017年4月12日 下午7:59:04
 * @version   
 */
public interface PostDao {

	/**
	 * 统计版块精华帖子数
	 * @return
	 */
	Integer countGood(Integer boardId);
	
	/**
	 * 统计版块帖子总数
	 * @return
	 */
	Integer countAllPost(Integer boardId);
	
	/**
	 * 统计版块当日帖子数
	 * @param boardId
	 * @return
	 */
	Integer countTodayPost(String date,Integer boardId);
	
	/**
	 * 通过翻页对象查询数据
	 * @param page
	 * @return
	 */
	List<Post> findPostByPage(Page page);
	
	/**
	 * 通过id获取帖子
	 * @param postId
	 * @return
	 */
	Post findPostByPostId(Integer postId);
	
	/**
	 * 保存帖子
	 * @param post
	 */
	void insertPost(Post post);
	
	/**
	 * 获取最大的postID
	 * @return
	 */
	Integer getMaxPostId();
	
	/**
	 * 删除帖子
	 * @param postId
	 */
	void deletePostById(Integer postId);
	
	/**
	 * 通过id查询帖子
	 * @param postId
	 * @return
	 */
	Post getPostByPostId(Integer postId);
	
	/**
	 * 删除版块下的所有帖子
	 * @param boardId
	 */
	void deletePostByBoardId(Integer boardId);
	
	/**
	 * 查询版块下所有的帖子
	 * @param boardId
	 * @return
	 */
	List<Post> findAllByBoardId(Integer boardId);
	
	/**
	 * 查询所有帖子
	 * @return
	 */
	List<Post> findAll();
	
	/**
	 * 统计整个网站当日发帖数
	 * @param date
	 * @return
	 */
	Integer countAllByDate(String date);
	
	/**
	 * 帖子加精
	 * @param postId
	 */
	void addGood(Integer postId);
	
	/**
	 * 取消加精
	 * @param postId
	 */
	void cancelGood(Integer postId);
}
