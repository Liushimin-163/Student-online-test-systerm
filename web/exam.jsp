<%@ page import="entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: liushimin
  Date: 2021/6/24
  Time: 下午8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/OnlineTestSystem_war_exploded/exam">
        <table border="2px">
            <tr>
                <td>ID:</td>
                <td>Question</td>
                <td>A</td>
                <td>B</td>
                <td>C</td>
                <td>D</td>
                <td>Answer</td>
            </tr>
            <%
                List<Question> questionList = (List<Question>) session.getAttribute("key");
                for (Question question : questionList) {
            %>
            <tr>
                <td><%=question.getQuestionId()%></td>
                <td><%=question.getTitle()%></td>
                <td><%=question.getOptionA()%></td>
                <td><%=question.getOptionB()%></td>
                <td><%=question.getOptionC()%></td>
                <td><%=question.getOptionD()%></td>
                <td>
                    <input type="radio" name="answer_<%=question.getQuestionId()%>" value="A">A
                    <input type="radio" name="answer_<%=question.getQuestionId()%>" value="B">B
                    <input type="radio" name="answer_<%=question.getQuestionId()%>" value="C">C
                    <input type="radio" name="answer_<%=question.getQuestionId()%>" value="D">D

                </td>
            </tr>


            <%
                }
            %>
            <tr align="center">
                <td><input type="submit" value="Submint answer:"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
