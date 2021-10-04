package ru.otus.spring.domain;

public class Question {

	private String questionType;
	
	private String questionText;
	
	public Question (String questionType, String questionText) {
		this.questionText = questionText;
		this.questionType = questionType;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	public String toString() {
		return this.questionText;		
	}
	
}
