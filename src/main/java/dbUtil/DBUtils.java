package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection getConnection(){
        try{
            String dbURL = "jdbc:mysql://localhost:3306/board";
            String dbID = "root";
            String dbPW = "root";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbURL,dbID,dbPW);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
