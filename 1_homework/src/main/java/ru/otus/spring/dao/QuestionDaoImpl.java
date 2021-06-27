package ru.otus.spring.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import ru.otus.spring.domain.Question;

public class QuestionDaoImpl implements QuestionDao {

    private String fileName;

	public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }	
	
	@Override
	public List<Question> findQuestions(String fileName) throws IOException {
		String separator = ";";
    	InputStream input = null;
    	List<Question> listQuestions = new ArrayList<>();
    	Map<String,String> mapString = new HashMap<>();
    	
		try {
			input = new ClassPathResource(fileName).getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	InputStreamReader inputStream = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        try (bufferedReader) {
        	String line;
       	
        	String headStr = bufferedReader.readLine();
        	String[] columns = headStr.split(separator);
        	
        	while ((line = bufferedReader.readLine()) != null) {
        		String[] values = line.split(separator);
        		int i= 0;
        		for (String value : values) {
        			mapString.put(columns[i++], value);
        		}
        		Question question = new Question(mapString.get("questionType"), mapString.get("questionText"));
        		listQuestions.add(question);        		
        	}
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
			bufferedReader.close();
			inputStream.close();
		}
        return listQuestions;
	}

	@Override
	public List<Question> findQuestions() {
		try {
			return findQuestions(this.fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
