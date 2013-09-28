package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class EquipamentoFixo {
    
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    
    public EquipamentoFixo() {
    }
    
    public CachedRowSetImpl buscarTipoDesc(String s){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipodesc from equipamentofixo, tipo where fixtipocod = tipocod and fixsalacod = "+s+"");
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
    
    public void salvarDados(String codSala, String codTipo){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into equipamentofixo values ("+codSala+","+codTipo+")");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void excluirEquipamentosFixos(String codSala){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("delete from equipamentoFixo where fixSalacod = "+ codSala +"");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl verificarEquipamentoFixo(String sala, String codTipo){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select * from equipamentofixo where fixtipocod = "+codTipo+" and fixsalacod = "+sala+"");
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
