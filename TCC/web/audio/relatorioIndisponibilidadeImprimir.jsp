<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Relatório de Indisponibilidade - SisCRE &raquo;</title>
    </head>
    <body>
        <%CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("indisponibilidade");%>
<a href="ReservasProfessores">voltar</a>
    <h3><center>Relatório de Reservas do Dia</center></h3><br>
    <% 
    if(crs.size()==0){
            out.println("<center>Nenhuma Indisponibilidade Registrada...</center>");
    }
    else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"25%\"><b>INICIO</b><td align=\"center\" width=\"25%\"><b>TERMINO</b><td align=\"center\" width=\"50%\"><b>SOLICITANTE</b>");
              out.println("</tr>");
              
              String tipoAnt = "0";
              String dataAnt = "0";
              int cont = 2;
              while (crs.next()){
                  if((crs.getString(1).compareTo(tipoAnt)!=0)||(tipoAnt.compareTo("0")==0)){
                      out.println("<tr bgcolor=\"#E4E4E4\">");
                      out.println("<td align=\"center\" colspan=\"3\"><b>"+crs.getString(1)+"</b>");
                      out.println("</tr>");
                      cont = 2;
                  }
                  if((crs.getString(3).compareToIgnoreCase(dataAnt)!=0)||(dataAnt.compareToIgnoreCase("0")==0)){
                      out.println("<tr bgcolor=\"#E3E3E3\">");
                      out.println("<td align=\"center\" colspan=\"3\"><b>"+crs.getString(3)+"</b>");
                      out.println("</tr>");
                      cont = 2;
                  }
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"25%\">" + crs.getString(4) +"<td align=\"center\" width=\"25%\">"+crs.getString(5)+"<td align=\"center\" width=\"50%\">"+crs.getString(2));
                  out.println("</tr>");
                  
                  cont++;
                 
                dataAnt = crs.getString(3);
                tipoAnt = crs.getString(1);
              }
              out.println("</table>");
    }
    %>
    </body>
</html>
