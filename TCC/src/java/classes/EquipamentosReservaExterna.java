package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class EquipamentosReservaExterna {
    
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public EquipamentosReservaExterna() {
    }
    
    public int buscarQtdeEquipamentoReservado(String codTipo, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select count(*) from reservaexterna, equipamentosresext where ResExtCod = EquExtResCod and EquExtTipoCod = "+codTipo+" and ResExtData = '"+ano+"/"+mes+"/"+dia+"' and ((ResExtHoraTermino > '"+horaInicio+":"+minInicio+"' and ResExtHoraTermino <= '"+horaTermino+":"+minTermino+"') or (ResExtHoraInicio >= '"+horaInicio+":"+minInicio+"' and ResExtHoraInicio < '"+horaTermino+":"+minTermino+"'))");
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
        
        int qtde = 0;
        
        try{
            crs.next();
            qtde = crs.getInt(1);
        }
        catch(Exception e){
            
        }
        
        return qtde;
    }
    
    public CachedRowSetImpl buscarHorarios(String codTipo, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select to_char(ResExtHoraInicio, 'HH24:MI'), to_char(ResExtHoraTermino, 'HH24:MI') from reservaexterna, equipamentosresext where EquExtResCod = ResExtCod and EquExtTipoCod = "+codTipo+" and ResExtData = '"+ano+"/"+mes+"/"+dia+"' and ((ResExtHoraTermino > '"+horaInicio+":"+minInicio+"' and ResExtHoraTermino <= '"+horaTermino+":"+minTermino+"') or (ResExtHoraInicio >= '"+horaInicio+":"+minInicio+"' and ResExtHoraInicio < '"+horaTermino+":"+minTermino+"')) order by ResExtHoraInicio");
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
