/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��21��
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * AnswerDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.Answer;


/**
 * ��ѯ�ظ���
 * @author tanshangdong
 * @since 2017��4��21�� ����5:24:06
 * @version   
 */
public interface AnswerDao {
	
	/**
	 * ��������ID��ȡ���еĻظ�
	 * @param post
	 * @return
	 */
	List<Answer> findAnswerByPostId(Integer postId);
	
	/**
	 * ��������IDͳ�����ӻظ���
	 * @param postId
	 * @return
	 */
	Integer countAnswer(Integer postId);
	
	/**
	 * �������ӵĻظ�
	 * @param answer
	 */
	void insertAnswer(Answer answer);
	
	/**
	 * ��ȡ�������Ļظ�id
	 * @return
	 */
	Integer getMaxAnswerId();
	
	/**
	 * ɾ���������лظ�
	 */
	void deleteAnswerByPostId(Integer postId);
	
	/**
	 * ɾ���ظ�
	 * @param answerId
	 */
	void deleteAnswerByAnswerId(Integer answerId);
	
}
