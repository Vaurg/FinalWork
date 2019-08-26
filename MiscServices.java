import org.openqa.selenium.By;

public class MiscServices extends Webdriver {
	
	// Variable for copying the question, will be used in FunctionalityTestCase2 junit for testin "Back" button in trivia mode
	public static String question; 

	// Opening homepage
	public static void goToHomepage() {
		driver.get("https://svcollegetest.000webhostapp.com/");
	}

	// Checking if web page contains the text
	public static boolean ifContains(String text) {
		if (driver.getPageSource().contains(text))
			return true;
		else
			return false;
	}

	// Another way to check if web page contains the text by ID
	public static boolean ifEqualsByID(String text, String ID) {
		if (text.equals(driver.findElement(By.id(ID)).getText()))
			return true;
		else
			return false;
	}

	// Another way to check if web page contains the text by Name
	public static boolean ifEqualsByName(String text, String name) {
		if (text.equals(driver.findElement(By.name(name)).getText()))
			return true;
		else
			return false;
	}

	// Clicking on "Start" button
	public static void start() {
		Exceptions.checkStartButton();
		Exceptions.checkAndClickStartButton();
	}

	// Clicking on "Play" button
	public static void play() {
		Exceptions.checkAndClickPlayButton();
	}

	// Clicking on "Next" button
	public static void nextPage() {
		Exceptions.checkAndClickNextButton();
	}

	// Clicking on "Back" button
	public static void lastPage() {
		Exceptions.checkAndClickBackButton();
	}

	// Clicking on "Next" button in trivia mode
	public static void nextPageTriviaMode() {
		Exceptions.checkAndClickNextButtonTriviaMode();
	}
	
	// Clicking on "Back" button in trivia mode
	public static void lastPageTriviaMode() {
		Exceptions.checkAndClickBackButtonTriviaMode();
	}
	
	// Clicking on "Quit" button of Start playing page
	public static void quit1() {
		Exceptions.checkAndClickQuitButtonStartPlayingPage();
	}
	
	// Clicking on "Quit" button of results page
	public static void quit2() {
		Exceptions.checkAndClickQuitButtonResultsPage();
	}
	
	// Clicking on "Try again" button of Start playing page
	public static void tryAgain() {
		Exceptions.checkAndClickTryAgainButton();
	}
	
	// Clecking on "Share on Facebook" button
	public static void facebook() {
		Exceptions.checkAndClickShareOnFacebookButton();
	}

	// Defining Xpath Array of radio buttons
	public static String [] defineRadioButtonXpathArray() {
		String [] radioButtonXpathArray = new String [4];
		radioButtonXpathArray [ 0] = "//*[@id=\"answers\"]/div[1]/div[1]/input";
		radioButtonXpathArray [ 1] = "//*[@id=\"answers\"]/div[2]/div[1]/input";
		radioButtonXpathArray [ 2] = "//*[@id=\"answers\"]/div[3]/div[1]/input";
		radioButtonXpathArray [ 3] = "//*[@id=\"answers\"]/div[4]/div[1]/input";

		return radioButtonXpathArray;
	}

	// Defining Xpath Array of radio buttons in trivia mode
	public static String [] defineRadioButtonXpathArrayTriviaMode(int questionNumber) {
		String [] radioButtonXpathArray = new String [4];

		switch (questionNumber) {
		case 1:
			radioButtonXpathArray [0] = "//*[@id=\"0\"]/input[1]";
			radioButtonXpathArray [1] = "//*[@id=\"0\"]/input[2]";
			radioButtonXpathArray [2] = "//*[@id=\"0\"]/input[3]";
			radioButtonXpathArray [3] = "//*[@id=\"0\"]/input[4]";
			break;

		case 2:
			radioButtonXpathArray [0] = "//*[@id=\"1\"]/input[1]";
			radioButtonXpathArray [1] = "//*[@id=\"1\"]/input[2]";
			radioButtonXpathArray [2] = "//*[@id=\"1\"]/input[3]";
			radioButtonXpathArray [3] = "//*[@id=\"1\"]/input[4]";
			break;

		case 3:
			radioButtonXpathArray [0] = "//*[@id=\"2\"]/input[1]";
			radioButtonXpathArray [1] = "//*[@id=\"2\"]/input[2]";
			radioButtonXpathArray [2] = "//*[@id=\"2\"]/input[3]";
			radioButtonXpathArray [3] = "//*[@id=\"2\"]/input[4]";
			break;

		default:
			System.out.println("Wrong question index (defining Xpath Array of radio buttons in trivia mode)");			
		}

		return radioButtonXpathArray;
	}

