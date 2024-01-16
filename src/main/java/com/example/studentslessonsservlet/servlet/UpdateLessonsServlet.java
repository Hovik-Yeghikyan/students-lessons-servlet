package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.LessonsManager;
import com.example.studentslessonsservlet.model.Lessons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateLessons")
public class UpdateLessonsServlet extends HttpServlet {

    private LessonsManager lessonsManager = new LessonsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Lessons lessons = lessonsManager.getLessonsById(id);
        req.setAttribute("lessons", lessons);
        req.getRequestDispatcher("/WEB-INF/updateLessons.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("lessonsName");
        double duration = Double.parseDouble(req.getParameter("duration"));
        String lecturerName = req.getParameter("lecturerName");
        double price = Double.parseDouble(req.getParameter("price"));
        lessonsManager.update(Lessons.builder()
                .id(id)
                .name(name)
                .duration(duration)
                .lecturerName(lecturerName)
                .price(price)
                .build());
        resp.sendRedirect("/lessons");
    }
}
