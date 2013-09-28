<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; ID Já Cadastrado - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerIdJaCadastrado.jpg"><br>
		<br><br><br><br><br>
                <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("professor");
                crs.next();
                request.setAttribute("professor", crs.getString(1));
                
		out.println("<h2><center> ID número "+crs.getString(1)+" já cadastrado!!!<br><br><br>");
		out.println("ID: "+crs.getString(1)+"&nbsp;&nbsp;| &nbsp;&nbsp;NOME: "+crs.getString(2));
                out.println("<br><br>Deseja Alterar?</center></h2>");
                %>
                <table width="100%">
                    <tr>
                        <% out.print("<td width=\"49%\" align=\"right\"><form action=\"professorAlterar\" method=\"post\">");%>
                        <input name="sim" type="submit" value="Sim"></form></td>
                        <td width="51%"><form action="secretariaProfessores" method="get"><input name="nao" type="submit" value="N&atilde;o"></form></td>
                    </tr>
                </table>
    </table>
    
    </body>
</html>
