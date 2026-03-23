package brandx.models;

import java.util.LinkedList;
import java.util.Stack;

public class Customer extends User {

	
	 private LinkedList<Product> cart;
	 private Stack<Product> undoStack;
	 private Stack<String> actionStack;
	 private Stack<String> redoactionStack;
	 private Stack<Product> redoProductStack;
	 //private LinkedList<order> orderHistory;
	 
	/* private String otp;
	 private boolean otpUsed;
	 private boolean passwordChanged;*/
	 public Customer(String userId, String firstName, String lastName, String email, String passwordHash) {
		 super(userId, firstName, lastName, email, passwordHash, null, passwordHash);
		 this.cart=new LinkedList<>();
		 this.undoStack=new Stack<>();
		 this.actionStack=new Stack<>();
		 this.redoactionStack=new Stack<>();
		 this.redoProductStack=new Stack<>();
		 
	 }
	 
	 
	 public String getUserType() {
		 return "CUSTOMER";
	 }
	 public LinkedList<Product> getCart(){
		 return cart; 
	 }
	 public Stack<Product> getUndoStack() {
		 return undoStack; }
	 
	 public Stack<String> getactionStack(){
		 return actionStack;
	 }
	 public Stack<String> getredoactionStack(){
		 return redoactionStack;
	 }
	 public Stack<Product> getredoProductStack(){
		 return redoProductStack;
		 
	 }
}
