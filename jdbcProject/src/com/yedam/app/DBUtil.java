package com.yedam.app;

import java.sql.Connection;
import java.sql.DriverManager;
// ojdbc.jar 외부라이브러리를 추가.
public class DBUtil {
	// DB 접속정보 활용 => 세션(Connection객체)
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
