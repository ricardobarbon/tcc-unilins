package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ProfessorConsultar extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            Professor prof = new Professor();
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            String id = (String)request.getParameter("id");
            
            if(id!=null){
                crs = prof.buscarProfessor(id);
                
                session.setAttribute("professor", crs);
                
                session.setAttribute("idProfessor", id);
                
                String tipoUsuario = (String)session.getAttribute("tipoUsuario");
                
                if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
                
                    RequestDispatcher view = request.getRequestDispatcher("secretaria/consultarProfessor.jsp");
                
                    view.forward(request, response);
                }
                else{
                    RequestDispatcher view = request.getRequestDispatcher("audio/professor.jsp");
                
                    view.forward(request, response);
                }
            }
        }
    }
}
