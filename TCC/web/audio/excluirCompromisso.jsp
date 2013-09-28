<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Excluir Compromisso - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerExcluirCompromisso.jpg"><br>
   <br><br><br>
   <h2><center>Tem certeza que deseja excluir o compromisso?</center></h2>
   <br><br>
   <table width="100%" border="0">
  <tr>
    <td width="49%" align="right"><form action="CompromissoExcluirSim" method="post">
      <input name="sim" type="submit" value="Sim"></form></td>
    <td width="51%"><form action="Agenda" method="get"><input name="nao" type="submit" value="N&atilde;o"></form></td>
  </tr>
</table>
    
    </table>
    
    </body>
</html>
