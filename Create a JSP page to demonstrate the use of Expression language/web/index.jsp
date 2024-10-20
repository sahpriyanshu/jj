<body> 
<h3>welcome to index page</h3> 
<% 
session.setAttribute("user","Admin"); 
%> 
<% 
Cookie ck=new Cookie("name","mycookie"); 
response.addCookie(ck); 
%> 
<!--<form action="ExpressionLanguage.jsp">--> 
<!--<form action="ELArithemeticOperator.jsp">--> 
<form action="ELLogicalOperator.jsp"> 
Enter Name:<input type="text" name="name" /><br/><br/> 
<input type="submit" value="Submit"/> 
</form> 
</body> 