package shulei.july26;

// 自定义星期类 
/**
 * 星期类，返回英文的星期
 * @author helloWorld
 *
 */
class Week {
	int iWeek;
	private String sWeek[] = { "Sunday", "Monday", "Tuesday", "Wednesday",
			"Thursday", "Friday", "Saturday" };

	public Week() {
		iWeek = 0;
	}

	public Week(int w) {
		if ((w > 6) || (w < 0)) {
			System.out.println("Week out of range, I think you want Sunday");
			this.iWeek = 0;
		} else
			this.iWeek = w;
	}

	public String toString() {
		return sWeek[iWeek];
	}
}