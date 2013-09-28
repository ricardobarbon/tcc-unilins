package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class EquipamentoManutencao extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            String c = request.getParameter("cod");
            CachedRowSetImpl crs;
            
            Equipamento eq = new Equipamento();
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch (Exception e){
                
            }
            
            crs = eq.buscarEquipamento(c);
            
            session.setAttribute("patrimonio", c);
            
            response.setContentType("text/html;charset=UTF-8");
            
            request.setAttribute("equipamento", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/equipamentoEmManutenção.jsp");
            
            view.forward(request, response);
            
        }
    }
}