package shulei.july25;

/**
 * @time 2011-9-21 ����8:18:15
 * @author Rookie
 * 
 * @version ���� v1.0
 * @function ������
 * 
 */

public class Calendar {
	// ��
	private int year = 1900;

	// ��
	private int month = 1;

	// ��
	private int date = 1;

	private int daySum = 0;
	// �������ڼ�
	private String day = "����һ";

	// ÿ������
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
