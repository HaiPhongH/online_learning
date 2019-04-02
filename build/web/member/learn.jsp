<%-- 
    Document   : learn
    Created on : Dec 23, 2017, 11:05:27 AM
    Author     : HaiPh
--%>

<%@page import="model.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Course"%>
<%@page import="data.DatabaseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Study Online</title>
        <link rel="stylesheet" type="text/css" href="../styles/video.css">
        <link rel="stylesheet" type="text/css" href="../styles/header.css">	
        <link rel="stylesheet" type="text/css" href="../styles/stream.css">
        <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    </head>
    <body>
        <%
            DatabaseDAO db = new DatabaseDAO();
            int courseID = Integer.parseInt(request.getParameter("courseID"));
            int memberID = Integer.parseInt(request.getParameter("memberID"));
            int sectionID = 1;
            String username = db.getMemberByID(memberID).getUsername();
            ArrayList<Section> listSection = db.getListSection(courseID);
            Course course = db.getCourseById(courseID);
            if (request.getParameter("sectionID") != null) {
                sectionID = Integer.parseInt(request.getParameter("sectionID"));
            }
            int count = 0;
        %>
        <div class="headers">
            <ul class="headers_nav">
                <li>
                    <div class="home_button">
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <div class="categories">
                        <img src="../images/categories-512.png">
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
                    <form method="POST" action="../MemberController">
                        <input type="hidden" value="main" name="action">
                        <input type="hidden" value="<%=username%>" name="username">
                        <button id="" type="submit"><%=username%></button>
                    </form>
                </li>
                <li class="li_login">
                    <a style="padding: 0; margin: 0; text-decoration: none;" href="../index.jsp"><button id="loginbtn">Log Out</button></a>
                </li>
            </ul>
        </div>
        <div id="videocontainer">
            <div id="theleft">
                <div id="thevideo">
                    <video id="video" controls onloadeddata="startVideoAtTime(<%=db.getCurrentTime(sectionID,memberID)%>)" width="950px" value="<%=count%>">
                        <source src="<%=db.getListSection(courseID).get(count).getVideo()%>" type="video/mp4">
                    </video>
                </div>

                <div id="theinfo">
                    <p id="section">Course: <%=course.getCourseName()%></p>
                    
                    <p id="titlevideo">Title: <%=course.getCourseTitle()%></p>
                </div>
            </div>
            <div id="listcourse">
                <ul>
                    <%
                        for (Section section : listSection) {
                    %>
                    <li>
                        <a id="<%=count%>" href="learn.jsp?memberID=<%=memberID%>&courseID=<%=db.getIdCourse(course)%>&sectionID=<%=section.getId()%>">
                            <%=String.valueOf(count += 1) + ".  " + section.getName()%>
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <input type="hidden" id="sectionID" value="<%=sectionID%>">
                <input type="hidden" id="memberID" value="<%=memberID%>">
            </div>
        </div>
        <script type="text/javascript" src="../js/video.js"></script>
    </body>
</html>
