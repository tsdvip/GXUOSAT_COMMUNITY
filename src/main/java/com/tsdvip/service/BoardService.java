/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * BoardService.java
 */
package com.tsdvip.service;

import java.util.List;


import com.tsdvip.entity.Board;


/**
 * 
 * @author tanshangdong
 * @since 2017年3月28日 下午4:24:39
 * @version   
 */
public interface BoardService {
	
	/**
	 * 查找所有版块
	 * @return
	 */
	public List<Board> listBoards();
}
