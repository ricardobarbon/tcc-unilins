package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UsuarioAtualizar extends HttpServlet {
       
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
            
            String nome = request.getParameter("nome");
            String diaNasc = request.getParameter("dataNascDia");
            String mesNasc = request.getParameter("dataNascMes");
            String anoNasc = request.getParameter("dataNascAno");
            String emailUm = request.getParameter("email1");
            String emailDois = request.getParameter("email2");
            String usuarioTipo = request.getParameter("tipo");
            
            Usuario usuario = new Usuario();
            
            boolean d = usuario.validarDados(nome, diaNasc, mesNasc, anoNasc, emailUm, emailDois);
            
            String usuarioId = (String)session.getAttribute("usuarioId");
            
            if(d){
                usuario.atualizarDadosAdmin(usuarioId, nome, diaNasc, mesNasc, anoNasc, emailUm, usuarioTipo);
                
                RequestDispatcher view = request.getRequestDispatcher("audio/usuarioAlteradoAdmin.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/usuarioDadosInvalidosAdmin.jsp");
                
                view.forward(request, response);
            }
        }    
    }
}
