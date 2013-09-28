package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class VerificaSenha extends HttpServlet {
        
    
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
            String senha = request.getParameter("senha");
            
            Usuario usuario = new Usuario();
            
            boolean d = usuario.validarSenha(idLogin, senha);
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("PROFESSOR")==0){
               if(d){
                   MeuUsuarioAlterarProf usuProf = new MeuUsuarioAlterarProf();
                
                   usuProf.doPost(request, response);
               }
               else{
                   request.setAttribute("mensagem", "Senha Inválida...");
                 
                   request.setAttribute("idLogin", idLogin);
                
                   RequestDispatcher view = request.getRequestDispatcher("professor/solicitaSenha.jsp");
                
                   view.forward(request, response);
               }
            }
            else if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                if(d){
                   UsuarioAlterar usu = new UsuarioAlterar();
                
                   usu.doPost(request, response);
               }
               else{
                   request.setAttribute("mensagem", "Senha Inválida...");
                 
                   request.setAttribute("idLogin", idLogin);
                
                   RequestDispatcher view = request.getRequestDispatcher("secretaria/solicitaSenha.jsp");
                
                   view.forward(request, response);
               }
            }
            else{
                if(d){
                   UsuarioAlterar usu = new UsuarioAlterar();
                
                   usu.doPost(request, response);
               }
               else{
                   request.setAttribute("mensagem", "Senha Inválida...");
                 
                   request.setAttribute("idLogin", idLogin);
                
                   RequestDispatcher view = request.getRequestDispatcher("audio/solicitaSenha.jsp");
                
                   view.forward(request, response);
               }
            }
        }
    }
}
