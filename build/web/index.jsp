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
        <link rel="stylesheet" href="styles/header.css" type="text/css"/>
        <link rel="stylesheet" href="styles/stream.css" type="text/css">
        <link rel="stylesheet" href="styles/stream.css" type="text/css"/>
        <link rel="stylesheet" href="styles/course.css" type="text/css">
        <link rel="stylesheet" href="styles/course.css" type="text/css"/>
        <link rel="stylesheet" href="styles/footer.css" type="text/css">
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
                        <input type="text" name="searchbox_h" class="seachboxInput">
                    </div>
                </li>
                <li class="li_signup">
                    <button id="signupbtn">Sign Up</button>
                    <div id="signup_conversation" class="signup">
                        <span id="xSignup" class="close">x</span>
                        <form class="signup_content signup_animation" method= "post" action="MemberController">
                            <input type="hidden" value="signup" name="action">
                            <div class="container">
                                <label><b>Username</b></label>
                                <input type="text" placeholder="Enter your Email" name="usernameSignUp" required>

                                <label><b>Password</b></label>
                                <input type="text" placeholder="Enter your Password" name="passwordSignUp" required>
                                
                                <label><b>Full Name</b></label>
                                <input type="text" placeholder="Enter your Full Name" name="fullnameSignUp" required>
                                
                                <label><b>Date Of Birth</b></label>
                                <input type="text" placeholder="YYYY - MM - dd" name="dobSignUp" required>
                                
                                <label><b>Email</b></label>
                                <input type="text" placeholder="Enter your Email" name="emailSignUp" required>

                                <div class="action">
                                    <button type="button" id="cancelSignup" class="cancelButton">Cancel</button>
                                    <button type="submit" id="singupClick" class="signupButton">Sign Up</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </li>
                <li class="li_login">
                    <button id="loginbtn">Login</button>
                    <div id="login_conversation" class="login">
                        <span id="xLogin" class="close">x</span>
                        <form class="login_content login_animation" method="POST" action="MemberController">
                            <input type="hidden" value="login" name="action">
                            <div class="container">
                                <label><b>Email</b></label>
                                <input type="text" placeholder="Enter your Username" id="emailLogin" required name="usernameLogin">

                                <label><b>Password</b></label>
                                <input type="password" placeholder="Enter your Password" id="passwordLogin" required name="passwordLogin">

                                <div class="action">
                                    <button type="button" id="cancelLogin" class="cancelButton">Cancel</button>
                                    <button type="submit" id="loginClick" class="loginButton">Login</button>
                                </div>
                            </div>
                        </form>
                    </div>
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
            <div class="member_course development_courses">
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
                    
                    <div id="resultMoreCourse">
                    </div>
                </div>
                <form class="see_more">
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
