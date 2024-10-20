/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
/**
 *
 * @author sahpr
 */
@WebServlet(urlPatterns = {"/Page1"})
public class Page1 extends HttpServlet {
    static int count=0,c2=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Page1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Page1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out=response.getWriter();
       String name=request.getParameter("t1");
       Cookie c1=new Cookie("count",String.valueOf(count));
       c2=Integer.parseInt(c1.getValue());
       if(c2==0)
       {
           out.println("Welcome = "+name);
           count++;
       }
       else
       {
           c1=new Cookie("count",String.valueOf(count));
           count++;
           out.println("Welcome= "+name + "You have visited the page" +count+ " times.");
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}



