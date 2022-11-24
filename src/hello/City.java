package hello;

public class City {
	private String name;
	private int temperature;

	public City() {
	}

	public City(String name, int temperature) {
		this.name = name;
		this.temperature = temperature;
	}

	public String getName() {
		return this.name;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public String ToString() {
		String string = "Ville : " + this.name + "\n" + "Temperature : " + this.temperature + "C";
		return string;
	}
}
