package controller;

import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/exam")
public class ExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        List<Question> questionList = (List<Question>) httpSession.getAttribute("key");
        int score = 0;
        for (Question question : questionList
        ) {
            String trueAnswer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String answer = request.getParameter("answer_" + questionId);
            if (answer.equals(trueAnswer)) {
                score += 25;
            }

        }
        request.setAttribute("info","This test Score:"+score);
        request.getRequestDispatcher("info.jsp").forward(request,response);
    }
    }

