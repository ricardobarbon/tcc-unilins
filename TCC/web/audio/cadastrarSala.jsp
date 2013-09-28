<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cadastrar Sala - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerCadastrarSala.jpg"><br>
		<table width="100%" border="0"><form action="SalaSalvar" method="post">
  <tr>
    <td align="right" width="13%">Descrição: </td>
    <td width="37%"><input name="descricao" type="text" size="50" maxlength="49"></td>
    <td>&nbsp;</td>
  </tr>
  <tr align="center" valign="middle" bgcolor="#E4E4E4">
    <td colspan="3"><h3><b>Se houver, quais são os Equipamentos Fixos... </b></h3></td>
  </tr>
  <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("tipos");
  
  if(crs.size()==0){
      out.println("Nenhum Tipo Cadastrado...");
  }
  else{
      int c = 0;
      while(crs.next()){
          if(c==0){
              out.println("<tr>");
              out.println("<td colspan=\"2\"><input name=\""+crs.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crs.getString(2)+"</td>");
              c = 1;
          }
          else{
              out.println("<td><input name=\""+crs.getString(2)+"\" type=\"checkbox\" value=\"1\">"+crs.getString(2)+"</td>");
              out.println("</tr>");
              c = 0;
          }
      }
  }
  %>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" value="Salvar"></form></td>
    <td><form action="salas" method="get"><input name="Cancelar" type="submit" value="Cancelar"></form></td>
  </tr>
</table>
<% if(request.getAttribute("decisao")!=null){
      out.println("<center><font color =\"#ff0000\" size = \"4\">" + request.getAttribute("decisao") + "</center></font>");
    }%>
        
    </table>
    
    </body>
</html>
