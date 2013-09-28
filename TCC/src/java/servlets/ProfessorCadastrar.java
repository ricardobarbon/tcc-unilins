package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ProfessorCadastrar extends HttpServlet {
            
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            
            response.setContentType("text/html;charset=UTF-8");
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/cadastrarProfessor.jsp");
            
            view.forward(request, response);
        }
    }
}
