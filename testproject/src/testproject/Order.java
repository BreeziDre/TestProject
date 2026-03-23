
public class Order 
{
	private String orderId;
	private String customerId;
	private ArrayList<CartItem> items;
	private double totalAmount;
	private String orderDate;
	private String status; //PENDING, PROCESSING, SHIPPED
	private String shippingAddress;
	
	public Order(String orderId, String customerId, String orderDate, String shippingAddress)
	{
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.status = "PENDING";
		this.items = new ArrayList<>();
		this.totalAmount = 0.0;
	}
	
	public void addItem(CartItem item)
	{
		items.add(item);
	}
	
	public void calculateTotal()
	{
		double total = 0.0;
		
		for (int i = 0; i < items.size(); i++)
		{
			total += items.get(i).getTotalPrice();
		}
		totalAmount = total;
	}
	
	
	public String getOrderId()
	{
		return orderId;
	}
	
	public String getCustomerId()
	{
		return customerId;
	}
	
	public ArrayList<CartItem> getItems()
	{
		return items;
	}
	
	public double getTotalAmount()
	{
		return totalAmount;
	}
	
	public String getOrderDate()
	{
		return orderDate;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getShippingAddress()
	{
		return shippingAddress;
	}

}
