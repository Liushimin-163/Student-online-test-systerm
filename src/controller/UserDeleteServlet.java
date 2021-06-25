package controller;

import Service.imp.IUserService;
import Service.imp.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService service = new UserService();
        PrintWriter out = null;
        int result = 0;
        String userId = request.getParameter("userId");
        result =service.deleteUser(userId);
        response.setContentType("text/html; charset=UTF-8");
        out = response.getWriter();
        if (result==1){
            out.print("<font style='color:red;font-size:40'>User information delete successful</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>User information delete fail</font>");

        }
    }
}
