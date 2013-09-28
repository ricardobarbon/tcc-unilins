<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Tipos de Equipamentos - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerTiposDeEquipamentos.jpg"><br>
        <table width="100%"  border="0">
                    <tr bgcolor="#E4E4E4">
                    <td align="center">
                    <form action="procurarTipo" method="post"><input name="procurarTipos" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></form></td><td align="center"><form action="cadastrarTipo" method="post"><input name="inserirTipo" type="submit" value="Inserir Tipo"></form></td>
                    </tr>
        </table>
        <% String m = (String)request.getAttribute("mensagem");
           if (m.length()>1){
            out.println("<center><b><h3>"+ m +"</h3></b></center>");
           }
           else{
        
           CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("tipos"); 

           if (crs.size()==0){
              out.println("<center><b>NENHUM TIPO CADASTRADO...</b></center>");
           }
           else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"50%\"><b>TIPO</b><td align=\"center\" width=\"25%\"><td align=\"center\" width=\"25%\">");
              out.println("</tr>");
              
              int cont = 2;
              while (crs.next()){
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"50%\">" + crs.getString(2) + "<td align=\"center\" width=\"25%\"><a href=\"http://localhost:8082/TCC/TipoAlterar?cod="+crs.getString(1)+"\">Alterar</a><td align=\"center\" width=\"25%\"><a href=\"http://localhost:8082/TCC/TipoExcluir?cod="+crs.getString(1)+"\">Excluir</a>");
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
           }%>
   
    </table>
    
    </body>
</html>
