/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.DatabaseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Member;

/**
 *
 * @author HaiPh
 */
public class MemberController extends HttpServlet {

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
            out.println("<title>Servlet MemberController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MemberController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String url = "/membermain.jsp";
        String action = request.getParameter("action");
        DatabaseDAO db = new DatabaseDAO();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        if(action.equals("login")) {
            String username = request.getParameter("usernameLogin");
            String password = request.getParameter("passwordLogin");
            if(username.equals("admin") && password.equals("admin")) {
                url = "/admin.jsp";
            } else if(db.authentMember(username, password)) {
                request.setAttribute("membername", username);
                url = "/member/membermain.jsp";
            }
        } else if(action.equals("main")) {
            String username = (String) request.getParameter("username");
            int id = db.getIdMember(username);
            ArrayList<Course> listCourse = db.getListCourseByMember(id);
            request.setAttribute("listCourse", listCourse);
            request.setAttribute("membername", username);
            url = "/member/listCourse.jsp";
        } else if(action.equals("signup")) {
            String username = (String) request.getParameter("usernameSignUp");
            String password = (String) request.getParameter("passwordSignUp");
            String fullname = (String) request.getParameter("fullnameSignUp");
            String email = (String) request.getParameter("emailSignUp");
            String dob = (String) request.getParameter("dobSignUp");
            String date = dateFormat.format(currentDate);
            Member member = new Member(fullname, email, dob, date, username, password);
            if(db.addMember(member)) {
                request.setAttribute("membername", username);
                url = "/member/membermain.jsp";
            }
        } else if(action.equals("search")) {
            String courseName = request.getParameter("searchbox_h");
            String username = (String) request.getParameter("username");
            ArrayList<Course> listCourse = db.searchCourseByName("%"+courseName+"%");
            request.setAttribute("listCourse", listCourse);
            request.setAttribute("membername", username);
            url = "/member/searchCourse.jsp";
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
