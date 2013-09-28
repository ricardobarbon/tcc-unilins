package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class CancelarReserva extends HttpServlet {
        
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
            
            String codReserva = (String)session.getAttribute("codReserva");
            
            Reserva reserva = new Reserva();
            
            reserva.apagarReserva(codReserva);
            
            String tipoUsuario = (String)session.getAttribute("tipoUsuario");
            
            if(tipoUsuario.compareToIgnoreCase("PROFESSOR")==0){
                 ReservasProfessor rProf = new ReservasProfessor();
                 
                 rProf.doGet(request, response);
            }
            else{
                ReservasProfessores rProfs = new ReservasProfessores();
                
                rProfs.doGet(request, response);
            }
        }
    }
}
