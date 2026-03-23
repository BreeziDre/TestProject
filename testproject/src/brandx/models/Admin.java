package brandx.models;

public class Admin extends User {

	public Admin(String userId, String firstName, String lastName, String email, String passwordHash,
			String[] passwordHistory, String status) {
		super(userId, firstName, lastName, email, passwordHash, passwordHistory, status);
		// TODO Auto-generated constructor stub
	}
	
	public String getUserType() {
		return "ADMIN";
		}
	
}
