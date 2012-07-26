package shulei.july25;

/**
 * @time 2011-9-21 上午8:18:15
 * @author Rookie
 * 
 * @version 日历 v1.0
 * @function 日历类
 * 
 */

public class Calendar {
	// 年
	private int year = 1900;

	// 月
	private int month = 1;

	// 日
	private int date = 1;

	private int daySum = 0;
	// 定义星期几
	private String day = "星期一";

	// 每月天数
	private int day_number = 28;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getDaySum() {
		return daySum;
	}

	public void setDaySum(int daySum) {
		this.daySum = daySum;
	}

	public int getDay_number() {
		return day_number;
	}

	public void setDay_number(int dayNumber) {
		day_number = dayNumber;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

}
