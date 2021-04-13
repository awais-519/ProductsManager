package com.example.ProductsManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet(name = "signUpServlet", value = "/signUp-servlet")
public class SignUpServlet extends HttpServlet {
private String message;


public void init() {
message = "Products Management Servlet!";
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {
    String n=request.getParameter("un");
    String p=request.getParameter("up");
    String fn=request.getParameter("fn");

    Connection con = DatabaseConnection.initializeDatabase();
    PreparedStatement check=con.prepareStatement(
            "select * from User where UserName=?");
    check.setString(1,n);
    ResultSet ch = check.executeQuery();
    if(ch==null) {

        //IF USERNAME DOES NOT EXIST ALREADY
        if (register(fn, n, p)) {
            out.println("REGISTERATION SUCCESSFULL!!YOU CAN LOGIN NOW");
            request.getRequestDispatcher("/index.jsp").include(request, response);
        } else {

            out.println("SORRY. SIGN UP FAILED!TRY AGAIN.");
            request.getRequestDispatcher("./signUp.jsp").include(request, response);
        }
    }
    else
    {
        out.println("SORRY. USERNAME ALREADY EXISTS.");
        request.getRequestDispatcher("./signUp.jsp").include(request, response);
    }
}
catch(Exception e)
{
    out.print(e);
}

}


public static boolean register(String fullName,String username,String pass)
{
boolean status=false;
try{
    Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement ps = con.prepareStatement(
                "insert into User(FullName,UserName,Password) values (?,?,?)");
        ps.setString(1, fullName);
        ps.setString(2, username);
        ps.setString(3, pass);
        int i = ps.executeUpdate();
        if (i != 0) {
            status = true;

        }

}
catch(Exception e){
    System.out.println(e);
}

return status;
}



}