package service;

import java.util.List;

import dto.OrderDTO;
import javabean.OrderDAO;

public class OrderService {
	
	OrderDAO dao = new OrderDAO();
	
	public int priceSearch(String beverage, String size_) {
		return dao.priceSearch(beverage, size_);
	}
	
	public void orderInsert(OrderDTO dto) {
		dao.addOrder(dto);
	}
	
	public List<OrderDTO> getOrderList(String id){
		return dao.getOrderList(id);
	}
}
