<%@ page import="entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: liushimin
  Date: 2021/6/24
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Question> questionList = (List) request.getAttribute("key");
%>
<table border="2px" align="center">
    <tr>
        <td>ID:</td>
        <td>Question</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>Correct answer</td>
        <td>Delete Question</td>
        <td>Detail</td>
    </tr>
    <%
        for (Question question : questionList
        ) {
    %>
    <tr style="background:paleturquoise">
        <td><%=question.getQuestionId()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td><a href="/OnlineTestSystem_war_exploded/question/delete?questionId=<%=question.getQuestionId()%>">Delete question</a></td>
        <td><a href="/OnlineTestSystem_war_exploded/findById?questionId=<%=question.getQuestionId()%>">Detail</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
