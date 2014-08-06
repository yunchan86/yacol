package com.yacol.sql;

import java.util.List;


public class RowSet<T> {

	private int currentNum;
	private int pageNum ;
	private List<T> rows ;
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
