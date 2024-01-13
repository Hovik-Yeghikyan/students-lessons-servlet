package com.example.studentslessonsservlet.manager;

import com.example.studentslessonsservlet.db.DBConnectionProvider;
import com.example.studentslessonsservlet.model.Lessons;
import com.example.studentslessonsservlet.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonsManager {

    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Lessons> getAllLessons() {
        String sql = "SELECT * FROM lessons";
        List<Lessons> lessons = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                lessons.add(Lessons.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .duration(resultSet.getDouble("duration"))
                        .lecturerName(resultSet.getString("lecturer_name"))
                        .price(resultSet.getDouble("price"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public Lessons getLessonsById(int id) {
        String sql = "SELECT * FROM lessons WHERE id=" + id;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return Lessons.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .duration(resultSet.getDouble("duration"))
                        .lecturerName(resultSet.getString("lecturer_name"))
                        .price(resultSet.getDouble("price"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Lessons lessons) {
        String sql = "INSERT INTO lessons(name,duration,lecturer_name,price) VALUES(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, lessons.getName());
            preparedStatement.setDouble(2, lessons.getDuration());
            preparedStatement.setString(3, lessons.getLecturerName());
            preparedStatement.setDouble(4, lessons.getPrice());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                int id = generatedKeys.getInt(1);
                lessons.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLesson(int id){
        String sql = "DELETE FROM lessons WHERE id="+id;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}

