package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CursoExcluirSim extends HttpServlet {
    


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        }
        else{
            String cod = (String)session.getAttribute("cursoCod");
            
            Curso c = new Curso();
                        
            response.setContentType("text/html;charset=UTF-8");
            
            int cont = c.cursoExcluir(cod);
            
            if(cont>0){
                Cursos s = new Cursos();
                
                s.doGet(request, response);
            }
            else{
                PrintWriter out = response.getWriter();
                
                out.println("Nao excluiu");
            }
        }
        
    }

}
