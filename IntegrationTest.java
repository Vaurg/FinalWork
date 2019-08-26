import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegrationTest {
	
	// Creating questions and answers for Integration Test
	@BeforeAll
	public static void setup() {
		QandAServices.functionalityTestCase1and2();
		Webdriver.chromedriver();
	}

	@Test
	@DisplayName ("Checking integration between Facebook and Trivia")
	public void testIntegrationBetweenFacebookAndTrivia() {
		System.out.println("Checking integration between Facebook and Trivia");
		
		MainServices.insertAllQuestionsAndAnswers();
		MiscServices.play();
		MainServices.gettingSuccessResultAllAnsweredRight();
		
		assertTrue(MainServices.IntegrationBetweenFacebookAndTrivia());
		
		System.out.println("Pass");		
	}
	
	@AfterAll
	public static void beforeEnd() {
		MiscServices.quitDriver();
	}
}
