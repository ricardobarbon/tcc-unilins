package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class SalaProcurarSecProf extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            
            String desc = (String)request.getParameter("procurarSala");
            
            Sala sala = new Sala();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = sala.buscarSalas(desc);
            
            response.setContentType("text/html;charset=UTF-8");
            
            request.setAttribute("salas", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/salas.jsp");
            
            view.forward(request, response);
        }
    }
}
