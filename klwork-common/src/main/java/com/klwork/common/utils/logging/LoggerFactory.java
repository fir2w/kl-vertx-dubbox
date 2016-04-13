package com.klwork.common.utils.logging;

import org.springframework.util.Assert;

/**
 * Logger的工厂类，用于创建Logger对象
 * 
 * @author ww
 */
public class LoggerFactory {

	private static LoggerProvider loggerProvider;

	/**
	 * 得到Logger对象
	 * 
	 * @param name Logger配置的名称
	 */
	public static Logger getLogger(String name) {
		if (loggerProvider == null) {
			loggerProvider = new Slf4jProvider();
		}
		Assert.notNull(loggerProvider, "loggerProvider must not be null");
		return loggerProvider.getLogger(name);
	}

	/**
	 * 得到Logger对象
	 * 
	 * @param clazz 待处理
	 */
	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	/**
	 * 配置类
	 * @author ww
	 */
	public static class Configueration {
		/**
		 * 设置LoggerProvider对象。
		 * @param loggerProvider
		 */
		protected void setLoggerProvider(LoggerProvider loggerProvider) {
			LoggerFactory.loggerProvider = loggerProvider;
			System.out.println("设置LoggerFactory.loggerProvider = " + loggerProvider);
		}

	}

}
