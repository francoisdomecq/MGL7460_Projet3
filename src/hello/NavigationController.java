package hello;
public class NavigationController {

	public static void main(String[] args) {
		NavigationController navigationController = new NavigationController();
		navigationController.setHomepage();

	}

	private Action[] actions = new Action[] { new Action() {
		public void execute() {
			setActionPage();
		}
	}, new Action() {
		public void execute() {
			setSignInPage();
		}
	}, new Action() {
		public void execute() {
			setSignUpPage();
		}
	}, new Action() {
		public void execute() {
			setQuitAction();
		}
	}, new Action() {
		public void execute() {
			setMeteoRequestPage();
		}
	} };

	private UserDatabase userDatabase;

	private User loggedUser;

	private UIComponent uiComponent;

	private MeteoDataCenter meteoDataCenter;

	public NavigationController() {
		this.uiComponent = new UIComponent();
		this.userDatabase = new UserDatabase();
		this.meteoDataCenter = new MeteoDataCenter();
	}

	public void setHomepage() {
		this.uiComponent.showHomepage();
		int navigationAnswer = this.uiComponent.getNavigationAnswer(1, 3);
		this.actions[navigationAnswer].execute();
	}

	private void setActionPage() {
		this.uiComponent.showActionPage();
		int navigationAnswer = this.uiComponent.getNavigationAnswer(3, 4);
		this.actions[navigationAnswer].execute();
	}

	private void setSignInPage() {
		this.uiComponent.showSignPage();
		do {
			this.loggedUser = this.uiComponent.getSignAnswer();
		} while (!this.userDatabase.isUserCorrect(this.loggedUser));
		this.loggedUser = this.userDatabase.getUserByLogin(this.loggedUser.getLogin());
		this.setActionPage();
	}

	private void setSignUpPage() {
		this.uiComponent.showSignPage();
		this.loggedUser = this.uiComponent.getSignAnswer();
		this.userDatabase.addUser(this.loggedUser);
		this.setHomepage();

	}

	private void setMeteoRequestPage() {
		this.uiComponent.showMeteoRequestPage();
		String cityPicked = this.uiComponent.getCityAnswer(1, 2);
		City city = this.meteoDataCenter.getMeteoData(cityPicked);
		this.uiComponent.showMeteoData(city);
		this.setActionPage();

	}

	private void setQuitAction() {
		this.uiComponent.showExitAction();
		this.userDatabase.finalize();
		System.exit(0);
	}

	private interface Action {
		void execute();
	}

}