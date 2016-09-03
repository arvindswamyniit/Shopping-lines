

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	

public void init() throws ServletException 
{
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","arvind");
	stmt=conn.createStatement();
		
	}
catch(Exception e)
{
	e.printStackTrace();
}

}

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String usrn =request.getParameter("username");
		String pass =request.getParameter("password");
		
		try
		{
			rs= stmt.executeQuery("select password from register where username='"+usrn+"'");
					while(rs.next())
					{
						String pa=rs.getString("password");
						if(pass.equals(pa))
						{
							out.print("You are successfully Logged in");
						}
						else
						{
							out.print("You are not successfully Logged in");
						}
					}
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

}
