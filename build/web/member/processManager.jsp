<%-- 
    Document   : manageProcess
    Created on : Dec 23, 2017, 11:06:19 AM
    Author     : HaiPh
--%>

<%@page import="model.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Course"%>
<%@page import="data.DatabaseDAO"%>
<%@page import="model.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Study Online</title>
        <link rel="stylesheet" type="text/css" href="../styles/header.css">	
        <link rel="stylesheet" type="text/css" href="../styles/learn.css">
        <link rel="stylesheet" type="text/css" href="../styles/join.css">
        <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            DatabaseDAO db = new DatabaseDAO();
            int courseID = Integer.parseInt(request.getParameter("courseID"));
            int memberID = Integer.parseInt(request.getParameter("memberID"));
            String username = db.getMemberByID(memberID).getUsername();
            Course course = db.getCourseById(courseID);
            ArrayList<Section> listSection = db.getListSection(courseID);
            int joinedSection = db.countJoinedSection(memberID, courseID);
            
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
        <!--Stream-->
        <div class="learntop">
            <div id="learnimg">
                <a href="learn.jsp?memberID=<%=memberID%>&courseID=<%=db.getIdCourse(course)%>&sectionID=<%=listSection.get(0).getId()%>">
                    <span class="play"></span>
                    <img src="../<%=course.getImage()%>" class="img" width="400px">
                </a>
            </div>
            <div id="learntopp">
                <br>
                <p class="topp"><%=course.getCourseName()%></p>
                <br>
                <a href="learn.jsp?memberID=<%=memberID%>&courseID=<%=db.getIdCourse(course)%>&sectionID=<%=listSection.get(0).getId()%>">
                    <button type="button" class="learnbtn">Continue to Lecture</button>
                </a>
                <form id="form">
                    <fieldset class="rating">
                        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                        <input type="radio" id="star4half" name="rating" value="4.5" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                        <input type="radio" id="star3half" name="rating" value="3.5" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                        <input type="radio" id="star2half" name="rating" value="2.5" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                        <input type="radio" id="star1half" name="rating" value="1.5" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                        <input type="radio" id="starhalf" name="rating" value="0.5" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                    </fieldset>
                    <input type="hidden" value="<%=course.getRating()%>" id="ratingValue">
                </form>
                <button id="btnRating">Rate</button>
                <div id="lotrinh" value="<%=listSection.size()%>">
                    <div id="lotrinhht" value="<%=joinedSection%>" style="width: <%=joinedSection*100/listSection.size()%>%; font-size: 15px">
                        <%=joinedSection*100/listSection.size()%>%
                    </div>
                </div>
                <input type="hidden" value="<%=courseID%>" id="courseID"> 
            </div>
        </div>
        
        <div style="margin-left: 500px; margin-top: 30px;">
            <ul>
                <%
                    for (Section section : listSection) {
                %>
                <li style="font-size: 25px; list-style-type: number;"><%=section.getName()%></li>
                <%
                    }
                %>
            </ul>
        </div>
    </body>
    <script type="text/javascript" src="../js/learn.js"></script>
</html>
