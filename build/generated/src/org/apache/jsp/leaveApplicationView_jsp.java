package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class leaveApplicationView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js\"></script>\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"logo.png\"/>\n");
      out.write("\n");
      out.write("        <title>View Application</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Statement st = null;
            Connection c1 = null;
            String q = "", reason = "", name = "", year = "", branch = "", leavefrom = "", leaveto = "", email = "";
            long contact = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                //out.println("Database Connected Succesfully");

                int appid = Integer.parseInt(request.getParameter("appid"));
                st = c1.createStatement();
                q = "select * from leaveapplications where applicationid="+48;

                ResultSet r = st.executeQuery(q);
                if (r.next()) {
                    reason = r.getString("reason");
                    name = r.getString("name");
                    //year=r.getString("year");
                    branch = r.getString("branch");
                    leavefrom = r.getString("leavefrom");
                    leaveto = r.getString("leaveto");
                    contact = r.getLong("contact");
                    email = r.getString("email");
                }

        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br><br><br>\n");
      out.write("            <center>\n");
      out.write("                <h3>Leave Application</h3>\n");
      out.write("            </center>\n");
      out.write("            <br><br>\n");
      out.write("            <pre>\n");
      out.write("            To Principle/HOD,\n");
      out.write("            Collage of Engineering Ambajogai 431517,\n");
      out.write("            \n");
      out.write("                Subject :- Wanted leave from <b>");
      out.print( leavefrom);
      out.write("</b> to <b>");
      out.print( leaveto);
      out.write("</b>\n");
      out.write("                \n");
      out.write("                Respected sir/Madam,\n");
      out.write("\n");
      out.write("                        I am Student <b>");
      out.print( name);
      out.write("</b> pursuing in branch <b>");
      out.print( branch);
      out.write("</b> due to following Reason <b>");
      out.print( reason);
      out.write("</b> i want leave \n");
      out.write("                    from <b>");
      out.print( leavefrom);
      out.write("</b> to <b>");
      out.print( leaveto);
      out.write("</b>,Day After<b> ");
      out.print( leaveto);
      out.write("</b> i will continue my Class.\n");
      out.write("                        This is kindly request to you,i hope you will accept my Leave.\n");
      out.write("\n");
      out.write("                                \n");
      out.write("                                                                                                                    Yours faithfully\n");
      out.write("                                                                                                                   <b>");
      out.print( name);
      out.write("\n");
      out.write("                    ");
      out.print( contact);
      out.write("\n");
      out.write("                    ");
      out.print( email);
      out.write("</b>\n");
      out.write("            </pre>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

                st.close();
            } catch (Exception e) {
                out.println("Student Exception" + e);
            }

        
      out.write("\n");
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
