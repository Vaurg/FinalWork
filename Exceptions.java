import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;

public class Exceptions extends Webdriver{

	// Checking if "Start" button exists on web page
	public static void checkStartButton() {
		checkNoSuchElementExceptionByID("startB", "\"Start\" button");
	}

	// Checking if "Start" button interactable on web page
	public static void checkAndClickStartButton() {
		checkElementNotInteractableExceptionByID("startB", "\"Start\" button");
	}

	// Checking if "Enter question" heading exists on web page
	public static void checkEnterQuestionHeading() {
		checkNoSuchElementExceptionByID("questhead", "\"Enter question\" heading");
	}

	// Checking if "Enter question" heading exists on web page
	public static void checkEnterAnswersHeading() {
		checkNoSuchElementExceptionByID("answerhead", "\"Enter answers\" heading");
	}

	// Checking if "Next" button exists on web page and is interactable
	public static void checkAndClickNextButton() {
		checkNoSuchElementExceptionByID("nextquest", "\"Next\" button");
		checkElementNotInteractableExceptionByID("nextquest", "\"Next\" button");
	}
	// Checking if "Back" button exists on web page and is interactable
	public static void checkAndClickBackButton() {
		checkNoSuchElementExceptionByID("backquest", "\"Back\" button");
		checkElementNotInteractableExceptionByID("backquest", "\"Back\" button");
	}

	// Checking if "Start play" heading exists on web page
	public static void checkStartPlayHeading() {
		checkNoSuchElementExceptionByID("needBackGround", "\"Start play\" heading");
	}

	// Checking if "Play" button exists on web page and is interactable
	public static void checkAndClickPlayButton() {
		checkNoSuchElementExceptionByXPath("//*[@id=\"secondepage\"]/center/button[1]", "\"Play\" button");
		checkElementNotInteractableExceptionByXPath("//*[@id=\"secondepage\"]/center/button[1]", "\"Play\" button");
	}

	// Checking if "Next" button in trivia mode exists on web page and is interactable
	public static void checkAndClickNextButtonTriviaMode() {
		checkNoSuchElementExceptionByID("btnnext", "\"Next\" button in trivia mode");
		checkElementNotInteractableExceptionByID("btnnext", "\"Next\" button in trivia mode");
	}	
	
	// Checking if "Back" button in trivia mode exists on web page and is interactable
	public static void checkAndClickBackButtonTriviaMode() {
		checkNoSuchElementExceptionByID("btnback", "\"Back\" button in trivia mode");
		checkElementNotInteractableExceptionByID("btnback", "\"Back\" button in trivia mode");
	}

	// Checking if "Enter question" field exists on web page
	public static void checkEnterQuestionField() {
		checkNoSuchElementExceptionByName("question", "\"Enter question\" field");
	}

	// Checking if "Enter answers" fields exist on web page
	public static void checkEnterAnswersFields() {
		checkNoSuchElementExceptionByName("answer1", "\"Enter answer\" field");
	}

	// Checking if radio buttons exists on web page
	public static void checkRadioButton(String xpath) {
		checkNoSuchElementExceptionByXPath(xpath, "\"Check right answer\" radio button");
	}

	// Checking if radio button is interactable
	public static void clickRadioButton(String xpath) {
		checkElementNotInteractableExceptionByXPath(xpath, "\"Check right answer\" radio button");
	}	

	// Checking if radio button exists on web page in trivia mode
	public static void checkRadioButtonTriviaMode(String xpath) {
		checkNoSuchElementExceptionByXPath(xpath, "\"Right answer\" radio button");
	}

	// Checking if radio button is interactable in trivia mode
	public static void clickRadioButtonTriviaMode(String xpath) {
		checkElementNotInteractableExceptionByXPath(xpath, "\"Right answer\" radio button");
	}

	// Checking if the first question in trivia mode exists on web page
	public static void checkFirstQuestion(String xpath) {
		checkNoSuchElementExceptionByXPath(xpath, "\"First question\" question");	
	}

	// Checking if the second question in trivia mode exists on web page
	public static void checkSecondQuestion(String xpath) {
		checkNoSuchElementExceptionByXPath(xpath, "\"Second question\" question");	
	}

