package cn.com.lk.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.com.lk.utils.Encrypt;

public class MYSQLTest {
	private String mysqlurl = "jdbc:mysql://localhost/lk_sampling";
	private String mysqlpassword = "12345678";
	private String mysqluser = "root";
	private String mysqldriver = "com.mysql.jdbc.Driver";


	public void mysql() throws Exception{
		Class.forName(mysqldriver);
		Connection mysqlconn = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
		PreparedStatement mysqlpstmt = mysqlconn.prepareStatement("insert into ais(avg) values(123.12)");
		mysqlpstmt.execute();
		mysqlpstmt.close();
		mysqlconn.close();
	}
	
	@Test
	public void testPassword(){
		System.out.println(Encrypt.SHA256("yang"));
	}
	
}
