package lessionDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class show_All  {
	DBconnet dBconnet= new DBconnet();
	JTable table = null;
    DefaultTableModel model = null;
	public void show_allStu() {

		//显示全部学生信息
		    JFrame jf = new JFrame("显示全部学生信息(点击表头可以按照升序降序排序)");	   
		    // 创建内容面板
		     JPanel panel = new JPanel();
		    // 表头（列名）
		   Vector columnNames=createColumnNames();
		   Vector data=createTableModelData();	   
		 // 创建一个默认的表格模型
		    model = new DefaultTableModel(data, columnNames);
		   table = new JTable(model);
	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
	       JScrollPane tablePanel = new JScrollPane(table);  				        
		        // 设置表格内容颜色
		        table.setForeground(Color.BLACK);                   // 字体颜色
		        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
		        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		        table.setGridColor(Color.GRAY);                     // 网格颜色

		        // 设置表头
		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
		        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

		        // 设置行高
		        table.setRowHeight(40);

		        // 第一列列宽设置为40
		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	             
		        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		        
		        //排序器	        
		        RowSorter sorter = new TableRowSorter(model);
		        table.setRowSorter(sorter);
		        JScrollPane pane = new JScrollPane(table);      

		        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		        JScrollPane scrollPane = new JScrollPane(table);

		        // 添加 滚动面板 到 内容面板
		        panel.add(scrollPane);
		       // JScrollPane pane = new JScrollPane(table);
		        // 设置 内容面板 到 窗口
		        jf.setContentPane(panel);
		        jf.pack();
		        jf.setSize(900, 600);
		        jf.add(scrollPane, BorderLayout.CENTER);
		        
		        //数据居中显示
		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				table.setDefaultRenderer(Object.class, r);
				
		        jf.setLocationRelativeTo(null);
		        int t=table.getRowCount();
		        if(t<=0){
		        	JOptionPane.showMessageDialog(null, "该系统中还没有录入学生信息！！！");
		        	jf.setVisible(false);
		        }
		        else {
		        	jf.setVisible(true);
		        }
		        
		        
	}
	
	private Vector createColumnNames() {
	       Vector columnNames = new Vector();
	       //columnNames.add("序号");
	       columnNames.add("学号");
	       columnNames.add("姓名");
	       columnNames.add("性别");
	       columnNames.add("生日");
	       columnNames.add("学院");
	       columnNames.add("专业");
	       columnNames.add("班级");
	       
	       return columnNames;
	   }
	   
	     private Vector createTableModelData() {
	        
	         Vector data = new Vector();
	         String t=null;
				try{
					int i=0;
					 String sql="select * from student";
					 System.out.println(1);
					  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //执行sql语句
					  while (rs.next()) {  //遍历结果集
						  Vector rowData = new Vector();
						  
						  String Sno=rs.getString("Sno");  //数据库数据
						  String Sname=rs.getString("Sname");  //数据库数据
						  String Sex=rs.getString("Sex");  //数据库数据
						  String Birthday=rs.getString("Birthday");  //数据库数据
						  String School=rs.getString("School");  //数据库数据
						  String Major=rs.getString("Major");  //数据库数据
						  String Class=rs.getString("Class");  //数据库数据
						  
						  rowData.add(Sno);
						  rowData.add(Sname);
						  rowData.add(Sex);
						  rowData.add(Birthday);
						  rowData.add(School);
						  rowData.add(Major);
						  rowData.add(Class);
						  data.add(rowData);
					  }
			     
						} catch (SQLException e) {
								// TODO 自动生成的 catch 块
						e.printStackTrace();
						
					}	  
	        return data;
	     }
	     
	     //*****************************************************
	     //课程显示模块
	 	//显示全部课程信息
	 	public void show_allCourse() {

	 		//显示全部课程信息
	 		    JFrame jf = new JFrame("显示全部课程信息(点击表头可以按照升序降序排序)");	   
	 		    // 创建内容面板
	 		     JPanel panel = new JPanel();
	 		    // 表头（列名）
	 		   Vector columnNamesCourse=createColumnNamesCourse();
	 		   Vector dataCourse=createTableModelDataCourse();	   
	 		 // 创建一个默认的表格模型
	 		    model = new DefaultTableModel(dataCourse, columnNamesCourse);
	 		   table = new JTable(model);
	 	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
	 	       JScrollPane tablePanel = new JScrollPane(table);  				        
	 		        // 设置表格内容颜色
	 		        table.setForeground(Color.BLACK);                   // 字体颜色
	 		        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
	 		        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
	 		        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
	 		        table.setGridColor(Color.GRAY);                     // 网格颜色

	 		        // 设置表头
	 		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
	 		        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
	 		        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
	 		        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

	 		        // 设置行高
	 		        table.setRowHeight(40);

	 		        // 第一列列宽设置为40
	 		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	 	             
	 		        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
	 		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
	 		        
	 		        //排序器	        
	 		        RowSorter sorter = new TableRowSorter(model);
	 		        table.setRowSorter(sorter);
	 		        JScrollPane pane = new JScrollPane(table);      

	 		        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
	 		        JScrollPane scrollPane = new JScrollPane(table);

	 		        // 添加 滚动面板 到 内容面板
	 		        panel.add(scrollPane);
	 		       // JScrollPane pane = new JScrollPane(table);
	 		        // 设置 内容面板 到 窗口
	 		        jf.setContentPane(panel);
	 		        jf.pack();
	 		        jf.setSize(900, 600);
	 		        jf.add(scrollPane, BorderLayout.CENTER);
	 		        
	 		        //数据居中显示
	 		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
	 				r.setHorizontalAlignment(JLabel.CENTER);   
	 				table.setDefaultRenderer(Object.class, r);
	 				
	 		        jf.setLocationRelativeTo(null);
	 		        int t=table.getRowCount();
	 		        if(t<=0){
	 		        	JOptionPane.showMessageDialog(null, "该系统中还没有录入课程信息！！！");
	 		        	jf.setVisible(false);
	 		        }
	 		        else {
	 		        	jf.setVisible(true);
	 		        }
	 		        
	 		        
	 	}
	     private Vector createColumnNamesCourse() {
		       Vector columnNames = new Vector();
		       //columnNames.add("序号");
		       columnNames.add("课程号");
		       columnNames.add("课程名");
		       columnNames.add("学分");
		      
		       return columnNames;
		   }
		   
		     private Vector createTableModelDataCourse() {
		        
		         Vector data = new Vector();
		         String t=null;
					try{
						int i=0;
						 String sql="select * from Course";
						 System.out.println(1);
						  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //执行sql语句
						  while (rs.next()) {  //遍历结果集
							  Vector rowData = new Vector();
							  
							  String Cno=rs.getString("Cno");  //数据库数据
							  String Cname=rs.getString("Cname");  //数据库数据
							  String Credit=rs.getString("Credit");  //数据库数据
							  
							  
							  rowData.add(Cno);
							  rowData.add(Cname);
							  rowData.add(Credit);
							  data.add(rowData);
						  }
				     
							} catch (SQLException e) {
									// TODO 自动生成的 catch 块
							e.printStackTrace();
							
						}	  
		        return data;
		     }
		     //*****************************************************
		     //教师模块
		 	//显示全部教师信息
		 	public void show_allTea() {

		 		//显示全部教师信息
		 		    JFrame jf = new JFrame("显示全部教师信息(点击表头可以按照升序降序排序)");	   
		 		    // 创建内容面板
		 		     JPanel panel = new JPanel();
		 		    // 表头（列名）
		 		   Vector columnNamesTea=createColumnNamesTea();
		 		   Vector dataTea=createTableModelDataTea();	   
		 		 // 创建一个默认的表格模型
		 		    model = new DefaultTableModel(dataTea, columnNamesTea);
		 		   table = new JTable(model);
		 	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		 	       JScrollPane tablePanel = new JScrollPane(table);  				        
		 		        // 设置表格内容颜色
		 		        table.setForeground(Color.BLACK);                   // 字体颜色
		 		        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
		 		        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		 		        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		 		        table.setGridColor(Color.GRAY);                     // 网格颜色

		 		        // 设置表头
		 		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
		 		        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		 		        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		 		        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

		 		        // 设置行高
		 		        table.setRowHeight(40);

		 		        // 第一列列宽设置为40
		 		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
		 	             
		 		        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		 		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		 		        
		 		        //排序器	        
		 		        RowSorter sorter = new TableRowSorter(model);
		 		        table.setRowSorter(sorter);
		 		        JScrollPane pane = new JScrollPane(table);      

		 		        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		 		        JScrollPane scrollPane = new JScrollPane(table);

		 		        // 添加 滚动面板 到 内容面板
		 		        panel.add(scrollPane);
		 		       // JScrollPane pane = new JScrollPane(table);
		 		        // 设置 内容面板 到 窗口
		 		        jf.setContentPane(panel);
		 		        jf.pack();
		 		        jf.setSize(900, 600);
		 		        jf.add(scrollPane, BorderLayout.CENTER);
		 		        
		 		        //数据居中显示
		 		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		 				r.setHorizontalAlignment(JLabel.CENTER);   
		 				table.setDefaultRenderer(Object.class, r);
		 				
		 		        jf.setLocationRelativeTo(null);
		 		        int t=table.getRowCount();
		 		        if(t<=0){
		 		        	JOptionPane.showMessageDialog(null, "该系统中还没有录入教师信息！！！");
		 		        	jf.setVisible(false);
		 		        }
		 		        else {
		 		        	jf.setVisible(true);
		 		        }
		 		        
		 		        
		 	}
		     private Vector createColumnNamesTea() {
			       Vector columnNames = new Vector();
			       //columnNames.add("序号");
			       columnNames.add("工号");
			       columnNames.add("姓名");
			       columnNames.add("性别");
			       columnNames.add("生日");
			       columnNames.add("任课课程号");
			       
			       return columnNames;
			   }
			   
			     private Vector createTableModelDataTea() {
			        
			         Vector data = new Vector();
			         String t=null;
						try{
							int i=0;
							 String sql="select * from Teacher";
							 System.out.println(1);
							  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //执行sql语句
							  while (rs.next()) {  //遍历结果集
								  Vector rowData = new Vector();
								  
								  String Tno=rs.getString("Tno");  //数据库数据
								  String Tname=rs.getString("Tname");  //数据库数据
								  String Sex=rs.getString("Sex");  //数据库数据
								  String Birthday=rs.getString("Birthday");  //数据库数据
								  String Cno=rs.getString("Cno");  //数据库数据
								  
								  rowData.add(Tno);
								  rowData.add(Tname);
								  rowData.add(Sex);
								  rowData.add(Birthday);
								  rowData.add(Cno);
								  data.add(rowData);
							  }
					     
								} catch (SQLException e) {
										// TODO 自动生成的 catch 块
								e.printStackTrace();
								
							}	  
			        return data;
			     }
			     //*****************************************************
			     //成绩模块
			 	//显示个人全部成绩信息
			 	public void show_allGradeByPeo(String sno) {

			 		//显示全部教师信息
			 		    JFrame jf = new JFrame("显示全部成绩信息(点击表头可以按照升序降序排序)");	   
			 		    // 创建内容面板
			 		     JPanel panel = new JPanel();
			 		    // 表头（列名）
			 		   Vector columnNamesGradeByPeo=createColumnNamesGradeByPeo();
			 		   Vector dataGradeByPeo=createTableModelDataGradeByPeo(sno);	   
			 		 // 创建一个默认的表格模型
			 		    model = new DefaultTableModel(dataGradeByPeo, columnNamesGradeByPeo);
			 		   table = new JTable(model);
			 	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
			 	       JScrollPane tablePanel = new JScrollPane(table);  				        
			 		        // 设置表格内容颜色
			 		        table.setForeground(Color.BLACK);                   // 字体颜色
			 		        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
			 		        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
			 		        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
			 		        table.setGridColor(Color.GRAY);                     // 网格颜色

			 		        // 设置表头
			 		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
			 		        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
			 		        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
			 		        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

			 		        // 设置行高
			 		        table.setRowHeight(40);

			 		        // 第一列列宽设置为40
			 		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
			 	             
			 		        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
			 		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
			 		        
			 		        //排序器	        
			 		        RowSorter sorter = new TableRowSorter(model);
			 		        table.setRowSorter(sorter);
			 		        JScrollPane pane = new JScrollPane(table);      

			 		        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
			 		        JScrollPane scrollPane = new JScrollPane(table);

			 		        // 添加 滚动面板 到 内容面板
			 		        panel.add(scrollPane);
			 		       // JScrollPane pane = new JScrollPane(table);
			 		        // 设置 内容面板 到 窗口
			 		        jf.setContentPane(panel);
			 		        jf.pack();
			 		        jf.setSize(900, 600);
			 		        jf.add(scrollPane, BorderLayout.CENTER);
			 		        
			 		        //数据居中显示
			 		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
			 				r.setHorizontalAlignment(JLabel.CENTER);   
			 				table.setDefaultRenderer(Object.class, r);
			 				
			 		        jf.setLocationRelativeTo(null);
			 		        int t=table.getRowCount();
			 		        if(t<=0){
			 		        	JOptionPane.showMessageDialog(null, "该系统中还没有录入你的成绩信息！！！");
			 		        	jf.setVisible(false);
			 		        }
			 		        else {
			 		        	jf.setVisible(true);
			 		        }
			 		        
			 		        
			 	}
			     private Vector createColumnNamesGradeByPeo() {
				       Vector columnNames = new Vector();
				       //columnNames.add("序号");
				       columnNames.add("课程号");
				       columnNames.add("课程名");
				       columnNames.add("分数");
				       return columnNames;
				   }
				   
				     private Vector createTableModelDataGradeByPeo(String sno) {
				        
				         Vector data = new Vector();
				         String t=null;
							try{
								int i=0;
								 String sql="select a.Cno,Cname,Grade from sc a,course b where sno="+"'"+sno+"' and "+"a.Cno=b.Cno";
								 System.out.println(1);
								  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //执行sql语句
								  while (rs.next()) {  //遍历结果集
									  Vector rowData = new Vector();
									  
									  String Cno=rs.getString("Cno");  //数据库数据
									  String Cname=rs.getString("Cname");  //数据库数据
									  String Grade=rs.getString("Grade");  //数据库数据
									
									  
									  rowData.add(Cno);
									  rowData.add(Cname);
									  rowData.add(Grade);
									 
									  data.add(rowData);
								  }
						     
									} catch (SQLException e) {
											// TODO 自动生成的 catch 块
									e.printStackTrace();
									
								}	  
				        return data;
				     } 
			     
}
