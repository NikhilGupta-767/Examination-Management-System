import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminMenu extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String btnvalue=request.getParameter("btnvalue");
		
		if(btnvalue.equals("StdDel")) {
			try
			{
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","tiger");
				 String query1 ="select * from student_details";
			     PreparedStatement ps = con.prepareStatement(query1);
			     ResultSet rs = ps.executeQuery();
			     
			     out.println("<table border=1 align='center' >");
	             out.println("<caption><h2>Student Details</h2></caption>");

	             out.println("<tr style='background-color:#ffffb3; color:red'>");
	             out.println("<th>formno</th>");
	             out.println("<th>name</th>");
	             out.println("<th>enroll</th>");
	             out.println("<th>email</th>");
	             out.println("<th>course</th>");
	             out.println("<th>phoneno</th>");
	             out.println("<th>semester</th>");
	             out.println("<th>SGPA</th>");
	             out.println("</tr>");
	             while(rs.next())
	             {
	                  int formno  = rs.getInt("formno");
	                  String name = rs.getString("name");
	                  String enroll = rs.getString("enroll");
	                  String email = rs.getString("email");
	                  String course = rs.getString("course");
	                  int phoneno = rs.getInt("Phoneno");
	                  int semester = rs.getInt("semester");
	                  float SGPA = rs.getFloat("SGPA");
	                  
	                  out.println("<tr style='background-color:#b3ffd9;'>");
	                  out.println("<td>" + formno + "</td>");
	                  out.println("<td>" + name + "</td>");
	                  out.println("<td>" + enroll + "</td>");
	                  out.println("<td>" + email + "</td>");
	                  out.println("<td>" + course + "</td>");
	                  out.println("<td>" + phoneno + "</td>");
	                  out.println("<td>" + semester + "</td>");
	                  out.println("<td>" + SGPA + "</td>");
	                  out.println("</tr>");

	             }
	             out.println("</table>");
	             out.println("</bod;=y></html>");

	             rs.close();
			}
	             
			catch (Exception e2) 
			{
				System.out.println(e2);
			}
			
			out.close();
		} 
		
		else if(btnvalue.equals("EditStdDel")) {
			response.sendRedirect("EditStudentDetails.html");
		} 
		
		else if(btnvalue.equals("SubMarks")) {
			response.sendRedirect("SubmitMarks.html");
		}
		
		else if(btnvalue.equals("RegStd")) {
			response.sendRedirect("RegisterStd.html");
		}
		
		else if(btnvalue.equals("DetStd")) {
			response.sendRedirect("DeleteStd.html");
		}
	
	}

}