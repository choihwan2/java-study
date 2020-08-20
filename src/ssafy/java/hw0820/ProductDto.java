package ssafy.java.hw0820;

public class ProductDto {
	private int no;
	private String name;
	private int price;
	private int amount;
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(String name, int price, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	

	public ProductDto(int no, String name, int price, int amount) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
