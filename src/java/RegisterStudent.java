
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class RegisterStudent extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String sname = request.getParameter("sname");
            int rollno = Integer.parseInt(request.getParameter("rollno"));
            int prn = Integer.parseInt(request.getParameter("prn"));
            long contact = Long.parseLong(request.getParameter("contact"));
            String branch = request.getParameter("branch");
            String semail = request.getParameter("semail");
            String password = request.getParameter("pwd1");
            String rdate = request.getParameter("rdate");
            String year = request.getParameter("year");

            RequestDispatcher rd = null;
            Connection c1 = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                PreparedStatement st = c1.prepareStatement("insert into student(name,rollno,prn,contact,branch,year,semail,password,rdate) values(?,?,?,?,?,?,?,?,?);");
                st.setString(1, sname);
                st.setInt(2, rollno);
                st.setInt(3, prn);
                st.setLong(4, contact);
                st.setString(5, branch);
                st.setString(6, year);
                st.setString(7, semail);
                st.setString(8, password);
                st.setString(9, rdate);

                int r = st.executeUpdate();
                if (r > 0) {
                    c1.close();
                    // using session 
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "success");
                    response.sendRedirect("studentRegister.jsp");
                   
                    // using RequestDispatcher but RequestDispatcher might cause Exception
                   /* request.setAttribute("status","success");
                    rd = request.getRequestDispatcher("/studentRegister.jsp");
                    rd.forward(request, response);*/
                    //c1.close();
                } else {
                    c1.close();
                    HttpSession s1 = request.getSession(true);
                    s1.setAttribute("status", "failed");
                    response.sendRedirect("studentRegister.jsp");
                    
                    /*request.setAttribute("status","failed");
                    rd = request.getRequestDispatcher("/studentRegister.jsp");
                    rd.forward(request, response);*/
                    //c1.close();
                }
            } catch (Exception e) {
                try {
                    c1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("studentRegister.jsp");
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
