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

        <title>View Application</title>
    </head>
    <body>
        <%
            // can not store user data on this page ie to prevent back after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        %>
        <header>
            <nav class="fixed px-4 lg:px-6 py-2.5 top-0 z-50 w-full bg-white shadow border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700">
                <div class="flex flex-wrap justify-between items-center    ">
                    <!--- logo div -->
                    <div class="flex items-center justify-start">
                        <p class="flex ml-2 md:mr-24">
                            <img src="logo.png" class="h-8 mr-3" alt="Logo" />
                            <span class="self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white">LeaveApp</span>
                        </p>
                    </div>
                </div>
            </nav>
        </header>



        <!-- content-->
        <div id="dashboard" class="p-4">
            <div class="p-4 border-2 border-gray-200 border-dashed rounded-lg dark:border-gray-700 mt-14">

                <%
                    PreparedStatement st = null;
                    Connection c1 = null;
                    int applicationid = Integer.parseInt(request.getParameter("applicationid"));

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                        //out.println("Database Connected Succesfully");
                        st = c1.prepareStatement("select * from leaveapplications where applicationid=?");
                        st.setInt(1, applicationid);

                        ResultSet r = st.executeQuery();
                        if (r.next()) {

                %>
                
                <!--hedding-->
                <div class="relative z-0 mb-6 w-full group">
                    <p  class="flex ml-2 justify-center">
                        <span class="self-center text-2xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white">
                            Leave Application
                        </span>
                    </p>
                </div>
                <!--application date-->
                <div class="grid grid-cols-2 gap-6">
                    <div class="relative z-0 w-full  group"></div>
                    <div class="flex z-0 w-full items-center justify-center group">
                        <p class="mb-3 text-left flex ml-4  ">
                            <%out.print(r.getString("applicationdate"));%>
                        </p>
                    </div>
                </div>
                        <!--name of college and principle-->
                <div class="grid grid-cols-3  gap-6">
                    <div class="relative z-0 w-full  group">
                        <p class="mb-3 text-left flex ml-4 justify-start ">
                            To,
                        </p>
                        <p class="mb-3 text-left flex ml-4 justify-start ">
                            Principl/HOD<br>College of Computer Science and IT Ambajogai 431517
                        </p>
                    </div>
                    <div class="relative z-0 w-full  group"></div>
                    <div class="relative z-0 w-full  group"></div>
                </div>

<!--subject leavetype-->
                <div class="relative z-0 w-full mb-3 ml-6 group">
                    <div class="ml-6">
                        <p class=" ml-6 text-left flex justify-start ">
                            <b>Leave Type :  </b> - <% out.print(" " + r.getString("leavetype"));%>
                        </p>
                    </div>
                </div>
<!--matter-->
                <div class="relative z-0 w-full mb-6 ml-6 group">
                    <p class="mb-3 ml-2 text-left flex justify-start ">Rspected sir/madam,<br></p>
                    <div class="ml-6">
                        <p class=" ml-4 mr-6 ">
                            I am Student <b><% out.print(r.getString("name"));%></b> pursuing in branch <b><% out.print(r.getString("branch"));%></b> due to following 
                            Reason <b><%out.print(r.getString("reason"));%></b> i want leave from <b><%out.print( r.getString("leavefrom"));%></b> to <b><%out.print( r.getString("leaveto"));%></b>
                            ,Day After<b> <%out.print(r.getString("leaveto"));%></b> i will continue my Class. This is kindly request to you,i 
                            hope you will accept my Leave.
                        </p>
                    </div>
                </div>
<!--end-->
                <div class="grid grid-cols-3 gap-6">
                    <div class="relative z-0 w-full mb-6 group"></div>
                    <div class="relative z-0 w-full mb-6 group"></div>
                    <div class="relative z-0 w-full mb-6 group">
                        <p class="mb-3 text-right flex mr-4 justify-center ">
                            <b><% out.print("Yours faithfully<br>" + r.getString("name"));%>
                                <% out.print("<br>" + r.getLong("contact"));%>
                                <% out.print("<br>" + r.getString("email"));%></b>
                        </p>
                    </div>
                </div>

                <%      }
                        c1.close();
                    } catch (Exception e) {
                        out.println("Student Exception :-" + e);
                    }

                %>

            </div>

        </div>    

    </body>
</html>
