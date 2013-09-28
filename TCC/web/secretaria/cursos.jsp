<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cursos - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerCursos.jpg"><br>
		<table width="100%"  border="0">
                    <tr height="35" bgcolor="#E4E4E4">
                    <td align="center">
                    <form action="CursoProcurarSecProf" method="post"><input name="procurarCurso" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></td>
                    </form>
                    </tr>
                 </table>
                 
         <%
           CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("cursos"); 

           if (crs.size()==0){
              out.println("<center><b>NENHUM CURSO CADASTRADO...</b></center>");
           }
           else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"100%\"><b>CURSO</b>");
              out.println("</tr>");
              
              int cont = 2;
              while (crs.next()){
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"100%\">" + crs.getString(2) + "");
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
           %>
    </table>
    
    </body>
</html>
