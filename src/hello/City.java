package hello;

public class City {
	private String name;
	private int temperature;
	private int feelsLike;
	private String weatherDescription;

	public City() {
	}

	public City(String name, int temperature, int feelsLike, String weatherDescription) {
		this.name = name;
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.weatherDescription = weatherDescription;
	}

	public String getName() {
		return this.name;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public int getFeelsLike() {
		return this.getFeelsLike();
	}

	public String ToString() {
		String string = "Ville : " + this.name + "\nCurrent weather : " + this.weatherDescription.toString() + "\n"
				+ "Temperature : " + this.temperature + "C" + "\nFeels like : " + this.feelsLike + "C";
		return string;
	}
}
