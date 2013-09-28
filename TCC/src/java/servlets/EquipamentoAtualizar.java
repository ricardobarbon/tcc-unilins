package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EquipamentoAtualizar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            String codEquipamento = (String)session.getAttribute("codEquipamento");
            String codTipo = request.getParameter("tipo");
            String marca = request.getParameter("marca");
            String situacao = request.getParameter("situacao");
            
            Equipamento eq = new Equipamento();
            
            boolean d = eq.verificarDados(codEquipamento, codTipo, marca, situacao);
            
            response.setContentType("text/html;charset=UTF-8");
            
            if(d == true){
                eq.atualizarDados(codEquipamento, codTipo, marca, situacao);
                
                RequestDispatcher view = request.getRequestDispatcher("audio/equipamentoAlterado.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/equipamentoAlterarDadosInvalidos.jsp");
                
                view.forward(request, response);
            }
            
        }
    }
}
