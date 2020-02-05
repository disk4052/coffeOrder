package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.MemberDTO;
import javabean.MemberDAO;
import singleton.Singleton;

public class Join extends JFrame{
		
		int id_check = 0;
		String id_temp = "";
	
		JPanel main;
		JButton join, idCheck, exit;
		JLabel id, pw, name, age, email;
		JTextField idTf, pwTf, nameTf, ageTf, emailTf;
		
		Container contain = getContentPane();
		
		public Join() {
			super("회원가입");
			contain.setLayout(null);
			
			main = new JPanel();
			main.setLayout(null);
			main.setSize(400, 400);
			main.setLocation(50, 0);
			
			id = new JLabel("ID");
			id.setSize(100,50);
			id.setLocation(110,50);
			
			pw = new JLabel("PW");
			pw.setSize(100,50);
			pw.setLocation(100,100);
			
			name = new JLabel("NAME");
			name.setSize(100,50);
			name.setLocation(90,150);
			
			age = new JLabel("AGE");
			age.setSize(100,50);
			age.setLocation(90,200);
			
			email = new JLabel("EMAIL");
			email.setSize(100,50);
			email.setLocation(90,250);
			
			idTf = new JTextField();
			idTf.setSize(100,20);
			idTf.setLocation(160,65);
			
			pwTf = new JTextField();
			pwTf.setSize(100,20);
			pwTf.setLocation(160,115);
			
			nameTf = new JTextField();
			nameTf.setSize(100,20);
			nameTf.setLocation(160,165);
			
			ageTf = new JTextField();
			ageTf.setSize(100,20);
			ageTf.setLocation(160,215);
			
			emailTf = new JTextField();
			emailTf.setSize(100,20);
			emailTf.setLocation(160,265);
			
			idCheck = new JButton("ID중복확인");
			idCheck.setSize(100,20);
			idCheck.setLocation(300,63);
			idCheck.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(Singleton.getInstance().memCtrl.idCheck(idTf)) {
						id_check = 1;
						id_temp = idTf.getText();
					}
				}
			});
			
			join = new JButton("회원가입");
			join.setSize(100,50);
			join.setLocation(80,300);
			join.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Singleton.getInstance().memCtrl.joinCheck(idTf, pwTf, nameTf, ageTf, emailTf, id_temp, id_check)) {
						dispose();
					}
					// TODO Auto-generated method stub
					
				}
			});
			
			exit = new JButton("이전화면");
			exit.setSize(100,50);
			exit.setLocation(240,300);
			exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			
			main.add(id);
			main.add(pw);
			main.add(name);
			main.add(email);
			main.add(age);
			
			main.add(idTf);
			main.add(pwTf);
			main.add(nameTf);
			main.add(emailTf);
			main.add(ageTf);
			
			main.add(idCheck);
			main.add(join);
			main.add(exit);
			
			contain.add(main);
			setSize(500,500);
			setLocation(200,200);
			setVisible(true);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
