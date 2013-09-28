<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="classes.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Salas - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerSalas.jpg"><br>
        <table width="100%"  border="0">
                    <tr bgcolor="#E4E4E4">
                    <td align="center">
                    <form action="SalaProcurar" method="post"><input name="procurarSala" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></form><td align="center"><form action="SalaCadastrar" method="post"><input name="inserirSala" type="submit" value="Inserir Sala"></form>
                    </tr>
	</table>
        <% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("salas");
        
        if(crs.size()==0){
            out.println("<center><b><h3> NENHUMA SALA ENCONTRADA...</h3></b></center>");
        }
        else{
            out.println("<table width=\"100%\" border=\"0\">");
            out.println("<tr bgcolor=\"#E4E4E4\">");
            out.println("<td align=\"center\" width=\"30%\"><b>SALA</b><td align=\"center\" width=\"50%\"><b>EQUIPAMENTO FIXO</b><td align=\"center\" width=\"10%\"><td align=\"center\" width=\"10%\">");
            out.println("</td>");
            
            CachedRowSetImpl crst = new CachedRowSetImpl();
            int cont = 2;
              while (crs.next()){
                  String t = "";
                  
                  EquipamentoFixo eqF = new EquipamentoFixo();
                  
                  crst = eqF.buscarTipoDesc(crs.getString(1));
                  
                  if (crst.size()==0){
                      t = "Não tem equipamento fixo...";
                  }
                  else{
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
                  }
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"30%\">" + crs.getString(2));
                  out.println("<td align=\"center\" width=\"50%\">"+ t);
                  out.println("<td align=\"center\" width=\"25%\"><a href=\"/TCC/SalaAlterar?cod="+crs.getString(1)+"\">Alterar</a><td align=\"center\" width=\"25%\"><a href=\"http://localhost:8084/TCC/SalaExcluir?cod="+crs.getString(1)+"\">Excluir</a>");
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
        %>
    </table>
    
    </body>
</html>
