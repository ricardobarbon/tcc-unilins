<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Curso - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerAlterarCurso.jpg"><br>
        <br><br><br><br><form action="cursoAtualizar" method="post">
            <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("curso");
                   crs.next();
                   out.println("<center>Curso: <input name=\"curso\" type=\"text\" size=\"49\" maxlength=\"49\" value=\""+ crs.getString(2)+"\"></center>");%>
        <br><br><br><br>
        <table width="100%" border = "0">
            <tr>
              <td align="right" width="50%"><input type="submit" value="Salvar"></form></td>
              <td><form acion="Cursos" method="post"><input type="submit" value="Cancelar"></form></td>
            </tr>
        </table>
    </table>
    
    </body>
</html>
