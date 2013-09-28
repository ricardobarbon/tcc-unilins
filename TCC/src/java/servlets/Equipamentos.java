package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class Equipamentos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            Equipamento eq = new Equipamento();
            CachedRowSetImpl crs;
        
            try{
               crs = new CachedRowSetImpl();
            }
            catch (Exception e){
            
            }
        
            crs = eq.buscarEquipamentos();
        
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("mensagem", "");
            request.setAttribute("equipamentos", crs);
        
            RequestDispatcher view = request.getRequestDispatcher("audio/equipamentos.jsp");
        
            view.forward(request, response);
        }

    }

 
}
