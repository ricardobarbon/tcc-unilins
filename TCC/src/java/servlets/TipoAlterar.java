package servlets;

import com.sun.rowset.CachedRowSetImpl;
import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class TipoAlterar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
     if (session.isNew()){
        request.setAttribute("mensagem", "");
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
        view.forward(request, response);
     }
     else{
            
        String codTipo = request.getParameter("cod");
        CachedRowSetImpl crs;
        
        Tipo t = new Tipo();
        
        try{
            crs = new CachedRowSetImpl();
        }
        catch (Exception e){
            
        }
        
        session.setAttribute("codTipo", codTipo);
        
        crs = t.buscarTipo(codTipo);
        
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("tipo", crs);
        
        RequestDispatcher view = request.getRequestDispatcher("audio/alterarTipo.jsp");
        
        view.forward(request, response);

    }
    }
}
