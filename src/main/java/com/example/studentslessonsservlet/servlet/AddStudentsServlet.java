package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.LessonsManager;
import com.example.studentslessonsservlet.manager.StudentsManager;
import com.example.studentslessonsservlet.model.Lessons;
import com.example.studentslessonsservlet.model.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addStudents")
public class AddStudentsServlet extends HttpServlet {

    private StudentsManager studentsManager = new StudentsManager();
    private LessonsManager lessonsManager = new LessonsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lessons> lessons = lessonsManager.getAllLessons();
        req.setAttribute("lessons", lessons);
        req.getRequestDispatcher("/WEB-INF/addStudents.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        int lessonId= Integer.parseInt(req.getParameter("lessonId"));
        studentsManager.add(Students.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .lesson(lessonsManager.getLessonsById(lessonId))
                .build());
        resp.sendRedirect("/students");
    }
}
