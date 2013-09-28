package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class Usuarios extends HttpServlet {

        
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
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("AUDIOVISUAL")==0){
                ReservasProfessores rProfs = new ReservasProfessores();
                
                rProfs.doGet(request, response);
            }
            
            Usuario usuario = new Usuario();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = usuario.buscarUsuarios();
            
            request.setAttribute("usuarios", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/usuarios.jsp");
            
            view.forward(request, response);
        }
    }
}
