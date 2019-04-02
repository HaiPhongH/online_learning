<%-- 
    Document   : index
    Created on : Nov 11, 2017, 10:20:51 AM
    Author     : HaiPh
--%>

<%@page import="data.FileDAO"%>
<%@page import="data.DatabaseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Course"%>
<%@page import="controller.AdminController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Study Online</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="styles/header.css" type="text/css">
        <link rel="stylesheet" href="styles/stream.css" type="text/css">
        <link rel="stylesheet" href="styles/course.css" type="text/css">
        <link rel="stylesheet" href="styles/footer.css" type="text/css"/>
        <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#see_more').click(function () {
                    $.ajax({
                        type: 'POST',
                        url: 'CourseController',
                        data: {
                            page: $('#pages').val()
                        },
                        success: function (result) {
                            $('#resultMoreCourse').html(result);
                        }
                    });
                    var value = parseInt($('#pages').val()) + 5;
                    $('#pages').val(value.toString());
                });
            });
        </script>
    </head>
    <body>
        <!--Header-->
        <div class="headers">   
            <ul class="headers_nav">
                <li>
                    <div class="home_button">
                        <a href="index.jsp"></a>
                    </div>
                </li>
                <li>
                    <div class="categories">
                        <img src="images/categories-512.png" alt="">
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
                            <input type="submit" value="Search" style="width: 80px; height: 45px;">
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
        <!--Stream-->
        <div class="stream">
            <img id="image" src="images/learning2.png">
        </div>
        <!--Courses-->
        <%
            DatabaseDAO database = new DatabaseDAO();
            int maxResult = 5;
            ArrayList<Course> list = database.getList(0, maxResult);
            
        %>
        <div class="courses">
            <div class="member_course development_courses"  id="displayCourse">
                <div class="title" id="development_title">
                    <p><b>Top Courses in "Development"</b></p>
                </div>

                <div class="list_courses" id="developmentCourse">
                    <%
                        for (Course c : list) {
                    %>
                    <a class="flex_course" href="#">
                        <section class="course course1">
                            <img src="<%=c.getImage()%>">
                            <p><b><%=c.getCourseName()%></b></p>
                            <p class="author"><%=c.getAuthor()%></p>
                            <p> &#9733 &#9733 &#9733 &#9733 &#9733</p>
                        </section>
                    </a>
                    <%
                        }
                    %>
                    <div id="resultMoreCourse"></div>
                </div>
                <form class="see_more" id="see_more_form">
                    <input class="see_morebtn" type="button" value="See More" id="see_more">
                    <input type="hidden" value="0" id="pages" >
                </form>                   
            </div>
        </div>
        <div class="footer">
            <div class="aboutus">
                <ul>
                    <li>
                        <a href="#"><img src="images/home1.png"></a>
                    </li>
                    <li>
                        <a href="#">About Us</a>
                    </li>
                    <li>
                        <a href="#">Copyright &copy 2017</a>
                    </li>
                    <li>
                        <a href="#">Terms</a>
                    </li>
                    <li>
                        <a href="#">Privacy Policy and Cookie Policy</a>
                    </li>
                </ul>
            </div>
            <ul id="ul_footer">
                <li>
                    <a href="#">
                        <img class="flag" src="images/spain.png">
                        <p class="nation">Spain</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img class="flag" src="images/french.png">
                        <p class="nation">French</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img class="flag" src="images/germany.png">
                        <p class="nation">Germany</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img class="flag" src="images/netherlands.png">
                        <p class="nation">Netherlands</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img id="icon_language" src="images/language.png">
                    </a>
                </li>
            </ul>
        </div>

        <!--JavaScript-->
        <script type="text/javascript" src="js/header.js"></script>
        <script type="text/javascript" src="js/course.js"></script>
        <script type="text/javascript" src="js/footer.js"></script>
    </body>
</html>
