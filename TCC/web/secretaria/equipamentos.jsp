<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Equipamentos - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerEquipamentos.jpg"><br>
        <table width="100%"  border="0">
                    <tr height="35" bgcolor="#E4E4E4">
                    <td align="center" valign="middle">
                    <form action="EquipamentoProcurarSecProf" method="post"><input name="procurarEquip" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></form>
                    
                    </tr>
          </table>
	<% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("equipamentos"); 
           String s = (String)request.getAttribute("mensagem");
           if (s.length()>1){
               out.println("<center><b><h3>"+ s +"</h3></b></center>");
           }
           else{
           if (crs.size()==0){
              out.println("<center><b>NENHUM EQUIPAMENTO CADASTRADO...</b></center>");
           }
           else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"20%\"><b>PATRIM.</b><td align=\"center\" width=\"30%\"><b>TIPO</b><td align=\"center\" width=\"30%\"><b>MARCA</b><td align=\"center\" width=\"20%\"><b>SITUAÇÃO</b>");
              out.println("</tr>");
              
              int cont = 2;
              while (crs.next()){
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"20%\">" + crs.getString(1) + "<td align=\"center\" width=\"30%\">"+ crs.getString(2)+"<td align=\"center\" width=\"30%\">"+ crs.getString(3)+"<td align=\"center\" width=\"20%\">"+ crs.getString(4));
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
           }
           %>	 
    </table>
    
    </body>
</html>
