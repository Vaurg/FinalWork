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

class FunctionalityTestCase2 {

	public static int i =1;

	// Creating questions and answers for Functionality Test Case 2
	@BeforeAll
	public static void setup() {
		QandAServices.functionalityTestCase1and2();
		Webdriver.chromedriver();
	}

	@BeforeEach
	public void emptyLine() {
		System.out.println();
	}

	// Testing if Start playing page opens (after inserting all the questions and answers)
	@Test
	@Order(1)
	@DisplayName ("Start playing page test")
	public void test() {
		System.out.println("Running Start playing page test (after inserting all the questions and answers)");

		assertTrue(MainServices.insertAllQuestionsAndAnswers());

		System.out.println("Pass");
	}

	// Testing if answer first question page opens
	@Test
	@Order(2)
	@DisplayName ("Opening answer question 1 page test")
	public void testOpenAnswerFirstQuestionPage() {
		System.out.println("Running opening answer question 1 page test");

		assertTrue(MainServices.openAnswerFirstQuestionPage());

		System.out.println("Pass");
	}

	// Testing firth "Back" button in trivia mode
	@Test
	@Order(3)
	@DisplayName ("First \"Back\" button test in trivia mode")
	public void testOpenLastStartPlayingPageTriviaMode() {
		System.out.println("Running First \"Back\" button test in trivia mode (from answer question 1 page to Start playing page");

		assertTrue(MainServices.openLastStartPlayingPageTriviaMode());

		System.out.println("Pass");

		MiscServices.play();
	}

	// Testing that all radio buttons of answers for question 1 can be reselected in trivia mode
	@RepeatedTest(4)
	@Order(4)
	@DisplayName ("Reselect all radio buttons of answers for question 1 test")
	public void testReselectRadioButtonAnswersForQuestion1pageTriviaMode() {
		System.out.println("Running reselect radio button " + i + " test (answer question 1 page in trivia mode)");

		assertTrue(MainServices.reselectRadioButtonTriviaMode(i, 1));

		System.out.println("Pass");

		if (i < 4)
			i++;

		else if (i == 4)
			i = 1;		
	}

	// Testing that question mark added automatically to question 1 
	@Test
	@Order(5)
	@DisplayName ("Question mark added automatically to question 1 test")
	public void testQuestionMarkAddedAutomaticallytoQuestion1() {
		System.out.println("Running question mark added automatically test (question 1)");

		assertTrue(MainServices.questionMarkAddedAutomatically(1));

		System.out.println("Pass");
	}

	// Testing if answer second question  page opens
	@Test
	@Order(6)
	@DisplayName ("Opening answer question 2 page test")
	public void testAnswerQuestion1Page() {
		System.out.println("Running opening answer question 2 page test");

		assertTrue(MainServices.answerQuestionPage(1, true));

		System.out.println("Pass");
	}

	// Testing second "Back" button in trivia mode
	@Test
	@Order(7)
	@DisplayName ("Second \"Back\" button test in trivia mode")
	public void testOpenLastQuestion1PageTriviaMode() {
		System.out.println("Running second \"Back\" button test in trivia mode (from answer question 2 page to answer question 1 page");

		assertTrue(MainServices.openLastQuestionPageTriviaMode());

		System.out.println("Pass");

		MiscServices.nextPageTriviaMode();
	}

	// Testing that all radio buttons of answers for question 2 can be reselected in trivia mode
	@RepeatedTest(4)
	@Order(8)
	@DisplayName ("Reselect all radio buttons of answers for question 2 test")
	public void testReselectRadioButtonAnswersForQuestion2pageTriviaMode() {
		System.out.println("Running reselect radio button " + i + " test (answer question 2 page in trivia mode)");

		assertTrue(MainServices.reselectRadioButtonTriviaMode(i, 2));

		System.out.println("Pass");

		if (i < 4)
			i++;

		else if (i == 4)
			i = 1;		
	}
	
	// Testing that question mark added automatically to question 2 
	@Test
	@Order(9)
	@DisplayName ("Question mark added automatically to question 2 test")
	public void testQuestionMarkAddedAutomaticallyToQuestion2() {
		System.out.println("Running question mark added automatically test (question 2)");

		assertTrue(MainServices.questionMarkAddedAutomatically(2));

		System.out.println("Pass");
	}
	
	// Testing if answer third question  page opens
	@Test
	@Order(10)
	@DisplayName ("Opening answer question 3 page test")
	public void testAnswerQuestion2Page() {
		System.out.println("Running opening answer question 3 page test");

		assertTrue(MainServices.answerQuestionPage(2, true));

		System.out.println("Pass");
	}
	
	// Testing third "Back" button in trivia mode
	@Test
	@Order(11)
	@DisplayName ("Third \"Back\" button test in trivia mode")
	public void testOpenLastQuestion2PageTriviaMode() {
		System.out.println("Running third \"Back\" button test in trivia mode (from answer question 3 page to answer question 2 page");

		assertTrue(MainServices.openLastQuestionPageTriviaMode());

		System.out.println("Pass");

		MiscServices.nextPageTriviaMode();
	}
	
	// Testing that all radio buttons of answers for question 3 can be reselected in trivia mode
	@RepeatedTest(4)
	@Order(12)
	@DisplayName ("Reselect all radio buttons of answers for question 3 test")
	public void testReselectRadioButtonAnswersForQuestion3pageTriviaMode() {
		System.out.println("Running reselect radio button " + i + " test (answer question 3 page in trivia mode)");

		assertTrue(MainServices.reselectRadioButtonTriviaMode(i, 3));

		System.out.println("Pass");

		i++;
	}
	
	// Testing that question mark added automatically to question 3 
	@Test
	@Order(13)
	@DisplayName ("Question mark added automatically to question 3 test")
	public void testQuestionMarkAddedAutomaticallyToQuestion3() {
		System.out.println("Running question mark added automatically test (question 3)");

		assertTrue(MainServices.questionMarkAddedAutomatically(3));

		System.out.println("Pass");
	}
	
	// Testing if results page opens
	@Test
	@Order(14)
	@DisplayName ("Opening results page test")
	public void testAnswerQuestion3Page() {
		System.out.println("Opening running Results page test");

		assertTrue(MainServices.answerQuestionPage(3, true));

		System.out.println("Pass");
	}	
	
	// Testing "Try again" button
	@Test
	@Order(15)
	@DisplayName ("Running \"Try again\" button test")
	public void testTryAgainButton() {
		System.out.println("\"Try again\" button test");

		assertTrue(MainServices.tryAgainButton());

		System.out.println("Pass");
	}

	// Testing getting "Failed" result (answering all questions wrong)
	@Test
	@Order(16)
	@DisplayName ("Running getting \"Failed\" result test")
	public void testGettingFailedResultAllAnsweredWrong() {
		System.out.println("Getting \"Failed\" result all answered wrong test");

		assertTrue(MainServices.gettingFailedResultAllAnsweredWrong());

		System.out.println("Pass");
	}
	
	// Testing "Quit" button of results page
	@Test
	@Order(17)
	@DisplayName ("\"Quit\" button of Start playing page test")
	public void testQuitButtonOfResultsPage() {
		System.out.println("Running \"Quit\" button of Start playing page test");

		assertTrue(MainServices.quitButtonOfResultsPage());

		System.out.println("Pass");
	}	
	
	@AfterAll
	public static void beforeEnd() {
		MiscServices.quitDriver();
	}

}
