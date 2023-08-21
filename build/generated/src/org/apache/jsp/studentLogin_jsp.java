package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--\n");
      out.write("\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Sign in - Students</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"flex flex-col items-center justify-center px-2 py-8 mx-auto md:h-screen lg:py-8\">\n");
      out.write("            <a href=\"#\" class=\"flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white\">\n");
      out.write("                <img class=\"w-8 h-8 mr-2\" src=\"logo.png\" alt=\"logo\">\n");
      out.write("                LeaveApp    \n");
      out.write("            </a>\n");
      out.write("            <div class=\"w-96 bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700\">\n");
      out.write("                <div class=\"p-6 space-y-4 md:space-y-6 sm:p-8\">\n");
      out.write("                    <h1 class=\"text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white\">\n");
      out.write("                        Sign in to your account\n");
      out.write("                    </h1>\n");
      out.write("                    <form class=\"space-y-4 md:space-y-6\" action=\"studentpanel.html\">\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"email\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Your email</label>\n");
      out.write("                            <input type=\"email\" name=\"email\" id=\"email\" class=\"bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\" placeholder=\"name@company.com\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"password\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Password</label>\n");
      out.write("                            <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"••••••••\" class=\"bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"flex items-center justify-between\">\n");
      out.write("                            <div class=\"flex items-start\">\n");
      out.write("                                <div class=\"flex items-center h-5\">\n");
      out.write("                                    <input id=\"remember\" aria-describedby=\"remember\" type=\"checkbox\" class=\"w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"ml-3 text-sm\">\n");
      out.write("                                    <label for=\"remember\" class=\"text-gray-500 dark:text-gray-300\">Remember me</label>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"#\" class=\"text-sm font-medium text-primary-600 hover:underline dark:text-primary-500\">Forgot password?</a>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"w-full text-blue bg-blue-600 hover:bg-blue-700 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800\">Sign in</button>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
