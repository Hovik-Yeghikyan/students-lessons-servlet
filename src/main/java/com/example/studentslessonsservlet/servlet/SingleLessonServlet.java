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

@WebServlet(urlPatterns = "/singleLessons")
public class SingleLessonServlet extends HttpServlet {


    private LessonsManager lessonsManager = new LessonsManager();
    private StudentsManager studentsManager = new StudentsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Lessons lessonsById = lessonsManager.getLessonsById(id);
        if (lessonsById == null) {
            resp.sendRedirect("/lessons");
        } else {
            List<Students> studentsList = studentsManager.getByLessonID(id);
            req.setAttribute("lessons", lessonsById);
            req.setAttribute("students", studentsList);
            req.getRequestDispatcher("/WEB-INF/singleLessons.jsp").forward(req, resp);
        }
    }
}
