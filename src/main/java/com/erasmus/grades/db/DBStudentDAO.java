package com.erasmus.grades.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBStudentDAO extends MySQLConnector {

    private PreparedStatement getActivitiesStudentCourseStmt;
    private PreparedStatement getCoursesStudentStmt;

    public DBStudentDAO() {
    }

//    public DBStudentDAO(String ip, String usr, String pass, String db, int port) throws SQLException {
//
//        super.connection(ip, usr, pass, db, port);
//        try {
//
//            getActivitiesStudentCourseStmt = con.prepareCall("CALL testing.getActivitiesStudentCourse(?, ?)");
//            getCoursesStudentStmt = con.prepareCall("CALL testing.getCoursesStudent(?)");
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//
//    }

    public ResultSet getActivitiesStudent(int userID) {
        ResultSet resultSet = null;
        try {
            con = getConnection(connectionModel);
            getActivitiesStudentCourseStmt = con.prepareCall("CALL testing.getActivitiesStudentCourse(?)");
            getActivitiesStudentCourseStmt.setInt(1, userID);
            resultSet = getActivitiesStudentCourseStmt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public ResultSet getCoursesStudent(int id) {
        ResultSet resultSet = null;
        try {
            getCoursesStudentStmt.setInt(1, id);
            resultSet = getActivitiesStudentCourseStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}



