/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*; 
import java.net.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

/**
 *
 * @author Administrator
 */
@WebServlet(name = "NonBlockingServlet", urlPatterns = {"/NonBlockingServlet"})
public class NonBlockingServlet extends HttpServlet {

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
            out.println("<title>Servlet NonBlockingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NonBlockingServlet at " + request.getContextPath() + "</h1>");
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
    protected void service(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
response.setContentType("text/html;charset=UTF-8"); 
try (PrintWriter out = response.getWriter()) { 
out.println("<h1>FileReader</h1>"); 
String filename="/WEB-INF/priyanshu.txt"; 
ServletContext c=getServletContext(); 
InputStream in=c.getResourceAsStream(filename); 
String 
path="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ReadingNonBloclingServlet";       
URL url=new URL(path); 
HttpURLConnection conn=(HttpURLConnection)url.openConnection(); 
conn.setChunkedStreamingMode(2); 
conn.setDoOutput(true); 
conn.connect(); 
if(in!=null) 
{ 
InputStreamReader inr=new InputStreamReader(in); 
BufferedReader br = new BufferedReader(inr); 
String text=""; 
System.out.println("Reading started...."); 
BufferedWriter bw=new BufferedWriter(new 
OutputStreamWriter(conn.getOutputStream())); 
while((text=br.readLine())!=null){ 
out.print(text+"<br>");
try{ 
Thread.sleep(1000); 
out.flush(); 
} 
catch(InterruptedException ex){} 
}out.print("reading completed...."); 
bw.flush(); 
bw.close(); 
} 
} 
} 
} 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
