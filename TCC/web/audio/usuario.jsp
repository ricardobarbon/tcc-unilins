<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo Usuário - SisCRE &raquo;</title>
    </head>
    <body>
    
    <%@include file="/Topo.htm" %>
    <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("usuario");
       crs.next();%>
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerUsuario.jpg"><br><br><br>
        <table width="100%"  border="0">
  <tr>
      <td width="20%" align="right"><b>ID: </b></td>
    <td width="80%"><%out.print(crs.getString(1));%></td>
  </tr>
  <tr>
      <td align="right"><b>Nome: </b></td>
    <td><%out.print(crs.getString(2));%></td>
  </tr>
  <tr>
    <td align="right"><b>Data Nascimento: </b></td>
    <td><%out.print(crs.getString(3)+" / "+crs.getString(4)+" / "+crs.getString(5));%></td>
  </tr>
  <tr>
    <td align="right"><b>E-mail: </b></td>
    <td><%out.print(crs.getString(6));%></td>
  </tr>
  <tr>
    <td align="right">Senha:</td>
    <td><%out.println("<a href=\"http://localhost:8084/TCC/AlterarSenha?id=\""+crs.getString(1)+"\" title=\"Clique aqui para alterar a senha\">Alterar Senha</a>");%></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form action="SolicitaSenha" method="post"><input type="submit" value="Alterar"></form></td>
  </tr>
</table>
    </table>
    
    </body>
</html>
