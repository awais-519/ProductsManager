<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Managing Products</title>
</head>
<body>
<h1 align="center"><%= "-Products Management-" %>
</h1>
<div class="container" align="center">
<h2>Add A PRODUCT</h2>
<br/>

<form name="pAdd" action="addProduct-servlet" method="get">
   <label>NAME: </label>
   <input type="text" name="pName" placeholder="PRODUCT's NAME.">
   <br>
   <label><%=request.getParameter("cId")%></label>
   <input type="hidden" name="cId" value="<%=request.getParameter("cId")%>">
   <label>DESCRIPTION: </label>
   <input type="text" name="desc" placeholder="DETAILS.">
   <br>
<input type="submit" value="Submit">



</form>
<br>

</div>

</body>
</html>