package com.klwork.common.dao;

public class SqlConditionUtil {

	final static String eq = "=";
	final static String ne = "<>";
	final static String like = "like";
	final static String gt = ">";
	final static String lt = "<";
	final static String ge = ">=";
	final static String le = "<=";
	final static int quot = 1;
	final static int noquot = 0;

	/**
	 * 
	 * @param propertyName
	 * @param value
	 * @param operType
	 * @param quot
	 * @return
	 */
	public static String sum(String propertyName, String value,
			String operType, int quot) {
		String quotStr = "";
		if (quot == SqlConditionUtil.quot) {
			quotStr = "'";
		}
		StringBuilder b = new StringBuilder();
		b.append("sum(");
		b.append(propertyName);
		b.append(")");
		b.append(operType);
		b.append(quotStr);
		b.append(value);
		b.append(quotStr);
		return b.toString();
	}

	/**
	 * 
	 * @param propertyName
	 * @param value
	 * @param operType
	 * @param quot
	 * @return
	 */
	public static String sum(String propertyName, String value, String operType) {
		return sum(propertyName, value, operType, 0);
	}

	/**
	 * 
	 * @param propertyName
	 * @param value
	 * @param operType
	 * @param quot
	 * @return
	 */
	public static String sumGe(String propertyName, String value) {
		return sum(propertyName, value, SqlConditionUtil.ge, 0);
	}
}
