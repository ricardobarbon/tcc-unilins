<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Professor - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerAlterarProfessor.jpg"><br>
		<% CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("professor");
                   Professor prof = new Professor();
                   GregorianCalendar data = new GregorianCalendar();
                   int anoag = data.get(Calendar.YEAR);
                %>
		<table width="100%"  border="0"><form action="ProfessorAtualizar" method="post">
  <tr>
    <td width="20%" align="right">ID:</td>
    <% crs.beforeFirst(); crs.next(); out.println("<td width=\"22%\">"+crs.getString(1)+"</td>");%>
    <td width="13%">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">Nome:</td>
    <%out.println("<td colspan=\"4\"><input size=\"80\" maxlength=\"79\" type=\"text\" name=\"nome\" value=\""+crs.getString(2)+"\"></td>");%>
    
  </tr>
  <tr>
    <td align="right">Endere&ccedil;o:</td>
    <%out.println("<td colspan=\"4\"><input size=\"80\" maxlength=\"79\" type=\"text\" name=\"endereco\" value=\""+crs.getString(3)+"\"></td>");%>
    
  </tr>
  <tr>
    <td align="right">Bairro:</td>
    <%out.println("<td><input type=\"text\" name=\"bairro\" size=\"50\" maxlength=\"49\" value=\""+crs.getString(4)+"\"></td>");%>
    <td align="right">&nbsp;</td>
        <td width="26%">&nbsp;</td>
	<td width="28%" align="left">&nbsp;
	<td width="1%">&nbsp;	  </td>
  </tr>
  <tr>
    <td align="right">CEP:</td>
        <%out.print("<td colspan=\"4\"><input size=\"9\" maxlength=\"9\" type=\"text\" name=\"cep\" value=\""+crs.getString(7)+"\">");%>&nbsp;&nbsp;
        Cidade:&nbsp;<%out.print("<input size=\"40\" maxlength=\"39\" type=\"text\" name=\"cidade\" value=\""+crs.getString(5)+"\">");%> &nbsp;&nbsp;
        UF:&nbsp;<select name="uf"><option value=""> </option>
            <%String estados[] = prof.buscarEstados();
                for (int i=0; i < 27; i++){
                    if(estados[i].compareToIgnoreCase(crs.getString(6))==0){
                        out.println("<option value=\""+estados[i]+"\" selected>"+estados[i]+"</option>");
                    }
                    else{
                        out.println("<option value=\""+estados[i]+"\">"+estados[i]+"</option>");
                    }
                }%>
           </select></td>
        </td>
  </tr>
  <tr>
    <td align="right">Tel. Fixo: </td>
        <td colspan="4"><%out.print("<input size=\"12\" maxlength=\"12\" type=\"text\" name=\"telFixo\" value=\""+crs.getString(8)+"\">");%>&nbsp;&nbsp;Tel. Celular:&nbsp;<%out.println("<input size=\"12\" maxlength=\"12\" type=\"text\" name=\"telCelular\" value=\""+crs.getString(9)+"\"></td>");%>
        </td>
    <td align="right"></td>
        <td>&nbsp;</td>
  </tr>
  <%int dia = crs.getInt(10);
    int mes = crs.getInt(11);
    int ano = crs.getInt(12);
    out.println("<tr>");
    out.println("<td align=\"right\">Data Nasc: </td>");
                out.print("<td><select name=\"dataNascDia\"><option value=\"\"> </option>");
                for(int d = 1; d < 32; d++){
                    if(d==dia){
                        out.println("<option value=\""+d+"\" selected>"+d+"</option>");
                    }
                    else{
                        out.println("<option value=\""+d+"\">"+d+"</option>");
                    }
                }
            out.print("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascMes\"><option value=\"\"> </option>");
                for(int m = 1; m < 13; m++){
                    if(m == mes){
                        out.println("<option value=\""+m+"\" selected>"+m+"</option>");
                    }
                    else{
                        out.println("<option value=\""+m+"\">"+m+"</option>");
                    }
                }
            out.println("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascAno\"><option value=\"\"> </option>");
               for(int a = anoag - 80; a < anoag - 15; a++){
                   if(a == ano){
                       out.println("<option value=\""+a+"\"selected>"+a+"</option>");
                   }
                   else{
                       out.println("<option value=\""+a+"\">"+a+"</option>");
                   }
               }
            out.println("</select></td>");
    out.println("<td>&nbsp;</td>");
  out.println("</tr>");%>
  <tr>
    <td align="right">E-mail:</td>
    <%out.println("<td colspan=\"3\"><input size=\"50\" maxlength=\"49\" type=\"text\" name=\"email\" value=\""+crs.getString(13)+"\"></td>");%>
    <td>&nbsp;</td>
  </tr>
  <tr><% request.setAttribute("professor", crs);%>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td><input type="submit" name="concluir" value="Concluir"></form></td>
    <td><form action="secretariaProfessores" method="get"><input type="submit" value=Cancelar></form></td>
  </tr>

 
</table>
    </table>  
    
    </body>
</html>
