package shulei.july26;

/**
 * 用来得到天干地支的年份
 * @author helloWorld
 *
 */
class ChineseEra {
	int iYear;
	String[] sHeavenlyStems = { "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬",
			"癸" };
	String[] sEarthlyBranches = { "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申",
			"酉", "戌", "亥" };

	public ChineseEra() { 
		this.iYear = 1981;
	}

	public ChineseEra(int iYear) {
		if ((iYear < 2050) && (iYear > 1901))
			this.iYear = iYear;
		else
			this.iYear = 1981;
	}

	public String toString() {
		int temp;
		temp = Math.abs(iYear - 1924);
		return sHeavenlyStems[temp % 10] + sEarthlyBranches[temp % 12];
	}
}