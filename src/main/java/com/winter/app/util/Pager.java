package com.winter.app.util;

public class Pager {
	
	private Long startRow;	// 시작페이지번호
	private Long lastRow;	// 끝페이지번호
	
	// 10개씩 조회
	private Long perPage = 10L;	// 몇개씩 조회할것인가
	
	private Long page;			// 몇번째 페이지
	
	private Long totalPage;		// 총 페이지
	
	private Long startNum;		// 시작번호
	private Long lastNum;		// 끝번호
	
	// 첫,끝 값이 맞는지 확인해줄 멤버변수
	// 이전 블럭이 없으면 true
	private boolean start;
	// 다음 블럭이 없으면 true
	private boolean last;

	// 검색 관련
	private String search;
	private String kind;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
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
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.lastRow = this.getPage()*this.getPerPage();
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
	}
	
//public void makeNum(Long totalCount) {
//		
//		// 페이지 계산
//		Long totalPage = 0L;
//		totalPage = totalCount/this.getPerPage();
//		
//		if(totalCount%this.getPerPage() != 0) {
//			totalPage++;
//		}
//		
//		this.setTotalPage(totalPage);
//		
//		// 총 블록 수
//		Long perBlock = 5L; // 블럭당 보여줄 번호의 갯수
//		Long totalBlock=totalPage/perBlock;
//		
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		// Page 값으로 현재 블럭 번호 구하기
//		Long curBlock = 0L;
//		curBlock = this.getPage()/perBlock;
//		if(this.getPage()%perBlock != 0) {
//			curBlock++;
//		}
//		
//		// 현재블럭 번호로 list 시작번호와 끝번호 구하기
//		Long lastNum = curBlock * perBlock;
//		Long startNum = lastNum - perBlock + 1;
//	
//		this.setStartNum(startNum);
//
//		this.setLastNum(lastNum);
//		
//		// 이전, 다음 블럭 유무
//		if(curBlock == 1) {
//			this.setStart(true);
//		}
//		if(curBlock == totalBlock) {
//			this.setLastNum(totalPage);
//			this.setLast(true);
//		}
//	}

	public void makeNum(Long totalCount) {
		// 1. 총 갯수로 총 페이지 수 구하기
		Long totalPage = totalCount/this.getPerPage();
		
		if(totalPage % this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 2. 총 페이지수로 총 블럭수 구하기
		// 5개씩
		Long perBlock = 5L;
		// 총 블럭갯수
		Long nblock = totalPage / perBlock;
		
		if(totalPage%perBlock != 0) {
			nblock++;
		}
		
		// 3. 현재 페이지 번호로 현재 블럭 번호 구하기
		// 현재 블록 
		Long curBlock = this.getPage() / perBlock;
		if(this.getPage() % perBlock != 0) {
			curBlock++;
		}
		
		// 4. 현재 블럭 번호로 시작번호와 끝번호 구하기
		this.setLastNum(curBlock * perBlock);
		this.setStartNum(this.lastNum-perBlock+1);
		
		// 5. 이전, 다음 블럭 유무
		if(curBlock == 1) {
			this.setStart(true);
		}
		if(curBlock == nblock) {
			this.setLastNum(totalPage);
			this.setLast(true);
		}
	}
}














