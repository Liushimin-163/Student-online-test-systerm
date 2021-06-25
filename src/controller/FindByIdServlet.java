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

@WebServlet("/question/findById")
public class FindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionById = request.getParameter("questionId");
        Question question = null;
        IQuestionService questionService = new QuestionService();
        question = questionService.findById(questionById);
        request.setAttribute("result",question);
        request.getRequestDispatcher("/questionInfo.jsp").forward(request,response);
    }
}
