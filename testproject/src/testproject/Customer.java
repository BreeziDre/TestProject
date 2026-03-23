
public class Customer extends User
{
	private LinkedList<CartItem> cart;
	private Stack<String> undoStack;
	private Stack<String> redoStack;
	private LinkedList<Order> orderHistory;
	
	private String otp;
	private boolean otpUsed;
	private boolean passwordChanged;
	
	public Customer(String userId, String firstName, String lastName, String email, String passwordHash)
	{
		super(userId, firstName, lastName, email, passwordHash);
		
		cart = new LinkedList<>();
		undoStack = new Stack<>();
		redoStack = new Stack<>();
		orderHistory = new LinkedList<>();
		
		otp = null;
		otpUsed = false;
		passwordChanged = false;
		
	}
	
	@Override
	public String getUserType()
	{
		return "CUSTOMER";
	}
	
	public LinkedList<CartItem> getCart()
	{
		return cart;
	}
	
	public Stack<String> getUndoStack()
	{
		return undoStack;
	}
	
	public Stack<String> getRedoStack()
	{
		return redoStack;
	}
	
	public LinkedList<Order> getOrderHistory()
	{
		return orderHistory;
	}
	
	public String getOtp()
	{
		return otp;
	}
	
	public void setOtp(String otp) 
	{
		this.otp = otp;
	}
	
	public boolean isOtpUsed()
	{
		return otpUsed;
	}
	
	public void setOtpUsed(boolean otpUsed)
	{
		this.otpUsed = otpUsed;
	}
	
	public boolean isPasswordChanged()
	{
		return passwordChanged;
	}
	
	public void setPasswordChanged(boolean passwordChanged)
	{
		this.passwordChanged = passwordChanged;
	}


}
