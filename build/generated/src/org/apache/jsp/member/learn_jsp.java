package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Section;
import java.util.ArrayList;
import model.Course;
import data.DatabaseDAO;

public final class learn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Study Online</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../styles/video.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../styles/header.css\">\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../styles/stream.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-3.2.1.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#btn_test').click(function () {\n");
      out.write("                    $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        url: 'VideoController',\n");
      out.write("                        data: {\n");
      out.write("                            time: $('#video').currentTime,\n");
      out.write("                        },\n");
      out.write("                        success: function (result) {\n");
      out.write("                            $('#xxx').html(result);\n");
      out.write("                        },\n");
      out.write("                        error: function () {\n");
      out.write("                            alert(\"That bai\");\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    var value = parseInt($('#pages').val()) + 5;\n");
      out.write("                    $('#pages').val(value.toString());\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <div class=\"headers\">\n");
      out.write("            <ul class=\"headers_nav\">\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"home_button\">\n");
      out.write("                        <a href=\"#\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"categories\">\n");
      out.write("                        <img src=\"../images/categories-512.png\">\n");
      out.write("                        <div class=\"categories_text\">Categories</div>\n");
      out.write("                        <div class=\"categories_contents\">\n");
      out.write("                            <a href=\"#\">IT and Software</a>\n");
      out.write("                            <a href=\"#\">Design</a>\n");
      out.write("                            <a href=\"#\">Development</a>\n");
      out.write("                            <a href=\"#\">Business</a>\n");
      out.write("                            <a href=\"#\">Photography</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"searchbox_h\">\n");
      out.write("                        <input type=\"text\" name=\"searchbox_h\" class=\"seachboxInput\">\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"li_signup\">\n");
      out.write("                    <form method=\"POST\" action=\"../MemberController\">\n");
      out.write("                        <input type=\"hidden\" value=\"main\" name=\"action\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(username);
      out.write("\" name=\"username\">\n");
      out.write("                        <button id=\"\" type=\"submit\">");
      out.print(username);
      out.write("</button>\n");
      out.write("                    </form>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"videocontainer\">\n");
      out.write("            <div id=\"theleft\">\n");
      out.write("                <div id=\"thevideo\">\n");
      out.write("                    <video id=\"video\" controls onloadeddata=\"startVideoAtTime(");
      out.print(db.getCurrentTime(sectionID));
      out.write(")\" width=\"950px\" value=\"");
      out.print(count);
      out.write("\">\n");
      out.write("                        <source src=\"");
      out.print(db.getListSection(courseID).get(count).getVideo());
      out.write("\" type=\"video/mp4\">\n");
      out.write("                    </video>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"theinfo\">\n");
      out.write("                    <p id=\"section\">Course: ");
      out.print(course.getCourseName());
      out.write("</p>\n");
      out.write("                    <div id=\"rating\">\n");
      out.write("                        <img id=\"star1\" src=\"../images/star1.png\">\n");
      out.write("                        <img id=\"star2\" src=\"../images/star1.png\">\n");
      out.write("                        <img id=\"star3\" src=\"../images/star1.png\">\n");
      out.write("                        <img id=\"star4\" src=\"../images/star1.png\">\n");
      out.write("                        <img id=\"star5\" src=\"../images/star1.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <p id=\"titlevideo\">Title: ");
      out.print(course.getCourseTitle());
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                <button id=\"btn_test\">CLICK ME</button>\n");
      out.write("                <div id=\"xxx\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"listcourse\">\n");
      out.write("                <ul>\n");
      out.write("                    ");

                        for (Section section : listSection) {
                    
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"");
      out.print(count);
      out.write("\" href=\"learn.jsp?memberID=");
      out.print(memberID);
      out.write("&courseID=");
      out.print(db.getIdCourse(course));
      out.write("&sectionID=");
      out.print(section.getId());
      out.write("\">\n");
      out.write("                            ");
      out.print(String.valueOf(count += 1) + ".  " + section.getName());
      out.write("\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/video.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/rating.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
