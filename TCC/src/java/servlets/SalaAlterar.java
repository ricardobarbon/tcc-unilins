package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class SalaAlterar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            String codSala = request.getParameter("cod");
            Sala sala = new Sala();
            EquipamentoFixo equFixo = new EquipamentoFixo();
            
            String salaDescricao = sala.buscarSalaDescricao(codSala);
            
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            crs = equFixo.buscarTipoDesc(codSala);
            
            if (crs.size()!=0){
                request.setAttribute("equFixo", crs);
            }
            session.setAttribute("codSala", codSala);
            
            request.setAttribute("salaDescricao", salaDescricao);
            
            response.setContentType("text/html;charset=UTF-8");
            
            RequestDispatcher view = request.getRequestDispatcher("audio/alterarSala.jsp");
            
            view.forward(request, response);
        }
    }
}
