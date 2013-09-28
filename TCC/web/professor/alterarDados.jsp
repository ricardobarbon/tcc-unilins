<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.util.*"%> 
<%@ page import="classes.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Dados - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuProfessor.htm" %> <td valign="top"><p><img src="Imagens/pagProfessor/headerAltereOsDadosDesejados.jpg"><br>
          <table width="100%"  border="0"><form action="ProfessorAlterarDadosProf" method="post">
  <% Professor prof = new Professor();
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
    String emailUm = (String)request.getAttribute("emailUm");
    String emailDois = (String)request.getAttribute("emailDois");%>
  <tr>
      <td width="15%" align="right"><b>ID: </b></td>
    <td width="22%"><% out.print(id);%></td>
    <td width="13%">&nbsp;</td>
  </tr>
  <tr>
      <td align="right"><b>Nome: </b></td>
    <td colspan="4"><input size="80" maxlength="79" type="text" name="nome" <% out.print("value=\""+nome+"\"");%>></td>
    
  </tr>
  <tr>
    <td align="right"><b>Endere&ccedil;o: </b></td>
    <td colspan="4"><input size="80" maxlength="79" type="text" name="endereco" <% out.print("value=\""+endereco+"\"");%>></td>
    
  </tr>
  <tr>
      <td align="right"><b>Bairro: </b></td>
    <td><input type="text" name="bairro" size="50" maxlength="49" <% out.print("value=\""+bairro+"\"");%>></td>
    <td align="right">&nbsp;</td>
        <td width="26%">&nbsp;</td>
	<td width="28%" align="left">&nbsp;
	<td width="1%">&nbsp;	  </td>
  </tr>
  <tr>
        <td align="right"><b>CEP: </b></td>
        <td colspan="4"><input type = "text" name="cep" size="9" maxlength="9" <% out.print("value=\""+cep+"\"");%>>&nbsp;&nbsp;
            <b>Cidade:</b>&nbsp;<input size="40" maxlength="39" type="text" name="cidade" <% out.print("value=\""+cidade+"\"");%>> &nbsp;&nbsp;
                <b>UF:</b>&nbsp;<% out.println("<select name=\"uf\">");
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
                out.println("</select>");%></td>
        </td>
  </tr>
  <tr>
    <td align="right"><b>Tel. Fixo: </b></td>
        <td colspan="4"><input size="12" maxlength="12" type="text" name="telFixo" <% out.print("value=\""+telFixo+"\"");%>>&nbsp;&nbsp;<b>Tel. Celular:</b>&nbsp;<input size="12" maxlength="12" type="text" name="telCelular" <% out.print("value=\""+telCelular+"\"");%>>
        </td>
    <td align="right"></td>
        <td>&nbsp;</td>
  </tr>
  <tr>
      <td align="right"><b>Data Nasc: </b></td>
    <td><% out.print("<select name=\"dataNascDia\"><option value=\"\"> </option>");
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
            out.println("</select></td>");%></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
      <td align="right"><b>E-mail: </b></td>
    <td colspan="3"><input size="50" maxlength="49" type="text" name="emailUm" value="<%out.println(emailUm);%>"></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right"><b>E-mail: </b></td>
    <td colspan="3"><input size="50" maxlength="49" type="text" name="emailDois" value="<%out.println(emailDois);%>"></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
        <td align="right"><b>Senha: </b></td>
        <td><%out.println("<a href=\"http://localhost:8084/TCC/AlterarSenhaProf?id=\""+id+"\" title=\"Clique aqui para alterar a senha\">Alterar Senha</a></td>");%>
        </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td><input type="submit" name="concluir" value="Concluir"></form></td>
    <td><form action="meuCadastroProf" method="get"><input type="submit" value=Cancelar></form></td>
  </tr>

</table>
<% String mensagem = (String)request.getAttribute("mensagem");
    if(mensagem!=null){
       out.println("<center>"+mensagem+"</center>");
    }%>
 
            </table>
    
    </body>
</html>
