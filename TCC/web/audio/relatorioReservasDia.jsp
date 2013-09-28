<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="classes.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Reservas do Dia - SisCRE</title>
    </head>
    <body>
<% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("reservasHoje");%>
    <a href="ReservasProfessores">voltar</a>
    <h3><center>Relatório de Reservas do Dia</center></h3>
    
    <% if (crs.size()==0){
              out.println("<center><b>NENHUMA RESERVA ENCONTRADA...</b></center>");
        }
        else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"10%\"><b>INICIO</b><td align=\"center\" width=\"10%\"><b>TERMINO</b><td align=\"center\" width=\"15%\"><b>SALA</b><td align=\"center\" width=\"40%\"><b>EQUIPAMENTOS</b><td align=\"center\" width=\"35%\"><b>SOLICITANTE</b>");
              out.println("</tr>");
              
              String dataAnt = "0";
              int cont = 2;
              String t = "";
              while (crs.next()){
                  if((crs.getString(1).compareTo(dataAnt)!=0)||(dataAnt.compareTo("0")==0)){
                      out.println("<tr bgcolor=\"#E4E4E4\">");
                      out.println("<td align=\"center\" colspan=\"5\"><b>"+crs.getString(1)+"</b>");
                      out.println("</tr>");
                      cont = 2;
                  }
                  CachedRowSetImpl crst = new CachedRowSetImpl();
                  
                  
                     t = "";
                  
                     Reserva reserva = new Reserva();
                  
                     crst = reserva.buscarEquipamentos(crs.getString(5));
                  
                     crst.beforeFirst();
                     int c = 0;
                     while(crst.next()){
                         try{
                           if(c == 0){
                             t = crst.getString(1);
                             c = 1;
                           }
                           else{
                               t = t + ", " + crst.getString(1);
                           }
                         }
                         catch(Exception e){
                          
                         }
                     }
                  t=t+".";
                  
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"12%\">" + crs.getString(2) +"<td align=\"center\" width=\"12%\">"+crs.getString(3)+"<td align=\"center\" width=\"15%\">"+crs.getString(4)+"<td align=\"center\" width=\"41%\">"+ t +"<td align=\"center\" width=\"10%\">"+crs.getString(6)+"");
                  out.println("</tr>");
                  
                  cont++;
                 
                dataAnt = crs.getString(1);
              }
              out.println("</table>");
           }%>
    
    </body>
</html>
