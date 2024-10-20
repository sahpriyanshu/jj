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
import javax.servlet.http.HttpSession;

/**
 *
 * @author sahpr
 */
@WebServlet(urlPatterns = {"/Page1"})
public class Page1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("<html><head><title>Servlet Page1</title></head>");
HttpSession hs = request.getSession(true);
if(hs.isNew()){
out.println("<body bgcolor=yellow>");
String name = request.getParameter("txtName");
hs.setAttribute("uname", name);
hs.setAttribute("visit", "1");
out.println("<h1>Welcome First Time</h1>");
}
else{
out.println("<h1>Welcome Again</h1>");
int visit = Integer.parseInt((String)hs.getAttribute("visit"))+1;
out.println("<h1>You Visited "+visit+"Times</h1>");
hs.setAttribute("visit", ""+visit);
}
out.println("<h1>Your Session ID "+hs.getId()+"</h1>");
out.println("<h1>You Logged in at "+new java.util.Date(hs.getCreationTime())+"</h1>");
out.println("<h1><a href=Page2>Click for Page 2 </a></h1>");
out.println("<h1><a href=LogoutServlet>Click to Terminate Session </a></h1>");
out.println("</body>");
out.println("</html>");
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
