package com.klwork.common.dto.vo;

import java.io.Serializable;

/**
 * Ajax提交返回对象<br/>
 * AjaxResult在JavaScript使用方法：<br/>
 * 如果data字段中存放的是如下Class的实例：<br/>
    public class KeyValue {
        private String key;
        private String value;
        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }
        public String getValue() {
            return value;
        }
    }
 * <br/>
 * 那么在EXT的Ajax调用中写如下代码：
 * action.result.data.key 返回KeyValue的key值；action.result.data.value返回KeyValue的value值。
 * 
 * @author ww
 */
public class AjaxResult implements Serializable {
	private static final long serialVersionUID = 1L;
	/**为Ajax提交*/
    public static final int AJAX_SUBMIT = 1;
    /**Ajax取数据*/
    public static final int AJAX_DATA = 2;
    
    private boolean success;
    /**
     * Ajax返回结果
     */
    private Object data;
    
    /**
     * 错误信息
     */
    private String errorMessage;
    
    /**
     * 请求类型，1、为Ajax提交；2、为Ajax取数据
     */
    private int requestType;
    
    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }
    
    public int getRequestType() {
        return requestType;
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

    /**
     * Ajax提交
     * 
     * @param success Ajax提交操作是否成功
     * @param data Ajax提交后的回页面数据

     */
    public AjaxResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
        requestType = 1;
    }
    
    /**
     * Ajax提交出错
     * 
     * @param success
     * @param errorMessage
     */
    public AjaxResult(boolean success, String errorMessage) {
    	this.success = success;
    	if(success) {//防止出现data为String类型的请求返回
    		this.data = errorMessage;
    	} else {
    		this.errorMessage = errorMessage;
    	}
    	requestType = 1;
    }
    
    /**
     * Ajax提交
     * 
     * @param success Ajax提交操作是否成功
     */
    public AjaxResult(boolean success) {
        this.success = success;
        requestType = 1;
    }
    
    /**
     * Ajax取数据

     * 
     * @param data Ajax取的数据
     */
    public AjaxResult(Object data) {
        this.data = data;
        requestType = 2;
    }
    
    public String toString() {
        switch(requestType) {
        case AJAX_SUBMIT://Ajax提交，需要有是否成功的标志
            return "success=" + success + ", data=" + data;
        case AJAX_DATA://Ajax取数据，仅有数据即可
            return "data=" + data;
        default:
            return "未知类型[" + requestType + "],success=" + success + ", data=" + data;
        }
    }
}