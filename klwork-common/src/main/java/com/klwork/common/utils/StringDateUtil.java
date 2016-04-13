package com.klwork.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * string to date 的工具类。
 * 
 * @author ssf
 */
public class StringDateUtil {
	/**
	 * 输出本类的相关log日志
	 */
	protected static final Logger logger = LoggerFactory.getLogger(StringDateUtil.class);
	//1
	public static final String FORMAT = "yyyyMMdd";
	//2
	public static final String FORMAT_BIAS = "yyyy/MM/dd";
	//3
	public static final String FORMAT_LAND = "yyyy-MM-dd";
	//4
	public static final String FORMAT_SCAPE_HMS = "yyyy-MM-dd HH:mm:ss";
	//5
	public static final String FORMAT_HMS = "yyyyMMddHHmmss";
	//6
	public static final String FORMAT_SCAPE_HMSS = "yyyy-MM-dd HH:mm:ss.sss";
	//7
	public static final String FORMAT_HOUR_MINUTE = "HH:mm";
	public static final int SERIAL_HOUR_MINUTE = 7;
	//8
	public static final String FORMAT_YEAR_MONTH = "yyyy-MM";

	//9
	public static final String FORMAT_SCAPE_HM = "yyyy-MM-dd HH:mm";
	//10
	public static final String FORMAT_YEAR = "yyyy";
	//11
	public static final String FORMAT_MD = "MM-dd";
	//12
	public static final String FORMAT_MD_HM = "MM-dd HH:mm:ss";
	
	public static Map<String, String> dateForMatString = new HashMap(8);
	public static Map<String, SimpleDateFormat> dateForMatObject = new HashMap(8);

	static {
		dateForMatString.put("1", FORMAT);
		dateForMatString.put("2", FORMAT_BIAS);
		dateForMatString.put("3", FORMAT_LAND);
		dateForMatString.put("4", FORMAT_SCAPE_HMS);
		dateForMatString.put("5", FORMAT_HMS);
		dateForMatString.put("6", FORMAT_SCAPE_HMSS);
		dateForMatString.put("7", FORMAT_HOUR_MINUTE);
		dateForMatString.put("8", FORMAT_YEAR_MONTH);
		dateForMatString.put("9", FORMAT_SCAPE_HM);
		dateForMatString.put("10", FORMAT_YEAR);
		dateForMatString.put("11", FORMAT_MD);
		dateForMatString.put("12", FORMAT_MD_HM);
	}

	public static final String TIME_FORMAT = "00:00:00";

	/**
	 * 把string类型的日期转化为相应的格式
	 * 
	 * @param dateString
	 *            字符串日期
	 * @param formatNum
	 *            需要按照哪种类型,1:FORMAT,2:FORMAT_BIAS,3:FORMAT_LAND,4:
	 *            FORMAT_SCAPE_HMS,5:FORMAT_HMS,6:DATE_FORMAT_SCAPE_HMSS
	 * @return
	 */
	public static Date stringToDate(String dateString, int formatNum) {
		if (dateString == null || "".equals(dateString)) {
			return null;
		} else {
			return parseDate(dateString, formatNum);
		}
	}

	/**
	 * 根据传入的字符串长度自动判断，解析成date类型
	 * @param dateString
	 * @return
	 */
	public static Date stringToDate(String dateString) {
		if (dateString == null || "".equals(dateString)) {
			return null;
		} else {
			return parseDate(dateString);
		}
	}

	/**
	 * 把string类型的日期转化为相应的格式
	 * 
	 *            字符串日期
	 * @param formatNum
	 *            需要按照哪种类型,
	 *            1:FORMAT,2:FORMAT_BIAS,3:FORMAT_LAND,4:FORMAT_SCAPE_HMS
	 *            ,5:FORMAT_HMS,6:DATE_FORMAT_SCAPE_HMSS
	 * @return
	 */
	public static String dateToString(Date date, int formatNum) {
		if (date == null) {
			return null;
		} else {
			return parseString(date, formatNum);
		}
	}

	/**
	 * 将日期解析为07:22的形式
	 * @param date
	 * @return
	 */
	public static String dateToHMString(Date date) {
		if (date == null) {
			return null;
		} else {
			return parseString(date, SERIAL_HOUR_MINUTE);
		}
	}

