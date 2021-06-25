<%--
  Created by IntelliJ IDEA.
  User: liushimin
  Date: 2021/6/24
  Time: 下午7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%   String info=(String) request.getAttribute("info");
%>
<center>
    <font style="color: red;font-size: 40px"><%=info%></font>
</center>
</body>
</html>
