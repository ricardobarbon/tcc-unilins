<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="classes.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Cadastrar Professor - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuSecretaria.htm" %> <td valign="top"><img src="Imagens/pagSecretaria/headerCadastrarProfessor.jpg"><br>
<%  Professor prof = new Professor();
    GregorianCalendar data = new GregorianCalendar();
    int ano = data.get(Calendar.YEAR);
    
    String id = (String)request.getAttribute("id");
    String nome = (String)request.getAttribute("nome");
    String endereco = (String)request.getAttribute("endereco");
    String bairro = (String)request.getAttribute("bairro");
    String cidade = (String)request.getAttribute("cidade");
    String uf = (String)request.getAttribute("uf");
    String cep = (String)request.getAttribute("cep");
    String telFixo = (String)request.getAttribute("telFixo");
    String telCelular = (String)request.getAttribute("telCelular");
    String dataNascDia = (String)request.getAttribute("dataNascDia");
    String dataNascMes = (String)request.getAttribute("dataNascMes");
    String dataNascAno = (String)request.getAttribute("dataNascAno");
    String email = (String)request.getAttribute("email");
    
    if(id==null){
        out.println("<table width=\"100%\"  border=\"0\"><form action=\"ProfessorSalvar\" method=\"post\">");
          out.println("<tr>");
            out.println("<td width=\"11%\" align=\"right\">ID: </td>");
            out.println("<td width=\"22%\"><input type=\"text\" maxlength=\"6\" name=\"id\"></td>");
            out.println("<td width=\"12%\">&nbsp;</td>");
          out.println("</tr>");
          out.println("<tr>");
            out.println("<td align=\"right\">Nome: </td>");
            out.println("<td colspan=\"4\"><input size=\"80\" type=\"text\" maxlength=\"79\" name=\"nome\"></td>");
    
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Endere&ccedil;o: </td>");
            out.println("<td colspan=\"4\"><input size=\"80\" type=\"text\" maxlength=\"79\" name=\"endereco\"></td>");
    
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Bairro: </td>");
            out.println("<td><input type=\"text\" maxlength=\"49\" name=\"bairro\"></td>");
            out.println("<td align=\"right\">Cidade: </td>");
	        out.println("<td width=\"30%\"><input size=\"20\" type=\"text\" maxlength=\"39\" name=\"cidade\"></td>");
	        out.println("<td width=\"24%\" align=\"left\">UF: ");
                out.println("<select name=\"uf\">");
                out.println("<option value=\"\"> </option>");
                String estados[] = prof.buscarEstados();
                for (int i=0; i < 27; i++){
                    out.println("<option value=\""+estados[i]+"\">"+estados[i]+"</option>");
                }
                out.println("</select>");
                out.println("</td>");
	        out.println("<td width=\"1%\">&nbsp;	  </td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">CEP: </td>");
                out.println("<td><input size=\"9\" maxlength=\"9\" type=\"text\" name=\"cep\">");
                out.println("</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Tel. Fixo: </td>");
                out.println("<td><input size=\"12\" maxlength=\"12\" type=\"text\" name=\"telFixo\">");
                out.println("</td>");
            out.println("<td align=\"right\">Tel. Celular: </td>");
	        out.println("<td><input size=\"12\" maxlength=\"12\" type=\"text\" name=\"telCelular\"></td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Data Nasc: </td>");
            out.print("<td><select name=\"dataNascDia\"><option value=\"\"> </option>");
                for(int d = 1; d < 32; d++){
                    out.println("<option value=\""+d+"\">"+d+"</option>");
                }
            out.print("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascMes\"><option value=\"\"> </option>");
                for(int m = 1; m < 13; m++){
                    out.println("<option value=\""+m+"\">"+m+"</option>");
                }
            out.println("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascAno\"><option value=\"\"> </option>");
               for(int a = ano - 80; a < ano - 15; a++){
                   out.println("<option value=\""+a+"\">"+a+"</option>");
               }
            out.println("</select></td>");
            out.println("<td>&nbsp;</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">E-mail: </td>");
            out.println("<td colspan=\"3\"><input size=\"50\" maxlength=\"49\" type=\"text\" name=\"email\"></td>");
            out.println("<td>&nbsp;</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td colspan=\"2\">&nbsp;</td>");
            out.println("<td><input type=\"submit\" name=\"concluir\" value=\"Concluir\"></form></td>");
            out.println("<td><form action=\"secretariaProfessores\" method=\"get\"><input type=\"submit\" value=Cancelar></form></td>");
         out.println("</tr>");

       
      out.println("</table>");

    }
    else{
        out.println("<table width=\"100%\"  border=\"0\"><form action=\"ProfessorSalvar\" method=\"post\">");
          out.println("<tr>");
            out.println("<td width=\"11%\" align=\"right\">ID: </td>");
            out.println("<td width=\"22%\"><input type=\"text\" maxlength=\"6\" name=\"id\" value=\""+id+"\"></td>");
            out.println("<td width=\"12%\">&nbsp;</td>");
          out.println("</tr>");
          out.println("<tr>");
            out.println("<td align=\"right\">Nome: </td>");
            out.println("<td colspan=\"4\"><input size=\"80\" type=\"text\" maxlength=\"79\" name=\"nome\" value=\""+nome+"\"></td>");
    
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Endere&ccedil;o: </td>");
            out.println("<td colspan=\"4\"><input size=\"80\" type=\"text\" maxlength=\"79\" name=\"endereco\" value=\""+endereco+"\"></td>");
    
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Bairro: </td>");
            out.println("<td><input type=\"text\" maxlength=\"49\" name=\"bairro\" value=\""+bairro+"\"></td>");
            out.println("<td align=\"right\">Cidade: </td>");
	        out.println("<td width=\"30%\"><input size=\"20\" type=\"text\" maxlength=\"39\" name=\"cidade\" value=\""+cidade+"\"></td>");
	        out.println("<td width=\"24%\" align=\"left\">UF: ");
                out.println("<select name=\"uf\">");
                out.println("<option value=\"\"> </option>");
                String estados[] = prof.buscarEstados();
                for (int i=0; i < 27; i++){
                    if(estados[i].compareToIgnoreCase(uf)==0){
                        out.println("<option value=\""+estados[i]+"\" selected>"+estados[i]+"</option>");
                    }
                    else{
                        out.println("<option value=\""+estados[i]+"\">"+estados[i]+"</option>");
                    }
                }
                out.println("</select>");
                out.println("</td>");
	        out.println("<td width=\"1%\">&nbsp;	  </td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">CEP: </td>");
                out.println("<td><input size=\"9\" maxlength=\"9\" type=\"text\" name=\"cep\" value=\""+cep+"\">");
                out.println("</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Tel. Fixo: </td>");
                out.println("<td><input size=\"12\" maxlength=\"12\" type=\"text\" name=\"telFixo\" value=\""+telFixo+"\">");
                out.println("</td>");
            out.println("<td align=\"right\">Tel. Celular: </td>");
	        out.println("<td><input size=\"12\" maxlength=\"12\" type=\"text\" name=\"telCelular\" value=\""+telCelular+"\"></td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">Data Nasc: </td>");
            out.print("<td><select name=\"dataNascDia\"><option value=\"\"> </option>");
                for(int d = 1; d < 32; d++){
                    if(d==Integer.parseInt(dataNascDia)){
                        out.println("<option value=\""+d+"\" selected>"+d+"</option>");
                    }
                    else{
                        out.println("<option value=\""+d+"\">"+d+"</option>");
                    }
                }
            out.print("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascMes\"><option value=\"\"> </option>");
                for(int m = 1; m < 13; m++){
                    if(m == Integer.parseInt(dataNascMes)){
                        out.println("<option value=\""+m+"\" selected>"+m+"</option>");
                    }
                    else{
                        out.println("<option value=\""+m+"\">"+m+"</option>");
                    }
                }
            out.println("</select>&nbsp;/&nbsp;");
            out.print("<select name=\"dataNascAno\"><option value=\"\"> </option>");
               for(int a = ano - 80; a < ano - 15; a++){
                   if(a == Integer.parseInt(dataNascAno)){
                       out.println("<option value=\""+a+"\"selected>"+a+"</option>");
                   }
                   else{
                       out.println("<option value=\""+a+"\">"+a+"</option>");
                   }
               }
            out.println("</select></td>");
            out.println("<td>&nbsp;</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td align=\"right\">E-mail: </td>");
            out.println("<td colspan=\"3\"><input size=\"50\" maxlength=\"49\" type=\"text\" name=\"email\" value=\""+email+"\"></td>");
            out.println("<td>&nbsp;</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
         out.println("</tr>");
         out.println("<tr>");
            out.println("<td colspan=\"2\">&nbsp;</td>");
            out.println("<td><input type=\"submit\" name=\"concluir\" value=\"Concluir\"></form></td>");
            out.println("<td><form action=\"secretariaProfessores\" method=\"get\"><input type=\"submit\" value=Cancelar></form></td>");
         out.println("</tr>");

       
      out.println("</table>");
      
      out.println("<center><b> Dados Inválidos...</b></center>");

    }
    %>		
    
    </table>
    
    </body>
</html>
