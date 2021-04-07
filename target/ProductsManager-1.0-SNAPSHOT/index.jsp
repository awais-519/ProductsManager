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
<h2>User Login</h2>
<br/>

   <form action="hello-servlet" method="post">
       <label>Username: </label>
       <input type="text" name="un" placeholder="Enter Your USERNAME">
       <br>
       <label>Password: </label>
       <input type="text" name="up" placeholder="Enter Your PASSWORD">
       <br>
    <input type="submit" value="login">

       <a href="signUp.jsp">  Register</a>

   </form>
<br>
    <a href="hello-servlet">Hello Servlet</a>
</div>

</body>
</html>