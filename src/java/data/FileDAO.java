/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Member;
import model.Section;

/**
 *
 * @author HaiPh
 */
public class FileDAO {
    public void writeFile(String fileName, ArrayList<Course> list) {
        File file = new File(fileName);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println("[");
            for(Course course:list) {
                out.print(course.toString());
                out.println(',');
            }
            out.println("]");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        DatabaseDAO db =  new DatabaseDAO();
        if(db.enrollCourse(2, 3)) {
            System.out.println("DAng ki thanh cong");
        } else System.out.println("Dang ki khong thanh cong");
    }
}
