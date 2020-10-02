<%--
  Created by IntelliJ IDEA.
  User: zhangyx-v
  Date: 2020-9-29
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input</title>
</head>
<body>
<form action="save.action">
    name:<input name="name" type="text" value="${people.name}">
    sex :<input name="sex" type="text" value="${people.sex}">
    <input type="submit">
</form>
<%=request%>:::<%=request.getAttribute("people")%>
</body>
</html>
