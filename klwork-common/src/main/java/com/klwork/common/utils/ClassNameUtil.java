package com.klwork.common.utils;

import java.util.HashMap;
import java.util.Map;

public abstract class ClassNameUtil {

	protected static final Map<Class<?>, String> cachedNames = new HashMap<Class<?>, String>();

	public static String getClassNameWithoutPackage(Object object) {
		return getClassNameWithoutPackage(object.getClass());
	}

	public static String getClassNameWithoutPackage(Class<?> clazz) {
		String unqualifiedClassName = cachedNames.get(clazz);
		if (unqualifiedClassName == null) {
			String fullyQualifiedClassName = clazz.getName();
			unqualifiedClassName = fullyQualifiedClassName
					.substring(fullyQualifiedClassName.lastIndexOf('.') + 1);
			cachedNames.put(clazz, unqualifiedClassName);
		}
		return unqualifiedClassName;
	}
}
