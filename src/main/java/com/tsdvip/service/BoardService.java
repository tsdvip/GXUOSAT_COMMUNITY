/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��3��28��
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
 * @since 2017��3��28�� ����4:24:39
 * @version   
 */
public interface BoardService {
	
	/**
	 * �������а��
	 * @return
	 */
	public List<Board> listBoards();
}
