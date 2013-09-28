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
        <table width="100%"  border="0"><form action="UsuarioSalvarSecProf" method="post">
  <% String id = (String)request.getAttribute("id");
      String nome = (String)request.getAttribute("nome");
      String diaNasc = (String)request.getAttribute("diaNasc");
      String mesNasc = (String)request.getAttribute("mesNasc");
      String anoNasc = (String)request.getAttribute("anoNasc");
      String emailUm = (String)request.getAttribute("emailUm");
      String emailDois = (String)request.getAttribute("emailDois");
      GregorianCalendar data = new GregorianCalendar();
      int anoag = data.get(Calendar.YEAR);%>
  <tr>
      <td width="20%" align="right"><b>ID: </b></td>
    <td width="80%"><%out.println(id);%></td>
  </tr>
  <tr>
      <td align="right"><b>Nome: </b></td>
    <% out.println("<td><input name=\"nome\" type=\"text\" size=\"80\" maxlength=\"79\" value=\""+nome+"\"></td>");%>
  </tr>
  <tr>
      <td align="right"><b>Data Nascimento: </b></td>
    <td><% int idiaNasc = Integer.parseInt(diaNasc);
           int imesNasc = Integer.parseInt(mesNasc);
           int ianoNasc = Integer.parseInt(anoNasc);
                out.print("<select name=\"dataNascDia\"><option value=\"\"> </option>");
                for(int d = 1; d < 32; d++){
                    if(d==idiaNasc){
                        out.println("<option value=\""+d+"\" selected>"+d+"</option>");
                    }
                    else{
                        out.println("<option value=\""+d+"\">"+d+"</option>");
                    }
                }
           out.print("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascMes\"><option value=\"\"> </option>");
                for(int m = 1; m < 13; m++){
                    if(m == imesNasc){
                        out.println("<option value=\""+m+"\" selected>"+m+"</option>");
                    }
                    else{
                        out.println("<option value=\""+m+"\">"+m+"</option>");
                    }
                }
            out.println("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascAno\"><option value=\"\"> </option>");
               for(int a = anoag - 80; a < anoag - 15; a++){
                   if(a == ianoNasc){
                       out.println("<option value=\""+a+"\"selected>"+a+"</option>");
                   }
                   else{
                       out.println("<option value=\""+a+"\">"+a+"</option>");
                   }
               }
            out.println("</select></td>");%>
  </tr>
  <tr>
    <td align="right">E-mail:</td>
    <% out.println("<td><input name=\"email1\" type=\"text\" size=\"50\" maxlength=\"49\" value=\""+emailUm+"\"></td>");%>
  </tr>
  <tr>
    <td align="right">Confirma E-mail:</td>
    <% out.println("<td><input name=\"email2\" type=\"text\" size=\"50\" maxlength=\"49\" value=\""+emailDois+"\"></td>");%>
  </tr>
  <tr>
    <td align="right">Senha:</td>
    <td><%out.println("<a href=\"http://localhost:8084/TCC/AlterarSenha?id=\""+id+"\" title=\"Clique aqui para alterar a senha\">Alterar Senha</a></td>");%>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
        <td><table><tr><td><input type="submit" value="Concluir"></form><td><form action="meuCadastroSecAudio" method="get"><input type="submit" value="Cancelar"></form></tr></table>
        </td>
  </tr>
</table>
<% String mensagem = (String)request.getAttribute("mensagem");
    if(mensagem!=null){
    out.println("<center>"+mensagem+"</center>");
    }%>
    </table>
    
    </body>
</html>
