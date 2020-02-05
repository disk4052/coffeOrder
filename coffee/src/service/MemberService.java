package service;

import javax.swing.JTextField;

import dto.MemberDTO;
import javabean.MemberDAO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	public boolean getId(String id) {
		return dao.getId(id);
	}
	
	public void addMember(MemberDTO dto) {
		dao.addMember(dto);
	}
	
	public boolean pwCheck(String id, String pwd) {
		return dao.pwCheck(id, pwd);
	}
}
