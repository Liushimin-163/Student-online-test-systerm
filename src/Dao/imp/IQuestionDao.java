package Dao.imp;

import entity.Question;

import java.util.List;

public interface IQuestionDao {
    public int add(Question question);

    public List<Question> findAllQuestion();

    public int delete(String questionId);

    public int update(Question question);

    public List<Question> findRand();
    public Question findById(String questionById);
}
