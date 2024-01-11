package com.pkg.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserVerify extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String userid = request.getParameter("username");
            String eemail = request.getParameter("useremail");

            HttpSession session = request.getSession();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root")) {
                    String selectQuery = "select email from hod where userid=?";
                    try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                        selectStatement.setString(1, userid);
                        ResultSet resultSet = selectStatement.executeQuery();
                        if (resultSet.next()) {

                            if (eemail.equals(resultSet.getString("email"))) {

                                SendEmail sm = new SendEmail();
                                String code = sm.getRandom();
                                User user = new User(userid, eemail, code);
                                boolean test = sm.sendEmail(user);
                                if (test) {
                                    session.setAttribute("userid", userid);
                                    session.setAttribute("authcode", user);
                                    response.sendRedirect("Verify.jsp");
                                }

                            } else {
                                session.setAttribute("sts", "F");
                                response.sendRedirect("forgotPass.jsp");
                            }
                        } else {
                            session.setAttribute("sts", "FU");
                            response.sendRedirect("forgotPass.jsp");
                        }
                    }

                }
            } catch (Exception e) {

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
