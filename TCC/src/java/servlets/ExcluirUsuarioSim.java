package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ExcluirUsuarioSim extends HttpServlet {
        
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
            
            String usuarioId = (String)session.getAttribute("usuarioId");
            
            Usuario usuario = new Usuario();
            
            usuario.excluirUsuario(usuarioId);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/usuarioExcluido.jsp");
            
            view.forward(request, response);
        }
    }
}
