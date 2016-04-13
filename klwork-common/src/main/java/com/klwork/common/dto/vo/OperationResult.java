package com.klwork.common.dto.vo;

import java.io.Serializable;

/**
 * 操作结果，用于记录有较为复杂的操作情况的操作结果，例如：不仅返回是否操作成功，
 * 如果成功的话还需要返回新生成的主键，如果失败的话还需要返回失败原因等。
 * 
 * @author ww
 */
public class OperationResult implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 只有success字段
	 */
	public static final int ONLY_SUCCESS = 1;
	/**
	 * 只有data字段
	 */
	public static final int ONLY_DATA = 2;
	/**
	 * success和data都有
	 */
	public static final int BOTH = 3;

	/**
	 * 是否操作成功
	 */
	private boolean success;
	/**
	 * Ajax返回结果，可以用于存放操作成功后新生成的ID，操作失败的错误提示，操作中异常等。
	 */
	private Serializable data;

	/**
	 * 请求类型，1、为Ajax提交；2、为Ajax取数据
	 */
	private int requestType;
	
	/**
	 * 错误的类型,除了返回不成功外,此字段可用户记录错误的类型号
	 */
	private int errorType;

	public boolean isSuccess() {
		return success;
	}

	public Object getData() {
		return data;
	}

	public int getRequestType() {
		return requestType;
	}

	/**
	 * 设置是否操作成功，并设置相应的提示信息
	 * 
	 */
	public OperationResult(boolean success, Serializable data) {
		this.success = success;
		this.data = data;
		requestType = BOTH;
	}

	/**
	 * 仅设置是否操作成功
	 */
	public OperationResult(boolean success) {
		this.success = success;
		requestType = ONLY_SUCCESS;
	}

	/**
	 * 仅设置返回的数据
	 */
	public OperationResult(Serializable data) {
		this.data = data;
		requestType = ONLY_DATA;
	}

	public String toString() {
		switch (requestType) {
		case ONLY_SUCCESS:
			return "success=" + success;
		case ONLY_DATA:
			return "data=" + data;
		case BOTH:
			return "success=" + success + "data=" + data;
		default:
			return "未知类型[" + requestType + "],success=" + success + ", data="
					+ data;
		}
	}
	
	

	/**
	 * 提供在返回时需要其他信息
	 * @param data the data to set
	 */
	public void setData(Serializable data) {
		this.data = data;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}
	
	
}