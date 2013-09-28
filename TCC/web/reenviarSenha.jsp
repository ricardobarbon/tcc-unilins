<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Reenviar Senha &raquo;</title>
    </head>
    <body>
    <%@include file="Topo.htm" %>
    
    <center><img src="Imagens/headerReenviarSenha.jpg"></center>
    <% GregorianCalendar data = new GregorianCalendar();
       int ano = data.get(Calendar.YEAR);%>
    <table border="0"><form method="post" action="ReenviarSenha">
        <tr><td rowspan="5" width="42%"><td colspan="2" height=70><td rowspan="3" width="70">
        <tr><td align="right"><font face=georgia><h3><i>ID:</font><td><input type="text" name="id" size="10">
        <tr><td valign="top" align="right"><font face=georgia><h3><i>Data Nascimento:</font><td>
            <select name="dia"><option value="0"> </opton>
            <% for (int d = 1; d < 32; d++){
            out.println("<option value=\""+d+"\">"+d+"</option>");
            }%></select>&nbsp;/&nbsp;<select name="mes"><option value="0"> </option>
            <%for (int m = 1; m < 13; m++){
            out.println("<option value=\""+m+"\">"+m+"</option>");
            }%></select>&nbsp;/&nbsp;<select name="ano"><option value="0"> </option>
            <%for (int a = ano - 80; a < ano - 15; a++){
            out.println("<option value=\""+a+"\">"+a+"</opton>");
            }%></select>
        <tr><td colspan="2" height="20">
        <tr><td colspan="2" align="right" valign="bottom"><input type=submit value="Enviar Senha"></form><td><form action="index.jsp"><input type="submit" value="Cancelar"></form>
    </table>
    
    
    </body>
</html>
