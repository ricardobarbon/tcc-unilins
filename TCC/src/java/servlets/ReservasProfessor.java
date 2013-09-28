package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ReservasProfessor extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String id = (String)session.getAttribute("idLogin");
            
            Reserva reserva = new Reserva();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            crs = reserva.buscarReservas(id);
            
            request.setAttribute("reservas", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("professor/pagInicial.jsp");
            
            view.forward(request, response);
        }
    }
}
