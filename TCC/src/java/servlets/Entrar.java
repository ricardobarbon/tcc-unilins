package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class Entrar extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        Usuario Usu = new Usuario();
        CachedRowSetImpl crs;
        HttpSession session;
        
        String id = request.getParameter("id");
        String senha = request.getParameter("senha");

        try{
            crs = new CachedRowSetImpl();
        }
        catch (Exception e){
            
        }
        crs = Usu.conectar(id);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            crs.next();
        }
        catch(Exception e){}
        
        if (crs.size() == 0){
            request.setAttribute("mensagem", "Dados Inválidos...");
        
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            try{
                String s = crs.getString(2);
                if (s.compareToIgnoreCase(senha) == 0){
                    
                    session = request.getSession();
                    session.setMaxInactiveInterval(30*60);
                    
                    session.setAttribute("idLogin",id);
        
                    String t = crs.getString(3);
                    
                    session.setAttribute("tipoUsuario", t);
                    
                    if ((t.compareToIgnoreCase("AUDIOVISUAL")== 0)||(t.compareToIgnoreCase("ADMINISTRADOR")==0)){
                        request.setAttribute("mensagem", "");
        
                        ReservasProfessores rProfs = new ReservasProfessores();
                        
                        rProfs.doGet(request, response);
                    }
                    else if (t.compareToIgnoreCase("SECRETARIA")== 0){
                        request.setAttribute("mensagem", "");
        
                        RequestDispatcher view = request.getRequestDispatcher("secretaria/pagInicial.jsp");
        
                        view.forward(request, response);
                    }
                    else{
                        ReservasProfessor rProf = new ReservasProfessor();
                        
                        rProf.doGet(request, response);
                    }
                }
                else{
                    request.setAttribute("mensagem", "Senha Inválida...");
        
                    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
                    view.forward(request, response);
                }
            }
            catch(Exception e){
            }
        }
    }
}
