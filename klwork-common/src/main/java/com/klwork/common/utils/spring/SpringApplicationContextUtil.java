package com.klwork.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 获得一个读取spring配置文件的服务类
 * 
 * @author ww
 * 
 * 2010-05-14
 *
 */
public class SpringApplicationContextUtil implements ApplicationContextAware{

	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext pContext)
			throws BeansException {
		SpringApplicationContextUtil.context = pContext;
	}

	public static ApplicationContext getContext() {
		return SpringApplicationContextUtil.context;
	}

}
