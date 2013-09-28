<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Relatório de Negociação - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerRelatorioDeNegociacao.jpg"><br>
        <br><br>
        <h3><center>Professores que reservaram este equipamento...</center></h3>
        <table border="1" width="100%">
            <tr>
              <td width="30%">Nome:</td>
              <td width="18%">Telefone Fixo:</td>
              <td width="18%">Telefone Cel:</td>
              <td width="34%">E-mail:</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
        </table>
        <br>
        <table width="100%">
            <tr>
              <td width="50%" align="right"><form action="ReservasProfessores" method="get"><input type="submit" value="OK"></form></td>
              <td><form action="" method="post"><input type="submit" value="Imprimir"></form></td>
            </tr>
    </table>
    
    </body>
</html>
