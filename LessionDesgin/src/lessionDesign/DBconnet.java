package lessionDesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnet {
	private Connection con;
	  private static Statement statement;  //数据库状态
	  
	  public  Statement getStatement() {
		return statement;
	}



	//静态模块可以提高效率
	  static {
		  try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	  }
	  
	  //加载驱动程序
	  public Connection getConnection() {
		  String url="jdbc:sqlserver://localhost:1433;DatabaseName=studentManager";
		  try {
			con=DriverManager.getConnection(url,"sa","123456");
			statement=con.createStatement();
			System.out.println("连接数据库成功");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}
		return con;
		
	}
}
