package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ProfessorExcluir extends HttpServlet {
    
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
            
            String id = (String)session.getAttribute("idProfessor");
            
            session.setAttribute("idProfessor", id);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/excluirProfessor.jsp");
            
            view.forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String id = (String)request.getParameter("id");
            
            session.setAttribute("idProfessor", id);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/excluirProfessor.jsp");
            
            view.forward(request, response);
        }
    }
}