	// Checking if the third question in trivia mode exists on web page
	public static void checkThirdQuestion(String xpath) {
		checkNoSuchElementExceptionByXPath(xpath, "\"Third question\" question");	
	}

	// Checking if "End game" heading exists on web page
	public static void checkEndGameHeading() {
		checkNoSuchElementExceptionByID("mark", "\"End game\" heading");
	}	

	// Checking if "Quit" button of Start playing page exists on web page and is interactable
	public static void checkAndClickQuitButtonStartPlayingPage() {
		checkNoSuchElementExceptionByXPath("//*[@id=\"secondepage\"]/center/button[2]", "\"Quit\" button of Start playing page");
		checkElementNotInteractableExceptionByXPath("//*[@id=\"secondepage\"]/center/button[2]", "\"Quit\" button of Start playing page");
	}
	
	// Checking if "Quit" button of results page exists on web page and is interactable
	public static void checkAndClickQuitButtonResultsPage() {
		checkNoSuchElementExceptionByXPath("//*[@id=\"markpage\"]/center/button[2]", "\"Quit\" button of results page");
		checkElementNotInteractableExceptionByXPath("//*[@id=\"markpage\"]/center/button[2]", "\"Quit\" button of results page");
	}
	
	// Checking if "Try again" button exists on web page and is interactable
	public static void checkAndClickTryAgainButton() {
		checkNoSuchElementExceptionByXPath("//*[@id=\"markpage\"]/center/button[1]", "\"Try again\" button");
		checkElementNotInteractableExceptionByXPath("//*[@id=\"markpage\"]/center/button[1]", "\"Try again\" button");
	}
	
	// Checking if "Share on Facebook" button exists on web page and is interactable
		public static void checkAndClickShareOnFacebookButton() {
			checkNoSuchElementExceptionByXPath("//*[@id=\"fackBook2\"]/img", "\"Share on Facebook\" button");
			checkElementNotInteractableExceptionByXPath("//*[@id=\"fackBook2\"]/img", "\"Share on Facebook\" button");
		}

	// Checking NoSuchElementException exception by element ID 
	public static void checkNoSuchElementExceptionByID(String ID, String element) {
		try {
			driver.findElement(By.id(ID));
		}
		catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception: ");
			System.out.println("Web element " + element + " \"ID: " + ID + "\" doesn't exist");
		}
	}

	// Checking NoSuchElementException exception by element name
	public static void checkNoSuchElementExceptionByName(String name, String element) {
		try {
			driver.findElement(By.name(name));
		}
		catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception: ");
			System.out.println("Web element " + element + " \"name: " + name + "\" doesn't exist");
		}
	}

	// Checking NoSuchElementException exception by element xpath
	public static void checkNoSuchElementExceptionByXPath(String xpath, String element) {
		try {
			driver.findElement(By.xpath(xpath));
		}
		catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception: ");
			System.out.println("Web element " + element + " \"xpath: " + xpath + "\" doesn't exist");
		}
	}

	// Checking  ElementNotInteractableException exception by element xpath exception by element ID
	public static void checkElementNotInteractableExceptionByID(String ID, String element) {
		try {
			driver.findElement(By.id(ID)).click();
		}
		catch (ElementNotInteractableException e) {
			System.out.println("Element Not Interactable Exception: ");
			System.out.println("Web element " + element + " \"ID: " + ID + "\" isn't interactable");
		}
	}

	// Checking ElementNotInteractableException exception by element xpath exception by element name
	public static void checkElementNotInteractableExceptionByName(String name, String element) {
		try {
			driver.findElement(By.name(name)).click();
		}
		catch (ElementNotInteractableException e) {
			System.out.println("Element Not Interactable Exception: ");
			System.out.println("Web element " + element + " \"name: " + name + "\" isn't interactable");
		}
	}

	// Checking ElementNotInteractableException exception by element xpath exception by element xpath
	public static void checkElementNotInteractableExceptionByXPath(String xpath, String element) {
		try {
			driver.findElement(By.xpath(xpath)).click();
		}
		catch (ElementNotInteractableException e) {
			System.out.println("Element Not Interactable Exception: ");
			System.out.println("Web element " + element + " \"xpath: " + xpath + "\" isn't interactable");
		}
	}
}

