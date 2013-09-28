<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cadastrar Curso - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerCadastrarCurso.jpg"><br>
        <br><br><br><br><form action="CursoSalvar" method="post">
        <center>Curso: <input type="text" size="49" maxlength="49" name="curso"></center>
        <br><br><br><br>
        <table width="100%" border = "0">
            <tr>
              <td align="right" width="50%"><input type="submit" value="Salvar"></form></td>
              <td><form action="Cursos" method="get"><input type="submit" value="Cancelar"></form></td>
            </tr>
        </table>
        
    <%  if (request.getAttribute("decisao") != null) 
    out.print("<center><font color =\"#ff0000\" size = \"4\">" + request.getAttribute("decisao") + "</center></font>");%>
    
    </table>
    
    </body>
</html>
