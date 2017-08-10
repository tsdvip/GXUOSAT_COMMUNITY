/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * BoardServiceImp.java
 */
package com.tsdvip.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsdvip.dao.BoardDao;
import com.tsdvip.entity.Board;


/**
 * 
 * @author 
 * @since 2017年3月28日 下午4:24:56
 * @version   
 */
@Service("boardService")
public class BoardServiceImp implements BoardService{

	@Resource
	private BoardDao boardDao;

	public List<Board> listBoards() {
	    return boardDao.findAll();
    }

}
