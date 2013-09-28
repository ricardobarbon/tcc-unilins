<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Senha Enviada - SisCRE &raquo;</title>
    </head>
    <body>
    
    <%@include file="Topo.htm" %>
    <% String id = (String)request.getAttribute("id");
       String nome = (String)request.getAttribute("nome");
       String senha = (String)request.getAttribute("senha");%>
    <center><img src="Imagens/headerSenhaEnviada.jpg">
    
    <br><br><br><br><br><br><br>
    <font face="georgia"><h2><i><p><%out.println("ID: "+id);%></p> 
    <p><%out.println("Nome: "+nome);%></p>  
    <p><%out.println("Senha: "+senha);%></p></h2></i></font>
    <br><br><br><br>
    <form action="index.jsp"><input value="Retornar ao Login" type="submit"></form>
    
    </body>
</html>
