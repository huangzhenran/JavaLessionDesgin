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
		 JFrame jf=new JFrame("����2");
		 JTextField account,password;
		 
		 account=new JTextField(20);
	    password=new JTextField(20);
	     
	    JLabel j1=new JLabel("�ʺ�:");
	    JLabel j2=new JLabel("����:");
	    j1.setForeground(Color.white);
	    j2.setForeground(Color.white);
	    Font font = new Font("����", Font.PLAIN, 25);//����1������ʵ��
	    j1.setFont(font);
	    j2.setFont(font);
	    
	     JPanel jp1=new JPanel(); //�������
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
		
			label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());	//�ѱ�ǩ����Ϊ��ͼƬ�ȸߵȿ�
			myPanel = (JPanel)jf.getContentPane();		//���ҵ��������Ϊ�������
			myPanel.setOpaque(false);					//���ҵ��������Ϊ������
			myPanel.setLayout(new FlowLayout());		//���ҵ��������Ϊ��������
			jf.getLayeredPane().setLayout(null);		//�ѷֲ����Ĳ����ÿ�
			myPanel.add(account);						//�Ѱ�ť��ӵ��ҵ������
			jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//�ѱ�ǩ��ӵ��ֲ�������ײ�
		
	        
	      
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
