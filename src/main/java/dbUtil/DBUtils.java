package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void close(ResultSet rs, PreparedStatement ps , Connection conn){
        if( ps != null) try{ rs.close();} catch (Exception e){};
        if( ps != null) try{ ps.close();} catch (Exception e){};
        if( ps != null) try{ conn.close();} catch (Exception e){};
    }


}
