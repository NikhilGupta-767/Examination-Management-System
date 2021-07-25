import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentMenu extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String btnvalue=request.getParameter("btnvalue");
		
		if(btnvalue.equals("ExamReg")) {
			response.sendRedirect("ExamRegistration.html");
		} else if(btnvalue.equals("ExamRes")) {
			response.sendRedirect("ExamResult.html");
		} else if(btnvalue.equals("Acard")) {
			response.sendRedirect("AdmitCard.html");
		}
		
		out.close();
	}

}