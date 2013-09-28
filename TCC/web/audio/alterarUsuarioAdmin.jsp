<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Usuário - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerAlterarUsuario.jpg"><br><br><br>
        <table width="100%"  border="0"><form action="" method="post">
  <tr>
    <td width="20%" align="right">ID:</td>
    <td width="80%">____________</td>
  </tr>
  <tr>
    <td align="right">Nome:</td>
    <td><input name="nome" type="text" size="80" maxlength="79"></td>
  </tr>
  <tr>
    <td align="right">Data Nascimento: </td>
    <td><input name="dia" type="text" size="2" maxlength="2">&nbsp;/&nbsp;<input name="mes" type="text" size="2" maxlength="2">&nbsp;/&nbsp;<input name="ano" type="text" size="4" maxlength="4"></td>
  </tr>
  <tr>
    <td align="right">E-mail:</td>
    <td><input name="email" type="text" size="50" maxlength="49"></td>
  </tr>
  <tr>
    <td align="right">Confirma E-mail:</td>
    <td><input name="email" type="text" size="50" maxlength="49"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
        <td><table><tr><td><input type="submit" value="Concluir"></form><td><form action="" method="post"><input type="submit" value="Cancelar"></form></tr></table>
        </td>
  </tr>
</table>
    </table>
    
    </body>
</html>
