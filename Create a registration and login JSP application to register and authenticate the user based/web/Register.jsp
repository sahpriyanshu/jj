<%@page contentType="text/html" import="java.sql.*"%> 
<html><body> 
<h1>Registration JSP Page</h1> 
<% 
String username=request.getParameter("txtName"); 
String password = request.getParameter("txtPass1"); 
String confirmpassword = request.getParameter("txtPass2"); 
String email = request.getParameter("txtEmail"); 
String country = request.getParameter("txtCon"); 
if(password.equals(confirmpassword)){ 
try{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fourB","root","robust"); 
PreparedStatement stmt = con.prepareStatement("insert into users values (?,?,?,?,?)"); 
stmt.setString(1, username);    stmt.setString(2, password); stmt.setString(3, confirmpassword); 
stmt.setString(4, email);    stmt.setString(5, country);  
int row = stmt.executeUpdate(); 
if(row==1) { out.println("Registration Successful"); } 
else {     
out.println("Registration FFFFFAAAIIILLLL !!!!"); 
%><jsp:include page="index.html" ></jsp:include> 
<%  
} 
}catch(Exception e){out.println(e);} 
} 
else  
{ 
out.println("<h1>Password Mismatch</h1>"); 
  %> 
<jsp:include page="index.html" ></jsp:include> 
<%  } 
    %> 
</body> 
</html> 