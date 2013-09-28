<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Relatório de Indisponibilidade - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerRelatorioDeIndisponibilidade.jpg"><br><br>
		<table width="100%"  border="0"><form action="ImprimirRelatorioIndisponibilidade" method="post">
  <tr>
    <td colspan="2" align="center"><h3><i>Selecione o Periodo...</i></h3></td>
  </tr>
  <tr valign="middle">
    <td height="60" colspan="2" align="center">De: Dia: <select name="diaInicio"><option value="0"> </option>
        <% for(int i = 1; i <32; i++){
            out.println("<option value=\""+i+"\">"+i+"</option>");
        }%>
    </select>&nbsp;&nbsp; 
    M&ecirc;s: 
    <select name="mesInicio"><option value="0"> </option>
       <% for(int j = 1; j < 13; j++){
            out.println("<option value=\""+j+"\">"+j+"</option>");
        }%>
    </select>
    &nbsp;&nbsp;
    Ano: <select name="anInicio"><option value="0"> </option>
    <% for(int k = 2004; k < 2008; k++){
        out.println("<option value=\""+k+"\">"+k+"</option>");
        }%>
    </select>
</td>
  </tr>
  <tr>
    <td height="60" colspan="2" align="center">&agrave;: Dia: 
      <select name="diaFim"><option value="0"> </option>
        <% for(int l = 1; l <32; l++){
            out.println("<option value=\""+l+"\">"+l+"</option>");
        }%>
      </select>
      &nbsp;&nbsp; M&ecirc;s:
      <select name="mesFim"><option value="0"> </option>
       <% for(int m = 1; m < 13; m++){
            out.println("<option value=\""+m+"\">"+m+"</option>");
        }%>
      </select>
      &nbsp;&nbsp; 
	  Ano:<select name="anoFim"><option value="0"> </option>
    <% for(int n = 2004; n < 2008; n++){
        out.println("<option value=\""+n+"\">"+n+"</option>");
        }%>
      </select></td>
  </tr>
  <tr align="center">
    <td height="60" colspan="2"><input name="semPeriodo" type="radio" value="Sem Periodo">
    Sem Periodo </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="50%" align="right"><input name="confirmar" type="submit" value="Confirmar"></form></td>
	<td><form action="ReservasProfessores" method="get"><input name="cancelar" type="submit" value="Cancelar"></form></td>
  </tr>
</table>
    </table>
    
    </body>
</html>
