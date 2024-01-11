
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String sname = request.getParameter("sname");
            int rollno = Integer.parseInt(request.getParameter("rollno"));
            long contact = Long.parseLong(request.getParameter("contact"));
            String year = request.getParameter("year");
            String semail = request.getParameter("semail");

            int prn = Integer.parseInt(request.getParameter("prn"));

            RequestDispatcher rd = null;
            Connection c1 = null;
            //out.println(prn);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                //out.println("Database Connected Succesfully");
                String q = "update student set name=?,rollno=?,contact=?, year=?,semail=? where prn=?";

                PreparedStatement st = c1.prepareStatement(q);
                st.setString(1, sname);
                st.setInt(2, rollno);
                st.setLong(3, contact);
                st.setString(4, year);
                st.setString(5, semail);
                st.setInt(6, prn);

                int r = st.executeUpdate();
                if (r > 0) {
                //closing connection before Redirecting    
                    c1.close();
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "success");
                    s1.setAttribute("prn", prn);
                    response.sendRedirect("studentUpdate.jsp");

                } else {
                //closing connection before Redirecting     
                    c1.close();
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "failed");
                    s1.setAttribute("prn", prn);
                    response.sendRedirect("studentUpdate.jsp");

                }

            } catch (Exception e) {
              
                try {
                    c1.close();
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "failed");
                    s1.setAttribute("prn", prn);
                    response.sendRedirect("studentUpdate.jsp");
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
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
