package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getAccessConnection(){
		String driver = "com.hxtt.sql.access.AccessDriver";
		String conStr = "jdbc:Access:///F:/Guitars.mdb";
		Connection con = null;       
        try {  
            Class.forName(driver);  
            con=DriverManager.getConnection(conStr);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return con;  
	}
	public static Connection getMySqlConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String conStr = "jdbc:mysql://localhost:3306/Guitars";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr, "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
