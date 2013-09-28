package servlets;

import com.sun.rowset.CachedRowSetImpl;
import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Cursos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        Curso t = new Curso();
        CachedRowSetImpl crs;
        
        try{
            crs = new CachedRowSetImpl();
        }
        catch (Exception e){
            
        }
        
        crs = t.buscarCursos();
        
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("cursos", crs);
        request.setAttribute("mensagem", "");
        
        RequestDispatcher view = request.getRequestDispatcher("audio/cursos.jsp");
        
        view.forward(request, response);
        
    }

}

