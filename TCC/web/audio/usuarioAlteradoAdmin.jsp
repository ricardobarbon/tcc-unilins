<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Dados Usuário Alterado - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><br>
   <br><br><br>
   <h2><center>Dados alterado com sucesso!</center></h2>
   <br><br>
   <form action="Usuarios" method="get"><center><input name="ok" type="submit" value="OK"></center></form>
    </table>
    
    </body>
</html>