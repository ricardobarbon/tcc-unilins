<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Agenda - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    <% GregorianCalendar data = new GregorianCalendar();
       int ano = data.get(Calendar.YEAR);%>
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerAgenda.jpg"><br>
        <table width="100%"  border="0">
                    <tr bgcolor="#E4E4E4">
                    <td width="63%" align="center">
                    <form action="CompromissoBuscar" method="post">
                            <input type="text" name="descProcurar" size="40">
        	        <input type="submit" name="procurarCompromisso" value="Procurar"></form><td width="37%" align="center"><form action="CompromissoCadastrar" method="post"><input name="inserirCompromisso" type="submit" value="Inserir Compromisso"></form>
                    </tr>
	</table>
        <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("compromissos");
           
        if (crs.size()==0){
              out.println("<center><b>NENHUM COMPROMISSO ENCONTRADO...</b></center>");
        }
        else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"12%\"><b>HORA</b><td align=\"center\" width=\"58%\"><b>COMPROMISSO</b><td align=\"center\" width=\"15%\"><td align=\"center\" width=\"15%\">");
              out.println("</tr>");
              
              int cont = 2;
              int diaAnt = -1;
              int mesAnt = -1;
              int anoAnt = -1;
              
              while (crs.next()){
                  if(((crs.getInt(2)!=diaAnt)||(crs.getInt(3)!=mesAnt)||(crs.getInt(4)!=anoAnt))||(diaAnt==-1)){
                      out.println("<tr bgcolor=\"#E4E4E4\">");
                      out.println("<td align=\"center\" colspan=\"4\"><b>"+crs.getString(2)+" / "+crs.getString(3)+" / "+crs.getString(4)+"</b>");
                      out.println("</tr>");
                      cont = 2;
                  }
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"12%\">" + crs.getString(5) +":"+crs.getString(6)+ "<td align=\"center\" width=\"58%\">"+crs.getString(7)+"<td align=\"center\" width=\"15%\"><a href=\"http://localhost:8082/TCC/CompromissoAlterar?cod="+crs.getString(1)+"\">Alterar</a><td align=\"center\" width=\"15%\"><a href=\"http://localhost:8082/TCC/CompromissoExcluir?cod="+crs.getString(1)+"\">Excluir</a>");
                  out.println("</tr>");
                  
                  cont++;
                 
                diaAnt = crs.getInt(2);
                mesAnt = crs.getInt(3);
                anoAnt = crs.getInt(4);
              }
              out.println("</table>");
           }%>
    </table>
    
    </body>
</html>
