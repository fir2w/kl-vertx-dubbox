package com.klwork.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * 
 */
public class StringTool {
	// Constants used by escapeHTMLTags
	private static final char[] QUOTE_ENCODE = "&quot;".toCharArray();

	private static final char[] AMP_ENCODE = "&amp;".toCharArray();

	private static final char[] LT_ENCODE = "&lt;".toCharArray();

	private static final char[] GT_ENCODE = "&gt;".toCharArray();

	public static List quoteStrList(List list) {
		List tmpList = list;
		list = new ArrayList();
		Iterator i = tmpList.iterator();
		while (i.hasNext()) {
			String str = (String) i.next();
			str = "'" + str + "'";
			list.add(str);
		}
		return list;
	}

	public static String join(List list, String delim) {
		if (list == null || list.size() < 1)
			return null;
		StringBuffer buf = new StringBuffer();
		Iterator i = list.iterator();
		while (i.hasNext()) {
			buf.append((String) i.next());
			if (i.hasNext())
				buf.append(delim);
		}
		return buf.toString();
	}

	public static List split(String str, String delim) {
		List splitList = null;
		StringTokenizer st = null;
		if (str == null)
			return splitList;
		if (delim != null)
			st = new StringTokenizer(str, delim);
		else
			st = new StringTokenizer(str);

		if (st != null && st.hasMoreTokens()) {
			splitList = new ArrayList();
			while (st.hasMoreTokens())
				splitList.add(st.nextToken());
		}
		return splitList;
	}

