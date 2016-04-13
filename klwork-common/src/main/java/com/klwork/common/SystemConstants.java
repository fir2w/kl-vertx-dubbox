package com.klwork.common;

import com.klwork.common.utils.StringTool;

public final class SystemConstants {
	/**
	 * AJAX访问方式的Exception对象存放
	 */
	public final static String EXCEPTION_NAME = "ajax-exception";
	/**
	 * session中存放用户的attribute值
	 */
	public final static String SESSION_USER = "loginUser";
	/**
	 * cookie中存放的登录用户ID
	 */
	public final static String COOKIE_USER_ID = "cookieUserId";
	
	/**
	 * cookie中存放的登录用户ID
	 */
	public final static String COOKIE_USER_PWD = "cookieUserPwd";
	
	/**
	 * 第三方登录的信息标志
	 */
	public final static String SESSION_THIRD_USER_MAP = "third_user_map";
	
	/**
	 * 第三方登录的类型标志
	 */
	public final static String SESSION_THIRD_LOGIN_TYPE = "third_login_type";

	/**
	 * 文件后缀
	 */
	public static final String FILE_SUFFIX = SystemProperties
			.getString("System.FILE_SUFFIX");

	/**
	 * 分页数
	 */
	public static int pageSize = StringTool.parseInt(SystemProperties
			.getString("System.PageSize"));
	
	

}
