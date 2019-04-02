<%-- 
    Document   : listCourse
    Created on : Dec 23, 2017, 11:07:32 AM
    Author     : HaiPh
--%>

<%@page import="data.DatabaseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Study Online</title>
        <link rel="stylesheet" type="text/css" href="styles/header.css">	
        <link rel="stylesheet" type="text/css" href="styles/stream.css">
        <link rel="stylesheet" type="text/css" href="styles/course.css">
        <link rel="stylesheet" type="text/css" href="styles/learn.css">
        <link rel="stylesheet" type="text/css" href="styles/join.css">
    </head>
    <body>
        <div class="headers">
            <ul class="headers_nav">
                <li>
                    <div class="home_button">
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <div class="categories">
                        <img src="images/categories-512.png">
                        <div class="categories_text">Categories</div>
                        <div class="categories_contents">
                            <a href="#">IT and Software</a>
                            <a href="#">Design</a>
                            <a href="#">Development</a>
                            <a href="#">Business</a>
                            <a href="#">Photography</a>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="searchbox_h">
                        <form method="POST" action="MemberController">
                            <input type="text" name="searchbox_h" class="seachboxInput" id="search_box">
                            <input type="hidden" value="search" name="action">
                            <input type="hidden" value="${membername}" name="username">
                            <input type="submit" value="Search" style="width: 80px; height: 45px;" id="btnSearch">
                        </form>
                    </div>
                </li>
                <li class="li_signup">
                    <form method="POST" action="MemberController">
                        <input type="hidden" value="main" name="action">
                        <input type="hidden" value="${membername}" name="username">
                        <button id="" type="submit">${membername}</button>
                    </form>
                </li>
                <li class="li_login">
                    <a style="padding: 0; margin: 0; text-decoration: none;" href="index.jsp"><button id="loginbtn">Log Out</button></a>
                </li>
            </ul>
        </div>
        <!--Menu-->
        <div id="jointop">
            <p id="jointitle">
                My Courses
            </p>
            <%
                ArrayList<Course> listCourse = (ArrayList<Course>) request.getAttribute("listCourse");
                DatabaseDAO db = new DatabaseDAO();
                int memberID = db.getIdMember((String) request.getAttribute("membername"));
            %>
            <div id="joinlist">
                <table id="tbjoinlist">
                    <tr>
                        <th id="column1">Course</th>
                        <th id="column2">Author</th>
                        <th id="column3">Date</th>
                        <th id="column4">Rate</th>
                    </tr>
                    <%
                        for(Course course:listCourse){
                    %>
                    <tr>
                        <td>
                            <div class="coursejoinlist">
                                <a href="member/processManager.jsp?memberID=<%=memberID%>&courseID=<%=db.getIdCourse(course)%>"><img src="<%=course.getImage()%>" class="avtcoursejoinlist"></a>
                                <p class="nameacoursejoinlist">
                                    <br>
                                    <%=course.getCourseName()%>
                                </p>
                            </div>
                        </td>
                        <td><%=course.getAuthor()%></td>
                        <td><%=course.getDate()%></td>
                        <td class="tbratecourse"><%=course.getRating()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        <!--Footer-->	
        <div class="footer"></div>
        <!--JavaScript-->
        <script type="text/javascript" src="js/header.js"></script>
        <script type="text/javascript" src="js/course.js"></script>
    </body>
</html>
