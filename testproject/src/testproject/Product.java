
public class Product implements Comparable<Product> 
{
	private String productId;
	private String name;
	private String category;
	private String description;
	private double price;
	private int stockQuantity;
	
	public Product(String productId, String name, String category, String description, double price, int stockQuantity)
	{
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;	
	}
	
	@Override
	public int compareTo(Product other)
	{
		return this.productId.compareTo(other.productId);
	}
	
	
	public String getProductId()
	{
		return productId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getStockQuantity()
	{
		return stockQuantity;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public void setStockQuantity(int stockQuantity)
	{
		this.stockQuantity = stockQuantity;
	}

}
