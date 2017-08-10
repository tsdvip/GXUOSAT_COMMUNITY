/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月21日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.entity
 * Answer.java
 */
package com.tsdvip.entity;

import java.io.Serializable;


/**
 * 回复
 * @author tanshangdong
 * @since 2017年4月21日 下午5:20:22
 * @version   
 */
public class Answer implements Serializable{
	
    private static final long serialVersionUID = 1L;
	private Integer answerId;
	private Integer postId;
	private Integer userId;
	private String content;
	private String answerTime;
	public Answer() {
    }
	public Answer(Integer answerId, Integer postId, Integer userId,
            String content, String answerTime) {
	    super();
	    this.answerId = answerId;
	    this.postId = postId;
	    this.userId = userId;
	    this.content = content;
	    this.answerTime = answerTime;
    }
	
    public Integer getAnswerId() {
    	return answerId;
    }
	
    public void setAnswerId(Integer answerId) {
    	this.answerId = answerId;
    }
	
    public Integer getPostId() {
    	return postId;
    }
	
    public void setPostId(Integer postId) {
    	this.postId = postId;
    }
	
    public Integer getUserId() {
    	return userId;
    }
	
    public void setUserId(Integer userId) {
    	this.userId = userId;
    }
	
    public String getContent() {
    	return content;
    }
	
    public void setContent(String content) {
    	this.content = content;
    }
	
    public String getAnswerTime() {
    	return answerTime;
    }
	
    public void setAnswerTime(String answerTime) {
    	this.answerTime = answerTime;
    }
	
    public static long getSerialversionuid() {
    	return serialVersionUID;
    }
	
}
