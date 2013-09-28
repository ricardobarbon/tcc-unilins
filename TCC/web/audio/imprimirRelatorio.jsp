<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Imprimir Relatório - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerImprimirRelatorio.jpg"><br>
		<table  width="100%" border="0"><form action="" method="post">
		<tr><td colspan="2"><br><br><br>
		<h2><center>
		  Imprimir Relatório de Reserva, de que dia?
		</center></h2>
		
		<center>
  Dia:
      <select name="dia">
      </select>
    M&ecirc;s:
      <select name="mes">
      </select>
	  </center>
      <br>
	  <h2><center>Qual o periodo?</center></h2>
	  <center>
	  <p>
	    <label>
	    <input type="radio" name="periodo" value="manha">
  Manhã</label>
	    <label>
	    <input type="radio" name="periodo" value="tarde">
  Tarde</label>
	    <label>
	    <input type="radio" name="periodo" value="noite">
  Noite</label>
	    </p>
	  <br></center>
	  </td>
	  </tr>
	  <tr>
	  <td align="right">
	  		<input name="visualisar" type="submit" value="Visualisar">&nbsp;&nbsp;</form>
	  </td>
	  <td><form action="" method="post">
          &nbsp;&nbsp;<input name="cancelar" type="submit" value="Cancelar"></form>
      </td>
	  </tr>	        

</table>


    </table>
    
    </body>
</html>
