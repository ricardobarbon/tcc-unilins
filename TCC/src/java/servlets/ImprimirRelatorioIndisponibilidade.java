package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ImprimirRelatorioIndisponibilidade extends HttpServlet {
        
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
            
            String diaInicio = request.getParameter("diaInicio");
            String mesInicio = request.getParameter("mesInicio");
            String anoInicio = request.getParameter("anoInicio");
            String diaFim = request.getParameter("diaFim");
            String mesFim = request.getParameter("mesFim");
            String anoFim = request.getParameter("anoFim");
            String semPeriodo = request.getParameter("semPeriodo");
            
            Indisponibilidade ind = new Indisponibilidade();
            
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            if(semPeriodo!=null){
                if(semPeriodo.compareToIgnoreCase("Sem Periodo")==0){
                    crs = ind.buscarIndisponibilidades();
                    
                    request.setAttribute("indisponibilidade", crs);
                   
                   RequestDispatcher view = request.getRequestDispatcher("audio/relatorioIndisponibilidadeImprimir.jsp");
                   
                   view.forward(request, response);
                }
                else{
                   crs = ind.buscarIndisponibilidades(diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim);
                   
                   request.setAttribute("indisponibilidade", crs);
                   
                   RequestDispatcher view = request.getRequestDispatcher("audio/relatorioIndisponibilidadeImprimir.jsp");
                   
                   view.forward(request, response);
                }
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("audio/relatorioDadosInvalidos.jsp");
                
                view.forward(request, response);
            }
           
        }
    }
}
