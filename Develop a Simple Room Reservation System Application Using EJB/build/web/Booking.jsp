<%-- 
    Document   : Booking
    Created on : 15-Oct-2024, 10:11:58 am
    Author     : sahpr
--%>
<%@ page import="com.test.RoomManagement" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String cust=request.getParameter("txtCust");
            String mob=request.getParameter("txtMob");
            String RoomType=request.getParameter("txtType");
            RoomManagement r1=new RoomManagement();
            String msg=r1.Booking(RoomType, cust, mob);
            out.println("<h1>"+msg+"</h1>");
            %>
    </body>
</html>
