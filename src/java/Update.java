
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

public class Update extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession s1 = request.getSession(true);
            String userid = (String) s1.getAttribute("userid");

            String hodname = request.getParameter("hodname");
            String branch = request.getParameter("branch");

            Connection c1 = null;
            PreparedStatement st = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                String q = "update hod set hodname=?,branch=? where userid=?";
                st = c1.prepareStatement(q);
                st.setString(1, hodname);
                st.setString(2, branch);
                st.setString(3, userid);
                int r = st.executeUpdate();

                if (r > 0) {
                    out.print("<br>updated success");
                    q = "select hodname,userid,branch from hod where userid=?";
                    st = c1.prepareStatement(q);
                    st.setString(1, userid);

                    ResultSet rr = st.executeQuery();
                    if (rr.next()) {
                        userid = rr.getString("userid");
                        hodname = rr.getString("hodname");
                        branch = rr.getString("branch");
                        s1.setAttribute("userid", userid);
                        s1.setAttribute("branch", branch);
                        s1.setAttribute("hodname", hodname);
                        s1.setAttribute("status", "success");
                        c1.close();
                        response.sendRedirect("hodProfile.jsp");
                    }

                } else {
                    c1.close();
                    s1.setAttribute("userid", userid);
                    s1.setAttribute("status", "failed");
                    response.sendRedirect("hodProfile.jsp");
                }

            } catch (Exception e) {
                try {
                    c1.close();
                    s1.setAttribute("userid", userid);
                    s1.setAttribute("status", "failed");
                    response.sendRedirect("hodProfile.jsp");
                } catch (SQLException ex) {
                    Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
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
