<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl"%>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Enviar Equipamento para Manutenção - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerEquipamentoEmManutencao.jpg"><br>
        <table width="100%" border="0"><form action="EquipamentoSalvarManutencao" method="post">
  <tr><br><br><% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("equipamento");
                                  
                 crs.next();%>
    <td width="40%" align="right" >Patrim&ocirc;nio:</td>
    <% out.println("<td width=\"20%\">"+ crs.getString(1)+"</td>");%>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Tipo:</td>
    <% out.println("<td>"+ crs.getString(2)+"");%>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Marca:</td>
    <% out.println("<td>"+ crs.getString(3) +"</td>");%>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Situação: </td>
    <% out.println("<td><select name=\"situacao\">)");
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
      out.println("</select></td>");%>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Data de Retorno: </td>
        <td><select name="dia">
                <option value="0"></option>
                <%for(int i=1; i < 32; i++){
                  out.println("<option value=\""+i+"\">"+i+"</option>");
                }
                %>
            </select>&nbsp;/&nbsp;
            <select name="mes">
                <option value="0"></option>
                <% for(int c=1; c<13;c++){
                   out.println("<option value=\""+c+"\">"+c+"</option>");
                }
                %>
            </select>&nbsp;/&nbsp;
            <select name="ano">
                 <option value="0"></option>
                <% GregorianCalendar data = new GregorianCalendar();
                   int ano = data.get(Calendar.YEAR);
                   
                   for(int a=ano; a<ano+11;a++){
                   out.println("<option value=\""+a+"\">"+a+"</option>");
                }
                %>
            </select></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right" valign="top">Descri&ccedil;&atilde;o da Manuten&ccedil;&atilde;o:  </td>
    <td colspan="2"><textarea name="descricaoManutencao" rows="4" cols="40"></textarea></td>
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
    </table>
    
    </body>
</html>
