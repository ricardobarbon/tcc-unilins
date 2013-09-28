package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class ProfessorSalvar extends HttpServlet {

        

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            String id = (String)request.getParameter("id");
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
            
            CachedRowSetImpl crs;
            
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            crs = prof.idJaCadastrado(id);
            
            response.setContentType("text/html;charset=UTF-8");
            
            if ((d) && (crs.size()==0)){
                String senha = prof.gerarSenha();
                
                prof.salvarDados(id, nome, endereco, bairro, cidade, uf, cep, telFixo, telCelular, dataNascDia, dataNascMes, dataNascAno, email, senha);
                
                //enviar e-mail
                
                RequestDispatcher view = request.getRequestDispatcher("secretaria/professorCadastrado.jsp");
                
                view.forward(request, response);
            }
            else if ((d) && (crs.size()>0)){
                request.setAttribute("professor", crs);
                session.setAttribute("idProfessor", id);
                
                RequestDispatcher view = request.getRequestDispatcher("secretaria/idJaCadastrado.jsp");
                
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
                request.setAttribute("email", email);
                
                RequestDispatcher view = request.getRequestDispatcher("secretaria/cadastrarProfessor.jsp");
                
                view.forward(request, response);
            }
            
        }
    }
}
