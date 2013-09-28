<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

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
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerCursos.jpg"><br>
        <table width="100%"  border="0">
                    <tr bgcolor="#E4E4E4">
                    <td align="center">
                    <form action="CursoProcurar" method="post"><input name="procurarCurso" type="text" size="55">
        	        <input type="submit" name="procurar" value="Procurar"></form><td align="center"><form action="CursoCadastrar" method="post"><input name="inserirCurso" type="submit" value="Inserir Curso"></form>
                    </tr>
	</table>
        <% /*String m = (String)request.getAttribute("mensagem");*/
           /*if (m.length()>1){
            out.println("<center><b><h3>"+ m +"</h3></b></center>");
           }
           else{
        */
           CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("cursos"); 

           if (crs.size()==0){
              out.println("<center><b>NENHUM CURSO CADASTRADO...</b></center>");
           }
           else{
              out.println("<table width=\"100%\" border=\"0\">");
              out.println("<tr bgcolor=\"#E4E4E4\">");
              out.println("<td align=\"center\" width=\"50%\"><b>CURSO</b><td align=\"center\" width=\"25%\"><td align=\"center\" width=\"25%\">");
              out.println("</tr>");
              
              int cont = 2;
              while (crs.next()){
                  if ((cont % 2) == 0){
                     out.println("<tr>");
                  }
                  else{
                     out.println("<tr bgcolor=\"#F2F2F3\">"); 
                  }
                  out.println("<td align=\"center\" width=\"50%\">" + crs.getString(2) + "<td align=\"center\" width=\"25%\"><a href=\"http://localhost:8084/TCC/cursoAlterar?cod="+crs.getString(1)+"\">Alterar</a><td align=\"center\" width=\"25%\"><a href=\"http://localhost:8084/TCC/cursoExcluir?cod="+crs.getString(1)+"\">Excluir</a>");
                  out.println("</tr>");
                  
                  cont++;
              }
              out.println("</table>");
           }
           %>
    </table>
    
    </body>
</html>
