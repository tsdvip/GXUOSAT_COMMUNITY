/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月29日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.entity
 * Notice.java
 */
package com.tsdvip.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 公告对象
 * @author 
 * @since 2017年4月29日 下午5:08:05
 * @version   
 */
public class Notice implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private Integer noticeId;
	private String content;
	private String ymd;
	private Timestamp postTime;
	public Notice() {
	    super();
	    // TODO Auto-generated constructor stub
    }
	public Notice(Integer noticeId, String content, String ymd,
            Timestamp postTime) {
	    super();
	    this.noticeId = noticeId;
	    this.content = content;
	    this.ymd = ymd;
	    this.postTime = postTime;
    }
	
    public Integer getNoticeId() {
    	return noticeId;
    }
	
    public void setNoticeId(Integer noticeId) {
    	this.noticeId = noticeId;
    }
	
    public String getContent() {
    	return content;
    }
	
    public void setContent(String content) {
    	this.content = content;
    }
	
    public String getYmd() {
    	return ymd;
    }
	
    public void setYmd(String ymd) {
    	this.ymd = ymd;
    }
	
    public Timestamp getPostTime() {
    	return postTime;
    }
	
    public void setPostTime(Timestamp postTime) {
    	this.postTime = postTime;
    }
	
    public static long getSerialversionuid() {
    	return serialVersionUID;
    }
	@Override
    public String toString() {
	    return "Notice [noticeId=" + noticeId + ", content=" + content
	            + ", ymd=" + ymd + ", postTime=" + postTime + "]";
    }
	
}