	// Checking if radio button selected or not
	public static boolean checkRadioButtonsNotSelected() {
		boolean result = false;

		String [] radioButtonXpathArray = new String [4];
		radioButtonXpathArray = defineRadioButtonXpathArray();

		for (int i = 0; i <= 3; i++) {
			Exceptions.checkRadioButton(radioButtonXpathArray[i]);
			if (driver.findElement(By.xpath(radioButtonXpathArray[i])).isSelected())
				result = true;
		}

		return result;			
	}

	// Checking if it's possible to select another radio button, if one already selected
	public static boolean checkClickAnotherRadioButton(int radioButtonIndex) {
		boolean result = true;

		String [] radioButtonXpathArray = new String [4];
		radioButtonXpathArray = defineRadioButtonXpathArray();

		if (radioButtonIndex == 1) {
			Exceptions.clickRadioButton(radioButtonXpathArray[radioButtonIndex - 1]);
			if (!(driver.findElement(By.xpath(radioButtonXpathArray[radioButtonIndex - 1])).isSelected()))
				result = false;
		}

		else if (radioButtonIndex >= 2 && radioButtonIndex <= 4) {
			Exceptions.clickRadioButton(radioButtonXpathArray[radioButtonIndex - 1]);
			if (!(driver.findElement(By.xpath(radioButtonXpathArray[radioButtonIndex - 1])).isSelected()) && driver.findElement(By.xpath(radioButtonXpathArray[radioButtonIndex - 2])).isSelected())
				result = false;
		}
		else {
			System.out.println("Radio button index is wrong");
			result = false;
		}
		
		return result;			
	}
	
	// Checking if it's possible to select another radio button, if one already selected
	public static boolean checkClickAnotherRadioButtonTriviaMode(int radioButtonIndex, int questionNumber) {
		boolean result = true;

		String [] radioButtonXpathArray = new String [4];
		radioButtonXpathArray = defineRadioButtonXpathArrayTriviaMode(questionNumber);

		if (radioButtonIndex == 1) {
			Exceptions.clickRadioButtonTriviaMode(radioButtonXpathArray[radioButtonIndex - 1]);
			if (!(driver.findElement(By.xpath(radioButtonXpathArray[radioButtonIndex - 1])).isSelected()))
				result = false;
		}

		else if (radioButtonIndex >= 2 && radioButtonIndex <= 4) {
			Exceptions.clickRadioButtonTriviaMode(radioButtonXpathArray[radioButtonIndex - 1]);
			if (!(driver.findElement(By.xpath(radioButtonXpathArray[radioButtonIndex - 1])).isSelected()) && driver.findElement(By.xpath(radioButtonXpathArray[radioButtonIndex - 2])).isSelected())
				result = false;
		}
		else {
			System.out.println("Radio button index is wrong");
			result = false;
		}
		
		return result;			
	}
	
	// Copying question
	public static String copyQuestion(int questionNumber) {
		question = null;
			
		switch (questionNumber) {
			case 1:
				Exceptions.checkFirstQuestion("//*[@id=\"2\"]/h3");
				question = driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText();		
				break;
				
			case 2:
				Exceptions.checkSecondQuestion("//*[@id=\"1\"]/h3");
				question = driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText();
				break;
				
			case 3:
				Exceptions.checkThirdQuestion("//*[@id=\"0\"]/h3");
				question = driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).getText();
				break;
				
			default:
					System.out.println("Wrong question index (checking question mark)");				
		}
		
		return question;
	}
		
	// Checking if question mark added automatically to question
	static public boolean checkQuestionMarkAddedAutomatically(String question) {
		boolean result = true;
		
		if (question.charAt(question.length() - 1) != '?')
			result = false;
		
		return result;	
	}
	
	
	
	// Quiting Web driver
	public static void quitDriver() {
		driver.quit();
	}
}
