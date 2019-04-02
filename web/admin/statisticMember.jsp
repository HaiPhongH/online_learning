<%-- 
    Document   : admin
    Created on : Dec 5, 2017, 2:46:13 PM
    Author     : HaiPh
--%>

<%@page import="model.Member"%>
<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Manager</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="styles/header.css" type="text/css"/>
        <link rel="stylesheet" href="styles/admin.css" type="text/css"/>
        <link rel="stylesheet" href="styles/footer.css" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.6.2.js"></script>
    </head>
    <body>
        <!--Header-->
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
                        <input type="text" name="searchbox_h" class="seachboxInput">
                    </div>
                </li>

                <li class="li_login">
                    <a style="padding: 0; margin: 0; text-decoration: none;" href="admin.jsp"><button id="loginbtn">Admin</button></a>
                </li>
                <li class="li_login">
                    <a style="padding: 0; margin: 0; text-decoration: none;" href="index.jsp"><button id="loginbtn">Log Out</button></a>
                </li>
            </ul>
        </div>
        
        <!--Content-->
        <div class="admin_options">
            <div class="key_options statisticCourse">
                <p>STATISTIC MEMBER</p>
                <form>
                    <input type="hidden" value="member" name="action">
                    START DATE: <input type="text" value="${startDate}" required name="startDate">
                    END DATE: <input type="text" value="${endDate}" required name="endDate"> 
                    <input type="submit" value="STATISTIC">
                </form>
            </div>
            <%
                ArrayList<Member> listMember = (ArrayList<Member>) request.getAttribute("listMember");
            %>
            <div id="content_course">
                <table class="table_statistic">
                    <tr class="row">
                        <th class="sub_row">Member Name</th>
                        <th class="sub_row">Member Email</th>
                        <th class="sub_row">Member Date</th>
                    </tr>
                    <%
                        for(Member member:listMember){
                    %>
                    <tr class="row">
                        <td class="sub_row"><%=member.getFullName()%></td>
                        <td class="sub_row"><%=member.getEmail()%></td>
                        <td class="sub_row"><%=member.getDate()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <p>NUMBER OF ADDED MEMBER IN THAT TIME: ${countMember}</p>
            </div>
        </div>
        <!--Footer-->
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
        <script type="text/javascript" src="js/footer.js"></script>
    </body>
</html>
