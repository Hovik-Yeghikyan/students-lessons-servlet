<%@ page import="com.example.studentslessonsservlet.model.Students" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.01.2024
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Students</title>
</head>
<body>
<%
    List<Students> studentsList = (List<Students>) request.getAttribute("students");

%>

Students| <a href="/addStudents">Add student</a>
<%
    if (studentsList != null && !studentsList.isEmpty()) {%>


<table border="1">
    <tr>
        <th>ID</th>
        <th>Picture</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Age</th>
        <th>Lesson</th>
        <th>Delete</th>
    </tr>
    <% for (Students student : studentsList) {%>
    <tr>
        <td><%=student.getId()%>
        </td>
        <td>
            <% if (student.getPicName() != null) { %>
            <img src="/downloadImage?imageName=<%=student.getPicName()%>" width="50">
            <%} else {%>
            <span>No Picture</span>
            <%}%>
        </td>
        <td><%=student.getName()%>
        </td>

        <td><%=student.getSurname()%>
        </td>
        <td><%=student.getEmail()%>
        </td>
        <td><%=student.getAge()%>
        </td>
        <td><%=student.getLesson().getName()%>
        </td>

        <td><a href="/deleteStudents?id=<%=student.getId()%>">Delete</a></td>
    </tr>
    <% }
    %>
</table>
<% }%>
</body>
</html>
