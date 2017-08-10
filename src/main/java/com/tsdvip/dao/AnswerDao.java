/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月21日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * AnswerDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.Answer;


/**
 * 查询回复表
 * @author tanshangdong
 * @since 2017年4月21日 下午5:24:06
 * @version   
 */
public interface AnswerDao {
	
	/**
	 * 根据帖子ID获取所有的回复
	 * @param post
	 * @return
	 */
	List<Answer> findAnswerByPostId(Integer postId);
	
	/**
	 * 根据帖子ID统计帖子回复数
	 * @param postId
	 * @return
	 */
	Integer countAnswer(Integer postId);
	
	/**
	 * 保存帖子的回复
	 * @param answer
	 */
	void insertAnswer(Answer answer);
	
	/**
	 * 获取表中最大的回复id
	 * @return
	 */
	Integer getMaxAnswerId();
	
	/**
	 * 删除帖子所有回复
	 */
	void deleteAnswerByPostId(Integer postId);
	
	/**
	 * 删除回复
	 * @param answerId
	 */
	void deleteAnswerByAnswerId(Integer answerId);
	
}
