package com.klwork.common.dto.vo;

import java.io.Serializable;
import java.util.List;

import com.klwork.common.SystemConstants;

/**
 * 分页页面对象
 * 
 * @author ww
 */
public class ViewPage<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3213752584629093788L;

	/**
	 * 每页大小
	 */
	private int pageSize = 10;

	/**
	 * 起始号
	 */
	private int start;
	
	
	/**
	 * 结束号
	 */
	private int end;


	/**
	 * 当前页号
	 */
	private int currentPage;

	/**
	 * 总数量
	 */
	private int totalSize;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * Title列表
	 */
	private List titleList;

	/**
	 * 当前页数据列表
	 */
	private List<E> pageDataList;

	/**
	 * 接口查询多个列表分页标志
	 */
	private int interFlag;
	/**
	 * 接收dojo中的grid表头的排序
	 */
	private String sort;

	/**
	 * 每页大小
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 每页大小
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 起始号
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 起始号
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * 总数量
	 * @return the totalSize
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * 总数量
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
		if (totalSize == 0) {
			this.currentPage = 0;
		} else {
			this.currentPage = start / pageSize + 1;
		}
		this.totalPage = (int) Math.ceil((float) totalSize / (float) pageSize);
	}

	/**
	 * 总页数
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 总页数
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 当前页号
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 当前页号
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Title列表
	 * @return the titleList
	 */
	public List getTitleList() {
		return titleList;
	}

	/**
	 * Title列表
	 * @param titleList the titleList to set
	 */
	public void setTitleList(List titleList) {
		this.titleList = titleList;
	}

	/**
	 * 当前页数据列表
	 * @return the pageDataList
	 */
	public List<E> getPageDataList() {
		return pageDataList;
	}

	/**
	 * 当前页数据列表
	 * @param pageDataList the pageDataList to set
	 */
	public void setPageDataList(List<E> pageDataList) {
		this.pageDataList = pageDataList;
	}

	public int getInterFlag() {
		return interFlag;
	}

	public void setInterFlag(int interFlag) {
		this.interFlag = interFlag;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{currentPage=").append(currentPage).append(", ");
		sb.append("start=").append(start).append(", ");
		sb.append("end=").append(end).append(", ");
		sb.append("sort=").append(sort).append(", ");
		sb.append("pageSize=").append(pageSize).append(", ");
		sb.append("totalSize=").append(totalSize).append(", ");
		sb.append("totalPage=").append(totalPage).append(",");
		sb.append("titleList=").append(titleList).append(", ");
		sb.append("pageDataList=").append(pageDataList).append("}");
		return sb.toString();
	}
}
