package brandx.models;


import java.util.Date;
import java.util.LinkedList;

public class order {
	private String orderId;
	private String customerId;
	private LinkedList<Product> items;
	private double totalAmount;
	private Date orderDate;
	private String status;
	private String shippingAddress;
	
	public order(String orderId, String customerId, LinkedList<Product> items, double totalAmount, String orderDate,
			String status, String shippingAddress) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.items = items;
		this.totalAmount = totalAmount;
		this.orderDate =new Date();
		this.status = "PENDING";
		this.shippingAddress = shippingAddress;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LinkedList<Product> getItems() {
		return items;
	}
	public void setItems(LinkedList<Product> items) {
		this.items = items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String toString() {
		return "[Order Id:]"+"|"+orderId+"|"+String.format("%.2f", totalAmount)+"| Items"+ items+"\n "+
	"|Customer Id:" +customerId+"|Order Date:"+orderDate+"|Status: "+status+"|Shipping address:"+shippingAddress;
		
	}
	


}
