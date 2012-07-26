package shulei.july25;

public class CalendarUtil {

	static Calendar calendar = new Calendar();

	// �ж��Ƿ�������
	public static boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
			return false;
		}
		if (year % 4 == 0) {
			return true;
		}
		return false;
	}

	// �õ�ÿ���µ�������28,29,30,31
	public static int getEachMonthDayNumber(int year, int month) {

		if (isLeapYear(year)) {
			switch (month) {
			case 2:
				calendar.setDay_number(29);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				calendar.setDay_number(30);
				break;
			default:
				calendar.setDay_number(31);

			}
		} else {
			switch (month) {
			case 2:
				calendar.setDay_number(28);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				calendar.setDay_number(30);
				break;
			default:
				calendar.setDay_number(31);
			}
		}

		return calendar.getDay_number();
	}

	// �������ڵ�1900�������
	public static int getDaySum(int year, int month, int date) {
		int tempDaySum = 0;
		int tempYear = 1900;
		for (int i = 1; i <= year - 1900; i++, tempYear++) {
			// �����ȥ�����ʱ��
			if (isLeapYear(tempYear)) {
				tempDaySum += 366;
			} else {
				tempDaySum += 365;
			}

		}
		// �����ȥ��ʱ��
		for (int j = 1; j < month; j++) {
			tempDaySum += getEachMonthDayNumber(year, j);
		}
		// �ѹ�ȥ�ꡢ��ȥ��ʱ�� �ټ��ϱ��¹�ȥʱ��
		tempDaySum += date;

		calendar.setDaySum(tempDaySum);
		return calendar.getDaySum();
	}

	public static String getDay(int year, int month, int date) {
		int tempResult = getDaySum(year, month, date) % 7;
		switch (tempResult) {
		case 0:
			calendar.setDay("������");
			break;
		case 1:
			calendar.setDay("����һ");
			break;
		case 2:
			calendar.setDay("���ڶ�");
			break;
		case 3:
			calendar.setDay("������");
			break;
		case 4:
			calendar.setDay("������");
			break;
		case 5:
			calendar.setDay("������");
			break;
		case 6:
			calendar.setDay("������");
			break;

		}

		return calendar.getDay();
	}

	// ��ʾָ�����µ��Ǹ��µ�����
	public static String showMonthCalender(int year, int month) {
		int eachMonthDaysNumber = getEachMonthDayNumber(year, month);
		StringBuilder sBuilder = new StringBuilder();
		System.out.println(year + "��" + month + "��");
		sBuilder.append(year + "��" + month + "��" + "\n");
		int flag = 0;
		for (int i = 1; i <= 7; i++) {
			System.out.print(getDay(year, month, i) + "    ");
			sBuilder.append(getDay(year, month, i) + "    ");

		}
		System.out.println();
		sBuilder.append("\n");

		for (int i = 1; i <= eachMonthDaysNumber; i++) {
			if (i < 10) {
				System.out.print("  " + i + "    ");
				sBuilder.append("  " + i + "    ");
			} else {
				System.out.print("  " + i + "   ");
				sBuilder.append("  " + i + "    ");
			}

			flag++;
			if (flag == 7) {
				System.out.println();
				sBuilder.append("\n");
				flag = 0;
			}

		}
		sBuilder.append("\n");
		return sBuilder.toString();
	}

}
