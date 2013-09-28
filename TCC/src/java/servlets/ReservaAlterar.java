package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ReservaAlterar extends HttpServlet {
        
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
            
            Reserva reserva = new Reserva();
            Usuario usuario = new Usuario();
            Tipo tipo = new Tipo();
            Sala sala = new Sala();
            Curso curso = new Curso();
            EquipamentosUtilizados eqU = new EquipamentosUtilizados();
            
            CachedRowSetImpl crsUsu, crsTipos, crsSalas, crsCursos, crsReserva, crsTipos1;
            try{
                crsUsu = new CachedRowSetImpl();
                crsTipos = new CachedRowSetImpl();
                crsSalas = new CachedRowSetImpl();
                crsCursos = new CachedRowSetImpl();
                crsReserva = new CachedRowSetImpl();
                crsTipos1 = new CachedRowSetImpl();
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
            crsReserva = reserva.buscarReserva(codReserva);
            request.setAttribute("reserva", crsReserva);
            session.setAttribute("reserva", crsReserva);
            
            session.setAttribute("codAnt", codReserva);
            
            crsTipos = eqU.buscarTiposDesc(codReserva);
            request.setAttribute("tipos", crsTipos);
            
            crsTipos1 = eqU.buscarTipos(codReserva);
            session.setAttribute("tipos", crsTipos1);
            
            crsCursos = curso.buscarCursos();
            request.setAttribute("cursos", crsCursos);
            
            crsSalas = sala.buscarSalas();
            request.setAttribute("salas", crsSalas);
            
            RequestDispatcher view = request.getRequestDispatcher("professor/alterarReserva.jsp");
            
            view.forward(request, response);
        }
    }
}
