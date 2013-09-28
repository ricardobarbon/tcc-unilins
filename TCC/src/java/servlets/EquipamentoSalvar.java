package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class EquipamentoSalvar extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            String p = request.getParameter("patrimonio");
            String t = request.getParameter("tipo");
            String m = request.getParameter("marca");
            String s = request.getParameter("situacao");
        
            Equipamento eq = new Equipamento();
            
            CachedRowSetImpl crs;
        
            try{
                crs = new CachedRowSetImpl();
            }
            catch (Exception e){
            
            }
            
            boolean validos = eq.verificarDados(p, t, m, s);
            
            response.setContentType("text/html;charset=UTF-8");
            
            if (validos == true){
               crs = eq.verificarPatrimonio(p);
               
               if(crs.size()==0){
                   eq.salvarDados(p, t, m, s);
                   
                   RequestDispatcher view = request.getRequestDispatcher("audio/equipamentoCadastrado.jsp");
                   
                   view.forward(request, response);
               }
               else{
                   request.setAttribute("equipamento", crs);
                   
                   try{ 
                      session.setAttribute("PatrimonioEquipamento", p);
                   }
                   catch(Exception e){
                       
                   }
                   RequestDispatcher view = request.getRequestDispatcher("audio/patrimonioJaCadastrado.jsp");
                   
                   view.forward(request, response);
               }
            }
            else{
                request.setAttribute("mensagem", "Dados Inválidos...");
                
                InserirEquipamento in = new InserirEquipamento();
                
                in.doPost(request, response);                               
            }
        }
    }
}
