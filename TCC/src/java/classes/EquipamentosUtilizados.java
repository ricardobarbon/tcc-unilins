package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class EquipamentosUtilizados {
    
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public EquipamentosUtilizados() {
    }
    
    public void salvarDados(String codReserva, String codTipo){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
                
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into equipamentosutilizados values ("+codTipo+", "+codReserva+")");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void apagarReserva(String codReserva){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("delete from equipamentosutilizados where EquUtiResCod = "+ codReserva +"");
            statement.execute("delete from reserva where rescod = "+codReserva+"");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl buscarTiposDesc(String codReserva){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipodesc from equipamentosutilizados, tipo where EquUtiTipoCod = tipocod and EquUtiResCod = "+codReserva+"");
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
    
    public CachedRowSetImpl buscarTipos(String codReserva){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipocod, tipodesc from equipamentosutilizados, tipo where EquUtiTipoCod = tipocod and EquUtiResCod = "+codReserva+"");
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
