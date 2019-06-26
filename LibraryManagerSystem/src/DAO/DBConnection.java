package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	private static Connection conn=null;
	
	public static Connection getConnection() throws Exception{
		if(conn==null){
			Context context=new InitialContext();
			Context envCtx=(Context)context.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/myJndi");
			conn=ds.getConnection();
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
            if (st != null)
                st.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
}
