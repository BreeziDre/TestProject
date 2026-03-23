package brandx.models;

public class Product implements Comparable <Product> {

	private String productId;
	private String name;
	private String category;
	private String description;
	private double price;
	private int stockQuantity;
	
	
	public Product(String productId, String name, String category, String description, double price,
			int stockQuantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public int compareTo(Product other) {
		return this.productId.compareTo(other.productId);
		
	}
	public String toString() {
		return "[+productId+]"+name+"|"+category+"| $"+String.format("%.2f", price)+"| Stock"+ stockQuantity+"\n "+description;
		
	}
	
	public boolean equals(Object obj) {
		if(this==obj) 
			return true; 
		if(obj==null || getClass() != obj.getClass())
			return false;
		Product other= (Product) obj;
		return productId.equals(other.productId);
	}
	
}
