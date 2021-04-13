
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Sign UP</title>
</head>

<script>
function validate()
{
    var fullname = document.form.fn.value;
    var username = document.form.un.value;
    var password = document.form.up.value;
    var conpassword= document.form.cp.value;

    if (fullname==null || fullname=="")
    {
        alert("Full Name can't be blank");
        return false;
    }

    else if (username==null || username=="")
    {
        alert("Username can't be blank");
        return false;
    }
    else if(password.length<6)
    {
        alert("Password must be at least 6 characters long.");
        return false;
    }
    else if (password!=conpassword)
    {
        alert("Confirm Password should match with the Password");
        return false;
    }
}
</script>


</head>
<body>
<h2 align="center">Products Management-USER Registration</h2>
<form name="form" action="signUp-servlet" method="post" onsubmit="return validate()">
<table align="center">
    <tr>
        <td>Full Name</td>
        <td><input type="text" name="fn" /></td>
    </tr>

    <tr>
        <td>Username</td>
        <td><input type="text" name="un" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="password" name="up" /></td>
    </tr>
    <tr>
        <td>Confirm Password</td>
        <td><input type="password" name="cp" /></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="submit" value="Register"></input></td>
    </tr>
</table>
</form>


</body>
</html>
