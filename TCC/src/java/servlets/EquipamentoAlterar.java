package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class EquipamentoAlterar extends HttpServlet {

        
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
            CachedRowSetImpl crs, crs2;
            
            Equipamento eq = new Equipamento();
            Tipo t = new Tipo();
            
            try{
                crs = new CachedRowSetImpl();
                crs2 = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            response.setContentType("text/html;charset=UTF-8");
            
            crs = eq.buscarEquipamento(c);
            crs2 = t.buscarTipos();
            
            session.setAttribute("codEquipamento", c);
            
            request.setAttribute("mensagem", null);
            request.setAttribute("tipos", crs2);
            request.setAttribute("equipamento", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/alterarEquipamento.jsp");
            
            view.forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            String c = (String)session.getAttribute("PatrimonioEquipamento");
            CachedRowSetImpl crs, crs2;
            
            Equipamento eq = new Equipamento();
            Tipo t = new Tipo();
            
            try{
                crs = new CachedRowSetImpl();
                crs2 = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            response.setContentType("text/html;charset=UTF-8");
            
            crs = eq.buscarEquipamento(c);
            crs2 = t.buscarTipos();
            
            session.setAttribute("codEquipamento", c);
            
            request.setAttribute("mensagem", null);
            request.setAttribute("tipos", crs2);
            request.setAttribute("equipamento", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("audio/alterarEquipamento.jsp");
            
            view.forward(request, response);
        }
    }
}
