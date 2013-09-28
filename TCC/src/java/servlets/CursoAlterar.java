package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class CursoAlterar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    HttpSession session = request.getSession();
        
     if (session.isNew()){
        request.setAttribute("mensagem", "");
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
        view.forward(request, response);
     }
     else{
            
        String codCurso = request.getParameter("cod");
        CachedRowSetImpl crs;
        
        Curso c = new Curso();
        
        try{
            crs = new CachedRowSetImpl();
        }
        catch (Exception e){
            
        }
        
        session.setAttribute("codCurso", codCurso);
        
        crs = c.buscarCurso(codCurso);
        
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("curso", crs);
        
        RequestDispatcher view = request.getRequestDispatcher("audio/alterarCurso.jsp");
        
        view.forward(request, response);

    }
    }
}
