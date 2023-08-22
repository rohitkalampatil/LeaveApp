
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LeaveAction extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int applicationid = Integer.parseInt(request.getParameter("applicationid"));
            String status = request.getParameter("status");
            out.print(status+""+applicationid);
            PreparedStatement st=null;
            Connection c1=null;
            try
            {
              Class.forName("com.mysql.jdbc.Driver"); 
              c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp","root","root");

              st = c1.prepareStatement("update leaveapplications set status=? where applicationid=?");
              st.setString(1, status);
              st.setInt(2,applicationid);
              int r=st.executeUpdate();
              if(r>0)
              {
                  response.sendRedirect("inbox.jsp");
              }
                         
              st.close();
            }
            catch(Exception e)
            {
                response.sendRedirect("inbox.jsp");
                //out.println("Student Exception"+e);
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
