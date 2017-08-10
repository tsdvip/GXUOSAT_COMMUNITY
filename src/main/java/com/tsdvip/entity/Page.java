/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017��4��20��
 * 
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.dao
 * Page.java
 */
package com.tsdvip.entity;

import java.io.Serializable;

/**
 * ��ҳ����
 * @author	
 * @since 2017��4��20�� ����8:33:19
 * @version
 */
public class Page implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int boardId ; //����

	private int pageNumber = 1;// ��ǰҳ�ţ�Ĭ����ʾ��һҳ

	private int pageSize = 5; // ÿҳ��С��Ĭ��ÿҳ5��

	private int startRow = 0;// ��ʼ��¼�кţ�Ĭ��Ϊ�ӱ�ͷ��ʼ
	
	private int endRow = 5;//��һҳ

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
    	// ������ʼ�к�
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
