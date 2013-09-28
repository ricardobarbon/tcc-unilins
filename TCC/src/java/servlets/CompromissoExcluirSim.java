package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CompromissoExcluirSim extends HttpServlet {
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String comCod = (String)session.getAttribute("comCod");
            
            Compromisso com = new Compromisso();
            
            com.excluir(comCod);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/compromissoExcluido.jsp");
            
            view.forward(request, response);
        }
    }
}
