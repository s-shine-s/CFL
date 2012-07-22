package shulei.july22;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		while (true) {
			WeatherManager weatherManager = new WeatherManager();
			System.out.println("«Î ‰»Î≥« –£∫");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			String city = reader.readLine();
			// reader.close();
			if (city != null) {
				Weather weather = weatherManager.getWeather(city);

				System.out.println(weather.getWeatherInfo());
			}

		}

	}

}
