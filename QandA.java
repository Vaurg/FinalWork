
public class QandA {
	
	private String question;
	private String [] answer;
	private int rightAnswerIndex;
	
	// Constructor	
	public QandA(String question, String[] answer, int rightAnswerIndex) {
		this.question = question;
		this.answer = answer;
		this.rightAnswerIndex = rightAnswerIndex;
	}
	
	
	// Getters
	public String getQuestion() {
		return question;
	}

	public String[] getAnswer() {
		return answer;
	}
	
	public String getAnswer(int i) {
		return answer [i];
	}

	public int getRightAnswerIndex() {
		return rightAnswerIndex;
	}
	
	
	// Setters
	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public void setRightAnswerIndex(int rightAnswerIndex) {
		this.rightAnswerIndex = rightAnswerIndex;
	}
}
