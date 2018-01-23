package cn.com.lk.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class SQLServerConnectTest {
	
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=LK_Samp";
	private String password = "123456";
	private String user = "sa";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private String mysqlurl = "jdbc:mysql://localhost/lk_sampling";
	private String mysqlpassword = "12345678";
	private String mysqluser = "root";
	private String mysqldriver = "com.mysql.jdbc.Driver";
	
	@Test
	public void testConnect(){
		try {
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement("select * from Species");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				Class.forName(mysqldriver);
				Connection mysqlconn = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
				PreparedStatement mysqlpstmt = mysqlconn.prepareStatement("insert into ais(avg,finalValue,std,areaId,industryId,speciesId) values(?,?,?,?,?,?)");
				mysqlpstmt.setDouble(1, rs.getDouble("iAvg"));
				mysqlpstmt.setDouble(2, rs.getDouble("iFinal"));
				mysqlpstmt.setDouble(3, rs.getDouble("iStd"));
				
				mysqlpstmt.setInt(4, rs.getInt("cAreaGuid"));
				mysqlpstmt.setInt(5, rs.getInt("cIndGuid"));
				mysqlpstmt.setInt(6, rs.getInt("cSpeGuid"));
				
				mysqlpstmt.execute();
				mysqlpstmt.close();
				mysqlconn.close();
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
