package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class SalaSalvar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        
            view.forward(request, response);
        }
        else{
            Sala sala = new Sala();
            Tipo tipo = new Tipo();
            EquipamentoFixo eqF = new EquipamentoFixo();
            
            String desc = request.getParameter("descricao");
            
            boolean d = sala.verificarDados(desc);
            
            response.setContentType("text/html;charset=UTF-8");
            
            if (d){
                sala.salvarDados(desc);
                
                String codSala = sala.buscarCodSala(desc);
                
                CachedRowSetImpl crs;
                
                try{
                    crs = new CachedRowSetImpl();
                }
                catch (Exception e){
                    
                }
                crs = tipo.buscarTipos();
                String lembrete = "";
                if(crs.size()>0){
                    String codTipo = "";
                    try{
                        //crs.beforeFirst();
                        while(crs.next()){
                            codTipo = (String)request.getParameter(crs.getString(2));
                            if (codTipo!=null){
                            if(codTipo.compareToIgnoreCase("1")==0){
                                eqF.salvarDados(codSala, crs.getString(1));
                                lembrete = "LEMBRETE: Alterar a situa��o dos equipamentos que \n foram instalados nesta sala...";
                            }
                            }
                        }
                    }
                    catch(Exception e){
                        
                    }
                }
                 request.setAttribute("lembrete", lembrete);
                 request.setAttribute("descSala", desc);
                 
                 RequestDispatcher view = request.getRequestDispatcher("audio/salaCadastrada.jsp");
                 
                 view.forward(request, response);
            }
            else{
                request.setAttribute("decisao", "Dados Inv�lidos...");
                
                SalaCadastrar sal = new SalaCadastrar();
                
                sal.doPost(request, response);
            }
        }
    }
}
