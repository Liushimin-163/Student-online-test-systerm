package test.dao;
import Dao.imp.QuestionDao;
import entity.Question;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class QuestionDaoTest {
    @Test
    public void addTest(){
        QuestionDao questionDao=new QuestionDao();
        Question question=new Question();
        question.setTitle("Which describe a cat?");
        question.setOptionA("An animal has 2 legs.");
        question.setOptionB("An animal has 2 asses");
        question.setOptionC("An animal who could walk stand");
        question.setOptionD("An animal who has 2 eyes");
        question.setAnswer("D");
        int result=questionDao.add(question);
        Assert.assertSame(1,result);
    }
    @Test
    public void findAllQuestionTest(){
        QuestionDao questionDao=new QuestionDao();
        List<Question> list = questionDao.findAllQuestion();
        Assert.assertNotNull(list);
    }
    @Test
    public void deleteTest(){
        QuestionDao questionDao=new QuestionDao();
        int result=questionDao.delete("1");
        Assert.assertSame(1,result);
    }
    @Test
    public void findByIdTest(){
        QuestionDao questionDao=new QuestionDao();
        Question question=questionDao.findById("2");
        Assert.assertNotNull(question);
    }
    @Test
    public void updateTest(){
        QuestionDao questionDao=new QuestionDao();
        Question question=new Question();
        question.setTitle("Which describe a cat?");
        question.setOptionA("An animal has 4 legs.");
        question.setOptionB("An animal has 2 asses");
        question.setOptionC("An animal who could walk stand");
        question.setOptionD("An animal who has 3 eyes");
        question.setAnswer("A");
        question.setQuestionId(3);
        int result=questionDao.update(question);
        Assert.assertSame(1,result);
    }
    @Test
    public void findRandTest(){
        QuestionDao questionDao=new QuestionDao();
        List<Question> list = questionDao.findRand();
        Assert.assertNotNull(list);

    }
}
