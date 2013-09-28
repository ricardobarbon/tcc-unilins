package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class CompromissoBuscar extends HttpServlet {
        
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
            
            Compromisso com = new Compromisso();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            String desc = request.getParameter("descProcurar");
            
            crs = com.buscarCompromisso(desc);
            
            request.setAttribute("compromissos", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/agenda.jsp");
            
            view.forward(request, response);
        }
    }
}
