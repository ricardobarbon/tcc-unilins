package servlets;

import com.sun.rowset.CachedRowSetImpl;
import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CursoProcurar extends HttpServlet {
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
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
        
        if (crs.size() == 0){
            request.setAttribute("mensagem", "Nenhum Tipo Encontrado...");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/cursos.jsp");
            
            view.forward(request, response);
        }
        else{
            request.setAttribute("cursos", crs);
            
            request.setAttribute("mensagem","");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/cursos.jsp");
            
            view.forward(request, response);
        }
    }

}
