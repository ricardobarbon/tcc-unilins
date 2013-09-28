<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Professores - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerProfessores.jpg"><br>
        <table width="100%"  border="0">
                    <tr bgcolor="#E4E4E4">
                    <td align="center">
                    <form action="ProfessorProcurar" method="post"><input name="procurarProf" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></form></td>
                    </tr>
	</table>
    <%     CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("professores"); 

           if (crs.size()==0){
              out.println("<center><b>NENHUM PROFESSOR ENCONTRADO...</b></center>");
           }
           else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"12%\"><b>ID</b><td align=\"center\" width=\"48%\"><b>NOME</b><td align=\"center\" width=\"40%\">");
              out.println("</tr>");
              
              int cont = 2;
              while (crs.next()){
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"12%\">" + crs.getString(1) + "<td align=\"center\" width=\"48%\"><a href=\"http://localhost:8084/TCC/ProfessorConsultar?id="+crs.getString(1)+"\">"+crs.getString(2)+"</a><td align=\"center\" width=\"40%\">"+crs.getString(3));
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
           %>
    </table>
    
    </body>
</html>
