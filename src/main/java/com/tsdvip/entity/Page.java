/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月20日
 * 
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * Page.java
 */
package com.tsdvip.entity;

import java.io.Serializable;

/**
 * 翻页对象
 * @author	
 * @since 2017年4月20日 下午8:33:19
 * @version
 */
public class Page implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int boardId ; //版块号

	private int pageNumber = 1;// 当前页号，默认显示第一页

	private int pageSize = 5; // 每页大小，默认每页5条

	private int startRow = 0;// 起始记录行号，默认为从表头开始
	
	private int endRow = 5;//第一页

	public Page() {
    }

    public Page(int boardId, int pageNumber, int pageSize, int startRow,
            int endRow) {
	    super();
	    this.boardId = boardId;
	    this.pageNumber = pageNumber;
	    this.pageSize = pageSize;
	    this.startRow = startRow;
	    this.endRow = endRow;
    }



	public int getPageNumber() {
    	return pageNumber;
    }

	
    public void setPageNumber(int pageNumber) {
    	this.pageNumber = pageNumber;
    }

	
    public int getPageSize() {
    	return pageSize;
    }

	
    public void setPageSize(int pageSize) {
    	this.pageSize = pageSize;
    }

	
    public int getStartRow() {
    	// 计算起始行号
    	//this.startRow = (this.pageNumber - 1) * this.pageSize;
    	return this.startRow;
    }

	
    public void setStartRow(int startRow) {
    	this.startRow = startRow;
    }

	
    public int getEndRow() {
    	//this.endRow = this.pageNumber * this.pageSize - 1;
    	return this.endRow;
    }

	
    public void setEndRow(int endRow) {
    	this.endRow = endRow;
    }

	
    public int getBoardId() {
    	return boardId;
    }

	
    public void setBoardId(int boardId) {
    	this.boardId = boardId;
    }

	@Override
    public String toString() {
	    return "Page [boardId=" + boardId + ", pageNumber=" + pageNumber
	            + ", pageSize=" + pageSize + ", startRow=" + startRow
	            + ", endRow=" + endRow + "]";
    }
    
    

}
