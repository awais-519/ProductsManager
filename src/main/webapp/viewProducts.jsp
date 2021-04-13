<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import= "java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.example.ProductsManager.DatabaseConnection" %>



<!DOCTYPE html>
<html>
<head>
<title>Categories</title>
</head>

<body>

<%
    Connection con = DatabaseConnection.initializeDatabase();
    Statement st = con.createStatement();
    int cid = Integer.parseInt(request.getParameter("cId"));
    String query = "Select * From Products where Cid="+cid;
    ResultSet rs = st.executeQuery(query);

%>
<div align="center">
    <h1><%= "-Products Management-" %>
    </h1>

    <h1>Products</h1>

        <table border="5">
            <tr>
                <td>Ids</td>
                <td>Category Id</td>
                <td>Category</td>
                <td>Name</td>
                <td>Description</td>
            </tr>
            <%while(rs.next())
            {

            %>
            <tr>
                <td>
                <%=rs.getInt("id")%>
                </td>
                <td>
                    <%=rs.getInt("Cid")%>
                </td>
                <td>
                    <%=request.getParameter("cName")%>
                </td>
                <td>
                <%=rs.getString("Name")%>
                </td>
                <td>
                <%=rs.getString("Description")%>
                </td>

            </tr>
            <%}%>

        </table>
    <br>




</div>
</body>
</html>