package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class salaExcluirSim extends HttpServlet {


        

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            String codSala = (String)session.getAttribute("codSala");
            EquipamentoFixo equFixo = new EquipamentoFixo();
            Sala sala = new Sala();
            
            equFixo.excluirEquipamentosFixos(codSala);
            
            sala.excluirSala(codSala);
            
            response.setContentType("text/html;charset=UTF-8");
            
            Salas salas = new Salas();
            
            salas.doGet(request, response);
        }
        
    }
}
