package servlets;

import classes.Tipo;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SalvarTipo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
        Tipo t = new Tipo();
        String s = request.getParameter("tipo");
        
        boolean d = t.verificarDados(s);
        
        response.setContentType("text/html;charset=UTF-8");
        
        if (d == false){
            request.setAttribute("decisao", "Dados Inválidos");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/cadastrarTipo.jsp");
            
            view.forward(request, response);
        }
        else{
            RequestDispatcher view = request.getRequestDispatcher("audio/tipoCadastrado.jsp");
            
            view.forward(request, response);
        }
        
        }
    }
}