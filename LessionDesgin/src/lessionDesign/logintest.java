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
	
	//������� 
	 JFrame jf=new JFrame("��½����");
    JTextField ѧ��,����,����,�绰����,��ͥסַ,���֤����;//����ѧ��������Ϣ���ı�
    JPasswordField ����;
    JRadioButton ��,Ů;//������ѡ������Ա�ѡ��
    ButtonGroup group=null;//������ť��
    JButton ��½,��ѯ,ɾ��,�޸�,��ʾ,����;//������Ӧ�Ĳ����İ�ť
    JPanel p1,p2,p3,p4,p5,p6,p7,pv,ph,pb;//���ڲ��ֵ�ͨ��

	public logintest() {
		
		ѧ��=new JTextField(15);//�����ı���Ϣ�ĵĶ���
	    ����=new JPasswordField(15);
	    �绰����=new JTextField(15);
	    ����=new JTextField(5);
	    ��ͥסַ=new JTextField(15);
	    ���֤����=new JTextField(18);
	    
	    group=new ButtonGroup();
	    ��=new JRadioButton("��");//��ʼ����ѡ��,
	    Ů=new JRadioButton("Ů");
	    group.add(��);//�Ѱ�ť��ӵ���ť��
	    group.add(Ů);
	    ��½=new JButton("��½");//������ť����
	    ��ѯ=new JButton("��ѯ����������ѧ����Ϣ");
	    ɾ��=new JButton("ɾ��ѧ����Ϣ");
	    �޸�=new JButton("�޸�ѧ����Ϣ");
	    ��ʾ=new JButton("��ʾȫ��ѧ����Ϣ");
	    ����=new JButton("���ص�¼����");
	       
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
	    p1.add(ѧ��);
	    ѧ��.setFont(font);
	    p2=new JPanel();
	    p2.add(j2);
	    p2.add(����);
	    ����.setFont(font); 
	    pv=new JPanel();//���
	    pv.setLayout(new GridLayout(7,1));   //��pv������óɵ�����1�е����񲼾�
	    pv.add(p3);
	    pv.add(p4);
	    pv.add(p5);
	    pv.add(p6);
	    pv.add(p1);//�����ŵ�������,add()��������
	    pv.add(p2);

	           
	    ph=new JPanel();      
	    ph.add(��½);

	    JLabel label=new JLabel();
        ImageIcon icon=new ImageIcon("image\\nami.jpg");
        Image image=icon.getImage();
        image=image.getScaledInstance(1200, 800, image.SCALE_DEFAULT);
        icon.setImage(image);
        label.setIcon(icon);
        
       
       
	    Container con=jf.getContentPane();//������������con,ȡ���������
	    con.setLayout(new BorderLayout());//���ò���Ϊ�߿򲼾֣��߿򲼾ֶַ���������5����λ����ӿؼ���
	    //��û��ָ����λ������ӵ��м䣬�������Ҷ�������չ
	  
	    con.add(pv, BorderLayout.NORTH);//pv���м�
	    con.add(ph, BorderLayout.SOUTH);//ph���ϱ�
	    jf.setLocation(350,150);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��һ��Ĭ�ϵĹرղ�����Ҳ�������JFrame���ڵĹرհ�ť�������ʱ���˳�����
	    //jf.setBounds(100,100,900,450);//setBounds(x,y,width,height); x:���������X���ϵ���� y:���������Y���ϵ���� width:����ĳ��� height:����ĸ߶�
	    jf.setSize(1200,800);
	    jf.setVisible(true);//Ŀ����ʹ�ؼ�������ʾ����,����ÿؼ��Ѿ�����ʾ����
	      
	  
	}

}
