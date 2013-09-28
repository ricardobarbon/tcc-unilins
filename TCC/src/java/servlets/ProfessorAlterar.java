package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ProfessorAlterar extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            String id = (String)request.getParameter("id");
            
            session.setAttribute("idProfessor", id);
            
            Professor prof = new Professor();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = prof.buscarProfessor(id);
            
            response.setContentType("text/html;charset=UTF-8");
            
            request.setAttribute("professor", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/alterarProfessor.jsp");
            
            view.forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            String id = (String)session.getAttribute("idProfessor");
            
            Professor prof = new Professor();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = prof.buscarProfessor(id);
            
            response.setContentType("text/html;charset=UTF-8");
                        
            request.setAttribute("professor", crs);
            
            session.setAttribute("professor", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("secretaria/alterarProfessor.jsp");
            
            view.forward(request, response);
        }
    }
}
