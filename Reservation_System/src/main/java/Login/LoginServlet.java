package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out =response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unn","root","Udhayan_sk7");
			String n = request.getParameter("Username");
			String p = request.getParameter("Password");
			
			PreparedStatement ps = con.prepareStatement("select Username from login where Username=? and Password=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			out.println("faileed");
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("faileed");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

