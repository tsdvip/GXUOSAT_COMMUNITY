/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
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
 * @since 2017年3月28日 下午12:14:00
 * @version   
 */
public interface BoardDao {

	/**
	 * 查找所有版块
	 */
	List<Board> findAll();
	
	/**
	 * 通过id查询版块信息
	 * @param boardId
	 * @return
	 */
	Board findBoardByBoardId(Integer boardId);
	
	/**
	 * 删除版块
	 * @param boardId
	 */
	void deleteBoardByBoarId(Integer boardId);
	
	/**
	 * 更新版块信息
	 * @param board
	 */
	void updateBoard(Board board);
	
	/**
	 * 添加版块
	 * @param board
	 */
	void insertBoard(Board board);
	
	/**
	 * 获取最大的版块Id
	 * @return
	 */
	Integer getMaxBoardId();
	
}
