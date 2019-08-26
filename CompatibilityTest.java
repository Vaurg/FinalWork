import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CompatibilityTest {
	
	// Creating questions and answers for sanity test
	@BeforeAll
	public static void setup() {
		QandAServices.sanity();
		Webdriver.firefoxDriver();
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
		
		assertTrue(MainServices.enterQuestionAndOpenEnterAnswersPage(1, 1));
		
		System.out.println("Pass");
	}

	// Testing if enter question 2 page opens
	@Test
	@Order(4)
	@DisplayName ("Enter question 2 page test")
	public void testEnterAnswersForQuestion1AndOpenEnterQuestion2Page() {
		System.out.println("Running Enter question 2 page test");
		
		assertTrue(MainServices.enterAnswersAndOpenNextQuestionPage(1));
		
		System.out.println("Pass");
	}

	// Testing if enter answers for question 2 page opens
	@Test
	@Order(5)
	@DisplayName ("Enter answers for question 2 page test")
	public void testEnterQuestion2AndOpenEnterAnswersForQuestion2Page() {
		System.out.println("Running Enter answers for question 2 page test");
		
		assertTrue(MainServices.enterQuestionAndOpenEnterAnswersPage(2, 2));
		
		System.out.println("Pass");
	}

	// Testing if enter question 3 page opens
	@Test
	@Order(6)
	@DisplayName ("Enter question 3 page test")
	public void testEnterAnswersForQuestion2AndOpenEnterQuestion3Page() {
		System.out.println("Running Enter question 3 page page test");
		
		assertTrue(MainServices.enterAnswersAndOpenNextQuestionPage(2));
		
		System.out.println("Pass");
	}

	// Testing if enter answers for question 3 page opens
	@Test
	@Order(7)
	@DisplayName ("Enter answers for question 3 page test")
	public void testEnterQuestion3AndOpenEnterAnswersForQuestion3Page() {
		System.out.println("Running Enter answers for question 3 page test");
		
		assertTrue(MainServices.enterQuestionAndOpenEnterAnswersPage(3, 3));
		
		System.out.println("Pass");
	}
	
	// Testing if start playing page opens
	@Test
	@Order(8)
	@DisplayName ("Start playing page test")
	public void testEnterAnswersForQuestion3AndOpenStartPlayingPage() {
		System.out.println("Running Start playing page test");
		
		assertTrue(MainServices.enterAnswersAndOpenNextQuestionPage(3));
		
		System.out.println("Pass");
	}
	
	// Testing if answer first question page opens
	@Test
	@Order(9)
	@DisplayName ("Opening answer question 1 page test")
	public void testOpenAnswerFirstQuestionPage() {
		System.out.println("Running Answer question 1 page test");
		
		assertTrue(MainServices.openAnswerFirstQuestionPage());
		
		System.out.println("Pass");
	}
	
	// Testing if answer second question  page opens
	@Test
	@Order(10)
	@DisplayName ("Opening answer question 2 page test")
	public void testAnswerQuestion1Page() {
		System.out.println("Running Answer question 2 page test");
		
		assertTrue(MainServices.answerQuestionPage(1, true));
		
		System.out.println("Pass");
	}
	
	// Testing if answer third question  page opens
	@Test
	@Order(11)
	@DisplayName ("Opening answer question 3 page test")
	public void testAnswerQuestion2Page() {
		System.out.println("Running Answer question 3 page test");
		
		assertTrue(MainServices.answerQuestionPage(2, true));
		
		System.out.println("Pass");
	}
	
	// Testing if results page opens
	@Test
	@Order(12)
	@DisplayName ("Results page test")
	public void testAnswerQuestion3Page() {
		System.out.println("Running Results page test");
		
		assertTrue(MainServices.answerQuestionPage(3, true));
		
		System.out.println("Pass");
	}

	@AfterAll
	public static void beforeEnd() {
		MiscServices.quitDriver();
	}
}
