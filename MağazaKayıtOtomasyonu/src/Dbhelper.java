import java.sql.*;
public class Dbhelper {
    
   
    private String userName ="root";
    private String password="";
    private String dbUrl ="jdbc:mysql://localhost:3306/magaza?useSSL=false&serverTimezone=UTC";
    
    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,password);
    
    }
    
    public void showErrorMessage(SQLException exception){
    
        System.out.println("Error" + exception.getMessage());
        System.out.println("Error Code" + exception.getErrorCode());
    }
    
    
    
    
    
    
    
}
