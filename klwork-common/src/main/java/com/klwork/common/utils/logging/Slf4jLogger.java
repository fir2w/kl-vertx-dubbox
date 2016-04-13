package com.klwork.common.utils.logging;

/**
 * LogBack的Logger实现类
 * 
 * @author ww
 */
public class Slf4jLogger implements Logger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454232923414903199L;

	/**
	 * 原始的Logger提供者
	 */
	private final org.slf4j.Logger logger;

	/**
	 * 日志的标识位，现在为调用类名
	 */
	public String callClassName;

	/**
	 * 设置Logger
	 * 
	 * @param logger
	 */
	protected Slf4jLogger(org.slf4j.Logger logger) {
		this.logger = logger;
	}

	public void trace(String msg) {
		logger.trace(msg);
	}

	public void trace(String format, Object... args) {
		logger.trace(format, args);
	}

	public void debug(String msg) {
		logger.debug(getHead() + msg);
	}

	public void debug(String format, Object... args) {
		logger.debug(format, args);
	}

	public void info(String msg) {
		logger.info(getHead() + msg);
	}

	public void info(String format, Object... args) {
		logger.info(format, args);
	}

	public void warn(String msg) {
		logger.warn(getHead() + msg);
	}

	public void warn(String format, Object... args) {
		logger.warn(format, args);
	}

	public void warn(String msg, Throwable t) {
		logger.warn(msg, t);
	}

	public void error(String msg) {
		logger.error(getHead() + msg);
	}

	public void error(String format, Object... args) {
		logger.error(format, args);
	}

	public void error(String msg, Throwable t) {
		logger.error(msg, t);
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	public String getCallClassName() {
		return callClassName;
	}

	public void setCallClassName(String callClassName) {
		this.callClassName = callClassName;
	}

	/**
	 * 给调试信息加入的头
	 * 
	 * @return
	 */
	public String getHead() {
		//return "{ " + getCallClassName() + " }";
		return "";
	}
}
