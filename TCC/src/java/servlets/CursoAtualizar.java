package servlets;
import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CursoAtualizar extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        
     if (session.isNew()){
            request.setAttribute("mensagem", "");
        
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
     }   
     else{
        int alterou = 0;
        PrintWriter out = response.getWriter();
        
        String desc = request.getParameter("curso");
        String cod = (String)session.getAttribute("codCurso");
        
        Curso c = new Curso();
         
        alterou = c.cursoAtualizar(cod, desc);
        
        response.setContentType("text/html;charset=UTF-8");
        
        if (alterou > 0){
            
            RequestDispatcher view = request.getRequestDispatcher("audio/cursoAlterado.jsp");
            
            view.forward(request, response);
        }
        else{
            out.println("não alterou"+ cod +"desc:"+ desc);
        }
    }
    }

}
