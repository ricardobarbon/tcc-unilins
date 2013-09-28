package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;

public class Equipamento {
    
    private String patrimonioEquip;
    private String situacaoEquip;
    private Tipo tipoEquip;
    
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public Equipamento() {
        
        patrimonioEquip = "";
        situacaoEquip = "";
        tipoEquip = new Tipo();
    }
    
    public void setPatrimonioEquip(String s){
        
        patrimonioEquip = s;
    }
    
    public void setSituacaoEquipDisponivel(){
        
        situacaoEquip = "disponivel";
    }
    
    public void setSituacaoEquipIndisponivel(){
        
        situacaoEquip = "indisponivel";
    }
    
    public void setSituacaoEquipInutilizado(){
        
        situacaoEquip = "inutilizado";
    }
    
    public void setSituacaoEquipFixo(){
        
        situacaoEquip = "fixo";
    }
    
    public String getPatrimonioEquip(){
        
        return patrimonioEquip;
    }
    
    public String getSituacaoEquip(){
        
        return situacaoEquip;
    }
    
    public CachedRowSetImpl buscarEquipamentos(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select EquPatrimonio, tipodesc, EquMarca, EquSituacao from tipo t, equipamentos e where e.equtipocod = t.tipocod and e.equSituacao <> 'EXCLUIDO' order by tipodesc");
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
    
    public boolean verificarDados(String p, String t, String m, String s){
        
        if((p.length()==0)||(t.compareTo("0")==0)||(m.length()==0)||(s.length()<3)){
            return false;
        }
        else
            return true;
    }
    
    public CachedRowSetImpl verificarPatrimonio(String p){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select EquPatrimonio, tipodesc, EquMarca, EquSituacao from tipo t, equipamentos e where e.equtipocod = t.tipocod and e.equPatrimonio ='"+ p +"' order by tipodesc");
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
    
    public void salvarDados(String p, String t, String m, String s){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        m = m.toUpperCase();
        s = s.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into equipamentos values ('"+p+"',"+t+",'"+m+"','"+s+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl buscarEquipamento(String c){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select EquPatrimonio, tipodesc, EquMarca, EquSituacao from tipo t, equipamentos e where e.equtipocod = t.tipocod and e.equPatrimonio ='"+ c +"' order by tipodesc");
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
    
    public void atualizarDados(String p, String t, String m, String s){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        m = m.toUpperCase();
        t = t.toUpperCase();
        s = s.toUpperCase();
         
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update equipamentos set equTipoCod = "+t+", equMarca = '"+m+"', equSituacao='"+s+"' where equPatrimonio="+ p +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public void atualizarSituacao(String pat, String sit){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        sit = sit.toUpperCase();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.executeUpdate("update equipamentos set equSituacao='"+sit+"' where equPatrimonio="+ pat +"");
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public int buscarQtdeDisponivel(String codTipo){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select count(*) from equipamentos where equtipocod = "+codTipo+" and EquSituacao='DISPONIVEL'");
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
    
    public int buscarQtdeEquipamentosReservados(String codTipo, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select count(*) from reserva, equipamentosutilizados where EquUtiResCod = rescod and EquUtiTipoCod = "+codTipo+" and resData = '"+ano+"/"+mes+"/"+dia+"' and ((reshoratermino > '"+horaInicio+":"+minInicio+"' and reshoratermino <= '"+horaTermino+":"+minTermino+"') or (reshorainicio >= '"+horaInicio+":"+minInicio+"' and reshorainicio < '"+horaTermino+":"+minTermino+"'))");
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
}
