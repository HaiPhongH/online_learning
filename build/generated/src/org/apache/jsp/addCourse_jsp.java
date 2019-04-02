package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Admin Manager</title>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/header.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/admin.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/footer.css\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Header-->\n");
      out.write("        <div class=\"headers\">\n");
      out.write("            <ul class=\"headers_nav\">\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"home_button\">\n");
      out.write("                        <a href=\"#\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <div class=\"categories\">\n");
      out.write("                        <img src=\"images/categories-512.png\">\n");
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
      out.write("\n");
      out.write("                <li class=\"li_login\">\n");
      out.write("                    <button id=\"loginbtn\">Admin</button>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Content-->\n");
      out.write("        <div class=\"admin_options\">\n");
      out.write("            <div class=\"key_options\">\n");
      out.write("                <ul class=\"keys\">\n");
      out.write("                    <li id=\"add_key\">Go Back</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"detail_options\">\n");
      out.write("                <div id=\"add_course_contents\">\n");
      out.write("                    <form method=\"post\" action=\"addCourse\">\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("                        Course Name: <input type=\"text\" placeholder=\"Enter course name\" required name=\"addName\">\n");
      out.write("                        Price: <input type=\"text\" placeholder=\"Enter course price\" required name=\"addPrice\">\n");
      out.write("                        Course Title: <input type=\"text\" placeholder=\"Enter course title\" required name=\"addTitle\">\n");
      out.write("                        Date: <input type=\"text\" placeholder=\"Enter date create\" required name=\"addDate\">\n");
      out.write("                        Author: <input type=\"text\" placeholder=\"Enter author name\" required name=\"addAuthor\">\n");
      out.write("                        List course: <input type=\"text\" placeholder=\"Enter list course\" required name=\"addList\">\n");
      out.write("                        Image: <input type=\"text\" placeholder=\"Enter image\" required name=\"addImage\">\n");
      out.write("                        <input type=\"submit\" value=\"Add Course\" name=\"addButton\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Footer-->\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <div class=\"aboutus\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\"><img src=\"images/home1.png\"></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">About Us</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Copyright &copy 2017</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Terms</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Privacy Policy and Cookie Policy</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <ul id=\"ul_footer\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <img class=\"flag\" src=\"images/spain.png\">\n");
      out.write("                        <p class=\"nation\">Spain</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <img class=\"flag\" src=\"images/french.png\">\n");
      out.write("                        <p class=\"nation\">French</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <img class=\"flag\" src=\"images/germany.png\">\n");
      out.write("                        <p class=\"nation\">Germany</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <img class=\"flag\" src=\"images/netherlands.png\">\n");
      out.write("                        <p class=\"nation\">Netherlands</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <img id=\"icon_language\" src=\"images/language.png\">\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--JavaScript-->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/header.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/footer.js\"></script>\n");
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
