<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Senha - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerAlterarSenha.jpg"><br>
        <br><br>
		<table width="100%"  border="0"><form action="SalvarNovaSenha" method="post">
  <tr>
    <td width="30%" align="right">Senha Atual: </td>
    <td width="70%" colspan="2"><input type="password" name="senhaAtual" size="15" maxlength="15"></td>
  </tr>
  <tr>
    <td align="right">Nova Senha: </td>
    <td colspan="2"><input type="password" name="novaSenha" size="15" maxlength="15"></td>
  </tr>
  <tr>
    <td align="right">Confirma Nova Senha: </td>
    <td colspan="2"><input type="password" name="confirmaNovaSenha" size="15" maxlength="15"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
        <td width="11%"><input type="submit" value="Concluir"></form></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td><form action="meuCadastroSecAudio" method="get"><input type="submit" value="Cancelar"></form>
        
  </tr>
</form></table>
<% String mensagem = (String)request.getAttribute("mensagem");
           if(mensagem!=null){
            out.println("<center>"+mensagem+"</center>");
           }%>
    </table>
    
    </body>
</html>
