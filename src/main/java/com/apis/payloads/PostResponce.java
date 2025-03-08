package com.apis.payloads;

import java.util.List;

public class PostResponce {
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElment;
	private int totalPage;
	private boolean lastPage;
	
	
	
	public long getTotalElment() {
		return totalElment;
	}
	public void setTotalElment(long totalElment) {
		this.totalElment = totalElment;
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
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
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	
	public PostResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
