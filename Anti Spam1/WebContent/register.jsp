<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="lightblue">
<center>

 <form action="RegisterServlet" method="post">
 <table border="1">
 <tr>
<td>Name:</td>
<td><input pattern="[^ @]+[a-zA-Z]+" type="text" name="name"></td> 
 </tr>
 
 <tr>
<td>Userid:</td> 
<td><input type="text" name="id"></td> 
 </tr>
 
 <tr>
<td>Password:</td> 
<td><input type="password" name="pass"></td> 
 </tr>
 
 <tr>
<td>DateofBirth:</td> 
<td><input type="text" name="dob"></td> 
 </tr>
 
 <tr>

<td>Email:</td> 
<td><input type="email" name="emailid"></td> 
 </tr>
 
 <tr>
<td>Mobileno:</td> 
<td><input pattern="[0-9]+" type="text" name="mobile"></td> 
 </tr>
 
 <tr>
<td>City:</td> 
<td><input type="text" name="city"></td> 
 </tr>
 
 <tr align="center">
<td><input type=reset value="reset"></td>
<td><input type="submit" value="Register"></td> 
 </tr>
 
 </table>
 </form>
</center>
</body> 
</html>