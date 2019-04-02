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
import model.Section;

/**
 *
 * @author HaiPh
 */
public class DatabaseDAO {

    private Connection dbConn;

    public DatabaseDAO() {
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

    //============== Lấy course theo tên ==============
    public Course getCourseByName(String name) {
        String sql = "SELECT * FROM course WHERE name = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("name");
                float price = rs.getFloat("price");
                String title = rs.getString("title");
                String date = String.valueOf(rs.getDate("date"));
                String author = rs.getString("author");
                String list = rs.getString("list");
                float rating = rs.getFloat("rating");
                String image = rs.getString("image");
                Course course = new Course(username, price, title, date, author, list, rating, image);
                return course;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    //============= xoa course =======================
    public boolean delete(String name) {
        String sql = "DELETE FROM course WHERE name = ?";
        try {
            PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
            ps.setString(1, name);
            int x = ps.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    //========================sua course====================
    public boolean update(String courseName, Course course) {
        String sql = "UPDATE course SET name = ?, price = ?, title = ?,"
                + "date = ?, author = ?, list = ?, image = ?"
                + "WHERE name = ?";
        try {
            PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ps.setFloat(2, course.getPrice());
            ps.setString(3, course.getCourseTitle());
            ps.setString(4, course.getDate());
            ps.setString(5, course.getAuthor());
            ps.setString(6, course.getListCourse());
            ps.setString(7, course.getImage());
            ps.setString(8, courseName);
            int x = ps.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //===============lay danh sach cac course theo gioi han===============
    public ArrayList<Course> getList(int firstResult, int limit) {
        ArrayList<Course> listCourse = new ArrayList<>();
        String sql = "SELECT * FROM course LIMIT ?,?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, firstResult);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCourse;
    }

    //=================== them course =============
    public boolean addCourse(Course course) {
        String sql = "INSERT INTO course ( name,"
                + "price,"
                + "title,"
                + "date,"
                + "author,"
                + "list,"
                + "rating,"
                + "image) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ps.setFloat(2, course.getPrice());
            ps.setString(3, course.getCourseTitle());
            ps.setString(4, course.getDate());
            ps.setString(5, course.getAuthor());
            ps.setString(6, course.getListCourse());
            ps.setFloat(7, 0);
            ps.setString(8, course.getImage());
            int x = ps.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//    ============================kiem tra tai khoan

    public boolean authentMember(String username, String password) {
        String sql = "select * from member where username = ? and password = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next() == true) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
//    ===============them moi member
    public boolean addMember(Member member) {
        String sql = "INSERT INTO member ( fullname,email,dob,date,username,password) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, member.getFullName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getdOB());
            ps.setString(4, member.getDate());
            ps.setString(5, member.getUsername());
            ps.setString(6, member.getPassword());
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//===========lay danh sach cac khoa dang theo hoc cua mot member
    public ArrayList<Course> getListCourseByMember(int memberID) {
        ArrayList<Course> listCourse = new ArrayList<>();
        String sql = "select * from web.course \n"
                + "where web.course.id in (select web.list.course_id from web.list, web.listcourse \n"
                                        + "where web.listcourse.id = web.list.listcourse_id\n"
                                        + "and web.listcourse.member_id = ?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCourse;
    }
//    ======================lay member theo id
    public int getIdMember(String username) {
        String sql = "SELECT member.id FROM member WHERE username = ?";
        int id = 0;
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
//    =====================lay id course
    public int getIdCourse(Course course) {
        String sql = "SELECT course.id FROM course WHERE name = ?";
        int id = 0;
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
//    =========================lay course theo id
    public Course getCourseById(int id) {
        String sql = "SELECT * FROM course WHERE id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("name");
                float price = rs.getFloat("price");
                String title = rs.getString("title");
                String date = String.valueOf(rs.getDate("date"));
                String author = rs.getString("author");
                String list = rs.getString("list");
                float rating = rs.getFloat("rating");
                String image = rs.getString("image");
                Course course = new Course(username, price, title, date, author, list, rating, image);
                return course;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
//    ==================lay member theo id
    public Member getMemberByID(int id) {
        String sql = "SELECT * FROM member WHERE member.id=?";
        try {
            PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String dob = String.valueOf(rs.getDate("dob"));
                String date = String.valueOf(rs.getDate("date"));
                String username = rs.getString("username");
                String password = rs.getString("password");
                Member member = new Member(fullName, email, dob, date, username, password);
                return member;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Section> getListSection(int courseID) {
        ArrayList<Section> listSection = new ArrayList<>();
        String sql = "SELECT web.section.id, web.section.name,web.section.video from web.section, web.course\n" +
                        "where web.course.id = web.section.course_id_section\n" +
                        "and web.course.id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, courseID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String video = rs.getString("video");
                Section section = new Section(id, name, video);
                listSection.add(section);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSection;
    }
    public boolean insertProcess(int sectionID, int currentTime) {
        String sql = "INSERT INTO sectionprocess ( section_id,"
                + "currenttime"
                + "VALUES(?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, sectionID);
            ps.setInt(2, currentTime);
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public int getCurrentTime(int id, int memberID) {
        String sql = "Select currentTime from sectionprocess where section_id = ? and process_member_id = ?";
        int currentTime = 0;
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, memberID);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                currentTime = rs.getInt("currenttime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentTime;
    }
    public boolean updateCurrentTime(int id, int time, int memberID) {
        String sql = "UPDATE sectionprocess SET currenttime = ? WHERE section_id = ? AND process_member_id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, time);
            ps.setInt(2, id);
            ps.setInt(3, memberID);
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean addProcess(int id, int time, int memberID) {
        String sql = "Insert into sectionprocess (section_id,currenttime,process_member_id) values (?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, time);
            ps.setInt(3, memberID);
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean checkProcess(int id, int memberID) {
        String sql = "Select * from sectionprocess where section_id = ? and process_member_id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, memberID);
            ResultSet rs = ps.executeQuery();
            while(rs.next() == true) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public int countJoinedSection(int memberID, int courseID) {
        int count = 0;
        String sql = "select count(web.sectionprocess.id) from web.sectionprocess, web.section, web.course\n" +
                        "where web.sectionprocess.process_member_id = ?\n" +
                        "and web.sectionprocess.section_id = web.section.id\n" +
                        "and web.section.course_id_section = web.course.id\n" +
                        "and web.course.id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, memberID);
            ps.setInt(2, courseID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    } 
    public ArrayList<Course> searchCourseByName(String courseName) {
        ArrayList<Course> listCourse = new ArrayList<>();
        String sql = "select * from web.course where web.course.name like ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setString(1, courseName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCourse;
    }
    public boolean checkListMember(int memberID) {
        String sql = "SELECT * FROM listcourse WHERE member_id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean checkCourseInList(int listID, int courseID) {
        String sql = "SELECT * FROM list WHERE listcourse_id = ? AND course_id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, listID);
            ps.setInt(2, courseID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public int getListID(int memberID) {
        int listID = 0;
        String sql = "SELECT listcourse.id FROM listcourse WHERE member_id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listID = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listID;
    }
    public boolean addListCourse(int memberID) {
        String sql = "INSERT INTO listcourse (member_id) VALUES (?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, memberID);
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean addCourseIntoList(int listID, int courseID) {
        String sql = "INSERT INTO list (course_id, listcourse_id) VALUES (?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) this.dbConn.prepareStatement(sql);
            ps.setInt(1, courseID);
            ps.setInt(2, listID);
            int x = ps.executeUpdate();
            if(x>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean enrollCourse(int memberID, int courseID) {
        if(checkListMember(memberID)) {
            int listID = getListID(memberID);
            if(checkCourseInList(listID, courseID)) {
                return false;
            } else {
                if(addCourseIntoList(listID, courseID)){
                    return true;
                }
                else return false;
            }
        }
        else {
            if(addListCourse(memberID)) {
                int listID = getListID(memberID);
                if(addCourseIntoList(listID, courseID)) {
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
}
