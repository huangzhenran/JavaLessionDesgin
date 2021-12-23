package lessionDesign;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class login {

	public void createWindow() {
		 JFrame jf=new JFrame("窗口1");
	     jf.setSize(1200,800);
	     jf.setLayout(new FlowLayout());
	     jf.setLocation(350, 150);
	     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     JPanel jPanelTop=new JPanel(); //创建面板
	     JPanel jPanelButtom=new JPanel();
	     JPanel jPanelCenter=new JPanel();
	     jPanelTop.setBackground(Color.gray);
	     jf.setVisible(true);
	}
}
