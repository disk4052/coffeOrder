package singleton;

import controller.MemberController;
import controller.OrderController;
import controller.PriceController;

public class Singleton {
private static Singleton s = null;
	
	public MemberController memCtrl = null;
	public PriceController priCtrl = null;
	public OrderController ordCtrl = null;
	//public BbsController bbsCtrl = null;
	
	private String loginID = null;
	
	private Singleton() {
		memCtrl = new MemberController();
		priCtrl = new PriceController();
		ordCtrl = new OrderController();
		//bbsCtrl = new BbsController();		
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
}
