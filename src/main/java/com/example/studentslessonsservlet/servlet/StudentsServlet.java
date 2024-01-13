package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.StudentsManager;
import com.example.studentslessonsservlet.model.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {

    private StudentsManager studentsManager = new StudentsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Students> students = studentsManager.getAllStudents();
        req.setAttribute("students",students);
        req.getRequestDispatcher("/WEB-INF/students.jsp").forward(req,resp);
    }
}
