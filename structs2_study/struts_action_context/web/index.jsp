<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zhangyx-v
  Date: 2020-9-30
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <body>
  <a href="actionContext.action">actionContext</a>
  <%
    if (application.getAttribute("date")==null)
       application.setAttribute("date",new Date());

  %>
  </body>
</html>
