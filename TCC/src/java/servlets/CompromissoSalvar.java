package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CompromissoSalvar extends HttpServlet {
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String dia = request.getParameter("dia");
            String mes = request.getParameter("mes");
            String ano = request.getParameter("ano");
            String hora = request.getParameter("hora");
            String min = request.getParameter("min");
            String descricao = request.getParameter("descricao");
            String aviso = request.getParameter("aviso");
            
            Compromisso com = new Compromisso();
            
            boolean d = com.validarDados(dia, mes, ano, descricao, hora, min);
            
            if(d){
                com.salvarDados(descricao, dia, mes, ano, hora, min, aviso);
                
                RequestDispatcher view = request.getRequestDispatcher("audio/compromissoCadastrado.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/compromissoDadosInvalidos.jsp");
                
                view.forward(request, response);
            }
        }
    }
}
