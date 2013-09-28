package classes;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;
import java.lang.*;

public class Manutencao {
    
    Statement statement = null;
    Connection conexao;
    
    public Manutencao() {
    }
    
    public boolean validarDados(String d, String m, String a, String descMan){
        
        int dia = Integer.parseInt(d);
        int mes = Integer.parseInt(m);
        int ano = Integer.parseInt(a);
            
        GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);
        
        if((ano==0)||(mes==0)||(dia==0)){
            return false;
        }
        else if((ano == data.get(Calendar.YEAR)) &&(mes - 1 == data.get(Calendar.MONTH))&&(dia == data.get(Calendar.DAY_OF_MONTH))&&(descMan.length()>10)){
            return true;
        }
        else
            return false;
    }
    
    public void salvarDados(String pat, String dia, String mes, String ano, String descMan){
        Conexao conexao = new Conexao();
        
        conexao.conectando();
        
        try{
            statement = conexao.getConexao().createStatement();
            statement.execute("insert into manutencao(manequPatrimonio, manDescricao, manDataRetorno) values ('"+pat+"','"+descMan+"','"+ano+"/"+mes+"/"+dia+"')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        conexao.desconectando();
    }
}
