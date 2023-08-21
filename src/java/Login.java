
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession s1 = request.getSession(true);
            s1.setAttribute("userid", null);
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");
            Connection c1;
            RequestDispatcher rd = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp", "root", "root");
                PreparedStatement st = c1.prepareStatement("select password,branch,hodname from hod where userid=?");
                st.setString(1, userid);

                ResultSet r = st.executeQuery();
                if (r.next()) {
                    if (password.equals(r.getString("password"))) {
                        String branch = r.getString("branch");
                        String hodname = r.getString("hodname");

                        s1.setAttribute("branch", branch);
                        s1.setAttribute("hodname", hodname);
                        s1.setAttribute("userid", userid);
                        response.sendRedirect("hodpanel.jsp");

                    } else {

                        s1.setAttribute("error", "Invalid Password");
                        s1.setAttribute("userid", userid);
                        response.sendRedirect("hodlogin.jsp");
                    }
                } else {

                    s1.setAttribute("error", "Invalid ID");
                    response.sendRedirect("hodlogin.jsp");
                }
                c1.close();

            } catch (Exception e) {
                response.sendRedirect("hodlogin.jsp");
            }
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
