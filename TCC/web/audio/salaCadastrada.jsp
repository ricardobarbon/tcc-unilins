<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Sala Cadastrada - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerSalaCadastrada.jpg"><br>
        <br><br><br><br>
        <% String desc = (String)request.getAttribute("descSala");
           String lembrete = (String)request.getAttribute("lembrete");
        out.println("<h3><center>"+desc +" cadastrado(a) com Sucesso!!!<br><br><br>");
        if(lembrete.length()>3){
            out.println(lembrete+"<br><br><br>");
        }
        %>
        Deseja Cadastrar outra Sala?
        </center></h3>
        
        <table width="100%">
            <tr>
              <td width="50%" align="right"><form action="SalaCadastrar" method="post"><input type="submit" value="Sim"></form></td>
              <td><form action="salas" method="get"><input type="submit" value="Não"></form></td>
            </tr>
    </table>
    
    </body>
</html>
