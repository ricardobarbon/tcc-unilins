package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

public class Reserva {
    
    private CachedRowSetImpl crs;
    
    Statement statement = null;
    Connection conexao;
    
    public Reserva() {
    }
    
    public boolean validarDados(String curso, String sala, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        if((curso.compareTo("0")==0)||(sala.compareTo("0")==0)){
            return false;
        }
        
        int idia = Integer.parseInt(dia);
        int imes = Integer.parseInt(mes);
        int iano = Integer.parseInt(ano);
        
        GregorianCalendar dataHj = new GregorianCalendar();
        
        boolean d = false;
        for(int i = 0; i < 8;i++){
            if((idia==dataHj.get(Calendar.DAY_OF_MONTH))&&(imes-1==dataHj.get(Calendar.MONTH))&&(iano==dataHj.get(Calendar.YEAR))){
                d=true;
            }
            dataHj.add(Calendar.DAY_OF_MONTH, 1);
        }
        if(d==false){
            return false;
        }
        if((horaInicio.compareToIgnoreCase("-1")==0)||(minInicio.compareToIgnoreCase("-1")==0)||(horaTermino.compareToIgnoreCase("-1")==0)||(minTermino.compareToIgnoreCase("-1")==0)){
            return false;
        }
        
        int hrInicio = Integer.parseInt(horaInicio);
        int hrTermino = Integer.parseInt(horaTermino);
        int minIni = Integer.parseInt(minInicio);
        int minTer = Integer.parseInt(minTermino);
        
        if(hrInicio==hrTermino){
            if((minTer-minIni)<=0){
                return false;
            }
        }
        else if((hrTermino-hrInicio)<0){
            return false;
        }
        return true;
    }
    
