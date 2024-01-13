package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.LessonsManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteLessons")
public class DeleteLessonsServlet extends HttpServlet {
    private LessonsManager lessonsManager = new LessonsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        lessonsManager.deleteLesson(id);
        resp.sendRedirect("/lessons");
    }
}
