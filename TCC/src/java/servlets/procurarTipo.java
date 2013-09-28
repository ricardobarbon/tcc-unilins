package servlets;

import com.sun.rowset.CachedRowSetImpl;
import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class procurarTipo extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
        Tipo t = new Tipo();
        CachedRowSetImpl crs;
        
        String s = request.getParameter("procurarTipos");
        
        try{
            crs = new CachedRowSetImpl();
        }
        catch (Exception e){
            
        }
        
        crs = t.procurarTipo(s);
        
        response.setContentType("text/html;charset=UTF-8");
        
        if (crs.size() == 0){
            request.setAttribute("mensagem", "Nenhum Tipo Encontrado...");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/tipos.jsp");
            
            view.forward(request, response);
        }
        else{
            request.setAttribute("tipos", crs);
            
            request.setAttribute("mensagem","");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/tipos.jsp");
            
            view.forward(request, response);
        }
        }
    }

}
