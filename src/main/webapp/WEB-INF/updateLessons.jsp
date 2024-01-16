<%@ page import="com.example.studentslessonsservlet.model.Lessons" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.01.2024
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Lessons</title>
</head>
<body>
<%Lessons lessons = (Lessons) request.getAttribute("lessons");%>
Update Lessons <br>
<form method="post" action="/updateLessons">
    <input type="hidden" name="id" value="<%=lessons.getId()%>">
    Lesson Name: <input type="text" name="lessonsName" value="<%=lessons.getName()%>"> <br>
   Lesson Duration: <input type="text" name="duration" value="<%=lessons.getDuration()%>"> <br>
   Lecturer Name : <input type="text" name="lecturerName" value="<%=lessons.getLecturerName()%>"> <br>
   Lesson price: <input type="number" name="price" value="<%=lessons.getPrice()%>"> <br>
    <input type="submit" value="update">
</form>
</body>
</html>