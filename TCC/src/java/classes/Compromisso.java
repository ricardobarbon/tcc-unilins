package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;
import java.lang.String;

public class Compromisso {
    
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public Compromisso() {
    }
    
    public CachedRowSetImpl buscarCompromissos(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select comcod, to_char(comdata, 'DD'), to_char(comdata, 'MM'), to_char(comdata, 'YYYY'), to_char(comhora, 'HH24'), to_char(comhora, 'MI'), comDescricao from compromisso where comdata >= CURRENT_DATE order by comdata, comhora");
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
    
    public CachedRowSetImpl buscarCompromisso(String desc){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        desc = desc.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select comcod, to_char(comdata, 'DD'), to_char(comdata, 'MM'), to_char(comdata, 'YYYY'), to_char(comhora, 'HH24'), to_char(comhora, 'MI'), comDescricao from compromisso where comdata >= CURRENT_DATE and comdescricao like '%"+desc+"%' order by comdata, comhora");
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
    
    public boolean validarDados(String dia, String mes, String ano, String descricao, String hora, String min){
        
        int idia=0, imes=0, iano=0;
        
        
        idia = Integer.parseInt(dia);
        imes = Integer.parseInt(mes);
        iano = Integer.parseInt(ano);
        
        GregorianCalendar data = new GregorianCalendar(iano, imes-1, idia);
        
        if((idia!=data.get(Calendar.DAY_OF_MONTH))||(imes!=data.get(Calendar.MONTH)+1)||(iano!=data.get(Calendar.YEAR))){
            return false;
        }
        if((hora.length()<1)||(min.length()<2)){
            return false;
        }
        return true;
    }
    
    public void salvarDados(String descricao, String dia, String mes, String ano, String hora, String min, String aviso){
        
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        descricao = descricao.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into compromisso(comdescricao, comdata, comhora, comaviso) values ('"+descricao+"', '"+ano+"/"+mes+"/"+dia+"', '"+hora+":"+min+"', "+aviso+")");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl buscarCompromissoAlterar(String comCod){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select comcod, to_char(comdata, 'DD'), to_char(comdata, 'MM'), to_char(comdata, 'YYYY'), to_char(comhora, 'HH24'), to_char(comhora, 'MI'), comDescricao, comaviso from compromisso where comdata >= CURRENT_DATE and comcod = "+comCod+" order by comdata, comhora");
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
    
    public void atualizarDados(String comCod, String dia, String mes, String ano, String descricao, String hora, String min, String aviso){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        descricao = descricao.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update compromisso set comdata = '"+ano+"/"+mes+"/"+dia+"', comhora = '"+hora+":"+min+"', comDescricao='"+descricao+"', comaviso = "+aviso+" where comcod="+ comCod +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void excluir(String comCod){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("delete from compromisso where comcod = "+comCod+"");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
}
