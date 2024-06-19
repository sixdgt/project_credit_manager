package dbconfig;
// required packages
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DbConnection {
    private final static String DB_NAME = "mvc_credit_manager";
    private final static String DB_USER = "sixdgt";
    private final static String DB_PASSWORD = "1234";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    static Connection CON;
    static Statement STMT;
    
    /**
     * this method is a static type of DbConnection class that returns the object of it
     * here Database Connection is done with MySQL Configuration
     * @return dbconnect
     */
    public static DbConnection getConnection(){
        DbConnection dbconnect = new DbConnection();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CON = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return dbconnect;
    }
    
    /**
     * this method is a select query builder which create SQL Statement for SELECT query
     * @param sql
     * @return rs
     */
    public ResultSet selectQueryBuilder(String sql){
        ResultSet rs = null;
        try {
            STMT = CON.createStatement();
            rs = STMT.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rs;
    }
    
    /**
     * this method is a query build for insert, update and delete query
     * here iud stands for i = insert, u = update and d = delete
     * @param sql
     * @return status
     */
    public boolean iudQueryBuilder(String sql){
        boolean status = false;
        try {
            STMT = CON.createStatement();
            if(STMT.executeUpdate(sql) > 0){
                status = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return status;
    }
}
