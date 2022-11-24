package hello;

public class Cities {
	private String[] cities;

	public Cities() {
		this.cities = new String[] { "Montreal", "Quebec" };
	}

	public String getCity(int index) {
		return this.cities[index];
	}

	public String ToString() {
		String stringToReturn = "";
		for (int i = 0; i < this.cities.length; i++) {
			int index = i + 1;
			stringToReturn += "\n" + index + " : " + this.cities[i];
		}
		return stringToReturn;
	}
}
