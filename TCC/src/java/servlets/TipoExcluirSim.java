package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class TipoExcluirSim extends HttpServlet {

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
            
            String cod = (String)session.getAttribute("tipoCod");
            
            Tipo t = new Tipo();
            
            int c = t.tipoExcluir(cod);
            
            if (c>0){
                Tipos ts = new Tipos();
                
                ts.doGet(request, response);
            }
            else{
                PrintWriter out = response.getWriter();
                
                out.println("nao excluiu");
            }
        }
        
    }

}
