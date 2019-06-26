package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUseType4 {
	private final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/librarymanagersystem?useSSL=false&serverTimezone=UTC";
	private final String USER="root";
	private final String PASS="Yans1105407817...";//Server key Yans1105407817...
	private Connection conn = null;

	
	public DBConnectionUseType4(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	

    public Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        }
        return conn;
    }
//
//    public static void close(Connection conn, Statement st, ResultSet rs) {
//        try {
//            if (conn != null)
//                conn.close();
//            if (st != null)
//                st.close();
//            if (rs != null)
//                rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
