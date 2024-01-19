package com.example.studentslessonsservlet.servlet;

import com.example.studentslessonsservlet.manager.LessonsManager;
import com.example.studentslessonsservlet.manager.StudentsManager;
import com.example.studentslessonsservlet.model.Lessons;
import com.example.studentslessonsservlet.model.Students;
import com.example.studentslessonsservlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addStudents")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5, //5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class AddStudentsServlet extends HttpServlet {

    private StudentsManager studentsManager = new StudentsManager();
    private LessonsManager lessonsManager = new LessonsManager();
    private final String UPLOAD_DIRECTORY = "C:\\Users\\Admin\\IdeaProjects\\students-lessons-servlet\\uploadDirectory";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lessons> lessons = lessonsManager.getAllLessons();
        req.setAttribute("lessons", lessons);
        req.getRequestDispatcher("/WEB-INF/addStudents.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        int lessonId = Integer.parseInt(req.getParameter("lessonId"));
        Part picture = req.getPart("picture");
        String picName = null;
        if (picture != null && picture.getSize() > 0) {
            picName = System.currentTimeMillis() + "_" + picture.getSubmittedFileName();
            picture.write(UPLOAD_DIRECTORY + File.separator + picName);
        }
        studentsManager.add(Students.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .picName(picName)
                .lesson(lessonsManager.getLessonsById(lessonId))
                .user(user)
                .build());
        resp.sendRedirect("/students");
    }
}
