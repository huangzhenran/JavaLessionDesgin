package lessionDesign;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ManagementCenter extends JFrame {
    JButton b1,b2,b3;
	JPanel p1;
    Font font=new Font("宋体", Font.BOLD, 25);//创建1个字体实例
    
	public ManagementCenter() {
		this.setTitle("管理员中心");
		 b1=new JButton("学生信息管理");
	     b2=new JButton("课程管理");
	     b3=new JButton("教师信息管理");
	     
	     
	     
	      b1.setFont(font);
	      b2.setFont(font);
	      b3.setFont(font);
	      
	     p1=new JPanel();//创建一个面板    
	     p1.setLayout(new GridLayout(3,1));//布局三行一列
	     p1.add(b1);
	     p1.add(b2);
	     p1.add(b3);
	    this.add(p1);
	    
	    b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new show_All().show_allStu();
			}
		});
	    b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new show_All().show_allTea();
			}
		});
	    
	    b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new show_All().show_allCourse();
			}
		});
	     this.setLocation(350,150);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//置一个默认的关闭操作，也就是你的JFrame窗口的关闭按钮，点击它时，退出程序
		    this.setSize(1200,800);
		    this.setVisible(true);//目的是使控件可以显示出来,如果该控件已经被显示出来
	}
    
    public void TeacherManagement() {
		
	}
    public void StudentManagement() {
		
	}
    public void courseManagement() {
		
	}
}
