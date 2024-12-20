import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet("/Main")
public class Main extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/client";
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "****";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        out.println("<html><head><style>");
        out.println("h2.error { color: red; text-align: center; }");
        out.println("h2.success { color: green; text-align: center; }");
        out.println("body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }");
        out.println("</style></head><body>");
        
        if ((username == null || username.isEmpty()) && (password == null || password.isEmpty()))
        {
            out.println("<h2 class='error'>Error: Username and Password are required.</h2>");
        }
        else if (username == null || username.isEmpty())
        {
            out.println("<h2 class='error'>Error: Username is required.</h2>");
        }
        else if (password == null || password.isEmpty())
        {
            out.println("<h2 class='error'>Error: Password is required.</h2>");
        }
        else
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                String query = "SELECT fname FROM client_info WHERE username=? AND password=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    String fname = rs.getString("fname");
                    out.println("<h2 class='success'>Hello " + fname + "! You have successfully logged in.</h2>");
                }
                else
                {
                    out.println("<h2 class='error'>Login failed!</h2>");
                    out.println("<h3>Username: <span style='color: red;'>" + username + "</span> and/or password: <span style='color: red;'>" + password + "</span> is incorrect.</h3>");
                }

                con.close();
            }
            catch (Exception e)
            {
                out.println("<h2 class='error'>Error: Unable to process your request.</h2>");
                e.printStackTrace(out);
            }
        }

        out.println("</body></html>");
    }
}
