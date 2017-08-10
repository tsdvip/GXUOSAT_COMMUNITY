/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月29日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * NoticeDao.java
 */
package com.tsdvip.dao;

import java.util.List;

import com.tsdvip.entity.Notice;


/**
 * 公告
 * @author 
 * @since 2017年4月29日 下午5:04:52
 * @version   
 */
public interface NoticeDao {

	/**
	 * 获取所有公告
	 * @return
	 */
	List<Notice> findAllNotice();
	
	/**
	 * 删除公告
	 */
	void deleteNotice(Integer noticeId);
	
	/**
	 * 获取最近一条公告
	 * @return
	 */
	Notice findNewNotice();
	
	/**
	 * 获取最大的noticeId
	 * @return
	 */
	Integer getMaxNoticeId();
	
	/**
	 * 插入公告
	 * @param notice
	 */
	void insertNotice(Notice notice);
	
	/**
	 * 更新公告
	 * @param notice
	 */
	void updateNotice(Notice notice);
	
}
