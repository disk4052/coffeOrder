package dto;

public class PriceDTO {
	private String beverage;
	private int short_;
	private int tall;
	private int grande;
	
	public PriceDTO() {
		
	}
	
	public PriceDTO(String beverage, int short_, int tall, int grande) {
		super();
		this.beverage = beverage;
		this.short_ = short_;
		this.tall = tall;
		this.grande = grande;
	}


	@Override
	public String toString() {
		return "PriceDTO [beverage=" + beverage + ", short_=" + short_ + ", tall=" + tall + ", grande=" + grande + "]";
	}
	
	
	public String getBeverage() {
		return beverage;
	}
	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}
	public int getShort_() {
		return short_;
	}
	public void setShort_(int short_) {
		this.short_ = short_;
	}
	public int getTall() {
		return tall;
	}
	public void setTall(int tall) {
		this.tall = tall;
	}
	public int getGrande() {
		return grande;
	}
	public void setGrande(int grande) {
		this.grande = grande;
	}
	
}
