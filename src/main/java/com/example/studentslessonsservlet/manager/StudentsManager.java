package com.example.studentslessonsservlet.manager;

import com.example.studentslessonsservlet.db.DBConnectionProvider;
import com.example.studentslessonsservlet.model.Lessons;
import com.example.studentslessonsservlet.model.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private LessonsManager lessonsManager = new LessonsManager();
    private UserManager userManager = new UserManager();

    public List<Students> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Students> students = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                students.add(Students.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .age(resultSet.getInt("age"))
                        .picName(resultSet.getString("pic_name"))
                        .lesson(lessonsManager.getLessonsById(resultSet.getInt("lesson_id")))
                        .user(userManager.getUserById(resultSet.getInt("user_id")))
                        .build());
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return students;
    }

    public void add(Students student) {
        String sql = "INSERT INTO students(name,surname,email,age,lesson_id,pic_name,user_id) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setInt(5, student.getLesson().getId());
            preparedStatement.setString(6, student.getPicName());
            preparedStatement.setInt(7, student.getUser().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                student.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id =" + id;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Students> getByLessonID(int studentID) {
        String sql = "SELECT * FROM students WHERE lesson_id=" + studentID;
        List<Students> students = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                students.add(Students.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .picName(resultSet.getString("pic_name"))
                        .lesson(lessonsManager.getLessonsById(resultSet.getInt("lesson_id")))
                        .user(userManager.getUserById(resultSet.getInt("user_id")))
                        .build());
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return students;
    }
}

