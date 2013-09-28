package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ReservaCancelar extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String codReserva = request.getParameter("cod");
            
            session.setAttribute("codReserva", codReserva);
            
            RequestDispatcher view = request.getRequestDispatcher("professor/cancelarReserva.jsp");
            
            view.forward(request, response);
        }
    }
}
