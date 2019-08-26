import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class FunctionalityTestCase1 {

	public static int i =1;

	// Creating questions and answers for Functionality Test Case 1
	@BeforeAll
	public static void setup() {
		QandAServices.functionalityTestCase1and2();
		Webdriver.chromedriver();
	}

	@BeforeEach
	public void emptyLine() {
		System.out.println();
	}

	// Testing if Trivia homepage opens
	@Test
	@Order(1)
	@DisplayName ("Homepage test")
	public void testHomepage() {
		System.out.println("Running Homepage test");

		assertTrue(MainServices.homepage());

		System.out.println("Pass");
	}

	// Testing if enter question 1 page opens
	@Test
	@Order(2)
	@DisplayName ("Enter question 1 page test")
	public void testOpenQuestion1page() {
		System.out.println("Running Enter question 1 page test");

		assertTrue(MainServices.openEnterQuestion1Page());

		System.out.println("Pass");
	}

	// Testing if enter answers for question 1 page opens
	@Test
	@Order(3)
	@DisplayName ("Enter answers for question 1 page test")
	public void testEnterQuestion1AndOpenEnterAnswersForQuestion1Page() {
		System.out.println("Running Enter answers for question 1 page test");

		assertTrue(MainServices.enterQuestionAndOpenEnterAnswersPage(0, 1));

		System.out.println("Pass");
	}

	// Testing first "Back" button.
	@Test
	@Order(4)
	@DisplayName ("First \"Back\" button test")
	public void testOpenLastQuestion1Page() {
		System.out.println("Running first \"Back\" button test (from answers for question 1 page to question 1 page");

		assertTrue(MainServices.openLastQuestionPage(1));

		System.out.println("Pass");
	}

	// Testing editing question 1
	@Test
	@Order(5)
	@DisplayName ("Edit question 1 test")
	public void testChangeRandomTextToRealQuestion1() {
		System.out.println("Running edit question 1 test");

		assertTrue(MainServices.changeRandomTextToRealQuestion(1));

		System.out.println("Pass");

		MiscServices.nextPage();
	}

	// Testing that all radio buttons are not selected before inserting answers for question 1
	@Test
	@Order(6)
	@DisplayName ("All radio buttons of answers for question 1 are not selected test")
	public void testRadioButtonsNotSelectedAnswersForQuestion1page() {
		System.out.println("Running all radio buttons of answers for question 1 are not selected before inserting answers test");

		assertFalse(MainServices.radioButtonsNotSelected());

		System.out.println("Pass");
	}

	// Testing that all radio buttons of answers for question 1 can be reselected 
	@RepeatedTest(4)
	@Order(7)
	@DisplayName ("Reselect all radio buttons of answers for question 1 test")
	public void testReselectRadioButtonAnswersForQuestion1page() {
		System.out.println("Running reselect radio button " + i + " test (insert answers question 1 page)");

		assertTrue(MainServices.reselectRadioButton(i));

		System.out.println("Pass");

		if (i < 4)
			i++;

		else if (i == 4)
			i = 1;		
	}

	// Testing if enter question 2 page opens
	@Test
	@Order(8)
	@DisplayName ("Enter question 2 page test")
	public void testEnterAnswersForQuestion1AndOpenEnterQuestion2Page() {
		System.out.println("Running Enter question 2 page test");

		assertTrue(MainServices.enterAnswersAndOpenNextQuestionPage(1));

		System.out.println("Pass");
	}

	// Testing second "Back" button.
	@Test
	@Order(9)
	@DisplayName ("Second \"Back\" button test")
	public void testOpenLastAnswersforQuestion1Page() {
		System.out.println("Running second \"Back\" button test (from question 2 page to answers for question 1 page)");

		assertTrue(MainServices.openLastAnswersPage(1));

		System.out.println("Pass");

		MiscServices.nextPage();
	}

	// Testing if enter answers for question 2 page opens
	@Test
	@Order(10)
	@DisplayName ("Enter answers for question 2 page test")
	public void testEnterQuestion2AndOpenEnterAnswersForQuestion2Page() {
		System.out.println("Running Enter answers for question 2 page test");

		assertTrue(MainServices.enterQuestionAndOpenEnterAnswersPage(0, 2));

		System.out.println("Pass");
	}

	// Testing third "Back" button.
	@Test
	@Order(11)
	@DisplayName ("Third \"Back\" button test")
	public void testOpenLastQuestion2Page() {
		System.out.println("Running third \"Back\" button test (from answers for question 2 page to question 2 page");

		assertTrue(MainServices.openLastQuestionPage(2));

		System.out.println("Pass");
	}

	// Testing editing question 2
	@Test
	@Order(12)
	@DisplayName ("Edit question 2 test")
	public void testChangeRandomTextToRealQuestion2() {
		System.out.println("Running edit question 2 test");

		assertTrue(MainServices.changeRandomTextToRealQuestion(2));

		System.out.println("Pass");

		MiscServices.nextPage();
	}

	// Testing that all radio buttons are not selected before inserting answers for question 2
	@Test
	@Order(13)
	@DisplayName ("All radio buttons of answers for question 2 are not selected test")
	public void testRadioButtonsNotSelectedAnswersForQuestion2page() {
		System.out.println("Running all radio buttons of answers for question 2 are not selected before inserting answers test");

		assertFalse(MainServices.radioButtonsNotSelected());

		System.out.println("Pass");
	}

	// Testing that all radio buttons of answers for question 2 can be reselected 
	@RepeatedTest(4)
	@Order(14)
	@DisplayName ("Reselect all radio buttons of answers for question 2 test")
	public void testReselectRadioButtonAnswersForQuestion2page() {
		System.out.println("Running reselect radio button " + i + " test (insert answers question 2 page)");

		assertTrue(MainServices.reselectRadioButton(i));

		System.out.println("Pass");

		if (i < 4)
			i++;

		else if (i == 4)
			i = 1;		
	}

	// Testing if enter question 3 page opens
	@Test
	@Order(15)
	@DisplayName ("Enter question 3 page test")
	public void testEnterAnswersForQuestion1AndOpenEnterQuestion3Page() {
		System.out.println("Running Enter question 3 page test");

		assertTrue(MainServices.enterAnswersAndOpenNextQuestionPage(2));

		System.out.println("Pass");
	}

	// Testing fourth "Back" button.
	@Test
	@Order(16)
	@DisplayName ("Fourth \"Back\" button test")
	public void testOpenLastAnswersforQuestion2Page() {
		System.out.println("Running fourth \"Back\" button test (from question 3 page to answers for question 2 page)");

		assertTrue(MainServices.openLastAnswersPage(1));

		System.out.println("Pass");

		MiscServices.nextPage();
	}

	// Testing if enter answers for question 3 page opens
	@Test
	@Order(17)
	@DisplayName ("Enter answers for question 3 page test")
	public void testEnterQuestion2AndOpenEnterAnswersForQuestion3Page() {
		System.out.println("Running Enter answers for question 3 page test");

		assertTrue(MainServices.enterQuestionAndOpenEnterAnswersPage(0, 3));

		System.out.println("Pass");
	}

	// Testing fifth "Back" button.
	@Test
	@Order(18)
	@DisplayName ("Fifth \"Back\" button test")
	public void testOpenLastQuestion3Page() {
		System.out.println("Running fifth \"Back\" button test (from answers for question 3 page to question 3 page");

		assertTrue(MainServices.openLastQuestionPage(3));

		System.out.println("Pass");
	}

	// Testing editing question 3
	@Test
	@Order(19)
	@DisplayName ("Edit question 3 test")
	public void testChangeRandomTextToRealQuestion3() {
		System.out.println("Running edit question 3 test");

		assertTrue(MainServices.changeRandomTextToRealQuestion(3));

		System.out.println("Pass");

		MiscServices.nextPage();
	}

	// Testing that all radio buttons are not selected before inserting answers for question 3
	@Test
	@Order(20)
	@DisplayName ("All radio buttons of answers for question 3 are not selected test")
	public void testRadioButtonsNotSelectedAnswersForQuestion3page() {
		System.out.println("Running all radio buttons of answers for question 3 are not selected before inserting answers test");

		assertFalse(MainServices.radioButtonsNotSelected());

		System.out.println("Pass");
	}

	// Testing that all radio buttons of answers for question 3 can be reselected 
	@RepeatedTest(4)
	@Order(21)
	@DisplayName ("Reselect all radio buttons of answers for question 3 test")
	public void testReselectRadioButtonAnswersForQuestion3page() {
		System.out.println("Running reselect radio button " + i + " test (insert answers question 3 page)");

		assertTrue(MainServices.reselectRadioButton(i));

		System.out.println("Pass");	

		i++;
	}

	// Testing if start playing page opens
	@Test
	@Order(22)
	@DisplayName ("Start playing page test")
	public void testEnterAnswersForQuestion3AndOpenStartPlayingPage() {
		System.out.println("Running Start playing page test");

		assertTrue(MainServices.enterAnswersAndOpenNextQuestionPage(3));

		System.out.println("Pass");
	}
	
	// Testing "Quit" button of start playing page
	@Test
	@Order(23)
	@DisplayName ("\"Quit\" button of Start playing page test")
	public void testQuitButtonOfStartPlayingPage() {
		System.out.println("Running \"Quit\" button of Start playing page test");

		assertTrue(MainServices.quitButtonOfStartPlayingPage());

		System.out.println("Pass");
	}

	@AfterAll
	public static void beforeEnd() {
		MiscServices.quitDriver();
	}

}
