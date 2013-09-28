<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cadastrar Equipamentos - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerCadastrarEquipamento.jpg"><br>
		
		<table width="100%" border="0"><form action="EquipamentoSalvar" method="post">
  <tr><br><br>
    <td width="40%" align="right" >Patrim&ocirc;nio:</td>
    <td width="20%"><input type="text" size="8" maxlength="7" name="patrimonio"></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("tipos");
      if(crs.size()==0){
        out.println("<td align=\"right\">Tipo: Nenhum Tipo Cadastrado </td>");
      }
      else{
        out.println("<td align=\"right\">Tipo: </td>");
        out.println("<td><select name=\"tipo\">");
        out.println("<option value = \"0\"> </option>");
        while(crs.next()){
            out.println("<option value=\"" + crs.getString(1)+"\">"+ crs.getString(2) +" </option>");
        }
        out.println("</select></td>");
      }
      %>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Marca:</td>
    <td><input type="text" size="15" maxlength="14" name="marca"></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Situação: </td>
    <td><select name="situacao">
        <option value=""> </option>
        <option value="disponivel">Disponível</option>
        <option value="indisponivel">Indisponível</option>
        <option value="inutilizado">Inutilizado</option>
        <option value="fixo">Fixo</option>
        <option value="excluido">Excluido</opton>
      </select></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td valign="top" align="right"><input type="submit" name="salvar" value="Salvar">&nbsp;</form></td>
    <td valign="top" align="left"><form action="equipamentos" method="get"><input name="cancelar" type="submit" value="Cancelar"></form></td>
  </tr>
 
</table>
<% if (request.getAttribute("mensagem") != null){
        out.print("<center><font color =\"#ff0000\" size = \"4\">" + request.getAttribute("mensagem") + "</center></font>");
    }%>
		
    </table>
    
    </body>
</html>
