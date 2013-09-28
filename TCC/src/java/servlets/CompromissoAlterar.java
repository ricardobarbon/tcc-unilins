package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class CompromissoAlterar extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String comCod = request.getParameter("cod");
            
            Compromisso com = new Compromisso();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = com.buscarCompromissoAlterar(comCod);
            
            request.setAttribute("compromisso", crs);
            
            session.setAttribute("comCod", comCod);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/alterarCompromisso.jsp");
            
            view.forward(request, response);
        }
    }
}
