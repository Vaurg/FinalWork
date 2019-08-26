import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class FunctionalityTestCase3 {

	public static int i =0;
	
	public static boolean answer [][] = {{false, false,  true},
										 {false,  true, false},
									 	 {false,  true,  true},
										 {true,  false, false}, 
										 {true,  false,  true},
										 {true,   true, false}};

	@BeforeEach
	public void emptyLine() {
		System.out.println();
		i++;
	}

	@RepeatedTest(4)
	@Order(1)
	@DisplayName ("Different length of questions and answers test")
	public void testWithDifferentLenghtOfQuestionsAndAnswers() {
		System.out.println("Input " + i +": question " + i*10 + " chars, answer " + (i+1)*5 + " chars");
		
		Webdriver.chromedriver();
		
		QandAServices.functionalityTestCase3(i);
		MainServices.insertAllQuestionsAndAnswers();
		MiscServices.play();
		
		assertTrue(MainServices.gettingSuccessResultAllAnsweredRight());
		
		System.out.println("Pass");
		
		if (i < 4)
			MiscServices.quitDriver();
		else {
			i = 0;
			MiscServices.tryAgain();
		}			
	}
	
	// All variations of wrong and right answers will be tested, except answering all wrong and answering all right,
	// because both of them were already tested.
	// true - answering right, false - answering wrong.
	@RepeatedTest(6)
	@Order(2)
	@DisplayName ("All variations of wrong and right answers test")
	public void testALLVariationsOfWrongAndRightAnswers() {
		System.out.println("Variation " + i + ":" + answer[i-1][0] + ", " + answer[i-1][1] + ", " + answer[i-1][2] + ".");
		
		if (i > 1)
			MiscServices.tryAgain();
				
		MainServices.answerQuestionPage(1, answer[i-1][0]);
		MainServices.answerQuestionPage(2, answer[i-1][1]);
		
		assertTrue(MainServices.answerQuestionPage(3, answer[i-1][2]));
		
		System.out.println("Pass");		
	}
	
	@AfterAll
	public static void beforeEnd() {
		MiscServices.quitDriver();
	}

}
