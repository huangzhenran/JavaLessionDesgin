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
    Font font=new Font("����", Font.BOLD, 25);//����1������ʵ��
    
	public ManagementCenter() {
		this.setTitle("����Ա����");
		 b1=new JButton("ѧ����Ϣ����");
	     b2=new JButton("�γ̹���");
	     b3=new JButton("��ʦ��Ϣ����");
	     
	     
	     
	      b1.setFont(font);
	      b2.setFont(font);
	      b3.setFont(font);
	      
	     p1=new JPanel();//����һ�����    
	     p1.setLayout(new GridLayout(3,1));//��������һ��
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
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��һ��Ĭ�ϵĹرղ�����Ҳ�������JFrame���ڵĹرհ�ť�������ʱ���˳�����
		    this.setSize(1200,800);
		    this.setVisible(true);//Ŀ����ʹ�ؼ�������ʾ����,����ÿؼ��Ѿ�����ʾ����
	}
    
    public void TeacherManagement() {
		
	}
    public void StudentManagement() {
		
	}
    public void courseManagement() {
		
	}
}
