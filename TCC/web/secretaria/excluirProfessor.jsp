<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Excluir Professor - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerExcluirProfessor.jpg"><br>
		<br>
                <% String id = (String)session.getAttribute("idProfessor");
                   
		out.println("<br><br><br><br><br>");
		out.println("<h2><center>Tem certeza que deseja excluir os dados do professor com ID:"+id+"?</h2>");%>
		<br><br><br><br>
                <table width="100%" border="0">
                    <tr><td align="right"><form action="ProfessorExcluirSim" method="post"><input type="submit" value="Sim">&nbsp;</form></td>
                        <td align="left"><form action="secretariaProfessores" method="get">&nbsp;<input type="submit" value="Não"></form></td>
                    </tr>
                </table>
		
    </table>
    
    </body>
</html>
