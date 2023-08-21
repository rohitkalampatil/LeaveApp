package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class studentpanel1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Students - panel</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-green-100\">\n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            if (session.getAttribute("prn") == null || session.getAttribute("name") == null || session.getAttribute("email") == null) {
                response.sendRedirect("studentLogin.jsp");
            } else {
                String name = (String) session.getAttribute("name");
                String email = (String) session.getAttribute("email");
                int prn = Integer.parseInt(session.getAttribute("prn").toString());
        
      out.write("\n");
      out.write("        <header>\n");
      out.write("            <nav class=\"fixed px-4 lg:px-6 py-2.5 top-0 z-50 w-full bg-green-200 shadow border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700\">\n");
      out.write("                <div class=\"flex flex-wrap justify-between items-center    \">\n");
      out.write("\n");
      out.write("                    <!--- logo div -->\n");
      out.write("                    <div class=\"flex items-center justify-start\">\n");
      out.write("                        <a href=\"studentpanel.jsp\" class=\"flex ml-2 md:mr-24\">\n");
      out.write("                            <img src=\"logo.png\" class=\"h-8 mr-3\" alt=\"Logo\" />\n");
      out.write("                            <span class=\"self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white\">LeaveApp</span>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!--- Profile and Bell icon div -->\n");
      out.write("                    <div class=\"flex items-center lg:order-2\">\n");
      out.write("                        <!-- notification Bell -->\n");
      out.write("                        <button type=\"button\" data-dropdown-toggle=\"notification-dropdown\" class=\"relative  p-2 mr-1 rounded-lg text-gray-700 hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:hover:text-white dark:hover:bg-gray-700 focus:ring-4 focus:ring-green-300 dark:focus:ring-gray-600\">\n");
      out.write("                            <span class=\"sr-only\">View notifications</span>\n");
      out.write("                            <!-- Bell icon -->\n");
      out.write("                            <svg aria-hidden=\"true\" class=\"w-6 h-6\" fill=\"currentColor\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10 2a6 6 0 00-6 6v3.586l-.707.707A1 1 0 004 14h12a1 1 0 00.707-1.707L16 11.586V8a6 6 0 00-6-6zM10 18a3 3 0 01-3-3h6a3 3 0 01-3 3z\"></path></svg>\n");
      out.write("                            <!-- notification badge -->\n");
      out.write("                            <span id=\"bellbadge\" class=\"top-0 left-7 absolute  w-2 h-2 bg-red-500 dark:border-gray-800 rounded-full\"></span>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <!-- Dropdown menu for bell button -->\n");
      out.write("                        <div class=\"hidden overflow-hidden z-50 my-4 max-w-sm text-base list-none bg-white rounded divide-y divide-gray-100 shadow-lg dark:divide-gray-600 dark:bg-gray-700\" id=\"notification-dropdown\">\n");
      out.write("                            <div class=\"block py-2 px-4 text-base font-medium text-center text-gray-700 bg-green-300 dark:bg-gray-700 dark:text-gray-400\">\n");
      out.write("                                Notifications\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <a href=\"#\" class=\"flex py-3 px-4 border-b hover:bg-green-200 dark:hover:bg-gray-600 dark:border-gray-600\">\n");
      out.write("                                    <div class=\"flex-shrink-0\">\n");
      out.write("                                        <img class=\"w-11 h-11 rounded-full\" src=\"https://flowbite.s3.amazonaws.com/blocks/marketing-ui/avatars/bonnie-green.png\" alt=\"Bonnie Green avatar\">\n");
      out.write("                                        <div class=\"flex absolute justify-center items-center ml-6 -mt-5 w-5 h-5 rounded-full border border-white bg-primary-700 dark:border-gray-700\">\n");
      out.write("                                            <svg aria-hidden=\"true\" class=\"w-3 h-3 text-white\" fill=\"currentColor\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M8.707 7.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l2-2a1 1 0 00-1.414-1.414L11 7.586V3a1 1 0 10-2 0v4.586l-.293-.293z\"></path><path d=\"M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z\"></path></svg>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"pl-3 w-full\">\n");
      out.write("                                        <div class=\"text-gray-500 font-normal text-sm mb-1.5 dark:text-gray-400\">New message from <span class=\"font-semibold text-gray-900 dark:text-white\">Bonnie Green</span>: \"Hey, what's up? All set for the presentation?\"</div>\n");
      out.write("                                        <div class=\"text-xs font-medium text-primary-700 dark:text-primary-400\">a few moments ago</div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <a href=\"#\" class=\"block py-2 text-base font-normal text-center text-gray-900 bg-green-300 hover:bg-green-200 dark:bg-gray-700 dark:text-white dark:hover:underline\">\n");
      out.write("                                <div class=\"inline-flex items-center \">\n");
      out.write("                                    <svg aria-hidden=\"true\" class=\"mr-2 w-5 h-5\" fill=\"currentColor\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10 12a2 2 0 100-4 2 2 0 000 4z\"></path><path fill-rule=\"evenodd\" d=\"M.458 10C1.732 5.943 5.522 3 10 3s8.268 2.943 9.542 7c-1.274 4.057-5.064 7-9.542 7S1.732 14.057.458 10zM14 10a4 4 0 11-8 0 4 4 0 018 0z\" clip-rule=\"evenodd\"></path></svg>\n");
      out.write("                                    View all\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- profile menu button-->\n");
      out.write("                        <button type=\"button\" class=\"p-2 mr-1 rounded-lg text-gray-700 hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:hover:text-white dark:hover:bg-gray-700 focus:ring-4 focus:ring-green-300 dark:focus:ring-gray-600\" aria-expanded=\"false\" data-dropdown-toggle=\"dropdown-user\">\n");
      out.write("                            <svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 16 16\">\n");
      out.write("                            <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M4 8h11m0 0-4-4m4 4-4 4m-5 3H3a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h3\"/>\n");
      out.write("                            </svg>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <div class=\"z-50 hidden my-4 text-base list-none bg-green-300 divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600\" id=\"dropdown-user\">\n");
      out.write("                            <div class=\"px-4 py-3\" role=\"none\">\n");
      out.write("                                <p class=\"text-sm text-black dark:text-white\" role=\"none\">\n");
      out.write("                                    ");
      out.print( name);
      out.write("\n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"text-sm font-medium text-black truncate dark:text-gray-300\" role=\"none\">\n");
      out.write("                                    ");
      out.print( email);
      out.write("\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                            <ul class=\"py-1\" role=\"none\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"studentProfile.jsp\" class=\"block px-4 py-2 text-sm text-black hover:bg-green-200 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white\" role=\"menuitem\">My Profile</a>\n");
      out.write("                                </li>\n");
      out.write("                                <!-- drawer init and toggle -->\n");
      out.write("                                <li>\n");
      out.write("                                    <button id=\"doubleDropdownButton\" data-dropdown-toggle=\"doubleDropdown\" data-dropdown-placement=\"right-start\" type=\"button\" class=\"flex text-sm text-black items-center justify-between w-full px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Application<svg class=\"w-2.5 h-2.5 ml-2.5\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 6 10\">\n");
      out.write("                                        <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"m1 9 4-4-4-4\"/>\n");
      out.write("                                        </svg>\n");
      out.write("                                    </button>\n");
      out.write("                                    <div id=\"doubleDropdown\" class=\"z-10 hidden bg-green-300 divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700\">\n");
      out.write("                                        <ul class=\"py-2 text-sm text-gray-700 dark:text-gray-200\" aria-labelledby=\"doubleDropdownButton\">\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"apllnAccepted.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Accepted</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"apllnRejected.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Rejected</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"apllnPending.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Pending</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <button id=\"settingDropdownButton\" data-dropdown-toggle=\"settingDropdown\" data-dropdown-placement=\"right-start\" type=\"button\" class=\"flex text-sm text-black items-center justify-between w-full px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Setting<svg class=\"w-2.5 h-2.5 ml-2.5\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 6 10\">\n");
      out.write("                                        <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"m1 9 4-4-4-4\"/>\n");
      out.write("                                        </svg>\n");
      out.write("                                    </button>\n");
      out.write("                                    <div id=\"settingDropdown\" class=\"z-10 hidden bg-green-300 divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700\">\n");
      out.write("                                        <ul class=\"py-2 text-sm text-gray-700 dark:text-gray-200\" aria-labelledby=\"settingDropdownButton\">\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"studentChangepass.jsp\" class=\"block px-4 py-2 hover:bg-green-200 dark:hover:bg-gray-600 dark:hover:text-white\">Change Password</a>\n");
      out.write("                                            </li>\n");
      out.write("\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"Logout\" class=\"block px-4 py-2 text-sm text-black hover:bg-green-200 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white\" role=\"menuitem\">Sign out</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"fixed z-50 w-full h-16 max-w-lg -translate-x-1/2 bg-white border border-gray-200 rounded-full bottom-4 left-1/2 dark:bg-gray-700 dark:border-gray-600\">\n");
      out.write("            <div class=\"grid h-full max-w-lg grid-cols-5 mx-auto\">\n");
      out.write("                <button data-tooltip-target=\"tooltip-home\" type=\"button\" class=\"inline-flex flex-col items-center justify-center px-5 rounded-l-full hover:bg-gray-50 dark:hover:bg-gray-800 group\">\n");
      out.write("                    <svg class=\"w-5 h-5 mb-1 text-gray-500 dark:text-gray-400 group-hover:text-blue-600 dark:group-hover:text-blue-500\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 20 20\">\n");
      out.write("                    <path d=\"m19.707 9.293-2-2-7-7a1 1 0 0 0-1.414 0l-7 7-2 2a1 1 0 0 0 1.414 1.414L2 10.414V18a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v4a1 1 0 0 0 1 1h3a2 2 0 0 0 2-2v-7.586l.293.293a1 1 0 0 0 1.414-1.414Z\"/>\n");
      out.write("                    </svg>\n");
      out.write("                    <span class=\"sr-only\">Home</span>\n");
      out.write("                </button>\n");
      out.write("                <div id=\"tooltip-home\" role=\"tooltip\" class=\"absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white transition-opacity duration-300 bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700\">\n");
      out.write("                    Home\n");
      out.write("                    <div class=\"tooltip-arrow\" data-popper-arrow></div>\n");
      out.write("                </div>\n");
      out.write("                <button data-tooltip-target=\"tooltip-wallet\" type=\"button\" class=\"inline-flex flex-col items-center justify-center px-5 hover:bg-gray-50 dark:hover:bg-gray-800 group\">\n");
      out.write("                    <svg class=\"w-5 h-5 mb-1 text-gray-500 dark:text-gray-400 group-hover:text-blue-600 dark:group-hover:text-blue-500\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 20 20\">\n");
      out.write("                    <path d=\"M11.074 4 8.442.408A.95.95 0 0 0 7.014.254L2.926 4h8.148ZM9 13v-1a4 4 0 0 1 4-4h6V6a1 1 0 0 0-1-1H1a1 1 0 0 0-1 1v13a1 1 0 0 0 1 1h17a1 1 0 0 0 1-1v-2h-6a4 4 0 0 1-4-4Z\"/>\n");
      out.write("                    <path d=\"M19 10h-6a2 2 0 0 0-2 2v1a2 2 0 0 0 2 2h6a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1Zm-4.5 3.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2ZM12.62 4h2.78L12.539.41a1.086 1.086 0 1 0-1.7 1.352L12.62 4Z\"/>\n");
      out.write("                    </svg>\n");
      out.write("                    <span class=\"sr-only\">Wallet</span>\n");
      out.write("                </button>\n");
      out.write("                <div id=\"tooltip-wallet\" role=\"tooltip\" class=\"absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white transition-opacity duration-300 bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700\">\n");
      out.write("                    Wallet\n");
      out.write("                    <div class=\"tooltip-arrow\" data-popper-arrow></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"flex items-center justify-center\">\n");
      out.write("                    <button data-tooltip-target=\"tooltip-new\" type=\"button\" class=\"inline-flex items-center justify-center w-10 h-10 font-medium bg-blue-600 rounded-full hover:bg-blue-700 group focus:ring-4 focus:ring-blue-300 focus:outline-none dark:focus:ring-blue-800\">\n");
      out.write("                        <svg class=\"w-4 h-4 text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 18 18\">\n");
      out.write("                        <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M9 1v16M1 9h16\"/>\n");
      out.write("                        </svg>\n");
      out.write("                        <span class=\"sr-only\">New item</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"tooltip-new\" role=\"tooltip\" class=\"absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white transition-opacity duration-300 bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700\">\n");
      out.write("                    Create new item\n");
      out.write("                    <div class=\"tooltip-arrow\" data-popper-arrow></div>\n");
      out.write("                </div>\n");
      out.write("                <button data-tooltip-target=\"tooltip-settings\" type=\"button\" class=\"inline-flex flex-col items-center justify-center px-5 hover:bg-gray-50 dark:hover:bg-gray-800 group\">\n");
      out.write("                    <svg class=\"w-5 h-5 mb-1 text-gray-500 dark:text-gray-400 group-hover:text-blue-600 dark:group-hover:text-blue-500\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 20 20\">\n");
      out.write("                    <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M4 12.25V1m0 11.25a2.25 2.25 0 0 0 0 4.5m0-4.5a2.25 2.25 0 0 1 0 4.5M4 19v-2.25m6-13.5V1m0 2.25a2.25 2.25 0 0 0 0 4.5m0-4.5a2.25 2.25 0 0 1 0 4.5M10 19V7.75m6 4.5V1m0 11.25a2.25 2.25 0 1 0 0 4.5 2.25 2.25 0 0 0 0-4.5ZM16 19v-2\"/>\n");
      out.write("                    </svg>\n");
      out.write("                    <span class=\"sr-only\">Settings</span>\n");
      out.write("                </button>\n");
      out.write("                <div id=\"tooltip-settings\" role=\"tooltip\" class=\"absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white transition-opacity duration-300 bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700\">\n");
      out.write("                    Settings\n");
      out.write("                    <div class=\"tooltip-arrow\" data-popper-arrow></div>\n");
      out.write("                </div>\n");
      out.write("                <button data-tooltip-target=\"tooltip-profile\" type=\"button\" class=\"inline-flex flex-col items-center justify-center px-5 rounded-r-full hover:bg-gray-50 dark:hover:bg-gray-800 group\">\n");
      out.write("                    <svg class=\"w-5 h-5 mb-1 text-gray-500 dark:text-gray-400 group-hover:text-blue-600 dark:group-hover:text-blue-500\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" fill=\"currentColor\" viewBox=\"0 0 20 20\">\n");
      out.write("                    <path d=\"M10 0a10 10 0 1 0 10 10A10.011 10.011 0 0 0 10 0Zm0 5a3 3 0 1 1 0 6 3 3 0 0 1 0-6Zm0 13a8.949 8.949 0 0 1-4.951-1.488A3.987 3.987 0 0 1 9 13h2a3.987 3.987 0 0 1 3.951 3.512A8.949 8.949 0 0 1 10 18Z\"/>\n");
      out.write("                    </svg>\n");
      out.write("                    <span class=\"sr-only\">Profile</span>\n");
      out.write("                </button>\n");
      out.write("                <div id=\"tooltip-profile\" role=\"tooltip\" class=\"absolute z-10 invisible inline-block px-3 py-2 text-sm font-medium text-white transition-opacity duration-300 bg-gray-900 rounded-lg shadow-sm opacity-0 tooltip dark:bg-gray-700\">\n");
      out.write("                    Profile\n");
      out.write("                    <div class=\"tooltip-arrow\" data-popper-arrow></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
}
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
