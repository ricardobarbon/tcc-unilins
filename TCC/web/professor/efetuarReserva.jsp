<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Efetuar Reserva - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    <% String solicitante = (String)request.getAttribute("solicitante");
       CachedRowSetImpl crsTipos = (CachedRowSetImpl)request.getAttribute("tipos");
       CachedRowSetImpl crsCursos = (CachedRowSetImpl)request.getAttribute("cursos");
       CachedRowSetImpl crsSalas = (CachedRowSetImpl)request.getAttribute("salas");
       GregorianCalendar data = new GregorianCalendar();%>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuProfessor.htm" %> <td valign="top"><img src="Imagens/pagProfessor/headerEfetuarReserva.jpg"><br>
		<table width="100%"  border="0"><form action="SalvarReserva" method="post">
  <tr>
      <td colspan="2"><b>Solicitante: </b><%out.println(solicitante);%></td>
  </tr>
  <tr>
      <td colspan="2"><b>Curso: </b><select name="curso"><option value="0"> </option>
          <%while(crsCursos.next()){
              out.println("<option value=\""+crsCursos.getString(1)+"\">"+crsCursos.getString(2)+"</option>");
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
          out.print("<select name=\"dia\"> <option value=\"-1\"> </option>");
          for(int d = 0; d < 8; d++){
              out.println("<option value=\""+dias[d]+"\">"+dias[d]+"</option>");
          }out.print("</select> / <select name=\"mes\"> <option value=\"-1\"> </option>");
           out.print("<option value=\""+mes[0]+"\">"+mes[0]+"</option>");
           if((mes[0]!=mes[1])&&(mes[1]!=-1)){
               out.print("<option value=\""+mes[1]+"\">"+mes[1]+"</option>");
           }
           out.print("</select> / <select name=\"ano\"> <option value=\"-1\"> </option>");
           out.print("<option value=\""+ano[0]+"\">"+ano[0]+"</option>");
           if((ano[0]!=ano[1])&&(ano[1]!=-1)){
               out.print("<option value=\""+ano[1]+"\">"+ano[1]+"</option>");
           }
           out.println("</select>");
      %></td>
  </tr>
  <tr>
      <td colspan="2"><b>Sala: </b> 
        <select name="sala"><option value="0"> </option>
        <%while(crsSalas.next()){
               out.println("<option value=\""+crsSalas.getString(1)+"\">"+crsSalas.getString(2)+"</option>");
        }
        %>
      </select> 
          &nbsp;&nbsp; <b>Hora Inicio: </b><select name="horaInicio"><option value="-1"> </option>
              <%for(int h = 0; h < 24; h++){
               out.println("<option value=\""+h+"\">"+h+"</option>");
              }
              %>
          </select>&nbsp;:&nbsp;<select name="minInicio"><option value="-1"> </option>
              <%for(int min = 0; min < 51; min = min + 10){
              out.println("<option value=\""+min+"\">"+min+"</option>");
              }
              %>
          </select>&nbsp;&nbsp;&nbsp;<b>Hora Término: </b><select name="horaTermino"><option value="-1"> </option>
              <%for(int hr = 0; hr < 24; hr++){
              out.println("<option value=\""+hr+"\">"+hr+"</option>");
              }
              %>
          </select>&nbsp;:&nbsp;<select name="minTermino"> <option value="-1"> </option>
              <%for(int min = 0; min < 51; min = min + 10){
              out.println("<option value=\""+min+"\">"+min+"</option>");
              }
              %>  
      </select></td>
  </tr>
  <tr>
    <td colspan="2" height="30" bgcolor="#E4E4E4"><center><b>EQUIPAMENTOS</b></center></td>
  </tr>
<%if(crsTipos.size()==0){
      out.println("Nenhum Tipo Cadastrado...");
  }
  else{
      int c = 0;
      while(crsTipos.next()){
          if(c==0){
              out.println("<tr>");
              out.println("<td width=\"50%\"><input name=\""+crsTipos.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crsTipos.getString(2)+"</td>");
              c = 1;
          }
          else{
              out.println("<td><input name=\""+crsTipos.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crsTipos.getString(2)+"</td>");
              out.println("</tr>");
              c = 0;
          }
      }
  }%>
  <tr>
      <td align="center"><b>Observação: </b></td>
      <td>&nbsp;</td>
  </tr>
  <tr>
      <td colspan="2" align="center" valign="top"><textarea name="observacao" rows="2" cols="57"></textarea></td>
  </tr>
  <tr>
    <td align="right"><br><input name="efetuarReserva" type="submit" value="Efetuar Reserva"></form>&nbsp;</td>
    <td><table border="0"><tr><td><form action="ReservasProfessor" method="get"><input name="cancelar" type="submit" value="Cancelar"></form></td></tr></table></td>
  </tr>
</table>

    </table>
    </body>
</html>
