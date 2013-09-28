package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class Tipo {
    
    private int codigoTipo;
    private String descricaoTipo;
    private boolean tipoExcluido;
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public Tipo() {
        
        codigoTipo = 0;
        descricaoTipo = "";
        tipoExcluido = true;
    }
    
    public void setCodigoTipo(int x){
        
        codigoTipo = x;
    }
    
    public void setDescricaoTipo(String s){
        
        descricaoTipo = s;
        
    }
    
    public void setTipoExcluidoTrue(){
        
        tipoExcluido = true;
    }
    
    public void setTipoExcluidoFalse(){
        
        tipoExcluido = false;
    }
    
    public int getCodigoTipo(){
        
        return codigoTipo;
    }
    
    public String getDescricaoTipo(){
        
        return descricaoTipo;
    }
    
    public boolean getTipoExcluido(){
        
        return tipoExcluido;
    }
    
    public CachedRowSetImpl buscarTipos(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipoCod, tipodesc from tipo where tipoExcluido = false order by tipodesc");
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
    
    public CachedRowSetImpl buscarTipo(String codTipo){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipoCod, tipoDesc from tipo where tipoCod = "+ codTipo+"");
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
    
    public boolean verificarDados(String s){
        
        setDescricaoTipo(s);
        
        if ((descricaoTipo.length() == 0) || (descricaoTipo == " ")){
            return false;
        }
        else{
            return salvarDados(descricaoTipo);
        }
        
    }
    
    public boolean salvarDados(String desc){
        boolean flag = true;
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        desc = desc.toUpperCase();  
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into tipo (tipodesc) values ('"+desc+"')");
            flag = true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            flag = false;
            System.exit(1);
        }
        
        conexao.desconectando();
        
        return flag;
    }
    
    public CachedRowSetImpl procurarTipo(String t){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        t = t.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipoCod, tipoDesc from tipo where tipoDesc like '%"+ t +"%' and tipoexcluido = false order by tipodesc");
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
    
    public int tipoAtualizar(String c,String d){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        int alterou = 0;
        
        conexao.conectando();
        
        d = d.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            alterou = statement.executeUpdate("update tipo set tipoDesc = '"+d+"' where tipoCod="+ c +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        return alterou;
    }
    
    public int tipoExcluir(String cod){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        int alterou = 0;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            alterou = statement.executeUpdate("update tipo set tipoExcluido = true where tipoCod="+ cod +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        return alterou;
    }
}
