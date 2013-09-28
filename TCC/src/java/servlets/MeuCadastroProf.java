package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class MeuCadastroProf extends HttpServlet {
        
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
            
            Professor prof = new Professor();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            String idLogin = (String)session.getAttribute("idLogin");
            
            crs = prof.buscarProfessor(idLogin);
            
            request.setAttribute("meuCadastro", crs);
            
            RequestDispatcher view = request.getRequestDispatcher("professor/meuCadastro.jsp");
            
            view.forward(request, response);
        }
    }
}
