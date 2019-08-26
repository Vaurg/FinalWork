import org.openqa.selenium.By;

public class QandAServices extends Webdriver {

	static QandA input1;
	static QandA input2;
	static QandA input3;
		
	// Creating questions and answers for sanity test
	public static void sanity() {
		String [] answers = {"a", "b", "c", "d"};
		input1 = new QandA("a", answers, 1);
		input2 = new QandA("b", answers, 2);
		input3 = new QandA("c", answers, 3);
	}
	
	// Creating questions (5 chars each) and answers (6 chars each) for Functionality tests cases 1 and 2
	public static void functionalityTestCase1and2() {
		String [] answers1 = {"aa aaa", "b bbbb", "cccc c", "ddd dd"};
		String [] answers2 = {"eeeeee", "fff ff", "gggg g", "hh hhh"};
		String [] answers3 = {"iii ii", "jjjjjj", "k kkkk", "llll l"};
		input1 = new QandA("abcde", answers1, 2);
		input2 = new QandA("fghij", answers2, 4);
		input3 = new QandA("klmno", answers3, 1);
	}
	
	// Creating questions and answers with different length
	// Case 1: question 10 chars, answer 10 chars
	// Case 2: question 20 chars, answer 15 chars
	// Case 3: question 30 chars, answer 20 chars
	// Case 4: question 40 chars, answer 25 chars
	public static void functionalityTestCase3(int inputNumber) {
		switch (inputNumber) {
			case 1:
				String [] answers1 = {"abc def gh", "vbn mnh nj", "fggfa ffff", "klmnjubgtr"};
				String [] answers2 = {"abg tf uhs", "as df ggaa", "aaaaaaaaaa", "hh hhh vvv"};
				String [] answers3 = {"aa ssdf ff", "wwwwwwwwww", "spqs fffff", "ert sdf ss"};
				input1 = new QandA("abcde klmn", answers1, 2);
				input2 = new QandA("fg hij qze", answers2, 1);
				input3 = new QandA("klmn o avb", answers3, 2);
				break;
				
			case 2:
				String [] answers4 = {"abc def ghgh gh", "vbn mnh nj gfff", "fggfaffff ssfsd", "klmnjubgtr vhjd"};
				String [] answers5 = {"abg tf uhs fghj", "as df ggaabbddf", "aaaaaaaaaaaaaaa", "hh hhh vvvdddfr"};
				String [] answers6 = {"aa ssdf fffghjd", "wwwwwwwwwwccccc", "spqs fffff cccc", "ert sdf sscc cc"};
				input1 = new QandA("abcde klmn abcde klm", answers4, 1);
				input2 = new QandA("fg hij qzedf gfgd dd", answers5, 3);
				input3 = new QandA("klmn o avbsdfs sdf f", answers6, 4);
				break;
				
			case 3:
				String [] answers7 = {"abc def ghh ghfgt yu", "vbn mnh nj gfffghjyt", "fggfaffff ssfsdafgty", "klmnjubgtr vhjd aftr"};
				String [] answers8 = {"abg tf uhs fghj ghty", "as df ggaabbddfagt y", "aaaaaaaaaaaaaaabbbbb", "hh hhh vvvdddfr fgtf"};
				String [] answers9 = {"aa ssdf fffghjdaaaaa", "wwwwwwwwwwcccccbbbbb", "spqs fffff cccc bbbb", "ert sdf sscc cc ffff"};
				input1 = new QandA("abcde klmn abcde klmanh sndg t", answers7, 2);
				input2 = new QandA("fg hij qzedf gfgd ddsssss dddd", answers8, 1);
				input3 = new QandA("klmn o avbsdfs sdf feeee fffff", answers9, 4);
				break;
				
			case 4:
				String [] answers10 = {"abc def ghh ghfgt yu ghfg", "vbn mnh nj gfffghjyt sd f", "fggfaffff ssfsdafgtydfrty", "klmnjubgtr vhjd aftr sdrd"};
				String [] answers11 = {"abg tf uhs fghj ghty gt d", "as df ggaabbddfagt ycccvv", "aaaaaaaaaaaaaaabbbbbvghyt", "hh hhh vvvdddfr fg tfdftr"};
				String [] answers12 = {"aa ssdf fffghjdaaaaa cccc", "wwwwwwwwwwcccccbbbbb ffff", "spqs fffff cccc bbbb ddrt", "ert sdf sscc cc ffff fffd"};
				input1 = new QandA("abcde klmn abcde klmanh sndg t klmn abcd", answers10, 3);
				input2 = new QandA("fg hij qzedf gfgd ddsssss ddddqzedf gfgs", answers11, 1);
				input3 = new QandA("klmn o avbsdfs sdf feeee fffffo avbsdfss", answers12, 2);
				break;
				
			default:
				System.out.println("Wrong input index (creating questions and answers for functionality test case 3)");
		}
	}
	
	// Cases 1, 2, 3: typing the questions.
	// Case 0: typing text "abc" for further editing test.
	public static void typeQuestion(int questionNumber) {
		Exceptions.checkEnterQuestionField();
		
		switch (questionNumber) {
			case 0:
				driver.findElement(By.name("question")).sendKeys("abc");
				break;
				
			case 1:
				driver.findElement(By.name("question")).sendKeys(input1.getQuestion());
				break;
				
			case 2:
				driver.findElement(By.name("question")).sendKeys(input2.getQuestion());
				break;
				
			case 3:
				driver.findElement(By.name("question")).sendKeys(input3.getQuestion());
				break;
				
			default:
				System.out.println("Wrong question index (entering question)");
		}
	}
	
