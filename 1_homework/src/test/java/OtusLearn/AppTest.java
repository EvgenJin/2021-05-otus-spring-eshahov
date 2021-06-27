/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package OtusLearn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import ru.otus.spring.App;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dao.QuestionDaoImpl;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.QuestionService;
import ru.otus.spring.service.QuestionServiceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class AppTest {
	
	@Rule 
	public TestName name = new TestName();


    @Test public void testContext() {
    	App app = new App();
    	assertNotNull(app);
    }	
	

    @Test 
    public void testQuestionDao() {
    	QuestionDao questionDao = new QuestionDaoImpl("test.csv");
    	List<Question> questions = questionDao.findQuestions();
        assertTrue(questions.size() > 0);
    }
    
    @Test
    public void testQuestionService() {
    	QuestionDao questionDao = new QuestionDaoImpl("test.csv");
    	QuestionService questionService = new QuestionServiceImpl(questionDao);
    	assertTrue(questionService.getQuestions().size() > 0);    	
    }
}