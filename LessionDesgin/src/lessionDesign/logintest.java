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
	
	//定义组件 
	JFrame jFrame = new  JFrame();
    JTextField account,password;//输入学生基本信息得文本
    JPasswordField password1;
    JRadioButton 男,女;//声明单选项对象，性别选择
    ButtonGroup group=null;//声明按钮组
    JButton Blogin;//声明相应的操作的按钮
    JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;//调节布局的通道

	public void loginInterface() {
		jFrame.setTitle("登陆界面");
		account=new JTextField(15);//创建文本信息的的对象
		password1=new JPasswordField(15);
	    
	    
	    group=new ButtonGroup();
	   
	    group.add(男);//把按钮添加到按钮组
	    group.add(女);
	    Blogin=new JButton("登陆");//创建按钮对象
	 
	       
	    Font font = new Font("宋体", Font.PLAIN, 25);//创建1个字体实例
	    
	    p3=new JPanel();//创建一个面板     
	    p4=new JPanel();//创建一个面板    
	    p5=new JPanel();//创建一个面板    
	    p6=new JPanel();//创建一个面板    
	    p1=new JPanel();//创建一个面板     
	    JLabel j1= new JLabel("帐号:",JLabel.CENTER);
	    JLabel j2 =new JLabel("密码:",JLabel.CENTER);
	    
	    j1.setFont(font);
	    j2.setFont(font);
	    p1.add(j1);//JLabel.CENTER是指JLabel的中心点。CENTER是中心点的坐标
	    p1.add(account);
	    account.setFont(font);
	    p2=new JPanel();
	    p2.add(j2);
	    p2.add(password1);
	    password1.setFont(font); 
	    pv=new JPanel();//面板
	    pv.setLayout(new GridLayout(7,1));   //把pv组件设置成第七行1列的网格布局
	    pv.add(p3);
	    pv.add(p4);
	    pv.add(p5);
	    pv.add(p6);
	    pv.add(p1);//把面板放到容器中,add()代表容器
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

	    Container con=jFrame.getContentPane();//建立容器对象con,取得容器面板
	    con.setLayout(new BorderLayout());//设置布局为边框布局，边框布局分东南西北中5个方位来添加控件。
	    //若没有指定方位，将添加到中间，上下左右都可以扩展
	  
	    con.add(pv, BorderLayout.NORTH);//pv在中间
	    con.add(ph, BorderLayout.SOUTH);//ph在南边
	    jFrame.setLocation(350,150);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//置一个默认的关闭操作，也就是你的JFrame窗口的关闭按钮，点击它时，退出程序
	    //jf.setBounds(100,100,900,450);//setBounds(x,y,width,height); x:组件在容器X轴上的起点 y:组件在容器Y轴上的起点 width:组件的长度 height:组件的高度
	    jFrame.setSize(1200,800);
	    jFrame.setVisible(true);//目的是使控件可以显示出来,如果该控件已经被显示出来
	      
	  
	} 
	public void logout() {
		
	}
}
