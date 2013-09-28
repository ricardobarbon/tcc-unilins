package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class InserirEquipamento extends HttpServlet {

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
        
            try{
                crs = new CachedRowSetImpl();
            }
            catch (Exception e){
            
            }
        
            crs = t.buscarTipos();
        
            response.setContentType("text/html;charset=UTF-8");
            
            request.setAttribute("tipos", crs);
        
            RequestDispatcher view = request.getRequestDispatcher("audio/cadastrarEquipamento.jsp");
        
            view.forward(request, response);
        }
    }
}
