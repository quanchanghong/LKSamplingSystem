package cn.com.lk.pojo;

import java.util.ArrayList;
import java.util.List;

import cn.com.lk.constant.PageConstant;

public class Page <T>{
	
	private Integer pageCount;//总页数
	private Integer pageSize = PageConstant.ONE_PAGE_SIZE;//每页显示条数
	private Integer pageTotal;//总的记录数
	private Integer currentPage = PageConstant.CURRENT_PAGE_INDEX;//当前页
	private Integer nextPage;
	private Integer lastPage;
	private Integer firstPage;
	private Integer endPage;
	private List<T> list = new ArrayList<T>();
	
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public Integer getPageCount() {
		if((pageTotal % pageSize) == 0){
			pageCount = pageTotal / pageSize;
		}
		else{
			pageCount = (pageTotal / pageSize) + 1;
		}
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [pageCount=" + pageCount + ", pageSize=" + pageSize
				+ ", pageTotal=" + pageTotal + ", currentPage=" + currentPage
				+ ", nextPage=" + nextPage + ", lastPage=" + lastPage
				+ ", firstPage=" + firstPage + ", endPage=" + endPage
				+ ", list=" + list + "]";
	}
}
