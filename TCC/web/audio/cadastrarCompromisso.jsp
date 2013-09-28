<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cadastrar Compromisso - SisCRE &raquo;</title>
    </head>
    <body>
    <% GregorianCalendar data = new GregorianCalendar();
       int ano = data.get(Calendar.YEAR); %>
    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><br><br><br>
		<table width="100%"  border="0"><form action="CompromissoSalvar" method="post">
  <tr>
      <td align="right"><b>Data: </b></td>
    <td colspan="2"><select name="dia"><option value="0"> </option>
            <% for (int i=1; i < 32; i++){
            out.println("<option value=\""+i+"\">"+i+"</option>");
            }%>
        </select> / <select name="mes"><option value="0"> </option>
            <% for (int j=1; j < 13; j++){
            out.println("<option value=\""+j+"\">"+j+"</option>");
            }%>
        </select> / <select name="ano"> <option value="0"> </option>
            <% for (int k=ano; k < ano + 11; k++){
            out.println("<option value=\""+k+"\">"+k+"</option>");
            }%>
        </select>
</td>
  </tr>
  <tr>
    <td align="right"><b>Hora: </b></td>
    <td colspan="2"><select name="hora"><option value=""> </option>
            <% for(int a = 0; a < 24; a++){
            out.println("<option value=\""+a+"\">"+a+"</option>");
            }%>
        </select>
        &nbsp;:&nbsp;<select name="min"><option value=""> </option>
            <option value="00">00</option>
            <option value="30">30</option>
        </select>
</td>
  </tr>
  <tr>
      <td align="right" valign="top"><b>Descri&ccedil;&atilde;o: </b></td>
    <td colspan="2"><textarea name="descricao" rows="4" cols="50" ></textarea></td>
  </tr>
  <tr>
    <td align="right"><b>Avisar: </b></td>
    <td colspan="2"><select name="aviso">
            <option value="0"> Na hora </option>
            <option value="10"> 10 min. antes</option>
            <option value="30"> 30 min. antes</option>
            <option value="60"> 1 hora antes</option>
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