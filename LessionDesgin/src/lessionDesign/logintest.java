package lessionDesign;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class logintest  {
	
	//������� 
	JFrame jFrame = new  JFrame();
    JTextField account,password;//����ѧ��������Ϣ���ı�
    JPasswordField password1;
    JRadioButton ��,Ů;//������ѡ������Ա�ѡ��
    ButtonGroup group=null;//������ť��
    JButton Blogin;//������Ӧ�Ĳ����İ�ť
    JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;//���ڲ��ֵ�ͨ��

	public void loginInterface() {
		jFrame.setTitle("��½����");
		account=new JTextField(15);//�����ı���Ϣ�ĵĶ���
		password1=new JPasswordField(15);
	    
	    
	    group=new ButtonGroup();
	   
	    group.add(��);//�Ѱ�ť��ӵ���ť��
	    group.add(Ů);
	    Blogin=new JButton("��½");//������ť����
	 
	       
	    Font font = new Font("����", Font.PLAIN, 25);//����1������ʵ��
	    
	    p3=new JPanel();//����һ�����     
	    p4=new JPanel();//����һ�����    
	    p5=new JPanel();//����һ�����    
	    p6=new JPanel();//����һ�����    
	    p1=new JPanel();//����һ�����     
	    JLabel j1= new JLabel("�ʺ�:",JLabel.CENTER);
	    JLabel j2 =new JLabel("����:",JLabel.CENTER);
	    
	    j1.setFont(font);
	    j2.setFont(font);
	    p1.add(j1);//JLabel.CENTER��ָJLabel�����ĵ㡣CENTER�����ĵ������
	    p1.add(account);
	    account.setFont(font);
	    p2=new JPanel();
	    p2.add(j2);
	    p2.add(password1);
	    password1.setFont(font); 
	    pv=new JPanel();//���
	    pv.setLayout(new GridLayout(7,1));   //��pv������óɵ�����1�е����񲼾�
	    pv.add(p3);
	    pv.add(p4);
	    pv.add(p5);
	    pv.add(p6);
	    pv.add(p1);//�����ŵ�������,add()��������
	    pv.add(p2);

	           
	    ph=new JPanel();      
	    ph.add(Blogin);

	    Blogin.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String accountString=account.getText();
					String passwordString=password1.getText();
					DBManager dbManager=new DBManager();
					if (1==dbManager.login(accountString, passwordString)) {
						jFrame.setVisible(false);
					}
					;
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});

	    Container con=jFrame.getContentPane();//������������con,ȡ���������
	    con.setLayout(new BorderLayout());//���ò���Ϊ�߿򲼾֣��߿򲼾ֶַ���������5����λ����ӿؼ���
	    //��û��ָ����λ������ӵ��м䣬�������Ҷ�������չ
	  
	    con.add(pv, BorderLayout.NORTH);//pv���м�
	    con.add(ph, BorderLayout.SOUTH);//ph���ϱ�
	    jFrame.setLocation(350,150);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��һ��Ĭ�ϵĹرղ�����Ҳ�������JFrame���ڵĹرհ�ť�������ʱ���˳�����
	    //jf.setBounds(100,100,900,450);//setBounds(x,y,width,height); x:���������X���ϵ���� y:���������Y���ϵ���� width:����ĳ��� height:����ĸ߶�
	    jFrame.setSize(1200,800);
	    jFrame.setVisible(true);//Ŀ����ʹ�ؼ�������ʾ����,����ÿؼ��Ѿ�����ʾ����
	      
	  
	} 
	public void logout() {
		
	}
}
