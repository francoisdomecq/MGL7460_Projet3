package hello;
import java.net.URL;
import java.util.Scanner;
import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MeteoDataCenter {

	public City getMeteoData(String cityName) {
		City city = new City();
		try {
			URL url = new URL("http://api.weatherstack.com/current?access_key=3cc18e10889f2277ef4544a3b78fd304&query="
					+ cityName);
			// URL url = new URL("https://ensc-ensciens.azurewebsites.net/api/Eleveapi");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode : " + responseCode);
			} else {

				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}

				scanner.close();

				JSONParser parser = new JSONParser();
				JSONObject object = (JSONObject) parser.parse(String.valueOf(informationString));
				JSONObject weather = (JSONObject) object.get("current");

				int temperature = Integer.parseInt(weather.get("temperature").toString());

				city = new City(cityName, temperature);

				return city;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

}