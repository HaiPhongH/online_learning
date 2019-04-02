/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.DatabaseDAO;
import data.StatisticDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import java.util.Date;
import model.Member;

/**
 *
 * @author HaiPh
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourse at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String url = "/admin.jsp";
        String action = request.getParameter("action");
        DatabaseDAO db = new DatabaseDAO();
        StatisticDAO st = new StatisticDAO();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        if (action.equals("add")) {
            url = "/admin/addCourse.jsp";
            request.setAttribute("notification", "ADD COURSE");
            if (request.getParameter("addName") != null) {
                String addName = request.getParameter("addName");
                float price = Float.parseFloat(request.getParameter("addPrice"));
                String title = request.getParameter("addTitle");
                String date = dateFormat.format(currentDate);
                String author = request.getParameter("addAuthor");
                String list = request.getParameter("addList");
                String image = request.getParameter("addImage");
                Course course = new Course(addName, price, title, date, author, list, 0, image);
                if (db.addCourse(course)) {
                    request.setAttribute("notification", "ADD SUCCESSED");
                    request.setAttribute("course", course);
                } else {
                    request.setAttribute("notification", "ADD FAILED");
                    request.setAttribute("course", course);
                }
            }
        } else if (action.equals("edit")) {
            url = "/admin/searchCourse.jsp";
            request.setAttribute("notification", "SEARCH COURSE");
        } else if (action.equals("search")) {
            String searchName = request.getParameter("searchName");
            Course course = db.getCourseByName(searchName);
            request.setAttribute("course", course);
            request.setAttribute("notification", "EDIT COURSE");
            url = "/admin/editCourse.jsp";
        } else if(action.equals("editCourse")){
            String editName = request.getParameter("editName");
            float price = Float.parseFloat(request.getParameter("editPrice"));
            String title = request.getParameter("editTitle");
            String date = request.getParameter("editDate");
            String author = request.getParameter("editAuthor");
            String list = request.getParameter("editList");
            String image = request.getParameter("editImage");
            Course course = new Course(editName, price, title, date, author, list, 0, image);
            if(db.update(editName, course)) {
                request.setAttribute("notification", "EDIT SUCCESSED");
                request.setAttribute("course", course);
            }
            else {
                request.setAttribute("notification", "EDIT FAILED");
                request.setAttribute("course", course);
            }
            url = "/admin/editCourse.jsp";
        } else if (action.equals("delete")) {
            url = "/admin/deleteCourse.jsp";
            request.setAttribute("notification", "DELETE COURSE");
            if(request.getParameter("deleteName")!=null) {
                String deleteName = request.getParameter("deleteName");
                if(db.delete(deleteName)) {
                    request.setAttribute("notification", "DELETE SUCCESSED");
                }
                else {
                    request.setAttribute("notification", "DELETE FAILED");
                }
            }
        } else if (action.equals("statistic")) {
            url = "/admin/statistic.jsp";
        } else if(action.equals("course")) {
            url = "/admin/statisticCourse.jsp";
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            int countCourse = st.countCourse(startDate, endDate);
            ArrayList<Course> listCourse = st.getCourseByDate(startDate, endDate);
            request.setAttribute("listCourse", listCourse);
            request.setAttribute("countCourse", countCourse);
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
        } else if(action.equals("member")) {
            url = "/admin/statisticMember.jsp";
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            int countMember = st.countMember(startDate, endDate);
            ArrayList<Member> listMember = st.getMemberByDate(startDate, endDate);
            request.setAttribute("listMember", listMember);
            request.setAttribute("countMember", countMember);
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
