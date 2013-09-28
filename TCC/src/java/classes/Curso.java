package classes;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import com.sun.rowset.CachedRowSetImpl;

public class Curso {
    
    private int codCurso;
    private String nomeCurso;
    private boolean cursoExcluido;
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public Curso() {
        codCurso = 0;
        nomeCurso = "";
        cursoExcluido = true;
    }
    
    public Curso(int c, String n){
        
        codCurso = c;
        nomeCurso = n;
        cursoExcluido = false;
    }
    
    public void setCodCurso(int x){
        
        codCurso = x;
    }
    
    public void setNomeCurso(String s){
        
        nomeCurso = s;
    }
    
    public void setCursoExcluidoFalse(){
        
        cursoExcluido = false;
    }
    
    public void setCursoExcluidoTrue(){
        
        cursoExcluido = true;
    }
    
    public int getCodCurso(){
        
        return codCurso;
    }
    
    public String getNomeCurso(){
        
        return nomeCurso;
    }
    
    public boolean getCursoExcluido(){
        
        return cursoExcluido;
    }
    
    public CachedRowSetImpl buscarCursos(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select cursoCod, cursoNome from curso where cursoExcluido = false order by cursoNome");
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
        
        setNomeCurso(s);
        
        if ((nomeCurso.length() == 0) || (nomeCurso == " ")){
            return false;
        }
        else{
            return salvarDados(nomeCurso);
        }
        
    }
    public boolean salvarDados(String desc){
        boolean flag = true;
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        desc = desc.toUpperCase();  
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into curso (cursoNome) values ('"+desc+"')");
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
    
    public CachedRowSetImpl procurarCurso(String c){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        c = c.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select cursoCod, cursoNome from curso where cursoNome like '%"+ c +"%' and cursoexcluido = false order by cursoNome");
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
    
    public CachedRowSetImpl buscarCurso(String codCurso){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select cursoCod, cursoNome from curso where cursoCod=" + codCurso);
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
    
    public int cursoAtualizar(String c,String d){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        int alterou = 0;
        
        conexao.conectando();
        
        d = d.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            alterou = statement.executeUpdate("update curso set cursoNome = '"+d+"' where cursoCod="+ c +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
        
        return alterou;
    }
    
    public int cursoExcluir(String c){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        int alterou = 0;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            alterou = statement.executeUpdate("update curso set cursoExcluido = true where cursoCod="+ c +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        return alterou;
    }
    
}
