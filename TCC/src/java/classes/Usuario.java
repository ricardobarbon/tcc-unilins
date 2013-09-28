package classes;

import java.util.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import com.sun.rowset.CachedRowSetImpl;

public class Usuario {
    
    private String id;
    private String nome;
    private GregorianCalendar dataNasc;
    private String email;
    private String senha;
    private String tipo;
    private boolean excluido;
    
    private CachedRowSetImpl crs;
    Statement statement = null;
    Connection conexao;
    
    public Usuario() {
        
        id = "";
        nome = "";
        dataNasc = new GregorianCalendar();
        email = "";
        senha = "";
        tipo = "";
        excluido = false;
    }
    
    public void setId(String i){
        id = i;
    }
    
    public void setNome(String n){
        nome = n;
    }
    
    public void setDataNasc(int d, int m, int a){
        dataNasc.set(a, m - 1, d);
    }
    
    public void setEmail(String e){
        email = e;
    }
    
    public void setSenha(String s){
        senha = s;
    }
    
    public void setTipo(String t){
        tipo = t;
    }
    
    public void setExcluidoTrue(){
        excluido = true;
    }
    
    public void setExcluidoFalse(){
        excluido = false;
    }
    
    public String getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getDataNasc(){
        int dia = dataNasc.get(Calendar.DAY_OF_MONTH);
        int mes = dataNasc.get(Calendar.MONTH) + 1;
        int ano = dataNasc.get(Calendar.YEAR);
        
        String data = dia + " / " + mes + " / "+ ano;
        
        return data;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public boolean getExcluido(){
        return excluido;
    }
    
    public CachedRowSetImpl conectar(String i){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select UsuarioID, UsuarioSenha, UsuarioTipo from Usuario where UsuarioID = '"+ i +"' and UsuarioExcluido = false");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        try{
           crs = new CachedRowSetImpl(); 
           crs.populate(resultSet);
        }
        catch (Exception e){
        }
        
        conexao.desconectando();
        
        return crs;
    }
    
    public CachedRowSetImpl buscarUsuario(String id){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select UsuarioID, usuarioNome, to_char(usuarioDataNasc, 'DD'), to_char(usuarioDataNasc, 'MM'), to_char(usuarioDataNasc, 'YYYY'), usuarioemail, usuariotipo, usuarioSenha from Usuario where UsuarioID = '"+ id +"' and UsuarioExcluido = false");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        try{
           crs = new CachedRowSetImpl(); 
           crs.populate(resultSet);
        }
        catch (Exception e){
        }
        
        conexao.desconectando();
        
        return crs;
    }
    
    public boolean validarDados(String nome, String dia, String mes, String ano, String emailUm, String emailDois){
        
        if((nome.length()<7)||(emailUm.compareTo(emailDois)!=0)){
            return false;
        }
        int idia = Integer.parseInt(dia);
        int imes = Integer.parseInt(mes);
        int iano = Integer.parseInt(ano);
        
        GregorianCalendar data = new GregorianCalendar(iano, imes-1, idia);
        
        if ((data.get(Calendar.DAY_OF_MONTH)!=idia)||(data.get(Calendar.MONTH)+1!=imes)||(data.get(Calendar.YEAR)!=iano)){
            return false;
        }
        else return true;
    }
    
    public void atualizarDados(String id, String nome, String dia, String mes, String ano, String email){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update usuario set usuarionome = '"+nome+"', usuariodatanasc = '"+ano+"/"+mes+"/"+dia+"', usuarioemail = '"+email+"' where usuarioid='"+ id +"'");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public boolean validarNovaSenha(String id, String senhaAtual, String novaSenha, String confirmaNovaSenha){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioSenha from Usuario where UsuarioID = '"+ id +"' and UsuarioExcluido = false");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        try{
           crs = new CachedRowSetImpl(); 
           crs.populate(resultSet);
        }
        catch (Exception e){
        }
        
        conexao.desconectando();
        
        String senha = "";
        try{
            crs.next();
            senha = crs.getString(1);
        }
        catch(Exception e){
            
        }
        
        if ((senha.compareTo(senhaAtual)==0)&&(novaSenha.compareTo(confirmaNovaSenha)==0)){
            return true;
        }
        else
            return false;
    }
    
    public void atualizarSenha(String id, String novaSenha){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update usuario set usuariosenha = '"+novaSenha+"' where usuarioid='"+ id +"'");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public boolean validarSenha(String id, String senhaDig){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioSenha from Usuario where UsuarioID = '"+ id +"' and UsuarioExcluido = false");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        try{
           crs = new CachedRowSetImpl(); 
           crs.populate(resultSet);
        }
        catch (Exception e){
        }
        
        conexao.desconectando();
        
        String senha = "";
        try{
            crs.next();
            senha = crs.getString(1);
        }
        catch(Exception e){
            
        }
        
        if (senha.compareTo(senhaDig)==0){
            return true;
        }
        else
            return false;
    }
    
    public CachedRowSetImpl buscarUsuarios(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select UsuarioID, usuarioNome, usuariotipo, usuarioemail from Usuario where Usuariotipo <> 'PROFESSOR' and UsuarioExcluido = false order by usuarionome");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        try{
           crs = new CachedRowSetImpl(); 
           crs.populate(resultSet);
        }
        catch (Exception e){
        }
        
        conexao.desconectando();
        
        return crs;
    }
    public void atualizarDadosAdmin(String id, String nome, String dia, String mes, String ano, String email, String tipo){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update usuario set usuarionome = '"+nome+"', usuariodatanasc = '"+ano+"/"+mes+"/"+dia+"', usuarioemail = '"+email+"', usuariotipo = '"+tipo+"' where usuarioid='"+ id +"'");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void excluirUsuario(String usuarioId){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update usuario set usuarioexcluido = true where usuarioid='"+ usuarioId +"'");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void salvarDados(String id, String nome, String dia, String mes, String ano, String tipo, String email, String senha){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into usuario values ('"+id+"', '"+nome+"', '"+ano+"/"+mes+"/"+dia+"', '"+email+"', '"+senha+"', '"+tipo+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl procurarUsuario(String proc){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        proc=proc.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select UsuarioID, usuarioNome, usuariotipo, usuarioemail from Usuario where Usuarionome  like '%"+ proc +"%' and usuariotipo <> 'PROFESSOR' and UsuarioExcluido = false order by usuarionome");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        try{
           crs = new CachedRowSetImpl(); 
           crs.populate(resultSet);
        }
        catch (Exception e){
        }
        
        conexao.desconectando();
        
        return crs;
    }
    
    public boolean validarDados(String id, String dia, String mes, String ano){
        
        if(id.length()<3){
            return false;
        }
        
        int idia = Integer.parseInt(dia);
        int imes = Integer.parseInt(mes);
        int iano = Integer.parseInt(ano);
        
        GregorianCalendar data = new GregorianCalendar(iano, imes-1, idia);
        
        if((idia!=data.get(Calendar.DAY_OF_MONTH))||(imes!=data.get(Calendar.MONTH)+1)||(iano!=data.get(Calendar.YEAR))){
            return false;
        }
        return true;
    }
}
