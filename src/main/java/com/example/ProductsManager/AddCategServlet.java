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


@WebServlet(name = "addCategoryServlet", value = "/addCategory-servlet")
public class AddCategServlet extends HttpServlet {
private String message;


public void init() {
message = "Products Management Servlet!";
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {
    String a=request.getParameter("cName");
    String b=request.getParameter("cDetail");

    if(addCategory(a,b))
    {
        out.println("YOUR CATEGORY SUCCESSFULLY ADDED.");
        request.getRequestDispatcher("/home.jsp").include(request,response);
    }

    else{
        out.println("YOUR CATEGORY ADDITION FAILED. PLEASE TRY AGAIN.");
        request.getRequestDispatcher("/home.jsp").include(request,response);

    }


}
catch(Exception e)
{
    out.print(e);
}

}


public static boolean addCategory(String cName,String Detail)
{
    boolean status=false;
try{
    Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement ps = con.prepareStatement(
                "insert into Categories(Name, Description) values (?,?)");
        ps.setString(1, cName);
        ps.setString(2, Detail);

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