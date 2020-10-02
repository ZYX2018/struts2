<%--
  Created by IntelliJ IDEA.
  User: zhangyx-v
  Date: 2020-9-29
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<form action="save.action">
    name:<input name="name" type="text" value="${name}">
    sex :<input name="sex" type="text" value="${sex}">
    <input type="submit">
</form>
<%=request%>:::<%=request.getAttribute("name")%>
</body>
</html>
