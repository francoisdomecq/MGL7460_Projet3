package hello;
import java.util.Scanner;

public class UIComponent {

	private Scanner scanner;

	private Cities cities;

	public UIComponent() {
		this.scanner = new Scanner(System.in);
		this.cities = new Cities();
	}

	public void showHomepage() {
		System.out.println("Welcome to the meteo data center:\n" + "  1. Sign in\n" + "  2. Sign up\n" + "  3. Quit");
	}

	public void showSignPage() {
		System.out.println("Please enter your login and your password:");
	}

	public void showActionPage() {
		System.out.println("Please choose an action:\n" + "  3. Quit\n" + "  4. Get meteo data\n");
	}

	public void showMeteoRequestPage() {
		System.out.print("Please select the city : ");
	}

	public void showMeteoData(City city) {
		System.out.println(city.ToString());
		this.waitPressingEnter();
	}

	public void showExitAction() {
		System.out.println("Goodbye!");
	}

	public void waitPressingEnter() {
		System.out.println("\nPress enter to continue");
		this.scanner.nextLine();
	}

	public int getNavigationAnswer(int minAnswer, int maxAnswer) {
		try {
			System.out.print("\nYour action: ");
			int action = fromStringToIntAnswer(this.scanner.nextLine());
			if (action < minAnswer || action > maxAnswer) {
				throw new NumberFormatException();
			}
			return action;
		} catch (NumberFormatException e) {
			System.out.println("Incorect answer, please retry:");
			return this.getNavigationAnswer(minAnswer, maxAnswer);
		}
	}

	public String getStringAnswer(String textToPrint) {
		System.out.print(textToPrint + ": ");
		return this.scanner.nextLine();
	}

	public User getSignAnswer() {
		System.out.print("Login: ");
		String login = this.scanner.nextLine();
		System.out.print("Password: ");
		String password = this.scanner.nextLine();
		return new User(login, password);
	}

	public User getUserAnswer() {
		System.out.print("Login: ");
		String login = this.scanner.nextLine();
		System.out.print("Password: ");
		String password = this.scanner.nextLine();
		return new User(login, password);
	}

	public String getCityAnswer(int minAnswer, int maxAnswer) {
		System.out.println(this.cities.ToString() + "\n");
		try {
			int action = fromStringToIntAnswer(this.scanner.nextLine());
			if (action < minAnswer || action > maxAnswer) {
				throw new NumberFormatException();
			}
			return cities.getCity(action - 1);
		} catch (NumberFormatException e) {
			System.out.println("Incorect answer, please retry:");
			return this.getCityAnswer(minAnswer, maxAnswer);
		}
	}

	private int fromStringToIntAnswer(String input) throws NumberFormatException {
		return Integer.parseInt(input);
	}

}