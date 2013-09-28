package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CursoExcluir extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            
            view.forward(request, response);
        }
        else{
            String c = request.getParameter("cod");
            
            session.setAttribute("cursoCod", c);
            
            response.setContentType("text/html;charset=UTF-8");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/excluirCurso.jsp");
            
            view.forward(request, response);
        }
        
    }

}
