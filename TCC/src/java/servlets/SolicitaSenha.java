package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SolicitaSenha extends HttpServlet {

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
            
            String idLogin = (String)session.getAttribute("idLogin");
            
            request.setAttribute("idLogin", idLogin);
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("Professor")==0){
                RequestDispatcher view = request.getRequestDispatcher("professor/solicitaSenha.jsp");
            
                view.forward(request, response);
            }
            else if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                RequestDispatcher view = request.getRequestDispatcher("secretaria/solicitaSenha.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/solicitaSenha.jsp");
                
                view.forward(request, response);
            }
        }
    }
}
