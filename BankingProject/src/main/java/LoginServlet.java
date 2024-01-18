import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import DAO.BankDAO;
import DAO.UserDAO;
import DTO.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw = response.getWriter();

        // URL to redirect to after successful login
        String welcomeURL = request.getContextPath() + "/Welcome.jsp";

        // Your existing code to check credentials and connect to the database
        BankDAO connectionDAO = new BankDAO();
        Connection con = null;

        try {
            con = connectionDAO.connect();

            String name = request.getParameter("Username");
            String pass = request.getParameter("password");

            // Check if name or pass is null
            if (name == null || pass == null || name.isEmpty() || pass.isEmpty()) {
                // Alert for empty
                pw.println("<script>alert('Username and password cannot be empty!'); window.location.href='Login.html';</script>");
            } else {
                // Create a UserDAO object
                UserDAO userDAO = new UserDAO(con);

                if (userDAO.validateUser(name, pass)) {
                    // If the user is validated, create a UserDTO object (replace this with your actual logic)
                    UserDTO userDTO = userDAO.getUserDetails(name, pass); // Replace with your actual method to fetch user details

                    // Set the user object in the session
                    request.getSession().setAttribute("user", userDTO);

                    // Redirect to welcome.jsp
                    response.sendRedirect(welcomeURL);
                } else {
                    // Display login failure messages
                    pw.println("<div style=\"color: red; font-size: 18px; font-weight: bold; background-color: #ffe6e6; padding: 10px; border: 1px solid #ff3333; height: 30px; width: 500px; text-align: center; margin: 0 auto; margin-top :10px;\">Login failed!</div>");
                    pw.println("<div style=\"color: green; font-size: 18px; font-weight: bold; background-color: #ffe6e6; padding: 10px; border: 1px solid #ff3333; height: 30px; width: 500px; text-align: center; margin: 0 auto; margin-top :10px;\">Try To Login Again: <a href=\"Login.html\"><input type=\"submit\" value=\"Login_in\"></a><br></div>");
                    pw.println("<div style=\"color: green; font-size: 18px; font-weight: bold; background-color: #ffe6e6; padding: 10px; border: 1px solid #ff3333; height: 30px; width: 500px; text-align: center; margin: 0 auto; margin-top :10px;\">New User Register Here: <a href=\"Sign_up.html\"><input type=\"submit\" value=\"Register\"></a><br></div>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Disconnect from the database
            connectionDAO.disconnect(con);
        }
    }
}
