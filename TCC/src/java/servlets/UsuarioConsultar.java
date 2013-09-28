package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class UsuarioConsultar extends HttpServlet {

        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String cod = request.getParameter("cod");
            
            Usuario usuario = new Usuario();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = usuario.buscarUsuario(cod);
            
            session.setAttribute("usuarioId", cod);
            
            request.setAttribute("usuario", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/usuarioConsultar.jsp");
            
            view.forward(request, response);
        }
    }
}
