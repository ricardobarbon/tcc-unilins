package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ReenviarSenha extends HttpServlet {
        
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
            
            String id = request.getParameter("id");
            String dia = request.getParameter("dia");
            String mes = request.getParameter("mes");
            String ano = request.getParameter("ano");
            
            int idia = Integer.parseInt(dia);
            int imes = Integer.parseInt(mes);
            int iano = Integer.parseInt(ano);
            
            Usuario usuario = new Usuario();
            
            boolean d = usuario.validarDados(id, dia, mes, ano);
            
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = usuario.buscarUsuario(id);
            
            if(crs.size()==0) d=false;
            
            
            if(d){
                try{
                  crs.next();
                  if((idia!=crs.getInt(3))||(imes!=crs.getInt(4))||(iano!=crs.getInt(5))){
                       d=false;
                  }
                }
                catch(Exception e){
                
                }
            }
            if(d){
                try{
                    request.setAttribute("id", crs.getString(1));
                    request.setAttribute("nome", crs.getString(2));
                    request.setAttribute("senha", crs.getString(8));
                }
                catch(Exception e){
                    
                }
                
                RequestDispatcher view = request.getRequestDispatcher("senhaEnviada.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("dadosInvalidos.jsp");
                
                view.forward(request, response);
            }
        }
    }
}
