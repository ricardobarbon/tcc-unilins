package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CursoCadastrar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        RequestDispatcher view = request.getRequestDispatcher("audio/cadastrarCurso.jsp");
        
        view.forward(request, response);
    }
}
