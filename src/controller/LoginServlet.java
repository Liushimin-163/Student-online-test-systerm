package controller;

import Service.imp.IUserService;
import Service.imp.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username,password;
        int result = 0;
        request.setCharacterEncoding("utf-8");
        username = request.getParameter("username");
        password = request.getParameter("pwd");
        //username=tom&pwd=123
        IUserService service = new UserService();//多态的用法
        result = service.login(username,password);
        if (result==1){
            response.sendRedirect("/OnlineTestSystem_war_exploded/index.html");
        }else {
            response.sendRedirect("/OnlineTestSystem_war_exploded/login_error.html");

        }
    }
}
