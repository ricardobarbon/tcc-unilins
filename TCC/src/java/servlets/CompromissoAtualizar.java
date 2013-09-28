package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CompromissoAtualizar extends HttpServlet {
        
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
            
            String comCod = (String)session.getAttribute("comCod");
            
            Compromisso com = new Compromisso();
            
            boolean d = com.validarDados(dia, mes, ano, descricao, hora, min);
            
            if(d){
                com.atualizarDados(comCod, dia, mes, ano, descricao, hora, min, aviso);
                
                RequestDispatcher view = request.getRequestDispatcher("audio/compromissoAlterado.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/compromissoDadosInvalidos.jsp");
                
                view.forward(request, response);
            }
        }
    }
}
