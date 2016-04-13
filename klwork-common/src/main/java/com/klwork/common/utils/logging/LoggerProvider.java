package com.klwork.common.utils.logging;

/**
 * Logger提供类
 * 
 * @author ww
 */
public interface LoggerProvider {

	/**
	 * 得到Logger对象
	 * 
	 * @param name
	 */
	Logger getLogger(String name);

}
