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
			JOptionPane.showMessageDialog(null, "성공적으로 가입되었습니다.");
			return true;
		}
		else if((!(idTf.getText().equals("")) && !(pwTf.getText().equals("")) && !(nameTf.getText().equals("")) && !(emailTf.getText().equals("")) && !(ageTf.getText().equals("")))
				&& id_check == 0 && idTf.getText().equals(id_temp)) {
			JOptionPane.showMessageDialog(null, "아이디 중복을 확인해주세요.");
		}
		else if((!(idTf.getText().equals("")) && !(pwTf.getText().equals("")) && !(nameTf.getText().equals("")) && !(emailTf.getText().equals("")) && !(ageTf.getText().equals("")))
				&& id_check == 1 && !(idTf.getText().equals(id_temp))) {
			JOptionPane.showMessageDialog(null, "중복확인한 아이디와 다릅니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "항목을 전부 입력해주세요.");
		}
		return false;
	}
	
	public boolean idCheck(JTextField idTf) {
		if(idTf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
			return false;
		}
		else if(memberS.getId(idTf.getText())) {
			JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.");
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
			return true;
		}
	}
	
	public boolean login(JPasswordField pwTf, JTextField idTf) {
		String pwd = new String(pwTf.getPassword());
		// TODO Auto-generated method stub
		
		if(idTf.getText().equals("") && pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디와 패스워드를 입력해주세요.");
		}
		else if(!(memberS.getId(idTf.getText()))) {
			JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다.");
		}
		else {
			if(memberS.pwCheck(idTf.getText(), pwd)) {
				JOptionPane.showMessageDialog(null, "로그인 성공 !");
				Singleton.getInstance().setLoginID(idTf.getText());
				new OrderMain();
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.");
			}
		}
		
		return false;
	}
	
}
