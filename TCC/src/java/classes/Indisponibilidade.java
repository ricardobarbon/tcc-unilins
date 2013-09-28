package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class Indisponibilidade {

    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public Indisponibilidade() {
    }
    
    public void salvarDados(String tipoCod, String id, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
                
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into indisponibilidade(IndTipoCod, IndUsuarioID, IndData, IndHoraInicio, IndHoraTermino) values ("+tipoCod+",'"+id+"','"+ano+"/"+mes+"/"+dia+"','"+horaInicio+":"+minInicio+"', '"+horaTermino+":"+minTermino+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public String buscarCodInd(String tipoCod, String id, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select indCod from indisponibilidade where IndTipoCod = "+tipoCod+" and IndUsuarioID = '"+id+"' and IndData = '"+ano+"/"+mes+"/"+dia+"' and IndHoraInicio = '"+horaInicio+":"+minInicio+"' and IndHoraTermino = '"+horaTermino+":"+minTermino+"'");
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
        String codInd = "";
        try{
            crs.next();
            codInd = crs.getString(1);
        }
        catch(Exception e){
            
        }
        return codInd;
    }
    
    public void entrarListaInteressados(String codInd){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update indisponibilidade set indinteressado = true where indcod="+ codInd +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl buscarIndisponibilidades(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipoDesc, usuarionome, to_char(indData, 'DD/MM/YYYY'), to_char(indHoraInicio, 'HH24:MI'), to_char(indhoratermino, 'HH24:MI') from indisponibilidade, usuario, tipo where IndTipoCod = tipocod and IndUsuarioID = usuarioid order by tipodesc, inddata");
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
    
    public CachedRowSetImpl buscarIndisponibilidades(String diaInicio, String mesInicio, String anoInicio, String diaFim, String mesFim, String anoFim){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipoDesc, usuarionome, to_char(indData, 'DD/MM/YYYY'), to_char(indHoraInicio, 'HH24:MI'), to_char(indhoratermino, 'HH24:MI') from indisponibilidade, usuario, tipo where IndTipoCod = tipocod and IndUsuarioID = usuarioid and inddata between '"+anoInicio+"/"+mesInicio+"/"+diaInicio+"' and '"+anoFim+"/"+mesFim+"/"+diaFim+"' order by tipodesc, inddata");
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
