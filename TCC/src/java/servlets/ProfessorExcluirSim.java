package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ProfessorExcluirSim extends HttpServlet {
        
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
            
            Professor prof = new Professor();
            
            prof.excluirProfessor(id);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/ProfessorExcluido.jsp");
            
            view.forward(request, response);
        }
    }
}
