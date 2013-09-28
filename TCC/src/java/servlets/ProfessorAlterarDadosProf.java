package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ProfessorAlterarDadosProf extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
    
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
            String emailUm = (String)request.getParameter("emailUm");
            String emailDois = (String)request.getParameter("emailDois");
            
            String id = (String)session.getAttribute("idLogin");
            
            Professor prof = new Professor();
            
            Usuario usuario = new Usuario();
            
            boolean d = prof.validarDados(id, nome, endereco, bairro, cidade, uf, cep, telCelular, dataNascDia, dataNascMes, dataNascAno, emailUm);
            
            d = usuario.validarDados(nome, dataNascDia, dataNascMes, dataNascAno, emailUm, emailDois);
                      
            response.setContentType("text/html;charset=UTF-8");
            
            if (d){
                prof.atualizarDados(id, nome, endereco, bairro, cidade, uf, cep, telFixo, telCelular, dataNascDia, dataNascMes, dataNascAno, emailUm);
                                
                RequestDispatcher view = request.getRequestDispatcher("professor/professorAlterado.jsp");
                
                view.forward(request, response);
            }
            else{
                request.setAttribute("id", id);
                request.setAttribute("nome", nome);
                request.setAttribute("endereco", endereco);
                request.setAttribute("bairro", bairro);
                request.setAttribute("cidade", cidade);
                request.setAttribute("uf", uf);
                request.setAttribute("cep", cep);
                request.setAttribute("telFixo", telFixo);
                request.setAttribute("telCelular", telCelular);
                request.setAttribute("dataNascDia", dataNascDia);
                request.setAttribute("dataNascMes", dataNascMes);
                request.setAttribute("dataNascAno", dataNascAno);
                request.setAttribute("emailUm", emailUm);
                request.setAttribute("emailDois", emailDois);
                
                request.setAttribute("mensagem", "Dados Inválidos...");
                
                RequestDispatcher view = request.getRequestDispatcher("professor/alterarDados.jsp");
                
                view.forward(request, response);
            }
            
        }
    }
}
