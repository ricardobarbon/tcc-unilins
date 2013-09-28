package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class EquipamentosSecProf extends HttpServlet {
    
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
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                RequestDispatcher view = request.getRequestDispatcher("secretaria/equipamentos.jsp");
        
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("professor/equipamentos.jsp");
                
                view.forward(request, response);
            }
            
        }
    }
}
