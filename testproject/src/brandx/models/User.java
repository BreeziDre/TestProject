package brandx.models;

import java.util.LinkedList;

public abstract class User {
	private String userId;
	private String firstName; 
	private String lastName;
	private String email;
	private String passwordHash;
	private LinkedList<String> passwordHistory;
	private String status;
	
	
	
	
	
	
	public User(String userId, String firstName, String lastName, String email, String passwordHash,
			String[] passwordHistory, String status) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.passwordHistory = new LinkedList<>();
		this.passwordHistory.add(passwordHash);
		
		this.status = status;
		
	}
	
	public abstract String getUserType();
	public String toString() {
		return userId +"," +firstName+","+lastName+","+email+","+passwordHash+",";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String newpasswordHash) {
		if(passwordHistory.size()>= 2) {
			passwordHistory.removeFirst();
			}
			passwordHistory.add(newpasswordHash);
			this.passwordHash=newpasswordHash;
	}
	public LinkedList<String> getPasswordHistory() {
		return passwordHistory;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
