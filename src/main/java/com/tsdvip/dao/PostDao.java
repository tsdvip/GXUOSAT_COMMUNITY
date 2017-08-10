/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��12��
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
 * @since 2017��4��12�� ����7:59:04
 * @version   
 */
public interface PostDao {

	/**
	 * ͳ�ư�龫��������
	 * @return
	 */
	Integer countGood(Integer boardId);
	
	/**
	 * ͳ�ư����������
	 * @return
	 */
	Integer countAllPost(Integer boardId);
	
	/**
	 * ͳ�ư�鵱��������
	 * @param boardId
	 * @return
	 */
	Integer countTodayPost(String date,Integer boardId);
	
	/**
	 * ͨ����ҳ�����ѯ����
	 * @param page
	 * @return
	 */
	List<Post> findPostByPage(Page page);
	
	/**
	 * ͨ��id��ȡ����
	 * @param postId
	 * @return
	 */
	Post findPostByPostId(Integer postId);
	
	/**
	 * ��������
	 * @param post
	 */
	void insertPost(Post post);
	
	/**
	 * ��ȡ����postID
	 * @return
	 */
	Integer getMaxPostId();
	
	/**
	 * ɾ������
	 * @param postId
	 */
	void deletePostById(Integer postId);
	
	/**
	 * ͨ��id��ѯ����
	 * @param postId
	 * @return
	 */
	Post getPostByPostId(Integer postId);
	
	/**
	 * ɾ������µ���������
	 * @param boardId
	 */
	void deletePostByBoardId(Integer boardId);
	
	/**
	 * ��ѯ��������е�����
	 * @param boardId
	 * @return
	 */
	List<Post> findAllByBoardId(Integer boardId);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	List<Post> findAll();
	
	/**
	 * ͳ��������վ���շ�����
	 * @param date
	 * @return
	 */
	Integer countAllByDate(String date);
	
	/**
	 * ���ӼӾ�
	 * @param postId
	 */
	void addGood(Integer postId);
	
	/**
	 * ȡ���Ӿ�
	 * @param postId
	 */
	void cancelGood(Integer postId);
}
