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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

/**
 *
 * @author HaiPh
 */
public class RatingDAO {
    private Connection dbConn;

    public RatingDAO() {
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
    public int getTimesRating(int courseID) {
        int times = 0;
        String sql = "Select course.timesrate from course where id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, courseID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                times = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return times;
    }
    public boolean updateTimesRating(int courseID) {
        int times = getTimesRating(courseID);
        String sql = "UPDATE course SET course.timesrate = ? WHERE id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, times+1);
            ps.setInt(2, courseID);
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void updateRating(int courseID, float rating) {
        String sql = "UPDATE course SET course.rating = ? where course.id = ?";
        try {
            PreparedStatement ps= (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setFloat(1, rating);
            ps.setInt(2, courseID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
