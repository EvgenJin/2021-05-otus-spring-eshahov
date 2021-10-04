package ru.otus.spring.dao;

import java.io.IOException;
import java.util.List;

import ru.otus.spring.domain.Question;

public interface QuestionDao {
	
	List<Question> findQuestions();
	
	List<Question> findQuestions (String fileName) throws IOException;
	
}
