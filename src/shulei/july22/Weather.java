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
		return "城市:" + city + "   温度:" + temperature + "   风向:" + WD + "   风力:"
				+ WS + "  湿度:" + SD /* + "    天气:" + getWeatherStatusByWSE(WSE) */;

	}

	/**
	 * 
	 * 没找到天气接口郁闷啊
	 * @param wse
	 * @return
	 */
	private String getWeatherStatusByWSE(String wse) {
		int i = Integer.parseInt(wse);
		String statusString = "晴";
		switch (i) {
		case 1:
			statusString = "晴";
			break;
		case 2:
			statusString = "晴";
			break;
		case 3:
			statusString = "晴";
			break;
		case 4:
			statusString = "晴";
			break;
		case 5:
			statusString = "晴";
			break;
		case 6:
			statusString = "晴";
			break;

		default:
			statusString = "晴";
			break;
		}
		return statusString;
	}

}
