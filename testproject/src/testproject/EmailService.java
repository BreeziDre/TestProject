package testproject;

public class EmailService {
	
	public static void sendOTP(String email, String otp) {
		
        System.out.println("To: " + email);
        System.out.println("Subject: Your Verification Code");
        System.out.println("Body: Your OTP code is: " + otp);
        
    }
    
    public static void sendWelcome(String email, String name) {

        System.out.println("To: " + email);
        System.out.println("Subject: Welcome to BrandEx!");
        System.out.println("Body: Hello " + name + ", your account is ready.");

    }
    
    public static void sendTempPassword(String email, String tempPass) {
        
        System.out.println("To: " + email);
        System.out.println("Subject: Password Reset");
        System.out.println("Body: Your temporary password is: " + tempPass + "\nPlease change it upon logging in.");
        
    }
    
    public static void sendOrderConfirmation(String email, String orderId, double total) {
        
        System.out.println("To: " + email);
        System.out.println("Subject: Order Confirmation");
        System.out.println("Body: Thank you for your order #" + orderId);
        System.out.println("Total Amount: $" + total);
        
    }

}
