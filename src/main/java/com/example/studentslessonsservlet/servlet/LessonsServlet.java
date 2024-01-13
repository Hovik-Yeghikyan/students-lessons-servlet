package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.LessonsManager;
import com.example.studentslessonsservlet.model.Lessons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/lessons")
public class LessonsServlet extends HttpServlet {

    private LessonsManager lessonsManager = new LessonsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lessons> lessons = lessonsManager.getAllLessons();
        req.setAttribute("lessons", lessons);
        req.getRequestDispatcher("/WEB-INF/lessons.jsp").forward(req,resp);
    }
}