    public void salvarDados(String id, String curso, String sala, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino, String descricao){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into reserva (resusuarioid, rescursocod, ressalacod, resdata, reshorainicio, reshoratermino, resobservacao) values ('"+id+"', "+curso+", "+sala+", '"+ano+"/"+mes+"/"+dia+"', '"+horaInicio+":"+minInicio+"', '"+horaTermino+":"+minTermino+"', '"+descricao+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
    
    public CachedRowSetImpl verificarSeProfJaTemReserva(String id, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select rescod from reserva where resData = '"+ano+"/"+mes+"/"+dia+"' and resusuarioid = '"+id+"' and ((reshoratermino > '"+horaInicio+":"+minInicio+"' and reshoratermino <= '"+horaTermino+":"+minTermino+"') or (reshorainicio >= '"+horaInicio+":"+minInicio+"' and reshorainicio < '"+horaTermino+":"+minTermino+"'))");
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
    
    public CachedRowSetImpl verificarSeSalaJaTemReserva(String id, String sala, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select rescod from reserva where resData = '"+ano+"/"+mes+"/"+dia+"' and ressalacod = '"+sala+"' and ((reshoratermino > '"+horaInicio+":"+minInicio+"' and reshoratermino <= '"+horaTermino+":"+minTermino+"') or (reshorainicio >= '"+horaInicio+":"+minInicio+"' and reshorainicio < '"+horaTermino+":"+minTermino+"'))");
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
    
    public CachedRowSetImpl buscarCodReserva(String id, String curso, String sala, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino, String observacao){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select rescod from reserva where resusuarioid = '"+id+"' and rescursocod = "+curso+" and ressalacod = "+sala+" and resdata = '"+ano+"/"+mes+"/"+dia+"' and reshorainicio = '"+horaInicio+":"+minInicio+"' and reshoratermino = '"+horaTermino+":"+minTermino+"' and resobservacao = '"+observacao+"'");
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
    
    public CachedRowSetImpl buscarHorarios(String codTipo, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select to_char(reshoraInicio, 'HH24:MI'), to_char(reshoraTermino, 'HH24:MI') from reserva, equipamentosutilizados where EquUtiResCod = rescod and EquUtiTipoCod = "+codTipo+" and resData = '"+ano+"/"+mes+"/"+dia+"' and ((reshoratermino > '"+horaInicio+":"+minInicio+"' and reshoratermino <= '"+horaTermino+":"+minTermino+"') or (reshorainicio >= '"+horaInicio+":"+minInicio+"' and reshorainicio < '"+horaTermino+":"+minTermino+"')) order by resHoraInicio");
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
    
    public CachedRowSetImpl buscarProfessores(String codTipo, String dia, String mes, String ano, String horaInicio, String minInicio, String horaTermino, String minTermino){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select usuarioNome, profTelcel from reserva, usuario, professor where usuarioid = profusuarioid and usuarioid = resusuarioid and resData = '"+ano+"/"+mes+"/"+dia+"' and ((reshoratermino > '"+horaInicio+":"+minInicio+"' and reshoratermino <= '"+horaTermino+":"+minTermino+"') or (reshorainicio >= '"+horaInicio+":"+minInicio+"' and reshorainicio < '"+horaTermino+":"+minTermino+"'))");
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
    
    public CachedRowSetImpl buscarReservas(String id){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        GregorianCalendar data = new GregorianCalendar();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select to_char(resData, 'DD/MM/YYYY'), to_char(reshoraInicio, 'HH24:MI'), to_char(reshoraTermino, 'HH24:MI'), salaDescricao, rescod from reserva, usuario, sala where usuarioid = resusuarioid and ressalacod = salacod and resusuarioid = '"+id+"' and resdata >= '"+ano+"/"+mes+"/"+dia+"' order by resdata, reshoraInicio");
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
    
    public CachedRowSetImpl buscarEquipamentos(String codReserva){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
               
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select tipodesc from equipamentosutilizados, tipo where tipocod = EquUtiTipoCod and EquUtiResCod = "+codReserva+"");
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
    
    public CachedRowSetImpl buscarReservas(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        GregorianCalendar data = new GregorianCalendar();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select to_char(resData, 'DD/MM/YYYY'), to_char(reshoraInicio, 'HH24:MI'), to_char(reshoraTermino, 'HH24:MI'), salaDescricao, rescod, usuarioNome from reserva, usuario, sala where usuarioid = resusuarioid and ressalacod = salacod and resdata >= '"+ano+"/"+mes+"/"+dia+"' order by resdata, reshoraInicio");
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
    
    public CachedRowSetImpl buscarReservasHoje(){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        GregorianCalendar data = new GregorianCalendar();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select to_char(resData, 'DD/MM/YYYY'), to_char(reshoraInicio, 'HH24:MI'), to_char(reshoraTermino, 'HH24:MI'), salaDescricao, rescod, usuarioNome from reserva, usuario, sala where usuarioid = resusuarioid and ressalacod = salacod and resdata = '"+ano+"/"+mes+"/"+dia+"' order by resdata, reshoraInicio");
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
    
    public CachedRowSetImpl buscarReserva(String codReserva){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select ResUsuarioID, ResCursoCod, ResSalaCod, to_char(ResData, 'DD'), to_char(resdata, 'MM'), to_char(resdata, 'YYYY'), to_char(ResHoraInicio, 'HH24'), to_char(Reshorainicio, 'MI'), to_char(ResHoraTermino, 'HH24'), to_char(reshoraTermino, 'MI'), ResObservacao from reserva where rescod = "+codReserva+"");
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
    
    public CachedRowSetImpl buscarHorariosTipo(String codReserva){
        Conexao conexao = new Conexao();
        ResultSet resultSet = null;
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            resultSet = statement.executeQuery("select resto_char(ResData, 'YYYY/MM/DD'), to_char(ResHoraInicio, 'HH24:MI'), to_char(ResHoraTermino, 'HH24:MI'), EquUtiTipoCod from reserva, equipamentosutilizados where rescod = "+codReserva+" and rescod = EquUtiResCod");
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