	/**
	 * 解析成2007-09-08形式
	 * @param date
	 * @param formatNum
	 * @return
	 */
	public static String dateToYMDString(Date date) {
		if (date == null) {
			return null;
		} else {
			return parseString(date, 3);
		}
	}

	/**
	 * 解析成2007-09-08的date形式
	 * @param date
	 * @return
	 */
	public static Date dateToYMD(Date date) {
		if (date == null) {
			return null;
		} else {
			String s = dateToYMDString(date);
			return stringToDate(s);
		}
	}

	/**
	 * 解析成2007-09
	 * @param date
	 * @param formatNum
	 * @return
	 */
	public static String dateToYMString(Date date) {
		if (date == null) {
			return null;
		} else {
			return parseString(date, 8);
		}
	}

	/**
	 * 解析成2007-09-22 12:44:22
	 * @param date
	 * @param formatNum
	 * @return
	 */
	public static String dateToALLString(Date date) {
		if (date == null) {
			return null;
		} else {
			return parseString(date, 4);
		}
	}

	/**
	 * String转化Date
	 * 
	 * @param dateString
	 * @param formatNum
	 * @return
	 */
	private static Date parseDate(String dateString, int formatNum) {
		Date date = null;
		try {
			date = dateFormat(formatNum).parse(dateString);
		} catch (ParseException e) {
			// throw new RuntimeException("在将String类型转化为Date型发生错误。");
			return null;
		}
		return date;
	}

	/**
	 * String转化Date
	 * 
	 * @param dateString
	 * @param formatNum
	 * @return
	 */
	private static Date parseDate(String dateString) {
		Date date = null;
		if ("".equals(dateString)) {
			return null;
		}
		try {
			if (dateString.length() == FORMAT_SCAPE_HMSS.length()) {
				date = dateFormat(6).parse(dateString);
			}
			if (dateString.length() == FORMAT_SCAPE_HMS.length()) {
				date = dateFormat(4).parse(dateString);
			}
			if (dateString.length() == FORMAT_SCAPE_HM.length()) {
				date = dateFormat(9).parse(dateString);
			}
			if (dateString.length() == FORMAT_LAND.length()) {
				date = dateFormat(3).parse(dateString);
			}
		} catch (ParseException e) {
			// throw new RuntimeException("在将String类型转化为Date型发生错误。");
			return null;
		}
		return date;
	}

	/**
	 * Date转化String
	 * 
	 * @param date
	 * @param formatNum
	 * @return
	 */
	public static String parseString(Date date, int formatNum) {
		return dateFormat(formatNum).format(date);
	}

	/**
	 * 实例SimpleDateFormat
	 * 
	 * @param formatNum
	 * @return
	 */
	private static SimpleDateFormat dateFormat(int formatNum) {
		String key = formatNum + "";
		if (dateForMatObject.get(key) != null) {
			return dateForMatObject.get(key);
		} else {
			String formatString = dateForMatString.get(key);
			SimpleDateFormat f = new SimpleDateFormat(formatString);
			dateForMatObject.put(key, f);
			return f;
		}
	}

	/**
	 * 按指定格式返回时间
	 * 
	 * @param date
	 * @param formatNum
	 * @return
	 */
	// TODO 优化
	public static Date dateFormat(Date date, int formatNum) {
		return parseDate(dateToString(date, formatNum), formatNum);
	}

	/**
	 * 给一个日期加上N天或减去N天得到一个新的日期
	 * 
	 * @param startDate
	 *            需要增加的日期时间
	 * @param addnos
	 *            添加的天数，可以是正数也可以是负数
	 * @return 操作后的日期
	 */
	public static Date addDay(Date startDate, int addnos) {
		if (startDate == null) {
			startDate = new Date();
		}

		Calendar cc = Calendar.getInstance();
		cc.setTime(startDate);
		cc.add(Calendar.DATE, addnos);
		return cc.getTime();
	}

