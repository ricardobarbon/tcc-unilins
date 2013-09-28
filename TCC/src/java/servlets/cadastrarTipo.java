package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class cadastrarTipo extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        RequestDispatcher view = request.getRequestDispatcher("audio/cadastrarTipo.jsp");
        
        view.forward(request, response);
        
    }
  
    
}
