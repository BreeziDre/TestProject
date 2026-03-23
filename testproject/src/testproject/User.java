
public abstract class User 
{
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String passwordHash;
	private String[] passwordHistory = new String[2];
	private String status; //ACTIVE or INACTIVE
	
	public User(String userId, String firstName, String lastname, String email, String passwordHash)
	{
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastname;
		this.email = email;
		this.passwordHash = passwordHash;
		this.status = "ACTIVE";
		
		passwordHistory[0] = passwordHash;
		passwordHistory[1] = null;
	}
	
	public abstract String getUserType();
	
	public boolean setPassword(String newHash)
	{
		for (int i = 0; i < passwordHistory.length; i++)
		{
			if(passwordHistory[i] != null && passwordHistory[i].equals(newHash))
			{
				System.out.println("Cannot reuse previous passwords.");
				return false;
			}
		}
		
		passwordHistory[1] = passwordHistory[0];
		passwordHistory[0] = passwordHash;
		
		passwordHash = newHash;
		
		return true;
	}

	
	public String getUserId()
	{
		return userId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPasswordHash()
	{
		return passwordHash;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String[] getPasswordHistory()
	{
		return passwordHistory;
	}
	
}

