<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="classes.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&laquo; Alterar Sala - SisCRE &raquo;</title>
    </head>
    <body>

    <%@include file="/Topo.htm" %>
    
    <table width="100%">
        <tr> <td width="18%" valign="top"> <%@include file="/menuAudio.htm" %> <td valign="top"><img src="Imagens/pagAudio/headerAlterarSala.jpg"><br>
		<table width="100%" border="0"><form action="SalaAtualizar" method="post">
  <tr>
    <td align="right" width="13%">Descrição: </td>
    <% String salaDesc = (String)request.getAttribute("salaDescricao");
       CachedRowSetImpl crs = (CachedRowSetImpl)request.getAttribute("equFixo");
       CachedRowSetImpl crst;
       Tipo tipo = new Tipo();
       String mensagem = (String)request.getAttribute("mensagem");
       
       out.println("<td width=\"37%\"><input name=\"descricao\" type=\"text\" size=\"50\" maxlength=\"49\" value=\""+salaDesc+"\"></td>");
       %>
    
    <td>&nbsp;</td>
  </tr>
  <tr align="center" valign="middle" bgcolor="#E4E4E4">
    <td colspan="3"><h3><b>Se houver, quais são os Equipamentos Fixos... </b></h3></td>
  </tr>
  <% try{
           crst = new CachedRowSetImpl();
     }
     catch(Exception e){
         
     }
          
     crst = tipo.buscarTipos();
     
     if (crst.size()==0){
         out.println("Nenhum tipo Cadastrado...");
     }
     else if(crs == null){
         int c = 0;
         crst.beforeFirst();
         while(crst.next()){
             if(c == 0 ){
                 out.println("<tr>");
                 out.println("<td colspan=\"2\"><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\""+crst.getString(1)+"\">"+crst.getString(2)+"</td>");
                 c = 1;
             }
             else{
                 out.println("<td><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\""+crst.getString(1)+"\">"+crst.getString(2)+"</td>"); 
                 out.println("</tr>");
                 c = 0;
             }
         }
     }
     else {
         boolean igual;
         int i = 0;
         crst.beforeFirst();
         while(crst.next()){
             igual = false;
             if(i==0){
                 crs.beforeFirst();
                 while(crs.next()){
                     if(crs.getString(1).compareToIgnoreCase(crst.getString(2))==0){
                         igual = true;
                     }
                 }
                 if (igual){
                     out.println("<tr>");
                     out.println("<td colspan=\"2\"><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\""+crst.getString(1)+"\" checked>"+crst.getString(2)+"</td>");
                     i = 1;
                 }
                 else{
                     out.println("<tr>");
                     out.println("<td colspan=\"2\"><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\""+crst.getString(1)+"\">"+crst.getString(2)+"</td>");
                     i = 1;
                 }
             }
             else{
                 crs.beforeFirst();
                 while(crs.next()){
                     if(crs.getString(1).compareToIgnoreCase(crst.getString(2))==0){
                         igual = true;
                     }
                 }
                 if(igual){
                     out.println("<td><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\""+crst.getString(1)+"\" checked>"+crst.getString(2)+"</td>"); 
                     out.println("</tr>");
                     i = 0;
                 }
                 else{
                     out.println("<td><input name=\""+crst.getString(2)+"\" type=\"checkbox\" value=\""+crst.getString(1)+"\">"+crst.getString(2)+"</td>"); 
                     out.println("</tr>");
                     i = 0;
                 }
             }
         }
     }
  %>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" value="Salvar"></form></td>
    <td><form action="salas" method="get"><input name="cancelar" type="submit" value="Cancelar"></form></td>
  </tr>
</table>

    </table>
    
    </body>
</html>
