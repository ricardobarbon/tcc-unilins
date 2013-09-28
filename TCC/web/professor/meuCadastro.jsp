<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Meu Cadastro - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%"> <%@include file="/menuProfessor.htm" %> <td valign="top"><img src="Imagens/pagProfessor/headerMeuCadastro.jpg"><br>
		<table width="100%"  border="0">
  <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("meuCadastro");
     crs.next();%>
  <tr>
      <td width="11%" align="right"><b>ID: </b></td>
    <td width="24%"><% out.println(crs.getString(1));%></td>
    <td width="13%">&nbsp;</td>
  </tr>
  <tr>
      <td align="right"><b>Nome: </b></td>
    <td colspan="4"><% out.println(crs.getString(2));%></td>
  </tr>
  <tr>
      <td align="right"><b>Endere&ccedil;o: </b></td>
    <td colspan="4"><% out.println(crs.getString(3));%></td>
  </tr>
  <tr>
      <td align="right"><b>Bairro: </b></td>
    <td><% out.println(crs.getString(4));%></td>
        <td align="right"><b>Cidade: </b></td>
	<td width="32%"><% out.println(crs.getString(5));%></td>
        <td width="19%" align="left"><b>UF: </b><% out.println(crs.getString(6));%></td>
	<td width="1%">&nbsp;	  </td>
  </tr>
  <tr>
        <td align="right"><b>CEP: </b></td>
	<td><% out.println(crs.getString(7));%></td>
  </tr>
  <tr>
      <td align="right"><b>Tel. Fixo: </b></td>
    <td><% out.println(crs.getString(8));%></td>
        <td align="right"><b>Tel. Celular: </b></td>
	<td><% out.println(crs.getString(9));%></td>
  </tr>
  <tr>
      <td align="right"><b>Data Nasc: </b></td>
    <td><% out.println(crs.getString(10)+" / "+crs.getString(11)+" / "+crs.getString(12));%></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
      <td align="right"><b>E-mail: </b></td>
    <td colspan="3"><% out.println(crs.getString(13));%></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
      <td align="right"><b>Senha: </b></td>
    <td><%out.println("<a href=\"http://localhost:8084/TCC/AlterarSenhaProf?id=\""+crs.getString(1)+"\" title=\"Clique aqui para alterar a senha\">Alterar Senha</a></td>");%>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td><form action="SolicitaSenha" method="post"><input type="submit" name="editar" value="Editar"></form></td>
    <td>&nbsp;</td>
  </tr>

 
</table>

    </table>    
    </body>
</html>
