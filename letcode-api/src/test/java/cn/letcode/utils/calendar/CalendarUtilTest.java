package cn.letcode.utils.calendar;

import org.junit.Test;

import cn.letcode.utils.calendar.CalendarUtil;

/**
 * 日历工具类测试方法（junit测试）
 * 
 * @author chensj
 *
 */
public class CalendarUtilTest {

	@Test
	public void test() {
		System.out.println(
				"1." + CalendarUtil.formatDateTime("2015-08-19 23:23:12", "yyyy-mm-dd HH:mm:ss", "yyyy/mm/dd HHmmss"));
		System.out.println("2." + CalendarUtil.getCurrentDateTime());
		System.out.println("3." + CalendarUtil.getCurrentDateTime("yyyy-MM-dd"));
		System.out.println("4." + CalendarUtil.getCurrentDateTime("HH:mm:ss"));
		System.out.println("5." + CalendarUtil.getCurrentDateTime("yyyy:MM:dd HH-mm-ss"));
		System.out.println("6." + CalendarUtil.formatDate(CalendarUtil.getCurrentDateTime("yyyyMMdd"), "yyyy-MM-dd"));
		System.out.println("7." + CalendarUtil.getYesterdayDateTime("yyyy-MM-dd"));
	}
}
