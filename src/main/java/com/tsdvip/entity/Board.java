/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.entity
 * Board.java
 */
package com.tsdvip.entity;

import java.io.Serializable;


/**
 * 版块
 * @author tanshangdong
 * @since 2017年3月28日 上午11:54:35
 * @version   
 */
public class Board implements Serializable{

    private static final long serialVersionUID = 1L;
    
	private Integer boardId;
	private String boardName;
	private String description;
	private Integer masterId;
	public Board() {

	}
	public Board(Integer boardId, String boardName,
            String description, Integer masterId) {
	    super();
	    this.boardId = boardId;
	    this.boardName = boardName;
	    this.description = description;
	    this.masterId = masterId;
    }
	
    public Integer getBoardId() {
    	return boardId;
    }
	
    public void setBoardId(Integer boardId) {
    	this.boardId = boardId;
    }
	
    public String getBoardName() {
    	return boardName;
    }
	
    public void setBoardName(String boardName) {
    	this.boardName = boardName;
    }
	
    public String getDescription() {
    	return description;
    }
	
    public void setDescription(String description) {
    	this.description = description;
    }
	
    public Integer getMasterId() {
    	return masterId;
    }
	
    public void setMasterId(Integer masterId) {
    	this.masterId = masterId;
    }
	
    public static long getSerialversionuid() {
    	return serialVersionUID;
    }
	
}
