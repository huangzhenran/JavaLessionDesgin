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

	        jdFrame.setTitle("成绩录入");
	        JLabel snoLab = new JLabel("学生号：");
	        JLabel cnoLab = new JLabel("课程号：");
	        JLabel gradeLab = new JLabel("成绩：");
	        JTextField snoText = new JTextField();
	        JTextField cnoText = new JTextField();
	        JTextField gradeText = new JTextField();
	        JButton submit = new JButton("提交");
	        JButton back = new JButton("返回");

            submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sno=snoText.getText();  //获取学号
					String cno=cnoText.getText();  //获取课程号
					String grade=gradeText.getText();  //获取分数
					
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
	        jdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//置一个默认的关闭操作，也就是你的JFrame窗口的关闭按钮，点击它时，退出程序
	        jdFrame.setSize(1200,800);
  	  jdFrame.setVisible(true);//目的是使控件可以显示出来,如果该控件已经被显示出来

	       
	}
}
