package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ProfessorProcurar extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String professor = (String)request.getParameter("procurarProf");
            
            Professor prof = new Professor();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = prof.procurarProfessor(professor);
            
            request.setAttribute("professores", crs);
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("SECRETARIA")==0){
               RequestDispatcher view = request.getRequestDispatcher("secretaria/professores.jsp");
            
               view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/professores.jsp");
            
                view.forward(request, response);
            }
        }
    }
}
