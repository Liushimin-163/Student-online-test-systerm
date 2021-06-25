package controller;

import Service.imp.IUserService;
import Service.imp.UserService;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user/add")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        IUserService userService = new UserService();
        UserInfo userInfo = null;
        int result= 0;
        PrintWriter out = null;
        String username = request.getParameter("userName");
        System.out.println("username = " + username);
        String password = request.getParameter("pwd");
        System.out.println("password = " + password);
        String gender = request.getParameter("gender");
        System.out.println("gender = " + gender);
        String email = request.getParameter("email");
        System.out.println("email = " + email);
        userInfo = new UserInfo(null,username,password,gender,email);
        //2.调用dao
        result = userService.add(userInfo);

        //3.调用响应对象，将数据写入响应体中
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result==1){
            out.print("<font style='color:red;font-size:40'>User register successful</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>User register fail</font>");
        }
    }
}
