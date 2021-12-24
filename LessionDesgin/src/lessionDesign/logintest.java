package lessionDesign;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class logintest {
	
	//定义组件 
	 JFrame jf=new JFrame("登陆界面");
    JTextField 学号,姓名,年龄,电话号码,家庭住址,身份证号码;//输入学生基本信息得文本
    JPasswordField 密码;
    JRadioButton 男,女;//声明单选项对象，性别选择
    ButtonGroup group=null;//声明按钮组
    JButton 登陆,查询,删除,修改,显示,返回;//声明相应的操作的按钮
    JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;//调节布局的通道

	public logintest() {
		
		学号=new JTextField(15);//创建文本信息的的对象
	    密码=new JPasswordField(15);
	    电话号码=new JTextField(15);
	    年龄=new JTextField(5);
	    家庭住址=new JTextField(15);
	    身份证号码=new JTextField(18);
	    
	    group=new ButtonGroup();
	    男=new JRadioButton("男");//初始化单选框,
	    女=new JRadioButton("女");
	    group.add(男);//把按钮添加到按钮组
	    group.add(女);
	    登陆=new JButton("登陆");//创建按钮对象
	    查询=new JButton("查询符合条件的学生信息");
	    删除=new JButton("删除学生信息");
	    修改=new JButton("修改学生信息");
	    显示=new JButton("显示全部学生信息");
	    返回=new JButton("返回登录界面");
	       
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
	    p1.add(学号);
	    学号.setFont(font);
	    p2=new JPanel();
	    p2.add(j2);
	    p2.add(密码);
	    密码.setFont(font); 
	    pv=new JPanel();//面板
	    pv.setLayout(new GridLayout(7,1));   //把pv组件设置成第七行1列的网格布局
	    pv.add(p3);
	    pv.add(p4);
	    pv.add(p5);
	    pv.add(p6);
	    pv.add(p1);//把面板放到容器中,add()代表容器
	    pv.add(p2);

	           
	    ph=new JPanel();      
	    ph.add(登陆);

	    JLabel label=new JLabel();
        ImageIcon icon=new ImageIcon("image\\nami.jpg");
        Image image=icon.getImage();
        image=image.getScaledInstance(1200, 800, image.SCALE_DEFAULT);
        icon.setImage(image);
        label.setIcon(icon);
        
       
       
	    Container con=jf.getContentPane();//建立容器对象con,取得容器面板
	    con.setLayout(new BorderLayout());//设置布局为边框布局，边框布局分东南西北中5个方位来添加控件。
	    //若没有指定方位，将添加到中间，上下左右都可以扩展
	  
	    con.add(pv, BorderLayout.NORTH);//pv在中间
	    con.add(ph, BorderLayout.SOUTH);//ph在南边
	    jf.setLocation(350,150);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//置一个默认的关闭操作，也就是你的JFrame窗口的关闭按钮，点击它时，退出程序
	    //jf.setBounds(100,100,900,450);//setBounds(x,y,width,height); x:组件在容器X轴上的起点 y:组件在容器Y轴上的起点 width:组件的长度 height:组件的高度
	    jf.setSize(1200,800);
	    jf.setVisible(true);//目的是使控件可以显示出来,如果该控件已经被显示出来
	      
	  
	}

}
