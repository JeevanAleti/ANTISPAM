
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Anti Spam</title>
</head>
<body bgcolor="pink">
<img src="E:\clg\IMG-20160304-WA0009.jpg" align="right" height="400" width="400">
<script>
<%
	try
	{
		StringBuffer param= new StringBuffer(request.getParameter("q"));
		String result="";
		for(int i=0;i<param.length();i++)
		{
			if(Character.isUpperCase(param.charAt(i))||
					Character.isLowerCase(param.charAt(i))||
					Character.isUpperCase(param.charAt(i)))
				result += param.charAt(i);
			else
				result += " ";				
		}
		result = result.replaceAll("  ", " ");
		result = result.replaceAll("  ", " ");
		result = result.replaceAll(" ", "---");
		if(result.startsWith("---"))
			result = result.substring(3);
		if(result.endsWith("---"))
			result = result.substring(0, result.length()-3);
		System.out.println(result);
			String [] parts = result.split("---");
			String SQL = "Select words from stopwords";
			SQL += " where ";
			System.out.println("Parts : ");
			for(String part:parts)
			{
				SQL += "words like '"+part+"' or ";
				System.out.println(part);
			}
			SQL = SQL.substring(0, SQL.lastIndexOf(" or "));
			System.out.println(SQL);
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/ANTISPAM","Jeevan Reddy","jeevan5005");
			PreparedStatement pstmt=con.prepareStatement(SQL);
			String checked="";
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				checked+= rs.getString(1)+" ";
			}
			if(checked.length()>0)
			{
				%>alert("Unable to submit Request! Words like <%=checked%> are not allowed in the comment!");<%
			}
			else
			{
				%>alert("Comment posted successfully!");<%
				
				System.out.println(param);
			}
			String id=(String)session.getAttribute("id");
			String sql=("insert into mrec.comment values(?,?)");
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con1 = DriverManager.getConnection("jdbc:db2://localhost:50000/antispam","Jeevan Reddy","jeevan5005");
			PreparedStatement ps1 = con1.prepareStatement(sql);
			ps1.setString(1, param.toString());
			ps1.setString(2, id);
			ps1.execute();
	}
	catch(Exception e){e.printStackTrace();}
%>
</script>
<form method="get" action="Comment.jsp">
<center>
<p>Post your Comment</p>
<textarea rows="4" name="q">

</textarea>
<br>
<br>&nbsp<input type="submit" value="Post">&nbsp&nbsp&nbsp&nbsp<input type="reset" value="reset"><br><br>

</center>
</form>
</body>
</html>