	public static String createBreaks(String input, int maxLength) {
		char chars[] = input.toCharArray();
		int len = chars.length;
		StringBuffer buf = new StringBuffer(len);
		int count = 0;
		int cur = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isWhitespace(chars[i]))
				count = 0;
			if (count >= maxLength) {
				count = 0;
				buf.append(chars, cur, i - cur).append(" ");
				cur = i;
			}
			count++;
		}
		buf.append(chars, cur, len - cur);
		return buf.toString();
	}

	/**
	 * Escape SQL tags, ' to ''; \ to \\.
	 * 
	 * @param input
	 *            string to replace
	 * @return string
	 */
	public static String escapeSQLTags(String input) {
		if (input == null || input.length() == 0)
			return input;
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (ch == '\\')
				buf.append("\\\\");
			else if (ch == '\'')
				buf.append("\'\'");
			else
				buf.append(ch);
		}
		return buf.toString();
	}

	/**
	 * Escape HTML tags.
	 * 
	 * @param input
	 *            string to replace
	 * @return string
	 */
	public static String escapeHTMLTags(String input) {
		if (input == null || input.length() == 0)
			return input;
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (ch == '<')
				buf.append("&lt;");
			else if (ch == '>')
				buf.append("&gt;");
			else if (ch == '&')
				buf.append("&amp;");
			else if (ch == '"')
				buf.append("&quot;");
			else
				buf.append(ch);
		}
		return buf.toString();
	}

	/**
	 * Convert new lines, \n or \r\n to <BR />
	 * .
	 * 
	 * @param input
	 *            string to convert
	 * @return string
	 */
	public static String convertNewlines(String input) {
		input = replace(input, "\r\n", "\n");
		input = replace(input, "\n", "<BR />");
		return input;
	}

	/**
	 * Check a string null or blank.
	 * 
	 * @param param
	 *            string to check
	 * @return boolean
	 */
	public static boolean nullOrBlank(String param) {
		return (param == null || param.trim().equals("")) ? true : false;
	}

	public static String notNull(String param) {
		return param == null ? "" : param.trim();
	}

	/**
	 * Parse a string to int.
	 * 
	 * @param param
	 *            string to parse
	 * @return int value, on exception return 0.
	 */

	public static int parseInt(String param) {
		int i = 0;
		try {
			i = Integer.parseInt(param);
		} catch (Exception e) {
			i = (int) parseFloat(param);
		}
		return i;
	}

	public static long parseLong(String param) {
		long l = 0;
		try {
			l = Long.parseLong(param);
		} catch (Exception e) {
			l = (long) parseDouble(param);
		}
		return l;
	}

	public static float parseFloat(String param) {
		float f = 0;
		try {
			f = Float.parseFloat(param);
		} catch (Exception e) {
			//
		}
		return f;
	}

	public static double parseDouble(String param) {
		double d = 0;
		try {
			d = Double.parseDouble(param);
		} catch (Exception e) {
			//
		}
		return d;
	}

	/**
	 * Parse a string to boolean.
	 * 
	 * @param param
	 *            string to parse
	 * @return boolean value, if param begin with(1,y,Y,t,T) return true, on
	 *         exception return false.
	 */
	public static boolean parseBoolean(String param) {
		if (nullOrBlank(param))
			return false;
		switch (param.charAt(0)) {
		case '1':
		case 'y':
		case 'Y':
		case 't':
		case 'T':
			return true;
		}
		return false;
	}
	
	/**
	 * 将一个类型返回String类型
	 * @param <T>
	 * @param param
	 * @return
	 */
	public static <T> String parseToString(T param) {
		if (param == null)
			return "";
		else
			return param.toString();
	}

	/**
	 * Convert URL .
	 * 
	 * @param input
	 *            string to convert
	 * @return string
	 */
	public static String convertURL(String input) {
		if (input == null || input.length() == 0)
			return input;
		StringBuffer buf = new StringBuffer(input.length() + 25);
		char chars[] = input.toCharArray();
		int len = input.length();
		int index = -1;
		int i = 0;
		int j = 0;
		int oldend = 0;
		while (++index < len) {
			char cur = chars[i = index];
			j = -1;
			if ((cur == 'f' && index < len - 6 && chars[++i] == 't'
					&& chars[++i] == 'p' || cur == 'h' && (i = index) < len - 7
					&& chars[++i] == 't' && chars[++i] == 't'
					&& chars[++i] == 'p'
					&& (chars[++i] == 's' || chars[--i] == 'p'))
					&& i < len - 4
					&& chars[++i] == ':'
					&& chars[++i] == '/'
					&& chars[++i] == '/')
				j = ++i;
			if (j > 0) {
				if (index == 0 || (cur = chars[index - 1]) != '\''
						&& cur != '"' && cur != '<' && cur != '=') {
					cur = chars[j];
					while (j < len) {
						if (cur == ' ' || cur == '\t' || cur == '\''
								|| cur == '"' || cur == '<' || cur == '['
								|| cur == '\n' || cur == '\r' && j < len - 1
								&& chars[j + 1] == '\n')
							break;
						if (++j < len)
							cur = chars[j];
					}
					cur = chars[j - 1];
					if (cur == '.' || cur == ',' || cur == ')' || cur == ']')
						j--;
					buf.append(chars, oldend, index - oldend);
					buf.append("<a href=\"");
					buf.append(chars, index, j - index);
					buf.append('"');
					buf.append(" target=\"_blank\"");
					buf.append('>');
					buf.append(chars, index, j - index);
					buf.append("</a>");
				} else {
					buf.append(chars, oldend, j - oldend);
				}
				oldend = index = j;
			} else if (cur == '[' && index < len - 6
					&& chars[i = index + 1] == 'u' && chars[++i] == 'r'
					&& chars[++i] == 'l'
					&& (chars[++i] == '=' || chars[i] == ' ')) {
				j = ++i;
				int u2;
				int u1 = u2 = input.indexOf("]", j);
				if (u1 > 0)
					u2 = input.indexOf("[/url]", u1 + 1);
				if (u2 < 0) {
					buf.append(chars, oldend, j - oldend);
					oldend = j;
				} else {
					buf.append(chars, oldend, index - oldend);
					buf.append("<a href =\"");
					String href = input.substring(j, u1).trim();
					if (href.indexOf("javascript:") == -1
							&& href.indexOf("file:") == -1)
						buf.append(href);
					buf.append("\" target=\"_blank");
					buf.append("\">");
					buf.append(input.substring(u1 + 1, u2).trim());
					buf.append("</a>");
					oldend = u2 + 6;
				}
				index = oldend;
			}
		}
		if (oldend < len)
			buf.append(chars, oldend, len - oldend);
		return buf.toString();
	}

	/**
	 * Display a string in html page, call methods: escapeHTMLTags, convertURL,
	 * convertNewlines.
	 * 
	 * @param input
	 *            string to display
	 * @return string
	 */
	public static String dspHtml(String input) {
		String str = input;
		str = createBreaks(str, 80);
		str = escapeHTMLTags(str);
		str = convertURL(str);
		str = convertNewlines(str);
		return str;
	}

	/**
	 * 为空返回false
	 * 
	 * @param dest
	 * @return
	 */
	public static boolean judgeBlank(String dest) {
		if (dest == null || dest.trim().equals(""))
			return false;
		return true;
	}
	
	/**
	 * 为空返回false
	 * 
	 * @param dest
	 * @return
	 */
	public static boolean judgeBlank(Object dest) {
		if (dest == null)
			return false;
		return judgeBlank(dest.toString());
	}

	public static java.util.Date parseDate(String key) {
		String temp = key;
		java.util.Date date = null;
		if (temp != null && !temp.trim().equals("")) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			try {
				date = formatter.parse(temp);
			} catch (Exception e) {
				System.out.println("unparseable using " + formatter);
			}
		}
		return date;
	}

	public static java.util.Date parseDateYMD(String key) {
		String temp = key;
		java.util.Date date = null;
		if (temp != null && !temp.trim().equals("")) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = formatter.parse(temp);
			} catch (Exception e) {
				System.out.println("unparseable using " + formatter);
			}
		}
		return date;
	}

	/**
	 * 返回一个double类型的自然表示化的显示
	 */
	public static String doubleNativeFormat(double v) {
		// 得到本地的缺省格式
		if (v == 0.0)
			return "0.00";
		// DecimalFormat df1 = new DecimalFormat("####.00");
		DecimalFormat df1 = new DecimalFormat("#,###.00");
		return df1.format(v);
	}

	/**
	 * 返回一个double类型，返回一个四舍五入的double
	 * 
	 * @param dSource
	 *            原数据
	 * @param dSource
	 *            保留位数
	 */
	public static double getRound(double dSource, int bitnumber) {
		double dRound;
		// BigDecimal的构造函数参数类型是double
		BigDecimal deSource = new BigDecimal(dSource + "");
		// deSource.setScale(0,BigDecimal.ROUND_HALF_UP) 返回值类型 BigDecimal
		// intValue() 方法将BigDecimal转化为int
		dRound = deSource.setScale(bitnumber, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		return dRound;
	}

	/**
	 * 返回一个double类型的自然表示化的显示
	 */
	public static String doubleNativeFormats(double v) {
		// 得到本地的缺省格式
		if (v == 0.0)
			return "0.00";
		DecimalFormat df1 = new DecimalFormat("####.00");
		// DecimalFormat df1 = new DecimalFormat("#,###.00");
		return df1.format(v);
	}

	public static String getFilePathSeparator() {
		String separator = System.getProperty("file.separator");
		if (separator.equals("\\"))
			separator = separator + "\\";
		return separator;
	}

	/**
	 * Replaces all instances of oldString with newString in line.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replace(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * Replaces all instances of oldString with newString in line with the added
	 * feature that matches of newString in oldString ignore case.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replaceIgnoreCase(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		String lcLine = line.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * Replaces all instances of oldString with newString in line with the added
	 * feature that matches of newString in oldString ignore case. The count
	 * paramater is set to the number of replaces performed.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * @param count
	 *            a value that will be updated with the number of replaces
	 *            performed.
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replaceIgnoreCase(String line, String oldString,
			String newString, int[] count) {
		if (line == null) {
			return null;
		}
		String lcLine = line.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
			int counter = 0;
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
				counter++;
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			count[0] = counter;
			return buf.toString();
		}
		return line;
	}

	/**
	 * Replaces all instances of oldString with newString in line. The count
	 * Integer is updated with number of replaces.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replace(String line, String oldString,
			String newString, int[] count) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			int counter = 0;
			counter++;
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				counter++;
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			count[0] = counter;
			return buf.toString();
		}
		return line;
	}

	/**
	 * Converts a line of text into an array of lower case words using a
	 * BreakIterator.wordInstance().
	 * <p>
	 * 
	 * This method is under the Jive Open Source Software License and was
	 * written by Mark Imbriaco.
	 * 
	 * @param text
	 *            a String of text to convert into an array of words
	 * @return text broken up into an array of words.
	 */
	public static final String[] toLowerCaseWordArray(String text) {
		if (text == null || text.length() == 0) {
			return new String[0];
		}

		ArrayList wordList = new ArrayList();
		BreakIterator boundary = BreakIterator.getWordInstance();
		boundary.setText(text);
		int start = 0;

		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary
				.next()) {
			String tmp = text.substring(start, end).trim();
			// Remove characters that are not needed.
			tmp = replace(tmp, "+", "");
			tmp = replace(tmp, "/", "");
			tmp = replace(tmp, "\\", "");
			tmp = replace(tmp, "#", "");
			tmp = replace(tmp, "*", "");
			tmp = replace(tmp, ")", "");
			tmp = replace(tmp, "(", "");
			tmp = replace(tmp, "&", "");
			if (tmp.length() > 0) {
				wordList.add(tmp);
			}
		}
		return (String[]) wordList.toArray(new String[wordList.size()]);
	}

	/**
	 * Pseudo-random number generator object for use with randomString(). The
	 * Random class is not considered to be cryptographically secure, so only
	 * use these random Strings for low to medium security applications.
	 */
	private static Random randGen = new Random();

	/**
	 * Array of numbers and letters of mixed case. Numbers appear in the list
	 * twice so that there is a more equal chance that a number will be picked.
	 * We can use the array to get a random number or letter by picking a random
	 * array index.
	 */
	private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
			+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	/**
	 * Returns a random String of numbers and letters (lower and upper case) of
	 * the specified length. The method uses the Random class that is built-in
	 * to Java which is suitable for low to medium grade security uses. This
	 * means that the output is only pseudo random, i.e., each number is
	 * mathematically generated so is not truly random.
	 * <p>
	 * 
	 * The specified length must be at least one. If not, the method will return
	 * null.
	 * 
	 * @param length
	 *            the desired length of the random String to return.
	 * @return a random String of numbers and letters of the specified length.
	 */
	public static final String randomString(int length) {
		if (length < 1) {
			return null;
		}
		// Create a char buffer to put random letters and numbers in.
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}

	/**
	 * Intelligently chops a String at a word boundary (whitespace) that occurs
	 * at the specified index in the argument or before. However, if there is a
	 * newline character before <code>length</code>, the String will be chopped
	 * there. If no newline or whitespace is found in <code>string</code> up to
	 * the index <code>length</code>, the String will chopped at
	 * <code>length</code>.
	 * <p>
	 * For example, chopAtWord("This is a nice String", 10) will return "This is
	 * a" which is the first word boundary less than or equal to 10 characters
	 * into the original String.
	 * 
	 * @param string
	 *            the String to chop.
	 * @param length
	 *            the index in <code>string</code> to start looking for a
	 *            whitespace boundary at.
	 * @return a substring of <code>string</code> whose length is less than or
	 *         equal to <code>length</code>, and that is chopped at whitespace.
	 */
	public static final String chopAtWord(String string, int length) {
		if (string == null) {
			return string;
		}

		char[] charArray = string.toCharArray();
		int sLength = string.length();
		if (length < sLength) {
			sLength = length;
		}

		// First check if there is a newline character before length; if so,
		// chop word there.
		for (int i = 0; i < sLength - 1; i++) {
			// Windows
			if (charArray[i] == '\r' && charArray[i + 1] == '\n') {
				return string.substring(0, i + 1);
			}
			// Unix
			else if (charArray[i] == '\n') {
				return string.substring(0, i);
			}
		}
		// Also check boundary case of Unix newline
		if (charArray[sLength - 1] == '\n') {
			return string.substring(0, sLength - 1);
		}

		// Done checking for newline, now see if the total string is less than
		// the specified chop point.
		if (string.length() < length) {
			return string;
		}

		// No newline, so chop at the first whitespace.
		for (int i = length - 1; i > 0; i--) {
			if (charArray[i] == ' ') {
				return string.substring(0, i).trim();
			}
		}

		// Did not find word boundary so return original String chopped at
		// specified length.
		return string.substring(0, length);
	}

	/**
	 * Escapes all necessary characters in the String so that it can be used in
	 * an XML doc.
	 * 
	 * @param string
	 *            the string to escape.
	 * @return the string with appropriate characters escaped.
	 */
	public static final String escapeForXML(String string) {
		if (string == null) {
			return null;
		}
		char ch;
		int i = 0;
		int last = 0;
		char[] input = string.toCharArray();
		int len = input.length;
		StringBuffer out = new StringBuffer((int) (len * 1.3));
		for (; i < len; i++) {
			ch = input[i];
			if (ch > '>') {
				continue;
			} else if (ch == '<') {
				if (i > last) {
					out.append(input, last, i - last);
				}
				last = i + 1;
				out.append(LT_ENCODE);
			} else if (ch == '&') {
				if (i > last) {
					out.append(input, last, i - last);
				}
				last = i + 1;
				out.append(AMP_ENCODE);
			} else if (ch == '"') {
				if (i > last) {
					out.append(input, last, i - last);
				}
				last = i + 1;
				out.append(QUOTE_ENCODE);
			}
		}
		if (last == 0) {
			return string;
		}
		if (i > last) {
			out.append(input, last, i - last);
		}
		return out.toString();
	}

	/**
	 * Unescapes the String by converting XML escape sequences back into normal
	 * characters.
	 * 
	 * @param string
	 *            the string to unescape.
	 * @return the string with appropriate characters unescaped.
	 */
	public static final String unescapeFromXML(String string) {
		string = replace(string, "&lt;", "<");
		string = replace(string, "&gt;", ">");
		string = replace(string, "&quot;", "\"");
		return replace(string, "&amp;", "&");
	}

	private static final char[] zeroArray = "0000000000000000".toCharArray();

	/**
	 * Pads the supplied String with 0's to the specified length and returns the
	 * result as a new String. For example, if the initial String is "9999" and
	 * the desired length is 8, the result would be "00009999". This type of
	 * padding is useful for creating numerical values that need to be stored
	 * and sorted as character data. Note: the current implementation of this
	 * method allows for a maximum <tt>length</tt> of 16.
	 * 
	 * @param string
	 *            the original String to pad.
	 * @param length
	 *            the desired length of the new padded String.
	 * @return a new String padded with the required number of 0's.
	 */
	public static final String zeroPadString(String string, int length) {
		if (string == null || string.length() > length) {
			return string;
		}
		StringBuffer buf = new StringBuffer(length);
		buf.append(zeroArray, 0, length - string.length()).append(string);
		return buf.toString();
	}

	/**
	 * Formats a Date as a fifteen character long String made up of the Date's
	 * padded millisecond value.
	 * 
	 * @return a Date encoded as a String.
	 */
	public static final String dateToMillis(Date date) {
		return zeroPadString(Long.toString(date.getTime()), 15);
	}
	
	
	public String getNewString(String str,String patternStr,String  replaceStr){
		// str :        原字符串
		// patternStr:  正则表达式
		// replaceStr:  将要替换的字符串
		//使用正则表达式"程序员"创建一个正则表达式对象
		Pattern pattern = Pattern.compile(patternStr);
		//使用字符串"我是一个程序员"创建一个匹配对象
		Matcher matcher = pattern.matcher(str);
		//看看是否有匹配到
		if(matcher.find()){
			//匹配到了，进行替换
			//这里使用replaceFirst，而不使用replaceAll（在这里也可以使用这个）。
			//在某些情况下不得不使用replaceFirst来一个个的进行替换
			str = matcher.replaceFirst(replaceStr);
			}
			//打印出结果，结果应该是：我是一个系统分析员
			System.out.println(str);
			return str;
	}
	
	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double doubleAdd(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.add(b2)).doubleValue();
	}

	/**
	 * 将DOUBLE类型的数据进行格式化
	 * 
	 * @param str
	 *            double类型数据
	 * @param max
	 *            保存小数点后最多位数据
	 * @param min
	 *            如果小数点后都为0，则保留最小位数
	 * @return
	 */
	public static String NumberFormat(double str, int max, int min) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(max);
		nf.setMinimumFractionDigits(min);
		return nf.format(str);
	}
	
	/**
	 * 判断字符串是否是Double
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?\\d*(\\.\\d*)?");
		boolean bool = pattern.matcher(str).matches();
		return bool;
	}

	/**
	 * 根据分割符，把字符串转化集合Set
	 * 
	 * @param str
	 * @param sign
	 * @return
	 */
	public static Set strToTreeSet(String str, String split) {
		Set set = new HashSet();
		if (str != null) {
			set = new HashSet(Arrays.asList(str.split(split)));
		}
		System.out.println("集合set=" + set + ",size=" + set.size());
		return set;
	}
	
	/**
	 * 
	 * 产生随机数
	 * @param duration
	 * @return
	 * 
	 */
	public static int currentRandomNumber(int duration) {
    	int number = randGen.nextInt(duration);
    	return number;
	}
	
	
	public static String subString(String text, int length) {        
	    int textLength = text.length();  
	    int byteLength = 0;  
	    StringBuffer returnStr =  new StringBuffer();  
	    for(int i = 0; i<textLength && byteLength < length*2; i++){  
	        String str_i = text.substring(i, i+1);
	        //英文
	        if(str_i.getBytes().length == 1){  
	            byteLength++;  
	        //中文    
	        }else{  
	            byteLength += 2 ;  
	        }  
	        returnStr.append(str_i);  
	    }  
	    return returnStr.toString();  
	}  
	
	public static String changeCharset(String source,String fromCharset,String toCharset){
//		String rtnStr = source;
//		try {
//			rtnStr = new String(rtnStr.getBytes(fromCharset),toCharset);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return rtnStr;
		return source;
	}
	
	public static String changeCharset(String source,String toCharset){
//		String rtnStr = source;
		try {
			source = new String(source.getBytes(),toCharset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		
//		return rtnStr;
		return source;
	}
	
	public static int totalChineseWords(String str) {
		String anotherString = null;
		try {
			anotherString = new String(str.getBytes("GBK"), "ISO8859_1");
		} catch (UnsupportedEncodingException ex) {
		}

		if (str == null || str.length() <= 0) {
			return 0;
		}
		int lengh = anotherString.length();
		if (lengh % 2 != 0) {
			lengh += 1;
		}
		return lengh/2;
	}
	
	public static StringBuilder getSplitString(String str, String splitStr,int number) {
		StringBuilder buffer =  new StringBuilder(str.length() + (int)number);
		double a = str.length();
		double times = Math.ceil(a / number);
		for (int i = 0; i < (int) times; i++) {
			int last = (int) times - 1;
			if (i < last) {
				int start = (int) (number * i);
				int end = (int) (number * (i + 1));
				buffer.append((str.substring(start, end)));
				buffer.append(splitStr);
			} else {
				int start = (int) (number * i);
				buffer.append((str.substring(start)));
				buffer.append(splitStr);
			}
		}
		return buffer;
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		return temp;
	}
	//获得指定数量的UUID
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

}