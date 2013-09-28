<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cadastrar Tipo de Equipamentos</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerCadastrarTipo.jpg"><br>
  <br><br><br><form action="SalvarTipo" method="post">
  <center>Tipo: <input name="tipo" type="text" size="24" maxlength="24"></center>  
  <br><br><br>
   <table width="100%" border="0">
  <tr>
    <td width="49%" align="right">
      <input name="salvar" type="submit" value="Salvar"></form></td>
    <td width="51%"><form action="tipos" method="get"><input name="cancelar" type="submit" value="Cancelar"></form></td>
  </tr>
</table>
<%  if (request.getAttribute("decisao") != null) 
    out.print("<center><font color =\"#ff0000\" size = \"4\">" + request.getAttribute("decisao") + "</center></font>");%>

    </table>
    
    </body>
</html>
