package controller;

import Service.imp.IQuestionService;
import Service.imp.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/question/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = request.getParameter("questionId");
        IQuestionService questionService = new QuestionService();
        int result = questionService.delete(questionId);
        if (result==1){
            request.setAttribute("info","Delete Successful");
        }else {
            request.setAttribute("info","Fail delete");
        }
        request.getRequestDispatcher("/delete.jsp").forward(request,response);
    }

}

