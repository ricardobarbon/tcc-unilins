package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SalvarNovaSenha extends HttpServlet {
        
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
            String senhaAtual = request.getParameter("senhaAtual");
            String novaSenha = request.getParameter("novaSenha");
            String confirmaNovaSenha = request.getParameter("confirmaNovaSenha");
            
            Usuario usuario = new Usuario();
            
            String idLogin = (String)session.getAttribute("idLogin");
            
            boolean d = usuario.validarNovaSenha(idLogin, senhaAtual, novaSenha, confirmaNovaSenha);
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(d){
                usuario.atualizarSenha(idLogin, novaSenha);
                if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                     RequestDispatcher view = request.getRequestDispatcher("secretaria/senhaAlterada.jsp");
                
                     view.forward(request, response);
                }
                else{
                    RequestDispatcher view = request.getRequestDispatcher("audio/senhaAlterada.jsp");
                
                    view.forward(request, response);
                }
            }
            else{
                request.setAttribute("mensagem", "Dados Inválidos...");
                if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                    RequestDispatcher view = request.getRequestDispatcher("secretaria/alterarSenha.jsp");
                
                    view.forward(request, response);
                }
                else{
                    RequestDispatcher view = request.getRequestDispatcher("audio/alterarSenha.jsp");
                
                    view.forward(request, response);
                }
            }
        }
    }
}
