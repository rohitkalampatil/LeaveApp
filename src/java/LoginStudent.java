
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession s1 = request.getSession(true);
            s1.setAttribute("prn", null);
            int prn = Integer.parseInt(request.getParameter("prn"));
            String password = request.getParameter("password");
            Connection c1;
            RequestDispatcher rd = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                PreparedStatement st = c1.prepareStatement("select contact,password,semail,name,branch from student where prn=?");
                st.setInt(1, prn);

                ResultSet r = st.executeQuery();
                if (r.next()) {
                    if (password.equals(r.getString("password"))) {
                        String email = r.getString("semail");
                        String name = r.getString("name");
                        String branch=r.getString("branch");
                        long contact=r.getLong("contact");
                        s1.setAttribute("email", email);
                        s1.setAttribute("name", name);
                        s1.setAttribute("prn", prn);
                        s1.setAttribute("branch",branch);
                        s1.setAttribute("contact", contact);
                        response.sendRedirect("studentpanel.jsp");
                        //out.print("logged in");
                    } else {

                        s1.setAttribute("error", "Invalid Password");
                        s1.setAttribute("prn", prn);
                        //out.print("invalid pass");
                        response.sendRedirect("studentLogin.jsp");
                    }
                } else {
                    //out.print("invalid id pass");
                    s1.setAttribute("error", "Invalid ID");
                    response.sendRedirect("studentLogin.jsp");
                }
                c1.close();

            } catch (Exception e) {
                response.sendRedirect("studentLogin.jsp");
                //out.print("logged in"+e);
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
