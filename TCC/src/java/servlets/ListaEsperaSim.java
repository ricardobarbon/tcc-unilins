package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ListaEsperaSim extends HttpServlet {
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String codInd = (String)session.getAttribute("codInd");
            
            Indisponibilidade ind = new Indisponibilidade();
            
            ind.entrarListaInteressados(codInd);
            
            ReservasProfessor rProf = new ReservasProfessor();
            
            rProf.doGet(request, response);
        }
    }
}
