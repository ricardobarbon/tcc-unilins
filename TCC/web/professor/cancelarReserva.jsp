<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cancelar Reserva - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuProfessor.htm" %> <td valign="top"><br>
		<br><br><br><br>
		<h2><center>Tem certeza que deseja cancelar esta Reserva?<br><br>
		<br><br></center></h2>
		<table width="100%"  border="0">
  <tr>
    <td align="right"><form action="CancelarReserva" method="post">
      <input name="submit" type="submit" value="Sim">
    </form></td>
    <td><form action="ReservasProfessor" method="get"><input type="submit" value="Não"></form></td>
  </tr>
</table>

			
		
    </table>
    
    </body>
</html>
