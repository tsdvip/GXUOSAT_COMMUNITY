/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��29��
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * NoticeDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.Notice;


/**
 * ����
 * @author 
 * @since 2017��4��29�� ����5:04:52
 * @version   
 */
public interface NoticeDao {

	/**
	 * ��ȡ���й���
	 * @return
	 */
	List<Notice> findAllNotice();
	
	/**
	 * ɾ������
	 */
	void deleteNotice(Integer noticeId);
	
	/**
	 * ��ȡ���һ������
	 * @return
	 */
	Notice findNewNotice();
	
	/**
	 * ��ȡ����noticeId
	 * @return
	 */
	Integer getMaxNoticeId();
	
	/**
	 * ���빫��
	 * @param notice
	 */
	void insertNotice(Notice notice);
	
	/**
	 * ���¹���
	 * @param notice
	 */
	void updateNotice(Notice notice);
	
}
