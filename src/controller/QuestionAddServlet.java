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

@WebServlet("/question/add")
public class QuestionAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        Question question = null;
        int result = 0;
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        question = new Question(null,title,optionA,optionB,optionC,optionD,answer);

        IQuestionService questionService = new QuestionService();
        result = questionService.add(question);
        if (result==1){
            request.setAttribute("info","Question add successful");
        }else {
            request.setAttribute("info","Question add fail");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
