

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {
	
		Connection conn;
		Statement stmt;
		
	
	public void init() throws ServletException 
	{
	try
	{
		Class.forName("oracle.jdbc.driver.oracledriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin;@localhost:1521:XE","system","arvind");
		stmt=conn.createStatement();
			
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fn =request.getParameter("firstname");
		String ln =request.getParameter("lastname");
		String phn =request.getParameter("phone number");
		String usrn =request.getParameter("user name");
		String pass =request.getParameter("password");
		String cpass =request.getParameter("confirm password");
		
		try{
			int i= stmt.executeUpdate("insert into register values('"+fn+"','"+ln+"','"+phn+"','"+usrn+"','"+pass+"','"+cpass+"')");
			if(i!=0)
			{
				
			
		
			out.print("You are Successfully Registered");
		}
			else
		{
			
			out.print("You are not Successfully Registered");
		}
		
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}	
		
}
