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
<h2>Add A CATEGORY</h2>
<br/>

<form name="cAdd" action="addCategory-servlet" method="post">
   <label>NAME: </label>
   <input type="text" name="cName" placeholder="Enter the Name of the Category.">
   <br>
   <label>DESCRIPTION: </label>
   <input type="text" name="cDetail" placeholder="Enter Some Details About the Category.">
   <br>
<input type="submit" value="Submit">



</form>
<br>

</div>

</body>
</html>