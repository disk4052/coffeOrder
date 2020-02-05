package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javabean.MemberDAO;
import singleton.Singleton;

public class Viewer extends JFrame {
	
	Container contain = getContentPane();
	JPanel main;
	JButton login, join;
	JLabel id, pw;
	JTextField idTf;
	JPasswordField pwTf;

	
	public Viewer() {
		super("메인화면");
		
		contain.setLayout(null);
		
		main = new JPanel();
		
		main.setLayout(null);
		main.setSize(400, 400);
		main.setLocation(50, 0);
		
		login = new JButton("로그인");
		login.setSize(150,50);
		login.setLocation(10,300);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Singleton.getInstance().memCtrl.login(pwTf, idTf)) {	
					Singleton.getInstance().setLoginID(idTf.getText());
					dispose();
				}
			}
		});
		
		join = new JButton("회원가입");
		join.setSize(150,50);
		join.setLocation(230,300);
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton.getInstance().memCtrl.join();	
			}
		});
		
		
		id = new JLabel("ID");
		id.setSize(100,50);
		id.setLocation(110,50);
		
		pw = new JLabel("PW");
		pw.setSize(100,50);
		pw.setLocation(100,100);
		
		idTf = new JTextField();
		idTf.setSize(100,20);
		idTf.setLocation(160,65);
		idTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Singleton.getInstance().memCtrl.login(pwTf, idTf)) {
					dispose();
				}
			}
		});
		
		pwTf = new JPasswordField();
		pwTf.setSize(100,20);
		pwTf.setLocation(160,115);
		pwTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Singleton.getInstance().memCtrl.login(pwTf, idTf)) {
					dispose();
				}				
			}
		});
		
		main.add(id);
		main.add(login);
		main.add(join);
		main.add(pw);
		main.add(idTf);
		main.add(pwTf);
		contain.add(main);
		
		setSize(500,500);
		setLocation(200,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
}
