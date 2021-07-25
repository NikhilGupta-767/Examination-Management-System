import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterStd extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        String p=request.getParameter("formno");
        String q=request.getParameter("password");
        String r=request.getParameter("enrollno");

        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","tiger");
             String query =" insert into login_user values(?,?,?,?);";
             PreparedStatement ps=con.prepareStatement(query);
             ps.setString(1,n);
             ps.setString(2,p);
             ps.setString(3,q);
             ps.setString(4,r);

        int i=ps.executeUpdate();

        if(i>0)
        response.sendRedirect("adminmenu.html");

        }
        catch (Exception e2) 
        {
            System.out.println(e2);
        }
        out.close();
        }
    }