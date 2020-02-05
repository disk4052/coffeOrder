package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dto.MemberDTO;
import service.MemberService;
import singleton.Singleton;
import view.Join;
import view.OrderMain;

public class MemberController {
	MemberService memberS = new MemberService();
	
	public void orderMain() {
		new OrderMain();
	}
	
	public void join() {
		new Join();
	}
	
	public boolean joinCheck(JTextField idTf, JTextField pwTf, JTextField nameTf, JTextField ageTf, JTextField emailTf, String id_temp, int id_check) {
		if((!(idTf.getText().equals("")) && !(pwTf.getText().equals("")) && !(nameTf.getText().equals("")) && !(emailTf.getText().equals("")) && !(ageTf.getText().equals("")))
				&& id_check == 1 && idTf.getText().equals(id_temp)){
			MemberDTO dto = new MemberDTO(idTf.getText(), pwTf.getText(), nameTf.getText(), Integer.parseInt(ageTf.getText()), emailTf.getText(), 1);
			memberS.addMember(dto);
			JOptionPane.showMessageDialog(null, "���������� ���ԵǾ����ϴ�.");
			return true;
		}
		else if((!(idTf.getText().equals("")) && !(pwTf.getText().equals("")) && !(nameTf.getText().equals("")) && !(emailTf.getText().equals("")) && !(ageTf.getText().equals("")))
				&& id_check == 0 && idTf.getText().equals(id_temp)) {
			JOptionPane.showMessageDialog(null, "���̵� �ߺ��� Ȯ�����ּ���.");
		}
		else if((!(idTf.getText().equals("")) && !(pwTf.getText().equals("")) && !(nameTf.getText().equals("")) && !(emailTf.getText().equals("")) && !(ageTf.getText().equals("")))
				&& id_check == 1 && !(idTf.getText().equals(id_temp))) {
			JOptionPane.showMessageDialog(null, "�ߺ�Ȯ���� ���̵�� �ٸ��ϴ�.");
		}
		else {
			JOptionPane.showMessageDialog(null, "�׸��� ���� �Է����ּ���.");
		}
		return false;
	}
	
	public boolean idCheck(JTextField idTf) {
		if(idTf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.");
			return false;
		}
		else if(memberS.getId(idTf.getText())) {
			JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵� �Դϴ�.");
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�.");
			return true;
		}
	}
	
	public boolean login(JPasswordField pwTf, JTextField idTf) {
		String pwd = new String(pwTf.getPassword());
		// TODO Auto-generated method stub
		
		if(idTf.getText().equals("") && pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "���̵�� �н����带 �Է����ּ���.");
		}
		else if(!(memberS.getId(idTf.getText()))) {
			JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵� �Դϴ�.");
		}
		else {
			if(memberS.pwCheck(idTf.getText(), pwd)) {
				JOptionPane.showMessageDialog(null, "�α��� ���� !");
				Singleton.getInstance().setLoginID(idTf.getText());
				new OrderMain();
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "�н����尡 Ʋ�Ƚ��ϴ�.");
			}
		}
		
		return false;
	}
	
}
