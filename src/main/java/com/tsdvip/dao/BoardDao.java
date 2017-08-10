/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��3��28��
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * BoardDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.Board;


/**
 * 
 * @author tanshangdong
 * @since 2017��3��28�� ����12:14:00
 * @version   
 */
public interface BoardDao {

	/**
	 * �������а��
	 */
	List<Board> findAll();
	
	/**
	 * ͨ��id��ѯ�����Ϣ
	 * @param boardId
	 * @return
	 */
	Board findBoardByBoardId(Integer boardId);
	
	/**
	 * ɾ�����
	 * @param boardId
	 */
	void deleteBoardByBoarId(Integer boardId);
	
	/**
	 * ���°����Ϣ
	 * @param board
	 */
	void updateBoard(Board board);
	
	/**
	 * ��Ӱ��
	 * @param board
	 */
	void insertBoard(Board board);
	
	/**
	 * ��ȡ���İ��Id
	 * @return
	 */
	Integer getMaxBoardId();
	
}