	/**
	 * 给一个字符格式的日期加上N天或减去N天得到一个新的日期
	 * 
	 * @param stringDate
	 *            需要增加的日期时间
	 * @param addnos
	 *            添加的天数，可以是正数也可以是负数
	 * @return 操作后的日期
	 */
	public static String addDay(String stringDate, int addnos) {
		int f = 3;
		if (stringDate.indexOf(":") != -1) {
			f = 4;
		}
		Date date = addDay(stringToDate(stringDate.trim(), f), addnos);
		return dateToString(date, f);
	}

	/**
	 * 给一个时间加上N分种或减去N分种后得到一个新的日期
	 * 
	 * @param startDate
	 *            需要增加的日期时间
	 * @param addnos
	 *            添加的分钟数，可以是正数也可以是负数
	 * @return 操作后的日期
	 */
	public static Date addMinute(Date startDate, int addnos) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
			cc.add(Calendar.MINUTE, addnos);
			return cc.getTime();
		} else {
			return null;
		}
	}
	/**
	 * 设置年月日得到想要的日期
	 * @param year 年份
	 * @param month 月份
	 * @param day 日期
	 * @return Date类型日期
	 */
	public static Date setYearMonthDay(int year,int month,int day){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	public static Date addHour(Date startDate, int addnos) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
			cc.add(Calendar.HOUR, addnos);
			return cc.getTime();
		} else {
			return null;
		}
	}

	public static Date addSecond(Date startDate, int addnos) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
			cc.add(Calendar.SECOND, addnos);
			return cc.getTime();
		} else {
			return null;
		}
	}

	/**
	 * 添加月份
	 * 
	 * @param startDate
	 * @param addnos
	 * @return
	 */
	public static Date addMonth(Date startDate, int addnos) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
			cc.add(Calendar.MONTH, addnos);
			return cc.getTime();
		} else {
			return null;
		}
	}

	/**
	 * 添加年
	 * 
	 * @param startDate
	 * @param addnos
	 * @return
	 */
	public static Date addYear(Date startDate, int addnos) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
			cc.add(Calendar.YEAR, addnos);
			return cc.getTime();
		} else {
			return null;
		}
	}

	/**
	 * 得到当前年份
	 * 
	 * @return
	 */
	public static int getNowYear() {
		Calendar cc = Calendar.getInstance();
		return cc.get(Calendar.YEAR);
	}

	/**
	 * 得到当前年份
	 * 
	 * @return
	 */
	public static int getDateOfYear(Date startDate) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
		}
		return cc.get(Calendar.YEAR);
	}

	/**
	 * 得到当前月份
	 * 
	 * @return
	 */
	public static int getDateOfMonth(Date startDate) {
		Calendar cc = Calendar.getInstance();
		if (startDate != null) {
			cc.setTime(startDate);
		}
		return cc.get(Calendar.MONTH);
	}

	/**
	 * 得到当前月份
	 * 
	 * @return
	 */
	public static int getNowMonth() {
		Calendar cc = Calendar.getInstance();
		return cc.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前日期
	 */
	public static int getNowday() {
		Calendar cc = Calendar.getInstance();
		return cc.get(Calendar.DATE);
	}

	/**
	 * 判断2个时间是否相等。
	 *  
	 * @param date1,date2
	 */
	public boolean isDateEqual(Date date1, Date date2) {
		boolean flag = false;
		try {

			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (date1 != null && date2 != null) {
				if (fmt.parse(fmt.format(date1)).equals(fmt.parse(fmt.format(date2)))) {
					flag = true;
				}
			}
		} catch (ParseException e) {
			System.out.print("[SYS] " + e.getMessage());
			flag = false;
		}
		return flag;

	}

	/**
	 * 比较两个日期的相差毫秒数,如果开始日期比结束日期早，则返回正数，否则返回负数。
	 * 
	 * @param start
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return
	 */
	public static long compareDate(Date start, Date end) {
		long temp = 0;
		Calendar starts = Calendar.getInstance();
		Calendar ends = Calendar.getInstance();
		starts.setTime(start);
		ends.setTime(end);
		temp = ends.getTime().getTime() - starts.getTime().getTime();
		return temp;
	}

	/**
	 * 比较两个日期的相差天数,如果开始日期比结束日期早，则返回正数，否则返回负数。
	 * 返回end - start的天数
	 * @param start
	 * @param end
	 * @return
	 */
	public static long compareDay(Date start, Date end) {
		long day = compareDate(start, end);
		return day / 1000 / 60 / 60 / 24;
	}

	/**
	 * 比较两个日期的相差天数,如果开始日期比结束日期早，则返回正数，否则返回负数。 0天返回0、小于等于一天返回1、大于一天返回2、依次类推
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static long dayDiff(Date start, Date end) {
		long day = compareDate(start, end);
		if (day == 0) {
			return 0;
		}
		if (day > 0) {
			return (day - 1) / 1000 / 60 / 60 / 24 + 1;
		} else {
			return (day + 1) / 1000 / 60 / 60 / 24 - 1;
		}

	}

	/**
	 * 返回两天的相差的小时数
	 * @param start
	 * @param end
	 * @return
	 */
	public static long hoursDiff(Date start, Date end) {
		long day = compareDate(start, end);
		if (day == 0) {
			return 0;
		}
		if (day > 0) {
			return (day - 1) / 1000 / 60 / 60 + 1;
		} else {
			return (day + 1) / 1000 / 60 / 60 - 1;
		}

	}

	/**
	 * 返回两天的相差的分钟
	 * @param start
	 * @param end
	 * @return
	 */
	public static long minutesDiff(Date start, Date end) {
		long day = compareDate(start, end);
		if (day == 0) {
			return 0;
		}
		if (day > 0) {
			return (day - 1) / 1000 / 60 + 1;
		} else {
			return (day + 1) / 1000 / 60 - 1;
		}

	}

	/**
	 * 得到一个日期的星期几数，星期日返回1以此类推,与真实的要减去1
	 * 
	 * @param date
	 * @return
	 */
	public static int getDateIsWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK);
		return week;
	}

	/**
	 * 返回一个日期的星期字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateToWeek(Date date) {
		int w = getDateIsWeek(date);
		String week = "星期";
		switch (w) {
		case 1:
			week += "日";
			break;
		case 2:
			week += "一";
			break;
		case 3:
			week += "二";
			break;
		case 4:
			week += "三";
			break;
		case 5:
			week += "四";
			break;
		case 6:
			week += "五";
			break;
		case 7:
			week += "六";
			break;
		}
		return week;
	}

	/**
	 * 根据日期得到入司时长<br>
	 * 1-3月=1;3-6月=3;6-12月=6;12-24月=12;24月以上=24;
	 * 请注意，如果一个员工是2008-01-01进入公司的，那么在2008
	 * -04-01那天仍然算是(1-3月),2008-04-02就算是(3-6月)的.
	 * 
	 * @param startWorkTime
	 *            入职时间
	 * @return 1,3,6,12,24
	 */
	public static int getJoinTime(Date startWorkTime) {
		if (startWorkTime == null) {
			return 1;
		}
		Date nowDate = dateFormat(addDay(new Date(), 1), 3);
		Date newdate = addMonth(startWorkTime, 3);
		long time = compareDate(newdate, nowDate);
		if (time > 0) {
			// 超过3个月
			newdate = addMonth(startWorkTime, 6);
			time = compareDate(newdate, nowDate);
			if (time > 0) {
				newdate = addMonth(startWorkTime, 12);
				time = compareDate(newdate, nowDate);
				if (time > 0) {
					newdate = addMonth(startWorkTime, 24);
					time = compareDate(newdate, nowDate);
					if (time > 0) {
						return 24;
					} else {
						return 12;
					}
				} else {
					return 6;
				}
			} else {
				return 3;
			}
		} else {
			return 1;
		}
	}

	/**
	 * 将日期格式转化为java.sql.Date类型，如果入参为null，则返回null
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date toSqlDate(Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * 将传入的s数转化为时分秒格式
	 * 
	 * @param time
	 * @return
	 */
	public static String convertTime(Long time) {
		long timelong = time.longValue();
		if (timelong == 0) {
			return TIME_FORMAT;
		}
		if (timelong > 0) {
			long h = 0, hh = 0;
			long m = 0, mm = 0;
			long s = 0;
			h = timelong / 3600;
			hh = timelong % 3600;
			m = hh / 60;
			mm = hh % 60;
			s = mm;
			String hStr, mStr, sStr = "";
			if (h < 10) {
				hStr = "0" + h;
			} else {
				hStr = "" + h;
			}
			if (m < 10) {
				mStr = "0" + m;
			} else {
				mStr = "" + m;
			}
			if (s < 10) {
				sStr = "0" + s;
			} else {
				sStr = "" + s;
			}
			// if (h > 0) {
			// return hStr + ":" + mStr + ":" + sStr;
			// }
			// if (h == 0 && m > 0) {
			// return mStr + ":" + s;
			// }
			// if (m == 0 && s > 0) {
			// return s + "s";
			// }
			return hStr + ":" + mStr + ":" + sStr;
		}
		return TIME_FORMAT;
	}

	/**
	 * 取得某一时间的某一个时刻的时间
	 * 
	 * @param date
	 *            某一时间
	 * @param millisecond
	 *            毫秒数
	 */
	public static String getNeedDate(Date date, long millisecond) {
		Date needDate = new Date();
		needDate.setTime(date.getTime() + millisecond);

		SimpleDateFormat dateFormatter = new SimpleDateFormat(FORMAT_SCAPE_HMS);
		if (logger.isDebugEnabled()) {
			logger.debug("当前时间：" + dateFormatter.format(date));
			logger.debug("你要的时间：" + dateFormatter.format(needDate));
		}

		return dateFormatter.format(needDate);
	}

	/**
	 * 返回接口需要的格式时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getInterFaceTime(Date date) {
		if (date != null) {
			String dateStr = StringDateUtil.dateToString(date, 4);
			return dateStr.substring(0, 10) + "T" + dateStr.substring(11);
		} else {
			return null;
		}
	}

	/**
	 * 接口时间String 转 本地日期Date
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getInterFaceToLocalTime(String dateStr) {
		if (dateStr != null) {
			dateStr = dateStr.replaceAll("T", " ");
			Date date = StringDateUtil.stringToDate(dateStr, 4);
			return date;
		} else {
			return null;
		}
	}

	public static List<String> getLatestMonth(Date date, int number) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		if (number >= 0) {
			for (int i = 0; i < number; i++) {
				Date d = addMonth(date, i);
				String s = parseString(d, 8);
				list.add(s);
			}
		} else {
			for (int i = number + 1; i <= 0; i++) {
				Date d = addMonth(date, i);
				String s = parseString(d, 8);
				list.add(s);
			}
		}
		return list;
	}

	public static List<String> getLatestYear(Date date, int number) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		if (number >= 0) {
			for (int i = 0; i < number; i++) {
				Date d = addYear(date, i);
				String s = parseString(d, 10);
				list.add(s);
			}
		} else {
			for (int i = number + 1; i <= 0; i++) {
				Date d = addYear(date, i);
				String s = parseString(d, 10);
				list.add(s);
			}
		}
		return list;
	}

	/**
	 * 得到当前年形于2008-07
	 * @return
	 */
	public static String getCurrentYMStr() {
		return StringDateUtil.parseString(new Date(), 8);
	}

	/**
	 * 得到当前年形于2008-07-03
	 * @return
	 */
	public static Date now() {
		return new Date();
	}
	
	public static Date dateStart(Date fDate) {
		return new Date();
	}
	
	/**
	 * 返回两个时间之前的所有时间(包含这两个时间)
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<Date> getBetweenDays(Date startDate, Date endDate) {
		int a = (int) compareDay(startDate, endDate);
		List<Date> test = new ArrayList<Date>();
		for (int i = 0; i <= a; i++) {
			test.add(addDay(startDate, i));
		}
		return test;
	}

	/**
	 * 
	 * 比较一个指定的时间是否在指定的范围内，如果在返回true
	 * @param appointDate
	 * @param startDate
	 * @param endDate
	 * @return
	 * 
	 */
	public static boolean checkDateInBetweenDays(Date appointDate, Date startDate,
			Date endDate) {
		//比结束时间大
		if (compareDate(appointDate, endDate) < 0) {
			return false;
		}

		//比开始时间小
		if (compareDate(appointDate, startDate) > 0) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 比较一个指定的时间是否在指定的范围内，如果在返回true
	 * @param appointDate
	 * @param startDate
	 * @param endDate
	 * @return
	 * 
	 */
	public static boolean checkDateInBetweenDaysOpen(Date appointDate, Date startDate,
			Date endDate) {
		//比结束时间大
		if (compareDate(appointDate, endDate) <= 0) {
			return false;
		}

		//比开始时间小
		if (compareDate(appointDate, startDate) >= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 返回两个日期中最小值
	 * @param one
	 * @param two
	 * @return
	 */
	public static Date minDate(Date one, Date two) {
		if (compareDate(one, two) > 0) {
			return one;
		} else {
			return two;
		}
	}

	/**
	 *  返回两个日期中最大值
	 * @param one
	 * @param two
	 * @return
	 */
	public static Date maxDate(Date one, Date two) {
		if (compareDate(one, two) > 0) {
			return two;
		} else {
			return one;
		}
	}

	/**
	 * 得到一天的最后一秒时间
	 * @param date
	 */
	public static Date getDayLastSecondTime(Date appointDate) {
		Date s = StringDateUtil.dateToYMD(appointDate);
		//第二天
		s = StringDateUtil.addDay(s, 1);
		//减少一秒
		return StringDateUtil.addSecond(s, -1);
		//return StringDateUtil.AddSecond(s, 23*60*60+59*60 + 59);
	}

	/**
	 * 得到一月的最后一天
	 * @param date
	 */
	public static Date getMoathLastDate(Date appointDate) {
		Date s = StringDateUtil.addMonth(appointDate, 1);
		String nex = StringDateUtil.dateToYMString(s) + "-01";
		Date nextMonthFristDate = StringDateUtil.stringToDate(nex);
		//下月的最后一天少一
		s = StringDateUtil.addDay(nextMonthFristDate, -1);
		return s;
		//return StringDateUtil.AddSecond(s, 23*60*60+59*60 + 59);
	}
	
	/**
	 * 得到一天的最后一秒时间
	 * @param date
	 * @return
	 */
	public static String foryyyyMMdd235959( Date date){
		SimpleDateFormat myFmt0=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		if(date==null){
			return null;
		}
		return myFmt0.format(date);
	}
	
	/**
	 * 得到一天的第一秒时间
	 * @param date
	 * @return
	 */
	public static String foryyyyMMdd000000( Date date){
		SimpleDateFormat myFmt0=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		if(date==null){
			return null;
		}
		return myFmt0.format(date);
	}
	
	/**
	 * 得到一天的最后一秒时间
	 * @param date
	 * @return
	 */
	public static Date foryyyyMMdd235959Date( Date date){
		SimpleDateFormat myFmt0=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		if(date==null){
			return null;
		}
		return parseDate(myFmt0.format(date));
	}
	
	/**
	 * 得到一天的第一秒时间
	 * @param date
	 * @return
	 */
	public static Date foryyyyMMdd000000Date( Date date){
		SimpleDateFormat myFmt0=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		if(date==null){
			return null;
		}
		return parseDate(myFmt0.format(date));
	}
	
	/**
	 * 时间加减
	 * @param date
	 * @param formatStr
	 * @param num
	 * @return
	 */
	public static Date addDateTime(Date date, String formatStr, int num){
		
		if(date != null && formatStr != null){
			Calendar calender = Calendar.getInstance();
			calender.setTime(date);
			if(formatStr.equals("yyyy")){
				calender.add(Calendar.YEAR, num);
			}else if(formatStr.equals("MM")){
				calender.add(Calendar.MARCH, num);
			}else if(formatStr.equals("dd")){
				calender.add(Calendar.DATE, num);
			}else if(formatStr.equals("hh")){
				calender.add(Calendar.HOUR, num);
			}else if(formatStr.equals("mm")){
				calender.add(Calendar.MINUTE, num);
			}else if(formatStr.equals("ss")){
				calender.add(Calendar.SECOND, num);
			}
			return calender.getTime();
		}
		return null;
	}
}