	// Typing the answers of each question
	public static void typeAnswers(int questionNumber) {
		Exceptions.checkEnterAnswersFields();	
		
		switch (questionNumber) {
			case 1:
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys(input1.getAnswer(0));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys(input1.getAnswer(1));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys(input1.getAnswer(2));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys(input1.getAnswer(3));
				break;
				
			case 2:
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys(input2.getAnswer(0));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys(input2.getAnswer(1));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys(input2.getAnswer(2));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys(input2.getAnswer(3));
				break;
				
			case 3:
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys(input3.getAnswer(0));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys(input3.getAnswer(1));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys(input3.getAnswer(2));
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys(input3.getAnswer(3));
				break;
				
			default:
				System.out.println("Answers of wrong question index (entering answers)");
		}
	}

	// Marking the radio button of right answer
	public static void checkRightAnswerRadioButton(int questionNumber) {
		String xpath = null;
		
		String [] radioButtonXpathArray = new String [4];
		radioButtonXpathArray = MiscServices.defineRadioButtonXpathArray();
		
		switch (questionNumber) {
			case 1:
				xpath = radioButtonXpathArray [input1.getRightAnswerIndex() - 1];				
				break;
				
			case 2:  
				xpath = radioButtonXpathArray [input2.getRightAnswerIndex() - 1];				
				break;
				
			case 3:
				xpath = radioButtonXpathArray [input3.getRightAnswerIndex() - 1];				
				break;		
				
			default:
				System.out.println("Wrong right answer index (checking radio button)");				
		}
		
		Exceptions.checkRadioButton(xpath);
		Exceptions.clickRadioButton(xpath);
	}
	
	// Identifying the question and clicking the right or wrong answer accordingly to request
	public static int identifyQuestion(int questionNumber) {
		int i = 0;
		String [] questionsArray = {input1.getQuestion(), input2.getQuestion(), input3.getQuestion()};
		
		switch (questionNumber) {
			case 1:
				Exceptions.checkFirstQuestion("//*[@id=\"2\"]/h3");
				for (; !(questionsArray[i].equals(driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText())); i++) {}		
				break;
				
			case 2:
				Exceptions.checkSecondQuestion("//*[@id=\"1\"]/h3");
				for (; !(questionsArray[i].equals(driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText())); i++) {}
				break;
				
			case 3:
				Exceptions.checkThirdQuestion("//*[@id=\"0\"]/h3");
				for (; !(questionsArray[i].equals(driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).getText())); i++) {}
				break;
				
			default:
					System.out.println("Wrong question index (answering questions)");				
		}
		return i;
	}
	
	// Identifying the right answer and clicking the right or wrong answer accordingly to request
	public static void identifyAnswer(int i, boolean answer) {
		String xpath = null;
		
		if (answer)
			xpath = findRightAnswer(i + 1);
		else
			xpath = findWrongAnswer(i + 1);
		
		Exceptions.checkRadioButtonTriviaMode(xpath);
		Exceptions.clickRadioButtonTriviaMode(xpath);		
	}
	
	// Finding the right answer
		public static String findRightAnswer(int questionNumber) {
			String xpath = null;			
			String [] radioButtonXpathArray = new String [4];
			radioButtonXpathArray = MiscServices.defineRadioButtonXpathArrayTriviaMode(questionNumber);
			
			switch (questionNumber) {
				case 1:
					xpath = radioButtonXpathArray [input1.getRightAnswerIndex() - 1];
					break;
					
				case 2:
					xpath = radioButtonXpathArray [input2.getRightAnswerIndex() - 1];
					break;
					
				case 3:
					xpath = radioButtonXpathArray [input3.getRightAnswerIndex() - 1];
					break;
					
				default:
					System.out.println("Wrong question index (choosing right answer)");					
			}
			
			return xpath;
			
		}
		
		// Finding the wrong answer
		public static String findWrongAnswer(int questionNumber) {
			String xpath = null;			
			String [] radioButtonXpathArray = new String [4];
			radioButtonXpathArray = MiscServices.defineRadioButtonXpathArrayTriviaMode(questionNumber);
			
			switch (questionNumber) {
				case 1:
					xpath = radioButtonXpathArray [Math.abs(input1.getRightAnswerIndex() - 4)];
					break;
					
				case 2:
					xpath = radioButtonXpathArray [Math.abs(input2.getRightAnswerIndex() - 4)];
					break;
					
				case 3:
					xpath = radioButtonXpathArray [Math.abs(input3.getRightAnswerIndex() - 4)];
					break;
					
				default:
					System.out.println("Wrong question index (choosing wrong answer)");					
			}
			
			return xpath;			
		}
		
		// Editing random text that was inserted in question field
		public static void editQuestion() {
			Exceptions.checkEnterQuestionField();
			
			driver.findElement(By.name("question")).clear();			
		}
}
	
	



