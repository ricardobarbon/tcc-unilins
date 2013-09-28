package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class MeuUsuarioAlterarProf extends HttpServlet {
        
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
            
            Professor prof = new Professor();
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            String idLogin = (String)session.getAttribute("idLogin");
            
            crs = prof.buscarProfessor(idLogin);
            
            try{
                crs.next();
                request.setAttribute("id", crs.getString(1));
                request.setAttribute("nome", crs.getString(2));
                request.setAttribute("endereco", crs.getString(3));
                request.setAttribute("bairro", crs.getString(4));
                request.setAttribute("cidade", crs.getString(5));
                request.setAttribute("uf", crs.getString(6));
                request.setAttribute("cep", crs.getString(7));
                request.setAttribute("telFixo", crs.getString(8));
                request.setAttribute("telCelular", crs.getString(9));
                request.setAttribute("dataNascDia", crs.getString(10));
                request.setAttribute("dataNascMes", crs.getString(11));
                request.setAttribute("dataNascAno", crs.getString(12));
                request.setAttribute("emailUm", crs.getString(13));
                request.setAttribute("emailDois", crs.getString(13));
            }
            catch(Exception e){
                
            }
            
            RequestDispatcher view = request.getRequestDispatcher("professor/alterarDados.jsp");
            
            view.forward(request, response);
        }
    }
}
