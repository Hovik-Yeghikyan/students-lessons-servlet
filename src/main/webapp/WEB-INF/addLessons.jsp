<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.01.2024
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Lessons</title>
</head>
<body>

<% if (session.getAttribute("msg") != null) {%>
<span style="color: red"><%=session.getAttribute("msg")%></span>
<% session.removeAttribute("msg");%>
<%}%>
Add Lessons <br>
<form method="post" action="/addLessons">
    Lesson Name: <input type="text" name="name"> <br>
    Duration: <input type="text" name="duration"> <br>
    Lecturer Name: <input type="text" name="lecturer_name"> <br>
    Lesson price: <input type="number" name="price"> <br>
    <input type="submit" value="add">
</form>
</body>
</html>
