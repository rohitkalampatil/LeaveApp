package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentpanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                String email="";
        
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js\"></script>\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"logo.png\"/>\r\n");
      out.write("        <title>Students - panel</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"bg-green-100\">\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <header>\r\n");
      out.write("            <nav class=\"fixed px-4 lg:px-6 py-2.5 top-0 z-50 w-full bg-green-200 shadow border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700\">\r\n");
      out.write("                <div class=\"flex flex-wrap justify-between items-center    \">\r\n");
      out.write("\r\n");
      out.write("                    <!--- logo div -->\r\n");
      out.write("                    <div class=\"flex items-center justify-start\">\r\n");
      out.write("                        <a href=\"studentPanel.jsp\" class=\"flex ml-2 md:mr-24\">\r\n");
      out.write("                            <img src=\"logo.png\" class=\"h-8 mr-3\" alt=\"Logo\" />\r\n");
      out.write("                            <span class=\"self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white\">LeaveApp</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!--- Profile and Bell icon div -->\r\n");
      out.write("                    <div class=\"flex items-center lg:order-2\">\r\n");
      out.write("                        <!-- notification Bell -->\r\n");
      out.write("                        <button type=\"button\" data-dropdown-toggle=\"notification-dropdown\" class=\"relative  p-2 mr-1 rounded-lg text-gray-700 hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:hover:text-white dark:hover:bg-gray-700 focus:ring-4 focus:ring-green-300 dark:focus:ring-gray-600\">\r\n");
      out.write("                            <span class=\"sr-only\">View notifications</span>\r\n");
      out.write("                            <!-- Bell icon -->\r\n");
      out.write("                            <svg aria-hidden=\"true\" class=\"w-6 h-6\" fill=\"currentColor\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10 2a6 6 0 00-6 6v3.586l-.707.707A1 1 0 004 14h12a1 1 0 00.707-1.707L16 11.586V8a6 6 0 00-6-6zM10 18a3 3 0 01-3-3h6a3 3 0 01-3 3z\"></path></svg>\r\n");
      out.write("                            <!-- notification badge -->\r\n");
      out.write("                            <span id=\"bellbadge\" class=\"top-0 left-7 absolute  w-2 h-2 bg-red-500 dark:border-gray-800 rounded-full\"></span>\r\n");
      out.write("                        </button>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Dropdown menu for bell button -->\r\n");
      out.write("                        <div class=\"hidden overflow-hidden z-50 my-4 max-w-sm text-base list-none bg-white rounded divide-y divide-gray-100 shadow-lg dark:divide-gray-600 dark:bg-gray-700\" id=\"notification-dropdown\">\r\n");
      out.write("                            <div class=\"block py-2 px-4 text-base font-medium text-center text-gray-700 bg-green-300 dark:bg-gray-700 dark:text-gray-400\">\r\n");
      out.write("                                Notifications\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <a href=\"#\" class=\"flex py-3 px-4 border-b hover:bg-green-200 dark:hover:bg-gray-600 dark:border-gray-600\">\r\n");
      out.write("                                    <div class=\"flex-shrink-0\">\r\n");
      out.write("                                        <img class=\"w-11 h-11 rounded-full\" src=\"https://flowbite.s3.amazonaws.com/blocks/marketing-ui/avatars/bonnie-green.png\" alt=\"Bonnie Green avatar\">\r\n");
      out.write("                                        <div class=\"flex absolute justify-center items-center ml-6 -mt-5 w-5 h-5 rounded-full border border-white bg-primary-700 dark:border-gray-700\">\r\n");
      out.write("                                            <svg aria-hidden=\"true\" class=\"w-3 h-3 text-white\" fill=\"currentColor\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M8.707 7.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l2-2a1 1 0 00-1.414-1.414L11 7.586V3a1 1 0 10-2 0v4.586l-.293-.293z\"></path><path d=\"M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z\"></path></svg>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"pl-3 w-full\">\r\n");
      out.write("                                        <div class=\"text-gray-500 font-normal text-sm mb-1.5 dark:text-gray-400\">New message from <span class=\"font-semibold text-gray-900 dark:text-white\">Bonnie Green</span>: \"Hey, what's up? All set for the presentation?\"</div>\r\n");
      out.write("                                        <div class=\"text-xs font-medium text-primary-700 dark:text-primary-400\">a few moments ago</div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <a href=\"#\" class=\"block py-2 text-base font-normal text-center text-gray-900 bg-green-300 hover:bg-green-200 dark:bg-gray-700 dark:text-white dark:hover:underline\">\r\n");
      out.write("                                <div class=\"inline-flex items-center \">\r\n");
      out.write("                                    <svg aria-hidden=\"true\" class=\"mr-2 w-5 h-5\" fill=\"currentColor\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10 12a2 2 0 100-4 2 2 0 000 4z\"></path><path fill-rule=\"evenodd\" d=\"M.458 10C1.732 5.943 5.522 3 10 3s8.268 2.943 9.542 7c-1.274 4.057-5.064 7-9.542 7S1.732 14.057.458 10zM14 10a4 4 0 11-8 0 4 4 0 018 0z\" clip-rule=\"evenodd\"></path></svg>\r\n");
      out.write("                                    View all\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- profile menu button-->\r\n");
      out.write("                        <button type=\"button\" class=\"p-2 mr-1 rounded-lg text-gray-700 hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:hover:text-white dark:hover:bg-gray-700 focus:ring-4 focus:ring-green-300 dark:focus:ring-gray-600\" aria-expanded=\"false\" data-dropdown-toggle=\"dropdown-user\">\r\n");
      out.write("                            <svg class=\"w-5 h-5\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 14 18\">\r\n");
      out.write("                            <path d=\"M7 9a4.5 4.5 0 1 0 0-9 4.5 4.5 0 0 0 0 9Zm2 1H5a5.006 5.006 0 0 0-5 5v2a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2a5.006 5.006 0 0 0-5-5Z\"/>\r\n");
      out.write("                            </svg>\r\n");
      out.write("                        </button>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"z-50 hidden my-4 text-base list-none bg-green-300 divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600\" id=\"dropdown-user\">\r\n");
      out.write("                            <div class=\"px-4 py-3\" role=\"none\">\r\n");
      out.write("                                <p class=\"text-sm text-black dark:text-white\" role=\"none\">\r\n");
      out.write("                                    Neil Sims\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"text-sm font-medium text-black truncate dark:text-gray-300\" role=\"none\">\r\n");
      out.write("                                    ");
      out.print( email);
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <ul class=\"py-1\" role=\"none\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"studentProfile.jsp\" class=\"block px-4 py-2 text-sm text-black hover:bg-green-200 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white\" role=\"menuitem\">My Profile</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!-- drawer init and toggle -->\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <button id=\"doubleDropdownButton\" data-dropdown-toggle=\"doubleDropdown\" data-dropdown-placement=\"right-start\" type=\"button\" class=\"flex text-sm text-black items-center justify-between w-full px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Application<svg class=\"w-2.5 h-2.5 ml-2.5\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 6 10\">\r\n");
      out.write("                                        <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"m1 9 4-4-4-4\"/>\r\n");
      out.write("                                        </svg>\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                    <div id=\"doubleDropdown\" class=\"z-10 hidden bg-green-300 divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700\">\r\n");
      out.write("                                        <ul class=\"py-2 text-sm text-gray-700 dark:text-gray-200\" aria-labelledby=\"doubleDropdownButton\">\r\n");
      out.write("                                            <li>\r\n");
      out.write("                                                <a href=\"apllnAccepted.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Accepted</a>\r\n");
      out.write("                                            </li>\r\n");
      out.write("                                            <li>\r\n");
      out.write("                                                <a href=\"apllnRejected.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Rejected</a>\r\n");
      out.write("                                            </li>\r\n");
      out.write("                                            <li>\r\n");
      out.write("                                                <a href=\"apllnPending.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Pending</a>\r\n");
      out.write("                                            </li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <button id=\"settingDropdownButton\" data-dropdown-toggle=\"settingDropdown\" data-dropdown-placement=\"right-start\" type=\"button\" class=\"flex text-sm text-black items-center justify-between w-full px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Setting<svg class=\"w-2.5 h-2.5 ml-2.5\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 6 10\">\r\n");
      out.write("                                        <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"m1 9 4-4-4-4\"/>\r\n");
      out.write("                                        </svg>\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                    <div id=\"settingDropdown\" class=\"z-10 hidden bg-green-300 divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700\">\r\n");
      out.write("                                        <ul class=\"py-2 text-sm text-gray-700 dark:text-gray-200\" aria-labelledby=\"settingDropdownButton\">\r\n");
      out.write("                                            <li>\r\n");
      out.write("                                                <a href=\"studentChangepass.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Change Password</a>\r\n");
      out.write("                                            </li>\r\n");
      out.write("\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" class=\"block px-4 py-2 text-sm text-black hover:bg-green-200 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white\" role=\"menuitem\">Sign out</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
