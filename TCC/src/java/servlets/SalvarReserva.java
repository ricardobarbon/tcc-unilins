package servlets;

import classes.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sun.rowset.CachedRowSetImpl;

public class SalvarReserva extends HttpServlet {
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.isNew()){
            request.setAttribute("mensagem", "");
            
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            
            view.forward(request, response);
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            
            String curso = request.getParameter("curso");
            String sala = request.getParameter("sala");
            String dia = request.getParameter("dia");
            String mes = request.getParameter("mes");
            String ano = request.getParameter("ano");
            String horaInicio = request.getParameter("horaInicio");
            String minInicio = request.getParameter("minInicio");
            String horaTermino = request.getParameter("horaTermino");
            String minTermino = request.getParameter("minTermino");
            String observacao = request.getParameter("observacao");
            
            Reserva reserva = new Reserva();
            
            boolean reservou = reserva.validarDados(curso, sala, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino); 
            
            String mensagem = "";
            if(reservou == false){
                mensagem = "Dados Inválidos...";
            }
            
            String id = (String)session.getAttribute("idLogin");
            
            CachedRowSetImpl crs;
            try{
                crs = new CachedRowSetImpl();
            }
            catch(Exception e){
                
            }
            
            crs = reserva.verificarSeProfJaTemReserva(id, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
            
            if((crs.size()>0)&&(reservou)){
                mensagem = "Professor ja tem reserva nesse periodo...";
                reservou = false;
            }
            
            crs = reserva.verificarSeSalaJaTemReserva(id, sala, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
            
            if((crs.size()>0)&&(reservou)){
                mensagem = "Sala ja tem reserva nesse periodo...";
                reservou = false;
            }
            
            if(reservou){
                reserva.salvarDados(id, curso, sala, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino, observacao);
                       
                crs = reserva.buscarCodReserva(id, curso, sala, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino, observacao);
                //buscar codigo reserva
                String codReserva = "";
                try{
                   crs.next();
                   codReserva = crs.getString(1);
                }
                catch(Exception e){
                
                }
                
                Tipo tipo = new Tipo();
                Equipamento equipamento = new Equipamento();
                EquipamentosUtilizados equipUtilizados = new EquipamentosUtilizados();
                //buscar tipos
                crs = tipo.buscarTipos();
            
                if(crs.size()>0){
                   String codTipo = "";
                   try{
                   
                       while(crs.next()){
                           codTipo = (String)request.getParameter(crs.getString(2));
                           if (codTipo!=null){
                              if(codTipo.compareToIgnoreCase("1")==0){
                               
                                  CachedRowSetImpl crsEqf = new CachedRowSetImpl();
                               
                                  EquipamentoFixo eqf = new EquipamentoFixo();
                                  
                                  EquipamentosReservaExterna ere = new EquipamentosReservaExterna();
                                  
                                  crsEqf = eqf.verificarEquipamentoFixo(sala, crs.getString(1));
                               
                                  if(crsEqf.size()==0){
                                     int qtdeDisponivel = 0;
                                     qtdeDisponivel = equipamento.buscarQtdeDisponivel(crs.getString(1));
                                  
                                     if(qtdeDisponivel>0){
                                         int qtdeReservado = 0;
                                         qtdeReservado = equipamento.buscarQtdeEquipamentosReservados(crs.getString(1), dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                         
                                         int qtdeReservadaExterna = 0;
                                         qtdeReservadaExterna = ere.buscarQtdeEquipamentoReservado(crs.getString(1), dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                         
                                         if((qtdeReservado>0)||(qtdeReservadaExterna>0)){
                                             CachedRowSetImpl crsHorario = new CachedRowSetImpl();
                                  
                                             crsHorario = reserva.buscarHorarios(crs.getString(1), dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
        
                                             while(crsHorario.next()){
                                                 if(crsHorario.isLast()){
                                                     break;
                                                 }
                                                 String termino = crsHorario.getString(2);
                                                 crsHorario.deleteRow();
                                                 crsHorario.beforeFirst();
                                                 
                                                 while(crsHorario.next()){
                                                     if(crsHorario.getString(1).compareTo(termino)>=0){
                                                         qtdeReservado = qtdeReservado - 1;
                                                         break;
                                                     }
                                                 }//termina While
                                              
                                                 crsHorario.beforeFirst();
                                             }//termina While
                                             
                                             CachedRowSetImpl crsHorarioExterna = new CachedRowSetImpl();
                                             
                                             crsHorarioExterna = ere.buscarHorarios(crs.getString(1), dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                             
                                             while(crsHorarioExterna.next()){
                                                 if(crsHorarioExterna.isLast()){
                                                     break;
                                                 }
                                                 String termino = crsHorarioExterna.getString(2);
                                                 crsHorarioExterna.deleteRow();
                                                 crsHorarioExterna.beforeFirst();
                                                 
                                                 while(crsHorarioExterna.next()){
                                                     if(crsHorarioExterna.getString(1).compareTo(termino)>=0){
                                                         qtdeReservadaExterna = qtdeReservadaExterna - 1;
                                                         break;
                                                     }
                                                 }//termina While
                                              
                                                 crsHorarioExterna.beforeFirst();
                                             }
                                             
                                             if(qtdeDisponivel>(qtdeReservadaExterna + qtdeReservado)){
                                                 equipUtilizados.salvarDados(codReserva, crs.getString(1));
                                             }
                                             else{
                                                 Indisponibilidade ind = new Indisponibilidade();
                                         
                                                 ind.salvarDados(crs.getString(1), id, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                                 
                                                 String codIndisponibilidade = ind.buscarCodInd(crs.getString(1), id, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                                 
                                                 session.setAttribute("codInd", codIndisponibilidade);
                                                 
                                                 equipUtilizados.apagarReserva(codReserva);
                                                 
                                                 CachedRowSetImpl crsProfessores = new CachedRowSetImpl();
                                                 
                                                 crsProfessores = reserva.buscarProfessores(codTipo, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                                 
                                                 request.setAttribute("tipo", crs.getString(2));
                                                 request.setAttribute("professores", crsProfessores);
                                                 
                                                 RequestDispatcher view = request.getRequestDispatcher("professor/equipamentosIndisponivel.jsp");
                                         
                                                 view.forward(request, response);
                                         
                                                 break;
                                             }
                                         }
                                         else if(qtdeDisponivel>=1){
                                             equipUtilizados.salvarDados(codReserva, crs.getString(1));
                                         }
                                      
                                     }
                                     else{
                                         Indisponibilidade ind = new Indisponibilidade();
                                         
                                         ind.salvarDados(crs.getString(1), id, dia, mes, ano, horaInicio, minInicio, horaTermino, minTermino);
                                         
                                         equipUtilizados.apagarReserva(codReserva);
                                         
                                         request.setAttribute("tipo", crs.getString(2));
                                                                                  
                                         RequestDispatcher view = request.getRequestDispatcher("professor/nenhumEquipamentoDisponivel.jsp");
                                         
                                         view.forward(request, response);
                                         
                                         break;
                                     }
                                  
                                  }
                                  else{
                                      equipUtilizados.salvarDados(codReserva, crs.getString(1));
                                  }
                                                             
                              }
                         }
                     }//termina while
                  }//termina try
                  catch(Exception e){
                        
                  }
              }//termina if dos tipos
            }
            else{
                request.setAttribute("mensagem", mensagem);
                
                RequestDispatcher view = request.getRequestDispatcher("professor/reservaDadosInvalidos.jsp");
                
                view.forward(request, response);
            }
            
            RequestDispatcher view = request.getRequestDispatcher("professor/reservaEfetuada.jsp");
            
            view.forward(request, response);
       }
    }
}
