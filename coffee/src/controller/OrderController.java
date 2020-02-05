package controller;

import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import dto.OrderDTO;
import service.OrderService;

public class OrderController {
	
	OrderService orderService = new OrderService();
	
	public String buttonCheck(ButtonGroup group) {
		Enumeration<AbstractButton> enums = group.getElements();
		while(enums.hasMoreElements()) {
		    AbstractButton ab = enums.nextElement();
		    JRadioButton jb = (JRadioButton)ab;
		 
		    if(jb.isSelected()) {
		        return jb.getText();
		    }
		}
		return "선택안함";
	}
	
	
	public String checkBox(JCheckBox chBox) {
		if(chBox.isSelected()) {
			return chBox.getText();
		}
		else {
			return "없음";
		}
	}
	
	public int priceSearch(String beverage, String size_) {
		return orderService.priceSearch(beverage, size_);
	}
	
	public void orderInsert(List<OrderDTO> list) {
		for(int i = 0 ; i < list.size() ; i++) {
			orderService.orderInsert(list.get(i));
		}
	}
	
	public List<OrderDTO> getOrderList(String id){
		return orderService.getOrderList(id);
	}
}
