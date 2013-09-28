package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;
import java.lang.String;

public class Professor {
    private CachedRowSetImpl crs;
    Statement statement = null;
    Connection conexao;
    
    public Professor() {
    }
    
    public CachedRowSetImpl buscarProfessores(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioId, UsuarioNome, usuarioemail from usuario where usuarioTipo = 'PROFESSOR' and usuarioexcluido = false order by usuarionome");
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
    
    public String[] buscarEstados(){
        String estados[] = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", 
                            "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
                            "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
        return estados;
    }
    
    public boolean validarDados(String id, String nome, String endereco, String bairro, String cidade, String uf, String cep, String telCelular, String dataNascDia, String dataNascMes, String dataNascAno, String email){
        
        if((id.length()<2)||(nome.length()<7)||(endereco.length()<7)||(bairro.length()<2)||(cidade.length()<2)||(uf.length()<2)||(cep.length()<8)||(telCelular.length()<8)||(dataNascDia.length()<1)||(dataNascMes.length()<1)||(dataNascAno.length()<4)||(email.length()<6)){
            return false;
        }
        
        int dia = Integer.parseInt(dataNascDia);
        int mes = Integer.parseInt(dataNascMes);
        int ano = Integer.parseInt(dataNascAno);
        
        GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);
        
        if((dia!= data.get(Calendar.DAY_OF_MONTH))||(mes!= data.get(Calendar.MONTH) + 1)||(ano!=data.get(Calendar.YEAR))){
            return false;
        }
        
        /*int arroba = email.indexOf("@");
        if (arroba == -1){
            return false;
        }
        
        String resto = email.substring(arroba, email.length() - 1);
        int ponto = resto.indexOf(".");
        
        if (ponto == -1){
            return false;
        }
        else if((ponto-arroba)<2){
            return false;
        }
        else return true;*/
        return true;
    }
    
    public CachedRowSetImpl idJaCadastrado(String id){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioId, usuarionome from usuario where usuarioId = '"+id+"' and usuarioexcluido = false and usuarioTipo='PROFESSOR'");
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
    
    public void salvarDados(String id, String nome, String endereco, String bairro, String cidade, String uf, String cep, String telFixo, String telCelular, String dataNascDia, String dataNascMes, String dataNascAno, String email, String senha){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
        endereco = endereco.toUpperCase();
        bairro = bairro.toUpperCase();
        cidade = cidade.toUpperCase();
        uf = uf.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into usuario values ('"+id+"', '"+nome+"', '"+dataNascAno+"/"+dataNascMes+"/"+dataNascDia+"', '"+email+"', '"+senha+"', 'PROFESSOR')");
            statement.execute("insert into professor values('"+id+"', '"+endereco+"', '"+bairro+"', '"+cidade+"', '"+uf+"', '"+telFixo+"', '"+telCelular+"', '"+cep+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }

    public Connection getConexao() {
        return conexao;
    }
    
    public String gerarSenha(){
        
        int d;
        String senha = "";
        
        Random rand = new Random();
        
        for (int i=0; i<6; i++){
            d = rand.nextInt() % 10;
            if (d<0){
                d = d * -1;
            }
            senha = senha + d;
        }
        
        return senha;
    }
    
    public CachedRowSetImpl buscarProfessor(String id){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioId, usuarionome, ProfEndereco, profbairro, profcidade, profestado, profcep, proftelfixo, proftelcel, to_char(usuariodatanasc, 'DD'), to_char(usuariodatanasc, 'MM'), to_char(usuariodataNasc, 'YYYY'), usuarioemail from usuario, professor where usuarioId = '"+id+"' and usuarioexcluido = false and usuarioTipo='PROFESSOR' and usuarioid = profusuarioid");
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
    
    public void atualizarDados(String id, String nome, String endereco, String bairro, String cidade, String uf, String cep, String telFixo, String telCelular, String dataNascDia, String dataNascMes, String dataNascAno, String email){
        
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        int alterou = 0;
        
        conexao.conectando();
        
        nome = nome.toUpperCase();
        endereco = endereco.toUpperCase();
        bairro = bairro.toUpperCase();
        cidade = cidade.toUpperCase();
        uf = uf.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            alterou = statement.executeUpdate("update usuario set usuarionome = '"+nome+"', usuarioDatanasc = '"+dataNascAno+"/"+dataNascMes+"/"+dataNascDia+"', usuarioemail = '"+email+"' where usuarioid='"+ id +"'");
            alterou = statement.executeUpdate("update professor set profendereco = '"+endereco+"', profbairro = '"+bairro+"', profcidade = '"+cidade+"', profestado='"+uf+"', proftelfixo = '"+telFixo+"', proftelcel = '"+telCelular+"', profcep = '"+cep+"' where profusuarioid='"+ id +"'");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void excluirProfessor(String id){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update usuario set usuarioexcluido = true where usuarioid='"+ id +"'");
            
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl procurarProfessor(String prof){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        prof = prof.toUpperCase();
        
        conexao.conectando();
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioId, usuarionome, usuarioemail from usuario where usuarionome like '%"+prof+"%' and usuarioexcluido = false and usuarioTipo='PROFESSOR' order by usuarionome");
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
}
