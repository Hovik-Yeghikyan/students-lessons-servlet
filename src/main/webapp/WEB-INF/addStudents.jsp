<%@ page import="com.example.studentslessonsservlet.model.Lessons" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.01.2024
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add students</title>
</head>
<body>
<% List<Lessons> lessons = (List<Lessons>) request.getAttribute("lessons");%>

Add Students <br>
<form method="post" action="/addStudents" enctype="multipart/form-data">
    Name: <input type="text" name="name"> <br>
    Surame: <input type="text" name="surname"> <br>
    Email: <input type="text" name="email"> <br>
    Age: <input type="number" name="age"> <br>

    <select name="lessonId">
        <%
            for (Lessons lesson : lessons) {%>
        <option value="<%=lesson.getId()%>"><%=lesson.getName()%>
        </option>
        <%}%>

    </select>
    <input type="file" name="picture">
    <input type="submit" value="add">
</form>
</body>
</html>