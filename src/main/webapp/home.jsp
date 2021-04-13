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
    String query = "Select * From Categories";
    ResultSet rs = st.executeQuery(query);

%>
<div align="center">
    <h1><%= "-Products Management-" %>
    </h1>

    <h1>Categories</h1>

        <table border="5">
            <tr>
                <td>Ids</td>
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
                <%=rs.getString("Name")%>
                </td>
                <td>
                <%=rs.getString("Description")%>
                </td>
                <td>
                    <a href="viewProducts.jsp?cId=<%=rs.getInt("id")%>?cName=<%=rs.getString("Name")%>" >View Products</a>

                </td>

                <td>
                    <a href="addProduct.jsp?cId=<%=rs.getInt("id")%>" >Add a Product</a>
                </td>
            </tr>
            <%}%>

        </table>
    <br>
        <a href="./addCateg.jsp"><button>Add A Category</button></a>



</div>
</body>
</html>