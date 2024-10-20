<%@page contentType="text/html" import="java.sql.*"%> 
<html><body> 
<h1>Registration JSP Page</h1> 
<% 
String username=request.getParameter("txtName"); 
String password=request.getParameter("txtPass"); 
ResultSet rs=null; 
try{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fourB","root","robust"); 
Statement stmt=con.createStatement(); 
rs=stmt.executeQuery("select password from users where username='"+username+"'"); 
rs.next(); 
if(password.equals(rs.getString(1))) 
{ 
out.println("<h1>~~~LOGIN SUCCESSFULLL~~~</h1>"); 
} 
else 
{ 
out.println("<h1>password  does not match!!!!!</h1>"); 
%> 
<jsp:include page="Login.jsp"></jsp:include> 
<% 
} 
}catch(Exception e){ 
out.println("<h1>User does not exist!!!!!</h1>"); 
%> 
<jsp:include page="Login.html"></jsp:include> 
<% 
} 
%> 
</body> 
</html>