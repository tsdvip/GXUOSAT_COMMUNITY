/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��23��
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * AdminService.java
 */
package com.tsdvip.service;

import java.util.List;
import java.util.Map;


/**
 * ��̨����
 * @author 
 * @since 2017��4��23�� ����6:55:40
 * @version   
 */
public interface AdminService {

	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 */
	List<Map<String,Object>> getAllUser();
	
	/**
	 * ��ȡ���а����Ϣ
	 * @return
	 */
	List<Map<String,Object>> getAllBoards();
	
	/**
	 * ɾ�����
	 * @param boardId
	 */
	void deleteBoardByBoardId(Integer boardId);
	
	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
	List<Map<String,Object>> getAllPosts();
	
	/**
	 * ������
	 * @param boardId
	 * @param boardName
	 * @param description
	 * @param masterName
	 */
	void boardManager(Integer boardId,Integer userId ,String boardName,String description,String masterName);
	
	/**
	 * �������
	 * @param noticeId
	 * @param content
	 * @param ymd
	 */
	void noticeManager(Integer noticeId,String content,String ymd);
	
	/**
	 * ��ȡ������
	 * @param dates
	 * @return
	 */
	List<Integer> getPostNum(List<String> dates);
}
