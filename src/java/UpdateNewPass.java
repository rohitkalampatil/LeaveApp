
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateNewPass")
public class UpdateNewPass extends HttpServlet {

    private static final long serialVersionUID = 1L;
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("username"); // Assuming the session attribute is "userId"

        if (userId != null) {
            String newPassword = request.getParameter("pwd1");

// Assuming the password parameter is "pwd1"
            PrintWriter out = response.getWriter();

            try {
                // Establish a database connection (replace these with your database details)
                String jdbcUrl = "jdbc:mysql://localhost:3306/studentapp";
                String dbUser = "root";
                String dbPassword = "root";

                Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

                // Update the password for the specific user ID
                String updateQuery = "UPDATE hod SET password = ? WHERE userid = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, newPassword);
                    preparedStatement.setString(2, userId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        // Password updated successfully
                        session.setAttribute("authcode", null);
                        session.setAttribute("sts", true);
                        response.sendRedirect("hodlogin.jsp");
                        out.println("Password updated successfully for user ID: " + userId);
                    } else {
                        // No rows affected, user ID not found
                        session.setAttribute("error", "Invalid Credentials");
                        response.sendRedirect("Verify.jsp");
                        // out.println("User ID not found: " + userId);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        } else {
            // User ID not found in the session
            response.sendRedirect("hodlogin.jsp"); // Redirect to the login page or handle it accordingly
        }
    }
}
