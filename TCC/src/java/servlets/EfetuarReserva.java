package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class EfetuarReserva extends HttpServlet {
        
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
            
            Usuario usuario = new Usuario();
            Tipo tipo = new Tipo();
            Sala sala = new Sala();
            Curso curso = new Curso();
            
            CachedRowSetImpl crsUsu, crsTipos, crsSalas, crsCursos;
            try{
                crsUsu = new CachedRowSetImpl();
                crsTipos = new CachedRowSetImpl();
                crsSalas = new CachedRowSetImpl();
                crsCursos = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            String id = (String)session.getAttribute("idLogin");
                       
            crsUsu = usuario.buscarUsuario(id);
            try{
                crsUsu.next();
                request.setAttribute("solicitante", crsUsu.getString(2));
            }
            catch(Exception e){
                
            }
            crsTipos = tipo.buscarTipos();
            request.setAttribute("tipos", crsTipos);
            
            crsCursos = curso.buscarCursos();
            request.setAttribute("cursos", crsCursos);
            
            crsSalas = sala.buscarSalas();
            request.setAttribute("salas", crsSalas);
            
            RequestDispatcher view = request.getRequestDispatcher("professor/efetuarReserva.jsp");
            
            view.forward(request, response);
        }
    }
}
