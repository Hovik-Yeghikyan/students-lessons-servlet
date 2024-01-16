<%@ page import="com.example.studentslessonsservlet.model.Students" %>
<%@ page import="com.example.studentslessonsservlet.model.Lessons" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.01.2024
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Lessons lessons = (Lessons) request.getAttribute("lessons");%>
<%List<Students> studentsList = (List<Students>) request.getAttribute("students");%>
<html>
<head>
    <title><%=lessons.getName()%>>></title>
</head>
<body>
<h2><%=lessons.getName()%>|<%=lessons.getId()%></h2>


<%
    if (studentsList != null && !studentsList.isEmpty()) {%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Picture</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>

    <%
        for (Students students : studentsList) {%>
    <tr>
        <td><%=students.getId()%>
        </td>
        <td>
            <% if (students.getPicName() != null) { %>
            <img src="/downloadImage?imageName=<%=students.getPicName()%>" width="50">
            <%} else {%>
            <span>No Picture</span>
            <%}%>
        </td>
        <td><%=students.getName()%>
        </td>
        <td><%=students.getSurname()%>
        </td>
        <td><%=students.getEmail()%>
        </td>

    </tr>
    <% }
    %>
</table>
<% }%>
</body>
</html>