
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.http.HttpSession;

public class ChangePassHod extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession s1 = request.getSession(true);
//            s1.setAttribute("status",null);
//            s1.setAttribute("error",null);
            String userid = (String) s1.getAttribute("userid");
            String oldpass = request.getParameter("password");
            String newpass = request.getParameter("pwd1");
            String confpass = request.getParameter("pwd2");

            Connection c1 = null;
            PreparedStatement st = null;
            String q = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                out.print("<br>dbms connected");

                q = "select password from hod where userid=?";
                st = c1.prepareStatement(q);
                st.setString(1, userid);
                ResultSet r = st.executeQuery();
                if (r.next()) {
                    if (oldpass.equals(r.getString("password"))) {
                        if (newpass.length() >= 4 && newpass.length() <= 8) {
                            if (newpass.equals(confpass)) {
                                q = "update hod set password=? where userid=?";
                                st = c1.prepareStatement(q);
                                st.setString(1, newpass);
                                st.setString(2, userid);
                                int rr = st.executeUpdate();
                                if (rr > 0) {
                                    c1.close();
                                    s1.setAttribute("status", "success");
                                    response.sendRedirect("hodChangepass.jsp");
                                }
                            } else {
                                s1.setAttribute("status", "failed");
                                s1.setAttribute("error", "New Password and Confirm Password missmatched");
                                response.sendRedirect("hodChangepass.jsp");
                            }
                        } else {
                            s1.setAttribute("status", "failed");
                            s1.setAttribute("error", "password must contain more than 4 charecter");
                            response.sendRedirect("hodChangepass.jsp");
                        }
                    } else {
                       s1.setAttribute("status", "failed");
                        s1.setAttribute("error", "Wrong Old Password");
                        response.sendRedirect("hodChangepass.jsp");
                    }
                }
            } catch (Exception e) {
                s1.setAttribute("status", "failed");
                s1.setAttribute("erroralert", "To many try,You were logged out");
                response.sendRedirect("hodlogin.jsp");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
