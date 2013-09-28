<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo Indisponibilidade de Equipamentos - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerEquipamentoIndisponivel.jpg"><br>
    <br><br><br>
		<h3><center> O equipamento __________ solicitado na reserva está indisponível para a data desejada.<br>
		Este estará sendo utilizado na data desejada pelos seguintes professores.<br><br>
		nome professor&nbsp;|&nbsp;telefone<br>
		<br>
		Deseja efetuar outra reserva?<br><br>
		</center></h3>
		<table width="100%"  border="0">
        <tr>
          <td align="right"><form action="" method="post">
             <input name="submit" type="submit" value="Sim">
             </form></td>
          <td><form action="" method="post"><input type="submit" value="Não"></form></td>
        </tr>
      </table>
	</table>
    
    </body>
</html>
