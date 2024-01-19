<%@ page import="com.example.studentslessonsservlet.model.Lessons" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.studentslessonsservlet.util.DateUtil" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.01.2024
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons</title>
</head>
<body>
<%
    List<Lessons> lessonsList = (List<Lessons>) request.getAttribute("lessons");

%>

Lessons| <a href="/addLessons">Add lesson</a>
<%
    if (lessonsList != null && !lessonsList.isEmpty()) {%>


<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Duration</th>
        <th>Lecturer_Name</th>
        <th>Price</th>
        <th>User Added</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
   <% for (Lessons lesson : lessonsList) {%>
    <%if (request.getSession().getAttribute("user").equals(lesson.getUser())) {%>
    <tr>
        <td><%=lesson.getId()%>
        </td>
        <td><a href="/singleLessons?id=<%=lesson.getId()%>">
            <%=lesson.getName()%></a></td>
        <td><%=lesson.getDuration()%>
        </td>
        <td><%=lesson.getLecturerName()%>
        </td>
        <td><%=lesson.getPrice()%>
        </td>
        <td><%=lesson.getUser().getName() + " " + lesson.getUser().getSurname()%>
        </td>

        <td><a href="/deleteLessons?id=<%=lesson.getId()%>">Delete</a></td>
        <td><a href="/updateLessons?id=<%=lesson.getId()%>">Update</a></td>
    </tr>
    <% }
    %>
    <%}%>
</table>
<% }%>
</body>
</html>
