package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EquipamentoSalvarManutencao extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else{
            String pat = (String)session.getAttribute("patrimonio");
            String descMan = request.getParameter("descricaoManutencao");
            String sit = request.getParameter("situacao");
            String dia = request.getParameter("dia");
            String mes = request.getParameter("mes");
            String ano = request.getParameter("ano");
            
            Manutencao man = new Manutencao();
            Equipamento eq = new Equipamento();
            
            boolean d = man.validarDados(dia, mes, ano, descMan);
            
            response.setContentType("text/html;charset=UTF-8");
            
            if(d){
                man.salvarDados(pat, dia, mes, ano, descMan);
                eq.atualizarSituacao(pat, sit);
                
                RequestDispatcher view = request.getRequestDispatcher("audio/relatorioDeNegociacao.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/manutencaoDadosInvalidos.jsp");
                
                view.forward(request, response);
                                
            }
            
        }
    }
}
