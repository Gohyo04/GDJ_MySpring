package com.winter.app.util;

public class Pager {
	
	private Long startRow;
	private Long lastRow;
	
	// 10개씩 조회
	private Long perPage = 10L;
	
	private Long page;
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.lastRow = this.getPage()*this.getPerPage();
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
	}
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	// null check
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}
	
	
}
