package Service.imp;

import Dao.imp.IQuestionDao;
import Dao.imp.QuestionDao;
import entity.Question;

import java.util.List;

public class QuestionService implements IQuestionService{
    IQuestionDao questionDao = new QuestionDao();

    @Override
    public int add(Question question) {
        return questionDao.add(question);
    }

    @Override
    public List<Question> findAllQuestion() {
        return questionDao.findAllQuestion();
    }

    @Override
    public int delete(String questionId) {
        return questionDao.delete(questionId);
    }

    @Override
    public int update(Question question) {
        return questionDao.update(question);
    }

    @Override
    public List<Question> findRand() {
        return questionDao.findRand();
    }

    @Override
    public Question findById(String questionById) {
        return questionDao.findById(questionById);
    }
}
