package service;

import java.util.List;

import dto.PriceDTO;
import javabean.PriceDAO;

public class PriceService {
	
	PriceDAO dao = new PriceDAO();
	
	public List<PriceDTO> getPriceList(){
		return dao.getPriceList();
	}
}
