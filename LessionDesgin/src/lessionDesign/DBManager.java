package lessionDesign;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DBManager extends DBconnet {
	JFrame jf= new JFrame();
  private ResultSet rs;
  logintest logintest= new logintest();
  //Statement statement=this.getStatement();
 
public int login(String account,String password) {
	
	  try {
		  String sql="select password from admin where adminName="+"'"+account+"'";
		  ResultSet rs=this.getStatement().executeQuery(sql);   //ִ��sql���
		  while (rs.next()) {  //���������
			  String password1=rs.getString("password");  //���ݿ�����
				if (password1.equals(password)) {
					System.out.println("��½�ɹ�");				
					new ManagementCenter();  //�򿪹���Ա����
					return 1;
					
				}
				else {
					System.out.println("�����������");
					return 0;
				}
		}	
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return 0;
	
}
  public void teacherQurey(String sql) {
	  
	  try {
		  ResultSet r1=this.getStatement().executeQuery(sql);
		  while (r1.next()) {
			String tno=r1.getString("Tno"); //����
			String tname=r1.getString("Tname"); //����
			String birthday=r1.getString("Birthdata"); //����
			String sex=r1.getString("Sex"); //�Ա�
			String con=r1.getString("Cno"); //�γ̺�
		}
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
	  public void studentQurey(String sql) {
		  
		  try {
			  ResultSet r1=this.getStatement().executeQuery(sql);
			  while (r1.next()) {
				String tno=r1.getString("Sno"); //ѧ��
				String tname=r1.getString("Sname"); //����
				String birthday=r1.getString("Birthday"); //����
				String sex=r1.getString("Sex"); //�Ա�
				String school=r1.getString("School"); //ѧԺ
				String major=r1.getString("Major"); //רҵ
				String banji=r1.getString("Class"); //�༶
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
}
	  public void courseQurey(String sql) {
		  
		  try {
			  ResultSet r1=this.getStatement().executeQuery(sql);
			  while (r1.next()) {
				String tno=r1.getString("Cno"); //�γ̺�
				String tname=r1.getString("Cname"); //�γ�����
				String birthday=r1.getString("Credit"); //ѧ��
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
}
}
