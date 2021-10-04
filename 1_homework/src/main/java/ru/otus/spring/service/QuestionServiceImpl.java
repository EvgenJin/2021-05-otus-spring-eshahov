package ru.otus.spring.service;

import java.util.List;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao;
	
	public QuestionServiceImpl(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public List<Question> getQuestions() {
		return questionDao.findQuestions();
	}

	@Override
	public void printQuestions() {
		List<Question> listQuestion = getQuestions();
		for (Question question : listQuestion) {
			System.out.println(question.toString());
		}
	}
	
}
