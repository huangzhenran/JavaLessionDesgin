package lessionDesign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeInput {
   JFrame jdFrame=new JFrame();
	public GradeInput() {
		// TODO Auto-generated constructor stub
		 JPanel studentpanel = new JPanel();
	        studentpanel.setLayout(null);

	        jdFrame.setTitle("�ɼ�¼��");
	        JLabel snoLab = new JLabel("ѧ���ţ�");
	        JLabel cnoLab = new JLabel("�γ̺ţ�");
	        JLabel gradeLab = new JLabel("�ɼ���");
	        JTextField snoText = new JTextField();
	        JTextField cnoText = new JTextField();
	        JTextField gradeText = new JTextField();
	        JButton submit = new JButton("�ύ");
	        JButton back = new JButton("����");

            submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sno=snoText.getText();  //��ȡѧ��
					String cno=cnoText.getText();  //��ȡ�γ̺�
					String grade=gradeText.getText();  //��ȡ����
					
					DBManager dbManager=new DBManager();
					dbManager.inertGrade(sno, cno, Float.parseFloat(grade));
				}
			});
	        
	        back.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	jdFrame.dispose();
	            	new teacherInfoInterface().jFrame.setVisible(true);
	            }
	        });


	        snoLab.setBounds(40,45,60,20);
	        snoText.setBounds(105,45,220,30);
	        cnoLab.setBounds(40,85,60,20);
	        cnoText.setBounds(105,85,220,30);
	        gradeLab.setBounds(40,135,60,20);
	        gradeText.setBounds(105,135,220,30);
	        submit.setBounds(150,270,65,30);
	        back.setBounds(220,270,65,30);

	        studentpanel.setSize(370,700);
	        studentpanel.setLocation(0,0);
	        studentpanel.add(snoLab);
	        studentpanel.add(snoText);
	        studentpanel.add(cnoLab);
	        studentpanel.add(cnoText);
	        studentpanel.add(gradeLab);
	        studentpanel.add(gradeText);
	        studentpanel.add(submit);
	        studentpanel.add(back);
	       // studentpanel.setVisible(true);
	        jdFrame.add(studentpanel);
	        jdFrame.setLocation(350,150);
	        jdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��һ��Ĭ�ϵĹرղ�����Ҳ�������JFrame���ڵĹرհ�ť�������ʱ���˳�����
	        jdFrame.setSize(1200,800);
  	  jdFrame.setVisible(true);//Ŀ����ʹ�ؼ�������ʾ����,����ÿؼ��Ѿ�����ʾ����

	       
	}
}
