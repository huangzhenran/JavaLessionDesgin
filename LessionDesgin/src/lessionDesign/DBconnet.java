package lessionDesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnet {
	private Connection con;
	  private static Statement statement;  //���ݿ�״̬
	  
	  public  Statement getStatement() {
		return statement;
	}



	//��̬ģ��������Ч��
	  static {
		  try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	  }
	  
	  //������������
	  public Connection getConnection() {
		  String url="jdbc:sqlserver://localhost:1433;DatabaseName=studentManager";
		  try {
			con=DriverManager.getConnection(url,"sa","123456");
			statement=con.createStatement();
			System.out.println("�������ݿ�ɹ�");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return con;
		
	}
}
