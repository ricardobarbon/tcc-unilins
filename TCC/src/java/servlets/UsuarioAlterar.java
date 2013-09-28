package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class UsuarioAlterar extends HttpServlet {

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
            
            String idLogin = (String)session.getAttribute("idLogin");
            
            Usuario usuario = new Usuario();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = usuario.buscarUsuario(idLogin);
            
            try{
               crs.next();
               request.setAttribute("id", crs.getString(1));
               request.setAttribute("nome", crs.getString(2));
               request.setAttribute("diaNasc", crs.getString(3));
               request.setAttribute("mesNasc", crs.getString(4));
               request.setAttribute("anoNasc", crs.getString(5));
               request.setAttribute("emailUm", crs.getString(6));
               request.setAttribute("emailDois", crs.getString(6));
               request.setAttribute("usuarioTipo", crs.getString(7));
            }
            catch(Exception e){
                
            }
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
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
