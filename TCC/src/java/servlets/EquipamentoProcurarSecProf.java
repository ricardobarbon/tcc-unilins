package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class EquipamentoProcurarSecProf extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            String s = request.getParameter("procurarEquip");
            
            Equipamento eq = new Equipamento();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            crs = eq.buscarEquipamento(s);
            
            response.setContentType("text/html;charset=UTF-8");
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if (tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                if(crs.size()==0){
                   request.setAttribute("mensagem", "Nenhum Equipamento Encontrado com este Patrim�nio...");
                
                   RequestDispatcher view = request.getRequestDispatcher("secretaria/equipamentos.jsp");
                
                   view.forward(request, response);
               }
               else{
                   request.setAttribute("mensagem", "");
                   request.setAttribute("equipamentos", crs);
                
                   RequestDispatcher view = request.getRequestDispatcher("secretaria/equipamentos.jsp");
                
                   view.forward(request, response);
               }
            }
            else{
                if(crs.size()==0){
                   request.setAttribute("mensagem", "Nenhum Equipamento Encontrado com este Patrim�nio...");
                
                   RequestDispatcher view = request.getRequestDispatcher("professor/equipamentos.jsp");
                
                   view.forward(request, response);
               }
               else{
                   request.setAttribute("mensagem", "");
                   request.setAttribute("equipamentos", crs);
                
                   RequestDispatcher view = request.getRequestDispatcher("professor/equipamentos.jsp");
                
                   view.forward(request, response);
               }
            }
        }
    }
}