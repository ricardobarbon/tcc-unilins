<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Equipamento Indisponível - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    <% String tipo = (String)request.getAttribute("tipo");
       CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("professores");
    %>
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuProfessor.htm" %> <td valign="top"><p><img src="Imagens/pagProfessor/headerEquipamentoIndisponivel.jpg"><br>
		<br><br><br>
		<h3><center> O equipamento <%=tipo %> solicitado na reserva está indisponível para a data desejada.<br>
		Este estará sendo usado na data desejada pelos seguintes professores.<br><br>
		<%while(crs.next()){
                   out.println("Nome: "+crs.getString(1)+"  |  Telefone: "+crs.getString(2));
                }
                %>
		<br>
		Deseja entrar na lista de interessados? Caso sim, o professor será avisado caso alguém venha a desistir do equipamento.<br><br>
		</center></h3>
		<table width="100%"  border="0">
        <tr>
          <td align="right"><form action="ListaEsperaSim" method="post">
             <input name="submit" type="submit" value="Sim">
             </form></td>
          <td><form action="ReservasProfessor" method="get"><input type="submit" value="Não"></form></td>
        </tr>
      </table>
    </table>
    </body>
</html>
