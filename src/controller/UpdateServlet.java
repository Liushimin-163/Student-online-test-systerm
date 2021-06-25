package controller;

import Service.imp.IQuestionService;
import Service.imp.QuestionService;
import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/question/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        Integer questionId;
        Question question = null;
        int result = 0;
        questionId = Integer.valueOf(request.getParameter("questionId"));
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
        IQuestionService questionService = new QuestionService();
        result = questionService.update(question);
        if (result==1){
            request.setAttribute("info","Update successful");
        }else {
            request.setAttribute("info","Update fail");
        }
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
