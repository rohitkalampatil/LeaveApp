<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>
        <link rel="icon" type="image/png" href="logo.png"/>
        <title>Students - panel</title>
    </head>
    <body>
        <%
            // can not store user data on this page ie to prevent back after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //checking for session is active or not 

            if (session.getAttribute("prn") == null) {
                //checking only prn cause if prn gets nulll it will not check further for true

                response.sendRedirect("studentLogin.jsp");
            } else {
                String name = (String) session.getAttribute("name");
                String email = (String) session.getAttribute("email");
                int prn = Integer.parseInt(session.getAttribute("prn").toString());
                PreparedStatement st = null;
                Connection c1 = null;

                String status = request.getParameter("status");
                // out.print(""+prn);

                // right now we dont need prn value on thid page isted of delete im commenting
                //int prn = Integer.parseInt(session.getAttribute("prn").toString());
<<<<<<< HEAD
        %>
=======
%>
>>>>>>> 4430194ce0039afe19f7f00cdfb0ff417f2d4e1c
        <header>
            <nav class="fixed px-4 lg:px-6 py-2.5 top-0 z-50 w-full bg-white shadow border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700">
                <div class="flex flex-wrap justify-between items-center    ">

                    <!--- logo div -->
                    <div class="flex items-center justify-start">
                        <button data-drawer-target="logo-sidebar" data-drawer-toggle="logo-sidebar" aria-controls="logo-sidebar" type="button" class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
                            <span class="sr-only">Open sidebar</span>
                            <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                            <path clip-rule="evenodd" fill-rule="evenodd" d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"></path>
                            </svg>
                        </button>
                        <a href="studentpanel.jsp" class="flex ml-2 md:mr-24">
                            <img src="logo.png" class="h-8 mr-3" alt="Logo" />
                            <span class="self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white">LeaveApp</span>
                        </a>
                    </div>

                    <!--profile button-->
                    <div class="flex items-center lg:order-2">
                        <button  type="button" aria-expanded="false" data-dropdown-toggle="dropdown-user" class="inline-flex flex-col items-center justify-center px-4 rounded-r-full hover:bg-gray-50 dark:hover:bg-gray-800 group">
                            <svg class="w-7 h-7 mb-1 text-gray-500 dark:text-gray-400 group-hover:text-blue-600 dark:group-hover:text-blue-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path d="M10 0a10 10 0 1 0 10 10A10.011 10.011 0 0 0 10 0Zm0 5a3 3 0 1 1 0 6 3 3 0 0 1 0-6Zm0 13a8.949 8.949 0 0 1-4.951-1.488A3.987 3.987 0 0 1 9 13h2a3.987 3.987 0 0 1 3.951 3.512A8.949 8.949 0 0 1 10 18Z"/>
                            </svg>
                            <span class="sr-only">Profile</span>
                        </button>
                    </div>
                    <!--user menu drawer-->
                    <div class="z-50 hidden my-4 w-44 text-base list-none bg-gray-200 divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600" id="dropdown-user">
                        <div class="px-4 py-3" role="none">
                            <p class="text-sm text-black dark:text-white" role="none">
                                <%= name%>
                            </p>
                            <p class="text-sm font-medium text-black truncate dark:text-gray-300" role="none">
                                <%= email%>
                            </p>
                        </div>
                        <ul class="py-1" role="none">
                            <li>
                                <a href="studentProfile.jsp" class="flex text-sm text-gray-700 items-center w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white group" role="menuitem">
                                    <svg class="w-5 h-5 mr-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                                    <path d="M10 0a10 10 0 1 0 10 10A10.011 10.011 0 0 0 10 0Zm0 5a3 3 0 1 1 0 6 3 3 0 0 1 0-6Zm0 13a8.949 8.949 0 0 1-4.951-1.488A3.987 3.987 0 0 1 9 13h2a3.987 3.987 0 0 1 3.951 3.512A8.949 8.949 0 0 1 10 18Z"/>
                                    </svg>
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a href="leaveApplication.jsp" class="flex text-sm text-gray-700 items-center w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white group" role="menuitem" >
                                    <svg class="w-5 h-5 mr-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                                    <path d="M9.546.5a9.5 9.5 0 1 0 9.5 9.5 9.51 9.51 0 0 0-9.5-9.5ZM13.788 11h-3.242v3.242a1 1 0 1 1-2 0V11H5.304a1 1 0 0 1 0-2h3.242V5.758a1 1 0 0 1 2 0V9h3.242a1 1 0 1 1 0 2Z"/>
                                    </svg>
                                    New Application
                                </a>
                            </li>
                            <!--button for application status-->
                            <li>                              
                                <button id="doubleDropdownButton" data-dropdown-toggle="doubleDropdown" data-dropdown-placement="right-start" type="button" class="flex text-sm text-gray-700 items-center w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white group">

                                    <svg class="mt-1 w-5 h-5 mr-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                                    <path d="M18 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2ZM5 12a1 1 0 1 1 0-2 1 1 0 0 1 0 2Zm0-3a1 1 0 1 1 0-2 1 1 0 0 1 0 2Zm0-3a1 1 0 1 1 0-2 1 1 0 0 1 0 2Zm10 6H9a1 1 0 0 1 0-2h6a1 1 0 0 1 0 2Zm0-3H9a1 1 0 0 1 0-2h6a1 1 0 1 1 0 2Zm0-3H9a1 1 0 0 1 0-2h6a1 1 0 1 1 0 2Z"/>
                                    </svg>
                                    Applications
                                </button>
                                <div id="doubleDropdown" class="z-10 hidden bg-gray-200 divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700">
                                    <ul class="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="doubleDropdownButton">
                                        <li>
                                            <a href="leaveApplicationStatus.jsp?status=accept" class="block px-4 py-2 hover:bg-gray-300 dark:hover:bg-gray-600 dark:hover:text-white">Accepted</a>
                                        </li>
                                        <li>
                                            <a href="leaveApplicationStatus.jsp?status=reject" class="block px-4 py-2 hover:bg-gray-300 dark:hover:bg-gray-600 dark:hover:text-white">Rejected</a>
                                        </li>
                                        <li>
                                            <a href="leaveApplicationStatus.jsp?status=pending" class="block px-4 py-2 hover:bg-gray-300 dark:hover:bg-gray-600 dark:hover:text-white">Pending</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!--setting button-->
                            <li>                           
                                <button id="settingDropdownButton" data-dropdown-toggle="settingDropdown" data-dropdown-placement="right-start" type="button" class="flex text-sm text-gray-700 items-center w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white group">
                                    <svg class="w-5 h-5 mr-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 12.25V1m0 11.25a2.25 2.25 0 0 0 0 4.5m0-4.5a2.25 2.25 0 0 1 0 4.5M4 19v-2.25m6-13.5V1m0 2.25a2.25 2.25 0 0 0 0 4.5m0-4.5a2.25 2.25 0 0 1 0 4.5M10 19V7.75m6 4.5V1m0 11.25a2.25 2.25 0 1 0 0 4.5 2.25 2.25 0 0 0 0-4.5ZM16 19v-2"/>
                                    </svg>
                                    Setting
                                </button>
                                <div id="settingDropdown" class="z-10 hidden bg-gray-200 divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700">
                                    <ul class="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="settingDropdownButton">
                                        <li>
                                            <a href="studentChangepass.jsp" class="block px-4 py-2 hover:bg-gray-300 dark:hover:bg-gray-600 dark:hover:text-white">Change Password</a>
                                        </li>

                                    </ul>
                                </div>
                            </li>
                            <!--logout-->
                            <li>
                                <a href="Logout" class="flex text-sm text-gray-700 items-center w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white group" role="menuitem">
                                    <svg class="w-4 mr-4 h-4 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 16 16">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 8h11m0 0-4-4m4 4-4 4m-5 3H3a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h3"/>
                                    </svg>
                                    Sign out
                                </a>
                            </li>
                        </ul>
                    </div>

                </div>
            </nav>
        </header>

        <!--side bar--> 
        <aside id="logo-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-800 dark:border-gray-700" aria-label="Sidebar">
            <div class="h-full px-3 pb-4 overflow-y-auto bg-white dark:bg-gray-800">
                <!--students side elements like college notice board syllabousall stuff-->
            </div>
        </aside>                

        <!--demo content-->
        <div id="dashboard" class="p-4 sm:ml-64">
            <div class="p-4 border-2 border-gray-200 border-dashed rounded-lg dark:border-gray-700 mt-14">
                <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
                    <div class="relative z-0 w-full mb-6 group">
                        <p  class="flex ml-2 md:mr-24">
                            <span class="self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white"><%=status%>ed Applications</span>
                        </p>
                    </div>
                    <table class=" w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr>

                                <th scope="col" class="px-6 py-3">
                                    Student name
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    PRN
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Contact
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Application ID
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    View
                                </th>

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");

                                    st = c1.prepareStatement("select * from leaveapplications where prn=? and status=?");
                                    st.setInt(1, prn);
                                    st.setString(2, status);
                                    ResultSet r = st.executeQuery();
                                    while (r.next()) {
                            %>
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <%= r.getString("name")%>
                                </th>
                                <td class="px-6 py-4">
                                    <%= r.getInt("prn")%>
                                </td>
                                <td class="px-6 py-4">
                                    <%= r.getLong("contact")%>
                                </td>
                                <td class="px-6 py-4">
                                    <%= r.getInt("applicationid")%>
                                </td>
                                <td class="px-6 py-4">
                                    <a href="leaveApplicationView.jsp?applicationid=<%= r.getInt(1)%>" class=" flex font-medium text-blue-400 dark:text-blue-500 hover:underline">
                                        <svg class="w-4 h-4 mr-2 text-blue-500 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 14">
                                        <path d="M10 0C4.612 0 0 5.336 0 7c0 1.742 3.546 7 10 7 6.454 0 10-5.258 10-7 0-1.664-4.612-7-10-7Zm0 10a3 3 0 1 1 0-6 3 3 0 0 1 0 6Z"/>
                                        </svg>
                                        View</a>
                                </td>
                            </tr>
                            <%
                                    }
                                    c1.close();
                                } catch (Exception e) {
<<<<<<< HEAD

=======
                                    
>>>>>>> 4430194ce0039afe19f7f00cdfb0ff417f2d4e1c
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%}%>
    </body>
</html>