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

		//��ʾȫ��ѧ����Ϣ
		    JFrame jf = new JFrame("��ʾȫ��ѧ����Ϣ(�����ͷ���԰�������������)");	   
		    // �����������
		     JPanel panel = new JPanel();
		    // ��ͷ��������
		   Vector columnNames=createColumnNames();
		   Vector data=createTableModelData();	   
		 // ����һ��Ĭ�ϵı��ģ��
		    model = new DefaultTableModel(data, columnNames);
		   table = new JTable(model);
	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
	       JScrollPane tablePanel = new JScrollPane(table);  				        
		        // ���ñ��������ɫ
		        table.setForeground(Color.BLACK);                   // ������ɫ
		        table.setFont(new Font(null, Font.PLAIN, 14));      // ������ʽ
		        table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
		        table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
		        table.setGridColor(Color.GRAY);                     // ������ɫ

		        // ���ñ�ͷ
		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // ���ñ�ͷ����������ʽ
		        table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
		        table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
		        table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������

		        // �����и�
		        table.setRowHeight(40);

		        // ��һ���п�����Ϊ40
		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	             
		        // ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		        
		        //������	        
		        RowSorter sorter = new TableRowSorter(model);
		        table.setRowSorter(sorter);
		        JScrollPane pane = new JScrollPane(table);      

		        // �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		        JScrollPane scrollPane = new JScrollPane(table);

		        // ��� ������� �� �������
		        panel.add(scrollPane);
		       // JScrollPane pane = new JScrollPane(table);
		        // ���� ������� �� ����
		        jf.setContentPane(panel);
		        jf.pack();
		        jf.setSize(900, 600);
		        jf.add(scrollPane, BorderLayout.CENTER);
		        
		        //���ݾ�����ʾ
		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				table.setDefaultRenderer(Object.class, r);
				
		        jf.setLocationRelativeTo(null);
		        int t=table.getRowCount();
		        if(t<=0){
		        	JOptionPane.showMessageDialog(null, "��ϵͳ�л�û��¼��ѧ����Ϣ������");
		        	jf.setVisible(false);
		        }
		        else {
		        	jf.setVisible(true);
		        }
		        
		        
	}
	
	private Vector createColumnNames() {
	       Vector columnNames = new Vector();
	       //columnNames.add("���");
	       columnNames.add("ѧ��");
	       columnNames.add("����");
	       columnNames.add("�Ա�");
	       columnNames.add("����");
	       columnNames.add("ѧԺ");
	       columnNames.add("רҵ");
	       columnNames.add("�༶");
	       
	       return columnNames;
	   }
	   
	     private Vector createTableModelData() {
	        
	         Vector data = new Vector();
	         String t=null;
				try{
					int i=0;
					 String sql="select * from student";
					 System.out.println(1);
					  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //ִ��sql���
					  while (rs.next()) {  //���������
						  Vector rowData = new Vector();
						  
						  String Sno=rs.getString("Sno");  //���ݿ�����
						  String Sname=rs.getString("Sname");  //���ݿ�����
						  String Sex=rs.getString("Sex");  //���ݿ�����
						  String Birthday=rs.getString("Birthday");  //���ݿ�����
						  String School=rs.getString("School");  //���ݿ�����
						  String Major=rs.getString("Major");  //���ݿ�����
						  String Class=rs.getString("Class");  //���ݿ�����
						  
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
								// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
						
					}	  
	        return data;
	     }
	     
	     //*****************************************************
	     //�γ���ʾģ��
	 	//��ʾȫ���γ���Ϣ
	 	public void show_allCourse() {

	 		//��ʾȫ���γ���Ϣ
	 		    JFrame jf = new JFrame("��ʾȫ���γ���Ϣ(�����ͷ���԰�������������)");	   
	 		    // �����������
	 		     JPanel panel = new JPanel();
	 		    // ��ͷ��������
	 		   Vector columnNamesCourse=createColumnNamesCourse();
	 		   Vector dataCourse=createTableModelDataCourse();	   
	 		 // ����һ��Ĭ�ϵı��ģ��
	 		    model = new DefaultTableModel(dataCourse, columnNamesCourse);
	 		   table = new JTable(model);
	 	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
	 	       JScrollPane tablePanel = new JScrollPane(table);  				        
	 		        // ���ñ��������ɫ
	 		        table.setForeground(Color.BLACK);                   // ������ɫ
	 		        table.setFont(new Font(null, Font.PLAIN, 14));      // ������ʽ
	 		        table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
	 		        table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
	 		        table.setGridColor(Color.GRAY);                     // ������ɫ

	 		        // ���ñ�ͷ
	 		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // ���ñ�ͷ����������ʽ
	 		        table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
	 		        table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
	 		        table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������

	 		        // �����и�
	 		        table.setRowHeight(40);

	 		        // ��һ���п�����Ϊ40
	 		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	 	             
	 		        // ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
	 		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
	 		        
	 		        //������	        
	 		        RowSorter sorter = new TableRowSorter(model);
	 		        table.setRowSorter(sorter);
	 		        JScrollPane pane = new JScrollPane(table);      

	 		        // �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
	 		        JScrollPane scrollPane = new JScrollPane(table);

	 		        // ��� ������� �� �������
	 		        panel.add(scrollPane);
	 		       // JScrollPane pane = new JScrollPane(table);
	 		        // ���� ������� �� ����
	 		        jf.setContentPane(panel);
	 		        jf.pack();
	 		        jf.setSize(900, 600);
	 		        jf.add(scrollPane, BorderLayout.CENTER);
	 		        
	 		        //���ݾ�����ʾ
	 		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
	 				r.setHorizontalAlignment(JLabel.CENTER);   
	 				table.setDefaultRenderer(Object.class, r);
	 				
	 		        jf.setLocationRelativeTo(null);
	 		        int t=table.getRowCount();
	 		        if(t<=0){
	 		        	JOptionPane.showMessageDialog(null, "��ϵͳ�л�û��¼��γ���Ϣ������");
	 		        	jf.setVisible(false);
	 		        }
	 		        else {
	 		        	jf.setVisible(true);
	 		        }
	 		        
	 		        
	 	}
	     private Vector createColumnNamesCourse() {
		       Vector columnNames = new Vector();
		       //columnNames.add("���");
		       columnNames.add("�γ̺�");
		       columnNames.add("�γ���");
		       columnNames.add("ѧ��");
		      
		       return columnNames;
		   }
		   
		     private Vector createTableModelDataCourse() {
		        
		         Vector data = new Vector();
		         String t=null;
					try{
						int i=0;
						 String sql="select * from Course";
						 System.out.println(1);
						  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //ִ��sql���
						  while (rs.next()) {  //���������
							  Vector rowData = new Vector();
							  
							  String Cno=rs.getString("Cno");  //���ݿ�����
							  String Cname=rs.getString("Cname");  //���ݿ�����
							  String Credit=rs.getString("Credit");  //���ݿ�����
							  
							  
							  rowData.add(Cno);
							  rowData.add(Cname);
							  rowData.add(Credit);
							  data.add(rowData);
						  }
				     
							} catch (SQLException e) {
									// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
							
						}	  
		        return data;
		     }
		     //*****************************************************
		     //��ʦģ��
		 	//��ʾȫ����ʦ��Ϣ
		 	public void show_allTea() {

		 		//��ʾȫ����ʦ��Ϣ
		 		    JFrame jf = new JFrame("��ʾȫ����ʦ��Ϣ(�����ͷ���԰�������������)");	   
		 		    // �����������
		 		     JPanel panel = new JPanel();
		 		    // ��ͷ��������
		 		   Vector columnNamesTea=createColumnNamesTea();
		 		   Vector dataTea=createTableModelDataTea();	   
		 		 // ����һ��Ĭ�ϵı��ģ��
		 		    model = new DefaultTableModel(dataTea, columnNamesTea);
		 		   table = new JTable(model);
		 	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		 	       JScrollPane tablePanel = new JScrollPane(table);  				        
		 		        // ���ñ��������ɫ
		 		        table.setForeground(Color.BLACK);                   // ������ɫ
		 		        table.setFont(new Font(null, Font.PLAIN, 14));      // ������ʽ
		 		        table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
		 		        table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
		 		        table.setGridColor(Color.GRAY);                     // ������ɫ

		 		        // ���ñ�ͷ
		 		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // ���ñ�ͷ����������ʽ
		 		        table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
		 		        table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
		 		        table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������

		 		        // �����и�
		 		        table.setRowHeight(40);

		 		        // ��һ���п�����Ϊ40
		 		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
		 	             
		 		        // ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
		 		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		 		        
		 		        //������	        
		 		        RowSorter sorter = new TableRowSorter(model);
		 		        table.setRowSorter(sorter);
		 		        JScrollPane pane = new JScrollPane(table);      

		 		        // �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		 		        JScrollPane scrollPane = new JScrollPane(table);

		 		        // ��� ������� �� �������
		 		        panel.add(scrollPane);
		 		       // JScrollPane pane = new JScrollPane(table);
		 		        // ���� ������� �� ����
		 		        jf.setContentPane(panel);
		 		        jf.pack();
		 		        jf.setSize(900, 600);
		 		        jf.add(scrollPane, BorderLayout.CENTER);
		 		        
		 		        //���ݾ�����ʾ
		 		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		 				r.setHorizontalAlignment(JLabel.CENTER);   
		 				table.setDefaultRenderer(Object.class, r);
		 				
		 		        jf.setLocationRelativeTo(null);
		 		        int t=table.getRowCount();
		 		        if(t<=0){
		 		        	JOptionPane.showMessageDialog(null, "��ϵͳ�л�û��¼���ʦ��Ϣ������");
		 		        	jf.setVisible(false);
		 		        }
		 		        else {
		 		        	jf.setVisible(true);
		 		        }
		 		        
		 		        
		 	}
		     private Vector createColumnNamesTea() {
			       Vector columnNames = new Vector();
			       //columnNames.add("���");
			       columnNames.add("����");
			       columnNames.add("����");
			       columnNames.add("�Ա�");
			       columnNames.add("����");
			       columnNames.add("�οογ̺�");
			       
			       return columnNames;
			   }
			   
			     private Vector createTableModelDataTea() {
			        
			         Vector data = new Vector();
			         String t=null;
						try{
							int i=0;
							 String sql="select * from Teacher";
							 System.out.println(1);
							  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //ִ��sql���
							  while (rs.next()) {  //���������
								  Vector rowData = new Vector();
								  
								  String Tno=rs.getString("Tno");  //���ݿ�����
								  String Tname=rs.getString("Tname");  //���ݿ�����
								  String Sex=rs.getString("Sex");  //���ݿ�����
								  String Birthday=rs.getString("Birthday");  //���ݿ�����
								  String Cno=rs.getString("Cno");  //���ݿ�����
								  
								  rowData.add(Tno);
								  rowData.add(Tname);
								  rowData.add(Sex);
								  rowData.add(Birthday);
								  rowData.add(Cno);
								  data.add(rowData);
							  }
					     
								} catch (SQLException e) {
										// TODO �Զ����ɵ� catch ��
								e.printStackTrace();
								
							}	  
			        return data;
			     }
			     //*****************************************************
			     //�ɼ�ģ��
			 	//��ʾ����ȫ���ɼ���Ϣ
			 	public void show_allGradeByPeo(String sno) {

			 		//��ʾȫ����ʦ��Ϣ
			 		    JFrame jf = new JFrame("��ʾȫ���ɼ���Ϣ(�����ͷ���԰�������������)");	   
			 		    // �����������
			 		     JPanel panel = new JPanel();
			 		    // ��ͷ��������
			 		   Vector columnNamesGradeByPeo=createColumnNamesGradeByPeo();
			 		   Vector dataGradeByPeo=createTableModelDataGradeByPeo(sno);	   
			 		 // ����һ��Ĭ�ϵı��ģ��
			 		    model = new DefaultTableModel(dataGradeByPeo, columnNamesGradeByPeo);
			 		   table = new JTable(model);
			 	       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
			 	       JScrollPane tablePanel = new JScrollPane(table);  				        
			 		        // ���ñ��������ɫ
			 		        table.setForeground(Color.BLACK);                   // ������ɫ
			 		        table.setFont(new Font(null, Font.PLAIN, 14));      // ������ʽ
			 		        table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
			 		        table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
			 		        table.setGridColor(Color.GRAY);                     // ������ɫ

			 		        // ���ñ�ͷ
			 		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // ���ñ�ͷ����������ʽ
			 		        table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
			 		        table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
			 		        table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������

			 		        // �����и�
			 		        table.setRowHeight(40);

			 		        // ��һ���п�����Ϊ40
			 		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
			 	             
			 		        // ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
			 		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
			 		        
			 		        //������	        
			 		        RowSorter sorter = new TableRowSorter(model);
			 		        table.setRowSorter(sorter);
			 		        JScrollPane pane = new JScrollPane(table);      

			 		        // �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
			 		        JScrollPane scrollPane = new JScrollPane(table);

			 		        // ��� ������� �� �������
			 		        panel.add(scrollPane);
			 		       // JScrollPane pane = new JScrollPane(table);
			 		        // ���� ������� �� ����
			 		        jf.setContentPane(panel);
			 		        jf.pack();
			 		        jf.setSize(900, 600);
			 		        jf.add(scrollPane, BorderLayout.CENTER);
			 		        
			 		        //���ݾ�����ʾ
			 		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
			 				r.setHorizontalAlignment(JLabel.CENTER);   
			 				table.setDefaultRenderer(Object.class, r);
			 				
			 		        jf.setLocationRelativeTo(null);
			 		        int t=table.getRowCount();
			 		        if(t<=0){
			 		        	JOptionPane.showMessageDialog(null, "��ϵͳ�л�û��¼����ĳɼ���Ϣ������");
			 		        	jf.setVisible(false);
			 		        }
			 		        else {
			 		        	jf.setVisible(true);
			 		        }
			 		        
			 		        
			 	}
			     private Vector createColumnNamesGradeByPeo() {
				       Vector columnNames = new Vector();
				       //columnNames.add("���");
				       columnNames.add("�γ̺�");
				       columnNames.add("�γ���");
				       columnNames.add("����");
				       return columnNames;
				   }
				   
				     private Vector createTableModelDataGradeByPeo(String sno) {
				        
				         Vector data = new Vector();
				         String t=null;
							try{
								int i=0;
								 String sql="select a.Cno,Cname,Grade from sc a,course b where sno="+"'"+sno+"' and "+"a.Cno=b.Cno";
								 System.out.println(1);
								  ResultSet rs=dBconnet.getStatement().executeQuery(sql);   //ִ��sql���
								  while (rs.next()) {  //���������
									  Vector rowData = new Vector();
									  
									  String Cno=rs.getString("Cno");  //���ݿ�����
									  String Cname=rs.getString("Cname");  //���ݿ�����
									  String Grade=rs.getString("Grade");  //���ݿ�����
									
									  
									  rowData.add(Cno);
									  rowData.add(Cname);
									  rowData.add(Grade);
									 
									  data.add(rowData);
								  }
						     
									} catch (SQLException e) {
											// TODO �Զ����ɵ� catch ��
									e.printStackTrace();
									
								}	  
				        return data;
				     } 
			     
}
