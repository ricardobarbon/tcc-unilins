<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Dados Inválidos - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    <% String mensagem = (String)request.getAttribute("mensagem");
    %>
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuProfessor.htm" %> <td valign="top"><p><br>
		<br><br><br>
		<h3><center> <%=mensagem %><br><br><br><br><br>
		</center></h3>
		<table width="100%"  border="0">
        <tr>
          <td align="center"><form action="ReservasProfessor" method="get">
             <input name="submit" type="submit" value="OK">
             </form></td>
        </tr>
      </table>
    </table>
    </body>
</html>
