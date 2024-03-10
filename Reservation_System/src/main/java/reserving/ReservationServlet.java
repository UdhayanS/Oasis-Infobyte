package reserving;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int guests = Integer.parseInt(request.getParameter("guests"));

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Connect to your MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unn", "root", "Udhayan_sk7");

            // Insert data into the database
            String sql = "INSERT INTO reservations (name, email, date, time, guests) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, date);
            stmt.setString(4, time);
            stmt.setInt(5, guests);
            stmt.executeUpdate();

            // Redirect to a success page or display a success message
            response.sendRedirect("success.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}