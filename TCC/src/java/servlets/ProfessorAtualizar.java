package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ProfessorAtualizar extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            String id = (String)session.getAttribute("idProfessor");
            String nome = (String)request.getParameter("nome");
            String endereco = (String)request.getParameter("endereco");
            String bairro = (String)request.getParameter("bairro");
            String cidade = (String)request.getParameter("cidade");
            String uf = (String)request.getParameter("uf");
            String cep = (String)request.getParameter("cep");
            String telFixo = (String)request.getParameter("telFixo");
            String telCelular = (String)request.getParameter("telCelular");
            String dataNascDia = (String)request.getParameter("dataNascDia");
            String dataNascMes = (String)request.getParameter("dataNascMes");
            String dataNascAno = (String)request.getParameter("dataNascAno");
            String email = (String)request.getParameter("email");
            
            Professor prof = new Professor();
            
            boolean d = prof.validarDados(id, nome, endereco, bairro, cidade, uf, cep, telCelular, dataNascDia, dataNascMes, dataNascAno, email);
            
            response.setContentType("text/html;charset=UTF-8");
            
            if(d){
                prof.atualizarDados(id, nome, endereco, bairro, cidade, uf, cep, telFixo, telCelular, dataNascDia, dataNascMes, dataNascAno, email);
                
                RequestDispatcher view = request.getRequestDispatcher("secretaria/professorAlterado.jsp");
                
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("secretaria/professorDadosInvalidos.jsp");
                
                view.forward(request, response);
            }
        }
    }
}
