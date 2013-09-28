package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class UsuarioSalvar extends HttpServlet {
        
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
            
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String dia = request.getParameter("dataNascDia");
            String mes = request.getParameter("dataNascMes");
            String ano = request.getParameter("dataNascAno");
            String tipo = request.getParameter("tipo");
            String emailUm = request.getParameter("email1");
            String emailDois = request.getParameter("email2");
            String senhaUm = request.getParameter("senha1");
            String senhaDois = request.getParameter("senha2");
            
            Usuario usuario = new Usuario();
            
            boolean d = usuario.validarDados(nome, dia, mes, ano, emailUm, emailDois);
            
            if((id.length()<3)||(tipo.length()<3)||(senhaUm.compareTo(senhaDois)!=0)){
                d = false;
            }
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = usuario.buscarUsuario(id);
            
            if(crs.size()>0){
                d=false;
            }
            if(d){
                usuario.salvarDados(id, nome, dia, mes, ano, tipo, emailUm, senhaUm);
                
                RequestDispatcher view = request.getRequestDispatcher("audio/usuarioCadastrado.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/usuarioDadosInvalidosAdmin.jsp");
                
                view.forward(request, response);
            }
        }
    }
}
