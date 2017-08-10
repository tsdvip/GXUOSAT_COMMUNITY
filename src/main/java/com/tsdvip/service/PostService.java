/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��12��
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
 * @since 2017��4��12�� ����8:41:06
 * @version   
 */
public interface PostService {

	/**
	 * �yӋ��龫��������
	 * @param boardId
	 * @return
	 */
	Integer countGood(Integer boardId);
	
	/**
	 * ͳ�ư������������
	 * @param boardId
	 * @return
	 */
	Integer countAllPost(Integer boardId);
	
	/**
	 * ͳ�Ƶ��շ�����
	 * @param date
	 * @param boardId
	 * @return
	 */
	public Integer countTodayPost(String date, Integer boardId);
	
	/**
	 * ���ݷ�ҳ�������ݲ�������
	 * @param page
	 * @return
	 */
	public List<Map<String,Object>> getPostByPage(Page page);
	
	/**
	 * ��ȡ���ӵ���������
	 * @param postId
	 * @return
	 */
	public Map<String,Object> getPostContent(Integer postId);
	
	/**
	 * ��ȡ�������лظ�
	 * @param postId
	 * @return
	 */
	public List<Map<String, Object>> getPostAnswers(Integer postId);
	
	/**
	 * ��������
	 * @param post
	 */
	public void savePost(Post post);
	
	/**
	 * �������ӻظ�
	 * @param answer
	 */
	public void saveAnswer(Answer answer);
	
	/**
	 * ɾ������
	 */
	public void deletePostById(Integer postId);
	
	/**
	 * ɾ�����ӻظ�
	 * @param answerId
	 */
	public void deletePostAnswer(Integer answerId);
	
}
