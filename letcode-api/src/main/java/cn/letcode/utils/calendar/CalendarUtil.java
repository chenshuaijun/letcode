package cn.letcode.utils.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具,请以更好的方式优化升级<br>
 * <b>注意: <i>请不要使用Date()类</i></b> <br>
 * yyyy(年)MM(月)dd(日)HH(时)mm(分)ss(秒) <br>
 * G 年代标志符<br>
 * y 年<br>
 * M 月<br>
 * d 日<br>
 * h 时 在上午或下午 (1~12)<br>
 * H 时 在一天中 (0~23)<br>
 * m 分<br>
 * s 秒<br>
 * S 毫秒<br>
 * E 星期<br>
 * D 一年中的第几天<br>
 * F 一月中第几个星期几<br>
 * w 一年中第几个星期<br>
 * W 一月中第几个星期<br>
 * a 上午 / 下午 标记符 <br>
 * k 时 在一天中 (1~24)<br>
 * K 时 在上午或下午 (0~11)<br>
 * z 时区<br>
 * 除了上述具有实际含义的字母之外，还可以配合诸如：空格、：、-等进行格式化设置。
 * 
 * @author chensj
 *
 */
public class CalendarUtil {
	private static String	defaultDateFormat		= "yyyyMMdd";
	private static String	defaultTimeFormat		= "HHmmss";
	private static String	defaultDateTimeFormat	= "yyyyMMddHHmmss";

	/**
	 * 获取当前时间 <br>
	 * 默认格式 : yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrentDateTime() {
		Calendar cal = Calendar.getInstance();
		return new SimpleDateFormat(defaultDateTimeFormat).format(cal.getTime());
	}

	/**
	 * 获取昨日时间 <br>
	 * 默认格式 : yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getYesterdayDateTime() {
		return getYesterdayDateTime(defaultDateTimeFormat);
	}

	/**
	 * 获取昨日时间 <br>
	 * 
	 * @param format
	 *            日期时间格式 例如：yyyyMMddHHmmss
	 * @return String
	 */
	public static String getYesterdayDateTime(String format) {
		Calendar cal = getOffsetDay(-1);
		return new SimpleDateFormat(format).format(cal.getTime());
	}

	/**
	 * 获取日期移量 <br>
	 * 
	 * @param offsetVal
	 *            日期偏移量
	 * @return Calendar
	 */
	public static Calendar getOffsetDay(int offsetVal) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, offsetVal);
		return cal;
	}

	/**
	 * 获取制定格式的当前日期时间
	 * 
	 * @param dateFormat
	 *            日期时间格式 ，例如 ：yyyyMMddHHmmss
	 * @return String
	 */
	public static String getCurrentDateTime(String dateFormat) {
		return formatDateTime(getCurrentDateTime(), defaultDateTimeFormat, dateFormat);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期 例如：20150202
	 * @return yyyy-MM-dd
	 */
	public static String formatDate(String date) {
		return formatDate(date, defaultDateFormat);
	}

	/**
	 * 格式化时间
	 * 
	 * @param time
	 *            时间 例如：123449
	 * @return HH:mm:ss
	 */
	public static String formatTime(String time) {
		return formatTime(time, defaultTimeFormat);
	}

	/**
	 * 格式化日期
	 * 
	 * @param datetime
	 *            日期时间 20160101123020
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDateTime(String datetime) {
		return formatDateTime(datetime, defaultDateTimeFormat);
	}

	/**
	 * 获取当前时间
	 * 
	 * @param date
	 *            日期时间字符串
	 * @param dateFormat 
	 *            日期格式，例如：yyyyMMdd
	 * @return 默认格式
	 */
	public static String formatDate(String date, String dateFormat) {
		return formatDateTime(date, defaultDateFormat, dateFormat);
	}

	/**
	 * 获取当前时间
	 * 
	 * @param time
	 *            日期时间字符串
	 * @param timeFormat
	 *            时间格式：HHmmss
	 * 
	 * @return 默认格式
	 */
	public static String formatTime(String time, String timeFormat) {
		return formatDateTime(time, defaultTimeFormat, timeFormat);
	}

	/**
	 * 获取当前时间
	 * 
	 * @param datetime
	 *            日期时间字符串
	 * @param dateFormat
	 *            日期格式：yyyyMMdd
	 * @return 默认格式
	 */
	public static String formatDateTime(String datetime, String dateFormat) {
		return formatDateTime(datetime, defaultDateTimeFormat, dateFormat);
	}

	/**
	 * 格式化日期
	 * 
	 * @param datetime
	 *            需要格式化的日期(例如 20150813 / 2015-08-13 / yyyy-mm-dd HH:mm:ss)
	 * @param oldFormat
	 *            原数据格式
	 * @param newFormat
	 *            新数据格式
	 * @return 目标格式
	 */
	public static String formatDateTime(String datetime, String oldFormat, String newFormat) {
		Date date;
		try {
			date = new SimpleDateFormat(oldFormat).parse(datetime);
			return new SimpleDateFormat(newFormat).format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datetime;
	}
}
