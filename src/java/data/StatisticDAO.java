/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Member;

/**
 *
 * @author HaiPh
 */
public class StatisticDAO {
    private Connection dbConn;
    
    public StatisticDAO() {
        String hostName = "localhost:3306";
        String dbName = "web";
        String dbURL = "jdbc:mysql://" + hostName + "/" + dbName;
        String username = "root";
        String password = "HaiPhong31796@";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConn = (Connection) DriverManager.getConnection(dbURL, username, password);
            if (dbConn != null) {
                System.out.println("Ket noi CSDL thanh cong");
            }
        } catch (SQLException ex) {
            System.out.println("Ket noi CSDL that bai");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int countMember(String start, String end) {
        int count = 0;
        String sql = "SELECT count(id) FROM member WHERE member.date>=? and member.date<=?";
        try {
            PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, start);
            ps.setString(2, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public int countCourse(String start, String end) {
        int count = 0;
        String sql = "SELECT count(id) FROM course WHERE course.date>=? and course.date<=?";
        try {
            PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, start);
            ps.setString(2, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public ArrayList<Course>  getCourseByDate(String start, String end) {
        ArrayList<Course> listCourse = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE course.date>=? and course.date<=?";
        try {
            PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, start);
            ps.setString(2, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String title = rs.getString("title");
                String date = String.valueOf(rs.getDate("date"));
                String author = rs.getString("author");
                String list = rs.getString("list");
                float rating = rs.getFloat("rating");
                String image = rs.getString("image");
                Course course = new Course(name, price, title, date, author, list, rating, image);
                listCourse.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCourse;
    }
    
    public ArrayList<Member>  getMemberByDate(String start, String end) {
        ArrayList<Member> listMember = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE member.date>=? and member.date<=?";
        try {
            PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, start);
            ps.setString(2, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String dob = String.valueOf(rs.getDate("dob"));
                String date = String.valueOf(rs.getDate("date"));
                String username = rs.getString("username");
                String password = rs.getString("password");
                Member member = new Member(fullName, email, dob, date, username, password);
                listMember.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMember;
    }
}
