package servlets;


import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CursoSalvar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        Curso t = new Curso();
        String s = request.getParameter("curso");
        
        boolean d = t.verificarDados(s);
        
        response.setContentType("text/html;charset=UTF-8");
        
        if (d == false){
            request.setAttribute("decisao", "Dados Inválidos");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/cadastrarCurso.jsp");
            
            view.forward(request, response);
        }
        else{
            RequestDispatcher view = request.getRequestDispatcher("audio/cursoCadastrado.jsp");
            
            view.forward(request, response);
        }

    }
}
