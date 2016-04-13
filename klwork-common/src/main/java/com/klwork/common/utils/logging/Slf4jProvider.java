package com.klwork.common.utils.logging;

/**
 * Slf4j的Logger提供者
 * 
 * @author ww
 */
public class Slf4jProvider extends LoggerFactory.Configueration implements LoggerProvider {
	private String configFile;

	public Slf4jProvider() {
		super.setLoggerProvider(this);
	}

	public Logger getLogger(String name) {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(name);
		Slf4jLogger backLogger = new Slf4jLogger(logger);
		backLogger.setCallClassName(name);
		return backLogger;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

}
