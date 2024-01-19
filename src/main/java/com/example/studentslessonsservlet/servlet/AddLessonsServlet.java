package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.LessonsManager;
import com.example.studentslessonsservlet.model.Lessons;
import com.example.studentslessonsservlet.model.User;
import com.example.studentslessonsservlet.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(urlPatterns = "/addLessons")
public class AddLessonsServlet extends HttpServlet {

    private LessonsManager lessonsManager = new LessonsManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addLessons.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String lessonName = req.getParameter("name");
        double duration = Double.parseDouble(req.getParameter("duration"));
        String lecturerName = req.getParameter("lecturer_name");
        double price = Double.parseDouble(req.getParameter("price"));
        lessonsManager.add(Lessons.builder()
                .name(lessonName)
                .duration(duration)
                .lecturerName(lecturerName)
                .price(price)
                .user(user)
                .build());

        resp.sendRedirect("/lessons");
    }
}
