package shulei.july22;

public class Weather {
	String city;
	String temperature;
	String WD;
	String WS;
	String SD;
	String WSE;

	public Weather(String city, String temperature, String wD, String wS,
			String sD, String wSE) {
		this.city = city;
		this.temperature = temperature;
		this.WD = wD;
		this.WS = wS;
		this.SD = sD;
		this.WSE = wSE;
	}

	public String getWeatherInfo() {
		return "����:" + city + "   �¶�:" + temperature + "   ����:" + WD + "   ����:"
				+ WS + "  ʪ��:" + SD /* + "    ����:" + getWeatherStatusByWSE(WSE) */;

	}

	/**
	 * 
	 * û�ҵ������ӿ����ư�
	 * @param wse
	 * @return
	 */
	private String getWeatherStatusByWSE(String wse) {
		int i = Integer.parseInt(wse);
		String statusString = "��";
		switch (i) {
		case 1:
			statusString = "��";
			break;
		case 2:
			statusString = "��";
			break;
		case 3:
			statusString = "��";
			break;
		case 4:
			statusString = "��";
			break;
		case 5:
			statusString = "��";
			break;
		case 6:
			statusString = "��";
			break;

		default:
			statusString = "��";
			break;
		}
		return statusString;
	}

}
