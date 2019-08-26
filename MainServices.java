
public class MainServices {
	
	// Opening Trivia homepage
	public static boolean homepage() {			
		MiscServices.goToHomepage();

		Exceptions.checkStartButton();

		return MiscServices.ifEqualsByID("Start", "startB");
	}

	// Opening enter question 1 page
	public static boolean openEnterQuestion1Page() {
		MiscServices.start();

		Exceptions.checkEnterQuestionHeading();

		return MiscServices.ifEqualsByID("question number: 1", "questhead");
	}

	// Typing each question and opening the answers for question  page
	// "questionInput" defines what we want to insert, "questionNumber" for checking if the next page opens correctly
	public static boolean enterQuestionAndOpenEnterAnswersPage(int questionInput, int questionNumber) {		
		QandAServices.typeQuestion(questionInput);
		
		MiscServices.nextPage();

		Exceptions.checkEnterAnswersHeading();

		return MiscServices.ifEqualsByID("question number: " + questionNumber, "answerhead");
	}

	// Typing answers for each question, checking the right radio button and opening the next question page or start playing page (when we finished to insert questions and answers)
	public static boolean enterAnswersAndOpenNextQuestionPage(int questionNumber) {
		QandAServices.typeAnswers(questionNumber);
		
		QandAServices.checkRightAnswerRadioButton(questionNumber);

		MiscServices.nextPage();

		if (questionNumber != 3) {
			Exceptions.checkEnterQuestionHeading();
			return MiscServices.ifEqualsByID("question number: " + (questionNumber + 1), "questhead");
		}

		else {
			Exceptions.checkStartPlayHeading();
			return MiscServices.ifEqualsByID("You finished to build the test - lets play!!", "needBackGround");	
		}
	}

	// Opening answer question 1 page
	public static boolean openAnswerFirstQuestionPage() {		
		MiscServices.play();
		
		return MiscServices.ifContains(QandAServices.input1.getQuestion()) || MiscServices.ifContains(QandAServices.input2.getQuestion()) || MiscServices.ifContains(QandAServices.input3.getQuestion());
	}

	
	// Answering to question and opening next question page or the results page if finished to answer questions
	// Variable "answer" defines if we answer wrong or right
	// Variable "endgame" was defined static, because it doesn't need to change, everytime the method is running
	public static String endgame = "Sucsses";
	public static boolean answerQuestionPage(int questionNumber, boolean answer) {
		if (!answer)
			endgame = "Failed";

		QandAServices.identifyAnswer(QandAServices.identifyQuestion(questionNumber), answer);

		MiscServices.nextPageTriviaMode();

		if (questionNumber != 3)
			return MiscServices.ifContains(QandAServices.input1.getQuestion()) || MiscServices.ifContains(QandAServices.input2.getQuestion()) || MiscServices.ifContains(QandAServices.input3.getQuestion());
		else {
			Exceptions.checkEndGameHeading();
			return MiscServices.ifEqualsByID(endgame, "mark");
		}
	}

	// Opening last question page and also checking if the random text we entered before in question is still there
	public static boolean openLastQuestionPage(int questionNumber) {

		MiscServices.lastPage();

		Exceptions.checkEnterQuestionHeading();

		return MiscServices.ifEqualsByID("question number: " + questionNumber, "questhead") && MiscServices.ifContains("abc");		
	}

	// Opening last page and also checking if the random text we entered before in question is still there
	public static boolean openLastAnswersPage(int questionNumber) {
		MiscServices.lastPage();

		Exceptions.checkEnterAnswersHeading();

		return MiscServices.ifEqualsByID("question number: " + questionNumber, "answerhead");		
	}

	// Editing question by deleting random text, inserting real question and checking if editing worked
	public static boolean changeRandomTextToRealQuestion(int questionNumber) {
		String question = null;

		QandAServices.editQuestion();

		QandAServices.typeQuestion(questionNumber);

		MiscServices.nextPage();
		MiscServices.lastPage();

		switch (questionNumber) {
			case 1: 
				question = QandAServices.input1.getQuestion();
				break;
	
			case 2: 
				question = QandAServices.input2.getQuestion();
				break;
	
			case 3: 
				question = QandAServices.input3.getQuestion();
				break;
	
			default:
				System.out.println("Wrong question index (editing question");
			}

		return MiscServices.ifContains(question);		
	}

