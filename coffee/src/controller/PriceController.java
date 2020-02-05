package controller;

import service.PriceService;
import view.PriceView;

public class PriceController {
	PriceService priceService = new PriceService();
	
	public void getList() {
		PriceView.getInstance().view(priceService.getPriceList());
	}
}
