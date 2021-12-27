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
		  ResultSet rs=this.getStatement().executeQuery(sql);   //执行sql语句
		  while (rs.next()) {  //遍历结果集
			  String password1=rs.getString("password");  //数据库数据
				if (password1.equals(password)) {
					System.out.println("登陆成功");				
					new ManagementCenter();  //打开管理员界面
					return 1;
					
				}
				else {
					System.out.println("密码输入错误");
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
			String tno=r1.getString("Tno"); //工号
			String tname=r1.getString("Tname"); //姓名
			String birthday=r1.getString("Birthdata"); //生日
			String sex=r1.getString("Sex"); //性别
			String con=r1.getString("Cno"); //课程号
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
				String tno=r1.getString("Sno"); //学号
				String tname=r1.getString("Sname"); //姓名
				String birthday=r1.getString("Birthday"); //生日
				String sex=r1.getString("Sex"); //性别
				String school=r1.getString("School"); //学院
				String major=r1.getString("Major"); //专业
				String banji=r1.getString("Class"); //班级
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
				String tno=r1.getString("Cno"); //课程号
				String tname=r1.getString("Cname"); //课程姓名
				String birthday=r1.getString("Credit"); //学分
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
}
}
