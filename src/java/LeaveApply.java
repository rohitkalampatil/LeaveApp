
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LeaveApply extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            PreparedStatement st = null;
            Connection c1 = null;
            int applicationid = Integer.parseInt(request.getParameter("applicationid"));
            String name = request.getParameter("sname");
            String leavetype = request.getParameter("leavetype");
            String applicationdate = request.getParameter("applicationdate");
            int prn = Integer.parseInt(request.getParameter("prn"));
            String branch = request.getParameter("branch");
            long contact = Long.parseLong(request.getParameter("contact"));
            String email = request.getParameter("email");
            String leavefrom = request.getParameter("leavefrom");
            String leaveto = request.getParameter("leaveto");
            String reason = request.getParameter("reason");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                //out.println("Database Connected Succesfully");

                st = c1.prepareStatement("insert into leaveapplications values(?,?,?,?,?,?,?,?,?,?,?,'');");
                st.setInt(1, applicationid);
                st.setString(2, applicationdate);
                st.setString(3, name);
                st.setInt(4, prn);
                st.setString(5, branch);
                st.setLong(6, contact);
                st.setString(7, email);
                st.setString(8, leavetype);
                st.setString(9, leavefrom);
                st.setString(10, leaveto);
                st.setString(11, reason);

                int r = st.executeUpdate();
                if (r > 0) {
                    c1.close();
                    //out.print("addd");
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "success");
                    response.sendRedirect("leaveApplication.jsp");

                }
                c1.close();
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    c1.close();
                    //out.print("fail");
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "failed");
                    response.sendRedirect("leaveApplication.jsp");
                } catch (SQLException ex) {
                    Logger.getLogger(LeaveApply.class.getName()).log(Level.SEVERE, null, ex);
                }

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
