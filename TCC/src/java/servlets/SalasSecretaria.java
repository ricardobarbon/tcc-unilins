package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class SalasSecretaria extends HttpServlet {

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
            
            Tipo t = new Tipo();
            Sala s = new Sala();
            
            CachedRowSetImpl crs, crst;
            
            try{
                crs = new CachedRowSetImpl();
                crst = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = s.buscarSalas();
            crst = t.buscarTipos();
            
            session.setAttribute("tipos", crst);
            
            response.setContentType("text/html;charset=UTF-8");
            
            request.setAttribute("salas", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/salas.jsp");
            
            view.forward(request, response);
        }
    }
}
