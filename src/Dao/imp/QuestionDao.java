package Dao.imp;

import Util.dbUtil;
import entity.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class QuestionDao implements IQuestionDao{
    dbUtil utilss = new dbUtil();
    public int add(Question question){
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer)" +
                "values (?,?,?,?,?,?)";
        PreparedStatement ps = utilss.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utilss.close();
        }
        return result;


    }
    public List<Question> findAllQuestion(){
        List<Question> list = new LinkedList<>();
        Question question = null;
        String sql = "select * from question";
        PreparedStatement ps = utilss.createStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utilss.close(rs);
            utilss.close();
        }
        return list;
    }
    public int delete(String questionId){
        String sql = "delete from question where questionId =?";
        int result = 0;
        PreparedStatement ps = utilss.createStatement(sql);
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            utilss.close();
        }
        return result;
    }
    public Question findById(String questionById){
        String sql = "select * from question where questionId=?";
        PreparedStatement ps = utilss.createStatement(sql);
        Question question = null;
        ResultSet rs = null;
        try {
            ps.setInt(1,Integer.valueOf(questionById));
            rs = ps.executeQuery();

            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utilss.close(rs);
            utilss.close();
        }
        return question;
    }
    public int update(Question question){
        String sql = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD" +
                "=?,answer=? where questionId=? ";
        PreparedStatement ps = utilss.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utilss.close();
        }
        return result;
    }
    public List<Question> findRand(){
        String sql = "select * from question order by rand() limit 0,4";
        List<Question> list = new LinkedList<>();
        Question question = null;
        PreparedStatement ps = utilss.createStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utilss.close(rs);
            utilss.close();
        }
        return list;
}}
