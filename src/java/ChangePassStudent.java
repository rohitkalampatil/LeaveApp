
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


public class ChangePassStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession s1 = request.getSession(true);
//            s1.setAttribute("status",null);
//            s1.setAttribute("error",null);
            int prn = Integer.parseInt(s1.getAttribute("prn").toString());
            String oldpass = request.getParameter("password");
            String newpass = request.getParameter("pwd1");
            String confpass = request.getParameter("pwd2");

            //out.print("oldpass - " + oldpass + "<br>newpass - " + newpass + "<br>confirmpass - " + confpass + "<br>userid - " + prn);
            Connection c1 = null;
            PreparedStatement st = null;
            String q = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                out.print("<br>dbms connected");

                q = "select password from student where prn=?";
                st = c1.prepareStatement(q);
                st.setInt(1, prn);
                ResultSet r = st.executeQuery();
                if (r.next()) {
                    if (oldpass.equals(r.getString("password"))) {
                        if (newpass.length() >= 4 && newpass.length() <= 8) {
                            if (newpass.equals(confpass)) {
                                q = "update student set password=? where prn=?";
                                st = c1.prepareStatement(q);
                                st.setString(1, newpass);
                                st.setInt(2, prn);
                                int rr = st.executeUpdate();
                                if (rr > 0) {
                                    c1.close();
                                    
                                    s1.setAttribute("status", "success");
                                    //s1.setAttribute("error","pass set");
                                    //out.print("<br>password set success");
                                    response.sendRedirect("studentChangepass.jsp");
                                }
                            } else {
                                s1.setAttribute("status", "failed");
                                out.print("<br>newpass conf pass mismatch ");
                                s1.setAttribute("error", "New Password and Confirm Password missmatched");
                                response.sendRedirect("studentChangepass.jsp");
                            }
                        } else {
                            s1.setAttribute("status", "failed");
                            s1.setAttribute("error", "password must minimum 4 or max 8 charecter long");
                            out.print("<br>pass must need greater than 4");
                            response.sendRedirect("studentChangepass.jsp");
                        }
                    } else {
                       s1.setAttribute("status", "failed");
                        out.print("<br>enter your old pass correct");
                        s1.setAttribute("error", "Wrong Old Password");
                        response.sendRedirect("studentChangepass.jsp");
                    }
                }
            } catch (Exception e) {
                s1.setAttribute("status", "failed");
                s1.setAttribute("erroralert", "To many try,You were logged out");
                response.sendRedirect("studentLogin.jsp");
                out.print(e);
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
