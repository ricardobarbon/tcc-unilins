package classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//driver: org.postgresql.Driver
//URL: jdbc:postgresql://localhost/...
public class Conexao {
    
    static final String DRIVER = "org.postgresql.Driver";
    static final String URL = "jdbc:postgresql://localhost:5432/siscre?user=postgres&password=851124";
    private Connection conexao = null;
        
    public Conexao() {
    }
    
    public void conectando(){
        
        try{
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
            System.exit(1);
        }
    }
    
    public void desconectando(){
        
        try{
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public Connection getConexao()
    {
        return conexao;
    }
}
