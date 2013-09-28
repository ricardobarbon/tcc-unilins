package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class CursoProcurarSecProf extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
           Curso c = new Curso();
           CachedRowSetImpl crs;
        
           String s = request.getParameter("procurarCurso");
        
           try{
               crs = new CachedRowSetImpl();
           }
           catch (Exception e){
            
           }
        
           crs = c.procurarCurso(s);
        
           response.setContentType("text/html;charset=UTF-8");
        
           request.setAttribute("cursos", crs);
            
           request.setAttribute("mensagem","");
            
           RequestDispatcher view = request.getRequestDispatcher("secretaria/cursos.jsp");
            
           view.forward(request, response);
           
        }
    }
}
