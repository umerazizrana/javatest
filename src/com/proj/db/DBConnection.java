package com.proj.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.proj.vo.DataVO;

public class DBConnection {
	
	private Connection con = null;
	private static String con_url = null;
	private static String user_name = null;
	private static String pass = null;
	
	public DBConnection() {
		if(con_url == null) {
			try (InputStream input = getClass().getClassLoader().getResourceAsStream("com/proj/resources/proj.properties")) {
				Properties prop = new Properties();
				prop.load(input);	
				con_url = prop.getProperty("db_url");
				System.out.println("Loaded con_url is: "+con_url);
				user_name = prop.getProperty("user");
				pass = prop.getProperty("pass");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		con = DriverManager.getConnection(con_url,user_name,pass);  
	}
	
	
	public void insertData(DataVO data) throws SQLException, ClassNotFoundException {
		
		PreparedStatement pstmt = null;
		try {
			getConnection();
			String query = "INSERT INTO user_dt(age,hb,blood_group,gender"
					+ ",external_id,pregnant,comments,samsung_file_link,redmi_file_link)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";		
			pstmt = con.prepareStatement(query);
			pstmt.setFloat(1, data.getAge());
			pstmt.setFloat(2, data.getHb());
			pstmt.setString(3, data.getBlood_group());
			pstmt.setFloat(4, data.getGender());
			pstmt.setString(5, data.getExternal_id());
			pstmt.setFloat(6, data.getPregnant());
			pstmt.setString(7, data.getComments());
			pstmt.setString(8, data.getSamsung_file_link());
			pstmt.setString(9, data.getRedmi_file_link());		
			pstmt.executeUpdate();
		}finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
	}
	  
}//EOC