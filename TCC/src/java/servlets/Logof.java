package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Logof extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
        view.forward(request, response);
        
        session.invalidate();
    }
}
