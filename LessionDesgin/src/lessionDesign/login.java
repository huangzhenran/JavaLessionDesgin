package lessionDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.jar.JarInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.javafx.geom.AreaOp.AddOp;

public class login {

	public static void main(String[] args) {
		 JFrame jf=new JFrame("窗口2");
		 JTextField account,password;
		 
		 account=new JTextField(20);
	    password=new JTextField(20);
	     
	    JLabel j1=new JLabel("帐号:");
	    JLabel j2=new JLabel("密码:");
	    j1.setForeground(Color.white);
	    j2.setForeground(Color.white);
	    Font font = new Font("宋体", Font.PLAIN, 25);//创建1个字体实例
	    j1.setFont(font);
	    j2.setFont(font);
	    
	     JPanel jp1=new JPanel(); //创建面板
	     JPanel jp2=new JPanel();
	     JPanel jp3=new JPanel();
	     
	     jp1.add(j1);
	     jp1.add(account);
	     jp2.add(j2);
	     jp2.add(password);
	     
	   
	     
	     JLabel label=new JLabel();
	        ImageIcon icon=new ImageIcon("source\\image\\1.jpg");
	        Image image=icon.getImage();
	        image=image.getScaledInstance(1200, 800, image.SCALE_DEFAULT);
	        icon.setImage(image);
	        label.setIcon(icon);
	        
	      JPanel myPanel=new JPanel();
		
			label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());	//把标签设置为和图片等高等宽
			myPanel = (JPanel)jf.getContentPane();		//把我的面板设置为内容面板
			myPanel.setOpaque(false);					//把我的面板设置为不可视
			myPanel.setLayout(new FlowLayout());		//把我的面板设置为流动布局
			jf.getLayeredPane().setLayout(null);		//把分层面板的布局置空
			myPanel.add(account);						//把按钮添加到我的面板里
			jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//把标签添加到分层面板的最底层
		
	        
	      
	        //jf.setLayout(new GridLayout(2,1));
	       // jf.add(jp1);
	       // jf.add(jp2);
	        
			
	        jf.setSize(1200,800);
		     jf.setLayout(new FlowLayout());
		     jf.setLocation(350, 150);
		     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     jf.setVisible(true);
	}
}
