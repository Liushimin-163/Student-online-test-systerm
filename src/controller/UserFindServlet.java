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
import java.util.List;

@WebServlet("/user/find")
public class UserFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService service = new UserService();
        PrintWriter out;
        List<UserInfo> userList = service.findAll();
        response.setContentType("text/html; charset=UTF-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>User ID</td>");
        out.print("<td>User name</td>");
        out.print("<td>Password</td>");
        out.print("<td>Gender</td>");
        out.print("<td>Email</td>");
        out.print("<td>Operation</td>");
        out.print("</tr>");
        for (UserInfo user : userList
        ) {
            out.print("<tr>");
            out.print("<td>" + user.getUserId() + "</td>");
            out.print("<td>" + user.getUserName() + "</td>");
            out.print("<td>*********</td>");
            out.print("<td>" + user.getGender() + "</td>");
            out.print("<td>" + user.getEmail() + "</td>");
            out.print("<td><a href='/OnlineTestSystem_war_exploded/user/delete?userId=" + user.getUserId() + "'>Delete user</td>");
            out.print("</tr>");

        }
        out.print("</table>");
    }
}
