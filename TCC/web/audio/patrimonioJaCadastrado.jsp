<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Patrimônio Já Cadastrado - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerPatrimonioJaCadastrado.jpg"><br>
        <br><br><h2><center><% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("equipamento");
        crs.next();
        out.println("Patrimônio: " + crs.getString(1)+"<br>");
        out.println("Tipo: " + crs.getString(2)+"<br>");
        out.println("Marca: " + crs.getString(3)+"<br>");
        out.println("Situação: " + crs.getString(4) +"<br><br>");
        %></center></h2>
        <table width="100%">
          <tr>
            <td align="right"><form action="EquipamentoAlterar" method="post"><input type="submit" value="Alterar"></form></td>
            <td><form action="equipamentos" method="get"><input type="submit" value="Cancelar"></form></td>            
          </tr>
        </table>
    </table>
    
    </body>
</html>
