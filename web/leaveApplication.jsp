<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="java.util.*"  %>
<%@ page import="java.text.*"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.0/flowbite.min.js"></script>
        <link rel="icon" type="image/png" href="logo.png"/>

        <title>Student Dashboard - Leave Application form</title>
    </head>
    <%
        // now for applicationid we need to connect with database for 
        // application id
        int applicationid = 0;
        Connection c1 = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
            st = c1.prepareStatement("select max(applicationid) from leaveapplications");
            ResultSet r = st.executeQuery();
            if (r.next()) {

                applicationid = (r.getInt("max(applicationid)") + 1);
                c1.close();
            }
        } catch (Exception e) {
            out.print(e);
        }
    %>
    <body>
        <%
            // can not store user data on this page ie to prevent back after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //checking for session is active or not 
            if (session.getAttribute("prn") == null) {
                response.sendRedirect("studentLogin.jsp");
            } else {
                //getting all required value through session 
                // we can also get from database but instead of connection again to database its better
                // set session for these data/value at the login time
                String name = (String) session.getAttribute("name");
                String email = (String) session.getAttribute("email");
                String branch = (String) session.getAttribute("branch");
                int prn = Integer.parseInt(session.getAttribute("prn").toString());
                long contact = Long.parseLong(session.getAttribute("contact").toString());

        %>

        <h2>Leave Application Form</h2>

        <form action="LeaveApply" method="post">

            <label for="applicationdate"> Application date:</label> 
            <input type="text" name="applicationdate" value="<% SimpleDateFormat frmt = new SimpleDateFormat("yy-MM-dd");
                out.print(frmt.format(new java.util.Date()));
                   %>" readonly="true" ><br><br>


            <label for="applicationid"> Application Id:</label> 
            <input type="text" name="applicationid" value="<%= applicationid%>" readonly="true" ><br><br>

            <label for="sname"> Your Name :</label> 
            <input type="text" name="sname" value="<%= name%>" readonly="true"><br><br>

            <label for="rollno"> Your PRN :</label> 
            <input type="number" name="prn" value="<%= prn%>" readonly="true"><br><br>

            <label for="branch"> Branch :</label> 
            <input type="text" name="branch" value="<%= branch%>" readonly="true"><br><br>


            <label for="contact"> Contact :</label> 
            <input type="tel" name="contact" value="<%= contact%>" readonly="true"><br><br>

            <label for="rollno"> You Email :</label> 
            <input type="email" name="email" value="<%= email%>" readonly="true"><br><br>

            <label for="leave-type">Leave Type:</label>
            <select id="leave-type" name="leavetype" required>
                <option value="vacation">Vacation</option>
                <option value="sick">Sick Leave</option>
                <option value="personal">Personal Leave</option>
                <option value="other">Other</option>
            </select>

            <label for="leavefrom"> leave from :</label> 
            <input type="date" name="leavefrom" ><br><br>

            <label for="leaveto"> leave to :</label> 
            <input type="date" name="leaveto" ><br><br>

            <label for="reason"> Reason For Leave:</label> 
            <textarea name="reason" rows="4" cols="30"></textarea>

            <br><hr>
            <input class="btn btn-secondary" type="submit" Value="Apply">


            <input type="hidden" id="successButton" data-modal-toggle="successModal" >

            <div id="successModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-modal md:h-full">
                <div class="relative p-4 w-full max-w-md h-full md:h-auto">
                    <!-- Modal content -->
                    <div class="relative p-4 text-center bg-white rounded-lg shadow dark:bg-gray-800 sm:p-5">
                        <button type="button" class="text-gray-400 absolute top-2.5 right-2.5 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-toggle="successModal">
                            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                            <span class="sr-only">Close modal</span>
                        </button>
                        <div class="w-12 h-12 rounded-full bg-green-100 dark:bg-green-900 p-2 flex items-center justify-center mx-auto mb-3.5">
                            <svg aria-hidden="true" class="w-8 h-8 text-green-500 dark:text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"></path></svg>
                            <span class="sr-only">Success</span>
                        </div>
                        <p class="mb-4 text-lg font-semibold text-gray-900 dark:text-white">Applied Successfully.</p>
                        <button data-modal-toggle="successModal" type="button" class="py-2 px-3 text-sm font-medium text-center text-white rounded-lg bg-green-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 dark:focus:ring-primary-900">
                            Continue
                        </button>
                    </div>
                </div>
            </div>
        </form>
            
            
            <%}%>
        <script >

            function alertNamefun() {

                var status = '<%= session.getAttribute("status")%>';

                if (status === "success") {
                    document.getElementById('successButton').click();

                }
                if (status === "failed") {
                    alert("Failed to add Student");

                }
            }
        </script>

        <script>
            window.onload = alertNamefun;
        </script>
        <% session.setAttribute("status", null);%>
        
    </body>
</html>
