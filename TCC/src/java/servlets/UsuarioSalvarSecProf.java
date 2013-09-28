package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class UsuarioSalvarSecProf extends HttpServlet {
        
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
            
            Usuario usuario = new Usuario();
            
            boolean d = usuario.validarDados(nome, diaNasc, mesNasc, anoNasc, emailUm, emailDois);
            
            String id = (String)session.getAttribute("idLogin");
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            if(d){
                usuario.atualizarDados(id, nome, diaNasc, mesNasc, anoNasc, emailUm);
                if(tipoUsuario.compareToIgnoreCase("Secretaria")==0){
                    RequestDispatcher view = request.getRequestDispatcher("secretaria/usuarioAlterado.jsp");
                
                    view.forward(request, response);
                }
                else{
                    RequestDispatcher view = request.getRequestDispatcher("audio/usuarioAlterado.jsp");
                
                    view.forward(request, response);
                }
            }
            else{
                
                request.setAttribute("id", id);
                request.setAttribute("nome", nome);
                request.setAttribute("diaNasc", diaNasc);
                request.setAttribute("mesNasc", mesNasc);
                request.setAttribute("anoNasc", anoNasc);
                request.setAttribute("emailUm", emailUm);
                request.setAttribute("emailDois", emailDois);
                request.setAttribute("mensagem", "Dados Inválidos...");
                if(tipoUsuario.compareToIgnoreCase("Secretaria")==0){
                    RequestDispatcher view = request.getRequestDispatcher("secretaria/alterarMeuUsuario.jsp");
                
                    view.forward(request, response);
                }
                else{
                    RequestDispatcher view = request.getRequestDispatcher("audio/alterarUsuario.jsp");
                
                    view.forward(request, response);
                }
            }
        }
    }
}
