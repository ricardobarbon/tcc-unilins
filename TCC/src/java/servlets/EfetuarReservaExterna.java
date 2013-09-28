package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EfetuarReservaExterna extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher view = request.getRequestDispatcher("audio/efetuarReservaExterna.jsp");
        
        view.forward(request, response);
    }
}
