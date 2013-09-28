<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.util.*" %>
<%@ page import="classes.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Reserva - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    <% String solicitante = (String)request.getAttribute("solicitante");
       CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("tipos");
       CachedRowSetImpl crsCursos = (CachedRowSetImpl)request.getAttribute("cursos");
       CachedRowSetImpl crsSalas = (CachedRowSetImpl)request.getAttribute("salas");
       CachedRowSetImpl crsReserva = (CachedRowSetImpl)request.getAttribute("reserva");
       GregorianCalendar data = new GregorianCalendar();
       
       crsReserva.next();
       int diaRes = crsReserva.getInt(4);
       int mesRes = crsReserva.getInt(5);
       int anoRes = crsReserva.getInt(6);
       int horaInicioRes = crsReserva.getInt(7);
       int minInicioRes = crsReserva.getInt(8);
       int horaTerminoRes = crsReserva.getInt(9);
       int minTerminoRes = crsReserva.getInt(10);%>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuProfessor.htm" %> <td valign="top"><img src="Imagens/pagProfessor/headerAlterarReserva.jpg"><br>
		<table width="100%"  border="0"><form action="AlterarReserva" method="post">
  <tr>
      <td colspan="2"><b>Solicitante: </b><%out.println(solicitante);%></td>
  </tr>
  <tr>
      <td colspan="2"><b>Curso: </b><select name="curso">
          <%while(crsCursos.next()){
              if(crsCursos.getString(1).compareToIgnoreCase(crsReserva.getString(2))==0){
                  out.println("<option value=\""+crsCursos.getString(1)+"\" selected>"+crsCursos.getString(2)+"</option>");
              }
              else{
              out.println("<option value=\""+crsCursos.getString(1)+"\">"+crsCursos.getString(2)+"</option>");
              }
            }
            %>
    </select>&nbsp;&nbsp; <b>Data:</b>&nbsp;<% int dias[]={0, 0, 0, 0, 0, 0, 0, 0};
          int mes[] = {-1, -1};
          int ano[] = {-1, -1};
          for(int i = 0; i < 8; i++){
              dias[i] = data.get(Calendar.DAY_OF_MONTH);
              if(mes[0]==-1){
                  mes[0]= data.get(Calendar.MONTH)+1;
              }
              else if((mes[0]!=-1)&&(mes[0]!=data.get(Calendar.MONTH)+1)){
                  mes[1]= data.get(Calendar.MONTH)+1;
              }
              if(ano[0]==-1){
                  ano[0]= data.get(Calendar.YEAR);
              }
              else if((ano[0]!=-1)&&(ano[0]!=data.get(Calendar.YEAR))){
                  ano[1]= data.get(Calendar.YEAR);
              }
              data.add(Calendar.DAY_OF_MONTH, 1);
          }
          out.print("<select name=\"dia\">");
          for(int d = 0; d < 8; d++){
              if(dias[d] == diaRes){
                  out.println("<option value=\""+dias[d]+"\" selected>"+dias[d]+"</option>");
              }else{
                  out.println("<option value=\""+dias[d]+"\">"+dias[d]+"</option>");
              }
          }out.print("</select> / <select name=\"mes\">");
           if(mes[0]==mesRes){ 
                out.print("<option value=\""+mes[0]+"\"selected>"+mes[0]+"</option>");
           }
           else{
              out.print("<option value=\""+mes[0]+"\">"+mes[0]+"</option>");
           }
           if((mes[0]!=mes[1])&&(mes[1]!=-1)){
               if(mes[1]==mesRes){
                   out.print("<option value=\""+mes[1]+"\" selected>"+mes[1]+"</option>");
               }
               else{
                   out.print("<option value=\""+mes[1]+"\">"+mes[1]+"</option>");
               }
           }
           out.print("</select> / <select name=\"ano\"> <option value=\"-1\"> </option>");
           if(ano[0] == anoRes){
              out.print("<option value=\""+ano[0]+"\" selected>"+ano[0]+"</option>");
           }
           else{
               out.print("<option value=\""+ano[0]+"\">"+ano[0]+"</option>");
           }
           if((ano[0]!=ano[1])&&(ano[1]!=-1)){
               if(ano[1] == anoRes){
                   out.print("<option value=\""+ano[1]+"\" selected>"+ano[1]+"</option>");
               }
               else{
                   out.print("<option value=\""+ano[1]+"\">"+ano[1]+"</option>");
               }
           }
           out.println("</select>");
      %></td>
  </tr>
  <tr>
      <td colspan="2"><b>Sala: </b> 
        <select name="sala"><option value="0"> </option>
        <%while(crsSalas.next()){
               if(crsSalas.getString(1).compareToIgnoreCase(crsReserva.getString(3))==0){
                   out.println("<option value=\""+crsSalas.getString(1)+"\" selected>"+crsSalas.getString(2)+"</option>");
               }
               else{
                   out.println("<option value=\""+crsSalas.getString(1)+"\">"+crsSalas.getString(2)+"</option>");
               }
        }
        %>
      </select> 
          &nbsp;&nbsp; <b>Hora Inicio: </b><select name="horaInicio">
              <%for(int h = 0; h < 24; h++){
                 if(h == horaInicioRes){
                      out.println("<option value=\""+h+"\" selected>"+h+"</option>");
                 }
                 else{
                     out.println("<option value=\""+h+"\">"+h+"</option>");
                 }
              }
              %>
          </select>&nbsp;:&nbsp;<select name="minInicio">
              <%for(int min = 0; min < 51; min = min + 10){
                  if(min == minInicioRes){
                      out.println("<option value=\""+min+"\" selected>"+min+"</option>");
                  }
                  else{
                      out.println("<option value=\""+min+"\">"+min+"</option>");
                  }
              }
              %>
          </select>&nbsp;&nbsp;&nbsp;<b>Hora Término: </b><select name="horaTermino"><option value="-1"> </option>
              <%for(int hr = 0; hr < 24; hr++){
                  if(hr == horaTerminoRes){
                    out.println("<option value=\""+hr+"\" selected>"+hr+"</option>");
                  }
                  else{
                      out.println("<option value=\""+hr+"\">"+hr+"</option>");
                  }
              }
              %>
          </select>&nbsp;:&nbsp;<select name="minTermino"> <option value="-1"> </option>
              <%for(int min = 0; min < 51; min = min + 10){
                  if(min == minTerminoRes){
                      out.println("<option value=\""+min+"\" selected>"+min+"</option>");
                  }
                  else{
                     out.println("<option value=\""+min+"\">"+min+"</option>");
                  }
              }
              %>  
      </select></td>
  </tr>
  <tr>
    <td colspan="2" height="30" bgcolor="#E4E4E4"><center><b>EQUIPAMENTOS</b></center></td>
  </tr>
  <% CachedRowSetImpl crst;
     try{
           crst = new CachedRowSetImpl();
     }
     catch(Exception e){
         
     }
     
     Tipo tipo = new Tipo();
     
     crst = tipo.buscarTipos();
     
     if (crst.size()==0){
         out.println("Nenhum tipo Cadastrado...");
     }
     else if(crs == null){
         int c = 0;
         crst.beforeFirst();
         while(crst.next()){
             if(c == 0 ){
                 out.println("<tr>");
                 out.println("<td width=\"50%\"><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crst.getString(2)+"</td>");
                 c = 1;
             }
             else{
                 out.println("<td><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crst.getString(2)+"</td>"); 
                 out.println("</tr>");
                 c = 0;
             }
         }
     }
     else {
         boolean igual;
         int i = 0;
         crst.beforeFirst();
         while(crst.next()){
             igual = false;
             if(i==0){
                 crs.beforeFirst();
                 while(crs.next()){
                     if(crs.getString(1).compareToIgnoreCase(crst.getString(2))==0){
                         igual = true;
                     }
                 }
                 if (igual){
                     out.println("<tr>");
                     out.println("<td width=\"50%\"><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\"1\" checked>"+crst.getString(2)+"</td>");
                     i = 1;
                 }
                 else{
                     out.println("<tr>");
                     out.println("<td width=\"50%\"><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crst.getString(2)+"</td>");
                     i = 1;
                 }
             }
             else{
                 crs.beforeFirst();
                 while(crs.next()){
                     if(crs.getString(1).compareToIgnoreCase(crst.getString(2))==0){
                         igual = true;
                     }
                 }
                 if(igual){
                     out.println("<td><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\"1\" checked>"+crst.getString(2)+"</td>"); 
                     out.println("</tr>");
                     i = 0;
                 }
                 else{
                     out.println("<td><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crst.getString(2)+"</td>"); 
                     out.println("</tr>");
                     i = 0;
                 }
             }
         }
     }
  %>
  <tr>
      <td align="center"><b>Observação: </b></td>
      <td>&nbsp;</td>
  </tr>
  <tr>
      <td colspan="2" align="center" valign="top"><textarea name="observacao" rows="2" cols="57"><% out.println(crsReserva.getString(11));%></textarea></td>
  </tr>
  <tr>
    <td align="right"><br><input name="alterarReserva" type="submit" value="Alterar Reserva"></form>&nbsp;</td>
    <td><table border="0"><tr><td><form action="ReservasProfessor" method="get"><input name="cancelar" type="submit" value="Cancelar"></form></td></tr></table></td>
  </tr>
</table>    
    </table>
    </body>
</html>
