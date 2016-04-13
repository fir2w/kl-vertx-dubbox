package com.klwork.common.utils.logging;

import java.io.Serializable;

/**
 * 平台Logger对象，用于封装日志实现，并且规范业务日志的记录。 注意：目前具体Logger实现类，采用的时候最新的LogBack作为实现， 因此没有必要再先检查：isDebugEnabled()等。
 * 而是采用Logger本身自己来控制，具体的写法类似： 正确的写法为： logger.debug("The new entry is {}.", entry); 错误的写法：
 * logger.debug("The new entry is "+entry+"."); 注意：{}代替直接构造出新的String对象。
 * 
 * @author ww
 */
public interface Logger extends Serializable {

	/**
	 * Is the logger instance enabled for the TRACE level?
	 * 
	 * @return True if this Logger is enabled for the TRACE level, false otherwise.
	 */
	public boolean isTraceEnabled();

	/**
	 * Log a message at the TRACE level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void trace(String msg);

	/**
	 * Log a message at the TRACE level according to the specified format and argument.
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled for the TRACE level.
	 * </p>
	 * 
	 * @param format the format string
	 * @param args the argument
	 */
	public void trace(String format, Object... args);

	/**
	 * Is the logger instance enabled for the DEBUG level?
	 * 
	 * @return True if this Logger is enabled for the DEBUG level, false otherwise.
	 */
	public boolean isDebugEnabled();

	/**
	 * Log a message at the DEBUG level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void debug(String msg);

	/**
	 * Log a message at the DEBUG level according to the specified format and argument.
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled for the DEBUG level.
	 * </p>
	 * 
	 * @param format the format string
	 * @param args the argument
	 */
	public void debug(String format, Object... args);

	/**
	 * Is the logger instance enabled for the INFO level?
	 * 
	 * @return True if this Logger is enabled for the INFO level, false otherwise.
	 */
	public boolean isInfoEnabled();

	/**
	 * Log a message at the INFO level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void info(String msg);

	/**
	 * Log a message at the INFO level according to the specified format and argument.
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled for the INFO level.
	 * </p>
	 * 
	 * @param format the format string
	 * @param args the argument
	 */
	public void info(String format, Object... args);

	/**
	 * Log a message at the WARN level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void warn(String msg);

	/**
	 * Log a message at the WARN level according to the specified format and argument.
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled for the WARN level.
	 * </p>
	 * 
	 * @param format the format string
	 * @param args the argument
	 */
	public void warn(String format, Object... args);

	/**
	 * Log an exception (throwable) at the WARN level with an accompanying message.
	 * 
	 * @param msg the message accompanying the exception
	 * @param t the exception (throwable) to log
	 */
	public void warn(String msg, Throwable t);

	/**
	 * Log a message at the ERROR level.
	 * 
	 * @param msg the message string to be logged
	 */
	public void error(String msg);

	/**
	 * Log a message at the ERROR level according to the specified format and argument.
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled for the ERROR level.
	 * </p>
	 * 
	 * @param format the format string
	 * @param args the argument
	 */
	public void error(String format, Object... args);

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying message.
	 * 
	 * @param msg the message accompanying the exception
	 * @param t the exception (throwable) to log
	 */
	public void error(String msg, Throwable t);

	public String getCallClassName();

	public void setCallClassName(String callClassName);

}
