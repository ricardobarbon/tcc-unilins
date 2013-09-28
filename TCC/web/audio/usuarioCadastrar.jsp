<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

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
        <table width="100%"  border="0"><form action="UsuarioSalvar" method="post">
  <% 
      GregorianCalendar data = new GregorianCalendar();
      int anoag = data.get(Calendar.YEAR);%>
  <tr>
      <td width="20%" align="right"><b>ID: </b></td>
    <td width="80%"><input type="text" size="6" maxlength="6" name="id"></td>
  </tr>
  <tr>
      <td align="right"><b>Nome: </b></td>
    <td><input name="nome" type="text" size="80" maxlength="79"></td>
  </tr>
  <tr>
      <td align="right"><b>Data Nascimento: </b></td>
              <td><select name="dataNascDia"><option value="0"> </option>
              <%for(int d = 1; d < 32; d++){
                 out.println("<option value=\""+d+"\">"+d+"</option>");
                }
                %></select>&nbsp;/&nbsp;
              <select name="dataNascMes"><option value="0"> </option>
              <%for(int m = 1; m < 13; m++){
                   out.println("<option value=\""+m+"\">"+m+"</option>");
              }
              %></select>&nbsp;/&nbsp;
              <select name="dataNascAno"><option value="0"> </option>
              <%for(int a = anoag - 80; a < anoag - 15; a++){
                  out.println("<option value=\""+a+"\">"+a+"</option>");
              }
              %></select></td>
          </tr>
          <tr>
              <td align="right"><b>Tipo: </b></td>
       <td><select name="tipo">
               <option value="0"> </option>
          <option value="ADMINISTRADOR">ADMINISTRADOR</option>
          <option value="AUDIOVISUAL">AUDIOVISUAL</option>
          <option value="SECRETARIA">SECRETARIA</option>
          </select>
        </td>
  </tr>
  <tr>
    <td align="right"><b>E-mail: </b></td>
    <td><input name="email1" type="text" size="50" maxlength="49"></td>
  </tr>
  <tr>
      <td align="right"><b>Confirma E-mail: </b></td>
      <td><input name="email2" type="text" size="50" maxlength="49"></td>
  </tr>
  <tr>
    <td align="right"><b>Senha: </b></td>
    <td><input name="senha1" type="password" size="14" maxlength="14"></td>
  </tr>
  <tr>
      <td align="right"><b>Confirma Senha: </b></td>
      <td><input name="senha2" type="password" size="14" maxlength="14"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
        <td><table><tr><td><input type="submit" value="Concluir"></form><td><form action="Usuarios" method="get"><input type="submit" value="Cancelar"></form></tr></table>
        </td>
  </tr>
</table>

    </table>
    
    </body>
</html>
