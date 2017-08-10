/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月12日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.entity
 * Post.java
 */
package com.tsdvip.entity;

import java.io.Serializable;


/**
 * 
 * @author 
 * @since 2017年4月12日 下午7:53:51
 * @version   
 */
public class Post implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer postId;
    private Integer userId;
    private Integer boardId;
    private String title;
    private String content;
    private String postTime;
    private String is_top;
    private String to_top_time;
    private String is_good;
    private String to_good_time;
    
	public Post() {
	}

	public Post(Integer postId, Integer userId, Integer boardId, String title,
            String content, String postTime, String is_top,
            String to_top_time, String is_good, String to_good_time) {
	    super();
	    this.postId = postId;
	    this.userId = userId;
	    this.boardId = boardId;
	    this.title = title;
	    this.content = content;
	    this.postTime = postTime;
	    this.is_top = is_top;
	    this.to_top_time = to_top_time;
	    this.is_good = is_good;
	    this.to_good_time = to_good_time;
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

	
    public Integer getBoardId() {
    	return boardId;
    }

	
    public void setBoardId(Integer boardId) {
    	this.boardId = boardId;
    }

	
    public String getTitle() {
    	return title;
    }

	
    public void setTitle(String title) {
    	this.title = title;
    }

	
    public String getContent() {
    	return content;
    }

	
    public void setContent(String content) {
    	this.content = content;
    }

	
    public String getPostTime() {
    	return postTime;
    }

	
    public void setPostTime(String postTime) {
    	this.postTime = postTime;
    }

	
    public String getIs_top() {
    	return is_top;
    }

	
    public void setIs_top(String is_top) {
    	this.is_top = is_top;
    }

	
    public String getTo_top_time() {
    	return to_top_time;
    }

	
    public void setTo_top_time(String to_top_time) {
    	this.to_top_time = to_top_time;
    }

	
    public String getIs_good() {
    	return is_good;
    }

	
    public void setIs_good(String is_good) {
    	this.is_good = is_good;
    }

	
    public String getTo_good_time() {
    	return to_good_time;
    }

	
    public void setTo_good_time(String to_good_time) {
    	this.to_good_time = to_good_time;
    }

	
    public static long getSerialversionuid() {
    	return serialVersionUID;
    }

	@Override
    public String toString() {
	    return "Post [postId=" + postId + ", userId=" + userId + ", boardId="
	            + boardId + ", title=" + title + ", content=" + content
	            + ", postTime=" + postTime + ", is_top=" + is_top
	            + ", to_top_time=" + to_top_time + ", is_good=" + is_good
	            + ", to_good_time=" + to_good_time + "]";
    }
    
    

	
}
