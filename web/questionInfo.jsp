<%--
  Created by IntelliJ IDEA.
  User: liushimin
  Date: 2021/6/24
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/OnlineTestSystem_war_exploded/question/add" method="get">
        <table>
            <tr>
                <td>Question:</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>A:</td>
                <td><input type="text" name="optionA"></td>
            </tr>
            <tr>
                <td>B:</td>
                <td><input type="text" name="optionB"></td>
            </tr>
            <tr>
                <td>C:</td>
                <td><input type="text" name="optionC"></td>
            </tr>
            <tr>
                <td>D:</td>
                <td><input type="text" name="optionD"></td>
            </tr>
            <tr>
                <td>Correst answer:</td>
                <td><input type="radio" name="answer" value="A">A
                    <input type="radio" name="answer" value="B">B
                    <input type="radio" name="answer" value="C">C
                    <input type="radio" name="answer" value="D">D
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>

    </form>
</center>
</body>
</html>
