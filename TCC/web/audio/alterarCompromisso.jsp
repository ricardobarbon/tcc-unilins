<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Compromisso - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("compromisso");
       crs.next();
       GregorianCalendar data = new GregorianCalendar();
       int anoAt = data.get(Calendar.YEAR);%>
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerAlterarCompromisso.jpg"><br><br><br>
		<table width="100%"  border="0"><form action="CompromissoAtualizar" method="post">
  <tr>
      <td align="right"><b>Data: </b></td>
    <td colspan="2"><select name="dia"><% 
         int dia = crs.getInt(2);
         int mes = crs.getInt(3);
         int ano = crs.getInt(4);
         for(int i = 1; i<32; i++){
             if(dia==i){
                 out.println("<option value=\""+i+"\" selected>"+i+"</option>");
             }
             else{
                 out.println("<option value=\""+i+"\">"+i+"</option>");
             }
         }out.println("</select>");out.print(" / ");
         out.println("<select name=\"mes\">");
         for(int j = 1; j<13; j++){
             if(mes==j){
                 out.println("<option value=\""+j+"\" selected>"+j+"</option>");
             }
             else{
                 out.println("<option value=\""+j+"\">"+j+"</option>");
             }
         }out.println("</select>");out.print(" / ");
         out.println("<select name=\"ano\">");
         for(int k = anoAt;k < anoAt+11; k++){
             if(ano==k){
                 out.println("<option value=\""+k+"\" selected>"+k+"</option>");
             }
             else{
                 out.println("<option value=\""+k+"\">"+k+"</option>");
             }
         }out.println("</select>");
         out.println("</td>");%>
  </tr>
  <tr>
      <td align="right"><b>Hora: </b></td>
    <td colspan="2"><select name="hora"><% 
       int hora = crs.getInt(5);
       for(int h = 0; h<24; h++){
           if(hora==h){
              out.println("<option value=\""+h+"\" selected>"+h+"</option>");
           }
           else{
               out.println("<option value=\""+h+"\">"+h+"</option>");
           }
       }%>
        </select> : <select name="min"><% 
            if(crs.getString(6).compareToIgnoreCase("00")==0){
               out.println("<option value=\"00\" selected>00</option>");
               out.println("<option value=\"30\">30</option>");
            }
            else{
               out.println("<option value=\"00\">00</option>");
               out.println("<option value=\"30\"selected>30</option>");
        }%></select>
    </td>
  </tr>
  <tr>
      <td valign="top"><b>Descri&ccedil;&atilde;o Antiga: </b></td>
    <td colspan="2"><textarea name="descricao" rows="4" cols="50"><%out.print(crs.getString(7));%></textarea></td>
  </tr>
  <tr>
      <td align="right"><b>Aviso: </b></td>
    <td colspan="2"><select name="aviso">
            <%if(crs.getString(8).compareToIgnoreCase("0")==0){
                out.println("<option value=\"0\" selected> Na hora </option>");
                out.println("<option value=\"10\"> 10 min. antes</option>");
                out.println("<option value=\"30\"> 30 min. antes</option>");
                out.println("<option value=\"60\"> 1 hora antes</option>");
              }
              else if(crs.getString(8).compareToIgnoreCase("10")==0){
                out.println("<option value=\"0\"> Na hora </option>");
                out.println("<option value=\"10\" selected> 10 min. antes</option>");
                out.println("<option value=\"30\"> 30 min. antes</option>");
                out.println("<option value=\"60\"> 1 hora antes</option>");
              }
              else if(crs.getString(8).compareToIgnoreCase("30")==0){
                out.println("<option value=\"0\"> Na hora </option>");
                out.println("<option value=\"10\"> 10 min. antes</option>");
                out.println("<option value=\"30\" selected> 30 min. antes</option>");
                out.println("<option value=\"60\"> 1 hora antes</option>");
              }
              else{
                out.println("<option value=\"0\"> Na hora </option>");
                out.println("<option value=\"10\"> 10 min. antes</option>");
                out.println("<option value=\"30\"> 30 min. antes</option>");
                out.println("<option value=\"60\" selected> 1 hora antes</option>");
              }%>
    </select></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" name="Submit" value="&nbsp;Salvar&nbsp;">&nbsp;</form></td>
    <td><form action="Agenda" method="get"><input type="submit" name="Submit2" value="Cancelar"></form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
    </table>
    
    </body>
</html>
