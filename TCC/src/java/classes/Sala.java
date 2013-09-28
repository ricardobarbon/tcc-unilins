package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class Sala {
    
    private String descricaoSala;
    private String numeroSala;
    private boolean salaExcluida;
    
    Statement statement = null;
    Connection conexao;
    
    CachedRowSetImpl crs;
    
    public Sala() {
        
        descricaoSala = "";
        numeroSala = "";
        salaExcluida = true;
    }
    
    public void setDescricaoSala(String s){
        
        descricaoSala = s;
    }
    
    public void setNumeroSala(String s){
        
        numeroSala = s;
    }
    
    public void setSalaExcluidaTrue(){
        
        salaExcluida = true;
    }
    
    public void setSalaExcluidaFalse(){
        
        salaExcluida = false;
    }
    
    public String getDescricaoSala(){
        
        return descricaoSala;
    }
    
    public String getNumeroSala(){
        
        return numeroSala;
    }
    
    public boolean getSalaExcluida(){
        
        return salaExcluida;
    }
    
    public CachedRowSetImpl buscarSalas(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select salacod, salaDescricao from sala where salaExcluida = false order by salaDescricao");
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
    
    public boolean verificarDados(String desc){
        
        if(desc.length()<4) 
            return false;
        else 
            return true;
    }
    
    public void salvarDados(String desc){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        desc = desc.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into sala(saladescricao) values ('"+desc+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public String buscarCodSala(String desc){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        desc = desc.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select salacod from sala where saladescricao = '"+desc+"'");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        String codTipo = "";
        
        try{
           resultSet.next();
           codTipo = resultSet.getString(1);
        }
        catch(Exception e){
            
        }
        
        conexao.desconectando();
        
        return codTipo;
    }
    
    public String buscarSalaDescricao(String codSala){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select salaDescricao from sala where salacod = "+codSala+"");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        String salaDescricao = "";
        
        try{
           resultSet.next();
           salaDescricao = resultSet.getString(1);
        }
        catch(Exception e){
            
        }
        
        conexao.desconectando();
        
        return salaDescricao;
    }
    
    public void atualizarDados(String codSala, String desc){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        desc = desc.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update sala set salaDescricao = '"+desc+"' where salaCod="+ codSala +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void excluirSala(String codSala){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update sala set salaExcluida = true where salaCod="+ codSala +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl buscarSalas(String desc){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        desc = desc.toUpperCase();
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select salacod, salaDescricao from sala where saladescricao like '%"+desc+"%' and salaExcluida = false order by salaDescricao");
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
