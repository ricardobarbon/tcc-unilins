<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Entrando no Meu Cadastro - SisCRE &raquo;</title>
    </head>
    <body>
    <%@include file="/Topo.htm" %>
    <% String idLogin = (String)request.getAttribute("idLogin");%>
    <table width="100%">
        <tr> <td width="18%"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagProfessor/headerInformeSenha.jpg"><br>
        <br><br><br><form action="VerificaSenha" method="post">
            <h2><center>Relembrando sua senha!!!<br><br>
            ID: <%out.println(idLogin);%><p>
            Senha:<input name="senha" type="password" size="15" maxlength="15"><br><br>
        <input name="entrar" type="submit" value="Entrar"></form></center></h2><br>
        <% String mensagem = (String)request.getAttribute("mensagem");
        if(mensagem!=null){
           out.println("<center>"+ mensagem+"</center>");
        }%>
    </table>
    
    </body>
</html>
