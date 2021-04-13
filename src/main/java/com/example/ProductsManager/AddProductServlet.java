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


@WebServlet(name = "addProductServlet", value = "/addProduct-servlet")
public class AddProductServlet extends HttpServlet {
private String message;


public void init() {
message = "Products Management Servlet!";
}
public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {
    String a=request.getParameter("pName");
    String b=request.getParameter("cId");
int bb=Integer.parseInt(b);
    String c=request.getParameter("desc");

    if(addProduct(a,bb,c))
    {
        out.println("YOUR PRODUCT's SUCCESSFULLY ADDED.");
        request.getRequestDispatcher("/home.jsp").include(request,response);
    }

    else{
        out.println("YOUR PRODUCT's ADDITION FAILED. PLEASE TRY AGAIN.");
        request.getRequestDispatcher("/home.jsp").include(request,response);

    }


}
catch(Exception e)
{
    out.print(e);
}

}


public static boolean addProduct(String a,int b,String c)
{
    boolean status=false;
try{
    Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement ps = con.prepareStatement(
                "insert into Products(Name, Cid, Description) values (?,?,?)");
        ps.setString(1, a);
        ps.setInt(2, b);
        ps.setString(3, c);

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