<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Efetuar Reserva Externa - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerEfetuarReservaExterna.jpg"><br>
        <table width="100%"  border="0"><form action="" method="post">
  <tr>
    <td colspan="2">Solicitante: <input type="text" size="50" maxlength="49" name="solicitante"></td>
  </tr>
  <tr>
    <td colspan="2">Evento: <input type="text" size="50" maxlength="49" name="evento">
        &nbsp;&nbsp; Data:&nbsp;<input name="dia" type="text" size="2" maxlength="2">&nbsp;/&nbsp;<input name="mes" type="text" size="2" maxlength="2">&nbsp;/&nbsp;<input name="ano" type="text" size="4" maxlength="4"></td>
  </tr>
  <tr>
    <td colspan="2">Local: <input type="text" size="50" maxlength="49" name="local"> 
  </tr>
  <tr>
    <td colspan="2">Hora Inicio: <input name="horaInicio" type="text" size="2" maxlength="2">&nbsp;:&nbsp;<input name="minutoInicio" type="text" size="2" maxlength="2">
	  &nbsp;&nbsp;&nbsp;Hora Término: <input name="horaTermino" type="text" size="2" maxlength="2">&nbsp;:&nbsp;<input name="minutoTermino" type="text" size="2" maxlength="2"></td>
  </tr>
  <tr>
    <td colspan="2" height="30" bgcolor="#E4E4E4"><center><b>EQUIPAMENTOS</b></center></td>
  </tr>
  <tr>
    <td width="50%"><input name="projetor" type="checkbox" value="projetor multimídia">Projetor Multimídia</td>
    <td width="50%"><input name="retro" type="checkbox" value="retro">Retro</td>
  </tr>
  <tr>
    <td width="50%"><input name="computador" type="checkbox" value="Computador">Computador</td>
    <td width="50%"><input name="DVDPlayer" type="checkbox" value="DVD player">DVD Player</td>
  </tr>
  <tr>
    <td width="50%"><input name="som" type="checkbox" value="Som">Som</td>
    <td width="50%"><input name="microfone" type="checkbox" value="microfone">Microfone</td>
  </tr>
  <tr>
    <td width="50%"><input name="videoCassete" type="checkbox" value="Video Cassete">Video Cassete</td>
    <td width="50%"><input name="tela" type="checkbox" value="tela">Tela</td>
  </tr>
  <tr>
    <td align="right"><br><input name="efetuarReserva" type="submit" value="Efetuar Reserva"></form>&nbsp;</td>
    <td><table border="0"><tr><td><form action="" method="post"><input name="cancelar" type="submit" value="Cancelar"></form></td></tr></table></td>
  </tr>
</table>

    </table>
    
    </body>
</html>
