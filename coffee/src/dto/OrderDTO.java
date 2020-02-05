package dto;

/*
	CREATE TABLE CAFEORDER(
	SEQ NUMBER(8) PRIMARY KEY,
	BEVERAGE VARCHAR2(50) NOT NULL, 
	SYRUP VARCHAR2(10) NOT NULL,
	CUPSIZE VARCHAR2(10) NOT NULL,
	ADDSHOT VARCHAR2(10) NOT NULL,
	ADDCREAM VARCHAR2(10) NOT NULL,
	CUP NUMBER(2) NOT NULL,
	PRICE NUMBER(8) NOT NULL,
	WDATE DATE NOT NULL,
	ID VARCHAR2(30)
);


 */


public class OrderDTO {
	private int seq;
	private String beverage;
	private String syrup;
	private String cupSize;
	private String addShot;
	private String addCream;
	private int cup;
	private int price;
	private String wdate;
	private String id;
	
	public OrderDTO(int seq, String beverage, String syrup, String cupSize, String addShot, String addCream, int cup,
			int price, String wdate, String id) {
		super();
		this.seq = seq;
		this.beverage = beverage;
		this.syrup = syrup;
		this.cupSize = cupSize;
		this.addShot = addShot;
		this.addCream = addCream;
		this.cup = cup;
		this.price = price;
		this.wdate = wdate;
		this.id = id;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBeverage() {
		return beverage;
	}
	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}
	public String getSyrup() {
		return syrup;
	}
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public String getAddShot() {
		return addShot;
	}
	public void setAddShot(String addShot) {
		this.addShot = addShot;
	}
	public String getAddCream() {
		return addCream;
	}
	public void setAddCream(String addCream) {
		this.addCream = addCream;
	}
	public int getCup() {
		return cup;
	}
	public void setCup(int cup) {
		this.cup = cup;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [seq=" + seq + ", beverage=" + beverage + ", syrup=" + syrup + ", cupSize=" + cupSize
				+ ", addShot=" + addShot + ", addCream=" + addCream + ", cup=" + cup + ", price=" + price + ", wdate="
				+ wdate + ", id=" + id + "]";
	}
	
	
	
}
