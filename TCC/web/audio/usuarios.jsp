<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Usuários - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerUsuarios.jpg"><br>
        <table width="100%"  border="0">
                    <tr bgcolor="#E4E4E4">
                    <td align="center">
                    <form action="UsuarioProcurar" method="post"><input name="procurarUsuario" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></form><td align="center"><form action="UsuarioCadastrar" method="post"><input name="inserirUsuario" type="submit" value="Inserir Usuário"></form>
                    </tr>
	</table>
        <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("usuarios"); 

           if (crs.size()==0){
              out.println("<center><b>NENHUM USUARIO ENCONTRADO...</b></center>");
           }
           else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"10%\"><b>ID</b><td align=\"center\" width=\"35%\"><b>NOME</b><td align=\"center\" width=\"15%\"><b>TIPO</b><td align=\"center\" width=\"40%\"><b>E-MAIL</b>");
              out.println("</tr>");
              
              int cont = 2;
              while (crs.next()){
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"10%\">" + crs.getString(1) + "<td align=\"center\" width=\"35%\"><a href=\"http://localhost:8080/TCC/UsuarioConsultar?cod="+crs.getString(1)+"\">"+crs.getString(2)+"</a><td align=\"center\" width=\"15%\">"+crs.getString(3)+"<td align=\"center\" width=\"40%\">"+crs.getString(4));
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
           %>
    </table>
    
    </body>
</html>
