<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Equipamento - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerAlterarEquipamento.jpg"><br>
        <table width="100%" border="0"><form action="EquipamentoAtualizar" method="post">
  <tr><br><br>
    <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("equipamento");
       CachedRowSetImpl crs2 = (CachedRowSetImpl)request.getAttribute("tipos");
       
       crs.next();
       out.println("<td width=\"40%\" align=\"right\">Patrim&ocirc;nio: </td>");
    out.println("<td width=\"20%\">"+crs.getString(1)+"</td>");
    out.println("<td>&nbsp;</td>");
  out.println("</tr>");
  out.println("<tr>");
    out.println("<td align=\"right\">Tipo: </td>");
    out.println("<td><select name=\"tipo\">");
      while(crs2.next()){
        if(crs.getString(2).compareToIgnoreCase(crs2.getString(2))==0){
            out.println("<option value=\""+crs2.getString(1)+"\" selected>"+crs2.getString(2)+"</option>");
        }
        else{
            out.println("<option value=\""+crs2.getString(1)+"\">"+crs2.getString(2)+"</option>");
        }
      }
      out.println("</select></td>");
    out.println("<td>&nbsp;</td>");
  out.println("</tr>");
  out.println("<tr>");
    out.println("<td align=\"right\">Marca: </td>");
    out.println("<td><input type=\"text\" size=\"15\" maxlength=\"14\" name=\"marca\" value=\""+crs.getString(3)+"\"></td>");
    out.println("<td>&nbsp;</td>");
  out.println("</tr>");
  out.println("<tr>");
    out.println("<td align=\"right\">Situação: </td>");
    out.println("<td><select name=\"situacao\">)");
        if(crs.getString(4).compareToIgnoreCase("DISPONIVEL")==0){
           out.println("<option value=\"disponivel\" selected>Disponível</option>");
        }
        else{
           out.println("<option value=\"disponivel\">Disponível</option>");
        }
        if(crs.getString(4).compareToIgnoreCase("INDISPONIVEL")==0){
           out.println("<option value=\"indisponivel\" selected>Indisponível</option>");
        }
        else{
           out.println("<option value=\"indisponivel\">Indisponível</option>");
        }
        if(crs.getString(4).compareToIgnoreCase("INUTILIZADO")==0){
           out.println("<option value=\"inutilizado\" selected>Inutilizado</option>");
        }
        else{
           out.println("<option value=\"inutilizado\">Inutilizado</option>");
        }
        if(crs.getString(4).compareToIgnoreCase("FIXO")==0){
           out.println("<option value=\"fixo\" selected>Fixo</option>");
        }
        else{
           out.println("<option value=\"fixo\">Fixo</option>");
        }
        if(crs.getString(4).compareToIgnoreCase("EXCLUIDO")==0){
           out.println("<option value=\"excluido\" selected>Excluido</option>");
        }
        else{
           out.println("<option value=\"excluido\">Excluido</option>");
        }
      out.println("</select></td>");
    out.println("<td>&nbsp;</td>");
  out.println("</tr>");%>
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