	// Checking that all radio buttons are not selected before inserting answers
	static public boolean radioButtonsNotSelected() {
		return MiscServices.checkRadioButtonsNotSelected();		
	}

	// Checking that radio buttons can be reselected 
	static public boolean reselectRadioButton(int radioButtonIndex) {
		return MiscServices.checkClickAnotherRadioButton(radioButtonIndex);		
	}

	// Checking that radio buttons can be reselected in trivia mode
	static public boolean reselectRadioButtonTriviaMode(int radioButtonIndex, int questionNumber) {
		return MiscServices.checkClickAnotherRadioButtonTriviaMode(radioButtonIndex, (QandAServices.identifyQuestion(questionNumber) + 1));		
	}

	// Checking "Quit" button of Start playing page
	static public boolean quitButtonOfStartPlayingPage() {
		MiscServices.quit1();
		return MiscServices.ifContains("<html><head></head><body></body></html>");
	}

	// This method will insert all questions and answers instantly and stop at Start playing screen
	static public boolean insertAllQuestionsAndAnswers() {
		MiscServices.goToHomepage();

		MiscServices.start();

		QandAServices.typeQuestion(1);		
		MiscServices.nextPage();
		QandAServices.typeAnswers(1);
		QandAServices.checkRightAnswerRadioButton(1);
		MiscServices.nextPage();

		QandAServices.typeQuestion(2);		
		MiscServices.nextPage();
		QandAServices.typeAnswers(2);
		QandAServices.checkRightAnswerRadioButton(2);
		MiscServices.nextPage();

		QandAServices.typeQuestion(3);		
		MiscServices.nextPage();

		return enterAnswersAndOpenNextQuestionPage(3);		
	}

	// Opening last Start playing page
	static public boolean openLastStartPlayingPageTriviaMode() {
		MiscServices.lastPageTriviaMode();

		Exceptions.checkStartPlayHeading();
		return MiscServices.ifEqualsByID("You finished to build the test - lets play!!", "needBackGround");		
	}

	// Opening last question page trivia mode
	static public boolean openLastQuestionPageTriviaMode() {
		MiscServices.lastPageTriviaMode();		
		
		return MiscServices.ifContains(MiscServices.question);
	}

	// Checking that question mark added automatically to questions without question mark
	public static boolean questionMarkAddedAutomatically(int questionNumber) {

		return MiscServices.checkQuestionMarkAddedAutomatically(MiscServices.copyQuestion(questionNumber));		
	}

	// Checking "Try again" button
	public static boolean tryAgainButton() {
		MiscServices.tryAgain();
		
		return MiscServices.ifContains(QandAServices.input1.getQuestion()) || MiscServices.ifContains(QandAServices.input2.getQuestion()) || MiscServices.ifContains(QandAServices.input3.getQuestion());
	}
	
	// Answering all questions wrong to get a "Failed" result
	public static boolean gettingFailedResultAllAnsweredWrong() {
		answerQuestionPage(1, false);
		answerQuestionPage(2, false);
		return answerQuestionPage(3, false);
	}
	
	// Answering all questions wright to get a "success" result
	public static boolean gettingSuccessResultAllAnsweredRight() {
		answerQuestionPage(1, true);
		answerQuestionPage(2, true);
		return answerQuestionPage(3, true);
	}
	
	// Checking "Quit" button of Start playing page
	static public boolean quitButtonOfResultsPage() {
		MiscServices.quit2();
		
		return MiscServices.ifContains("<html><head></head><body></body></html>");
	}
	
	// Checking integration between Facebook and Trivia
	static public boolean IntegrationBetweenFacebookAndTrivia() {
		MiscServices.facebook();
		
		return MiscServices.ifContains("Facebook");
	}

} 
