package com.example.ProductsManager;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.example.ProductsManager.DatabaseConnection;

import javax.xml.crypto.Data;


import java.sql.SQLException;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
private String message;


public void init() {
message = "Products Management Servlet!";
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException {

try {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

    String n=request.getParameter("un");
    String p=request.getParameter("up");
    if(validate(n,p))
    {
        out.println("LOGIN-SUCCESSFULL.");
        RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
        rd.include(request,response);

    }
    else
    {
        out.println("LOGIN FAILED!!! WRONG USERNAME OR PASSWORD.");
        RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
        rd.include(request,response);

    }



out.println("</body></html>");
}
catch (Exception e){
    e.printStackTrace();
}
}

public static boolean validate(String name,String pass){
boolean status=false;
try{
    Connection con = DatabaseConnection.initializeDatabase();

    PreparedStatement ps=con.prepareStatement(
            "select * from User where UserName=? and Password=?");
    ps.setString(1,name);
    ps.setString(2,pass);
    ResultSet rs=ps.executeQuery();
    status = rs.next();

}
catch(Exception e){
    System.out.println(e);
}

return status;
}



public void destroy() {
}
}