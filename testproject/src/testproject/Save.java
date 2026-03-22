package testproject;
import java.io.*;
import java.util.*;

public class Save {
	public void saveOrderList(Node head) {
		FileWriter pen = null;
		try {
			pen = new FileWriter (new File("Orders.txt"), true);
			Node current = head;
			
			while (current != null) {
				String record = current.data + "\n";
				pen.write(record);
				current = current.nextNode;
			}
			pen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveOneOrder(Order o) {
		FileWriter pen = null;
		try {

			pen = new FileWriter("Orders.txt", true);
			
			pen.write(o.toString() + "\n");
			
			pen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadOrderFile() {
		try {
			Scanner fileScanner = new Scanner(new File("Orders.txt"));
		
			while (fileScanner.hasNext()) {
				int id = fileScanner.nextInt();
				String name = fileScanner.next();
				System.out.println("Order ID: " + id + "\nOrder Name" + name);
			}
			fileScanner.close();
			return;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void retrieveOneOrder() {
		int searchID;
		Scanner scanner = new Scanner(System.in);
		try {
			Scanner fileScanner = new Scanner(new File("Orders.txt"));
			System.out.println("Enter the order number to look for: ");
			searchID = scanner.nextInt();
			
			while (fileScanner.hasNext()) {
				int id = fileScanner.nextInt();
				String name = fileScanner.next();
				
				if (searchID == id) {
					System.out.println("Data found!" + "\n" + "Order Name: " + name);
					fileScanner.close();
					scanner.close();
					return;
				}
			}
			System.out.print("Item not found...");
			fileScanner.close();
			scanner.close();
			return;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void saveProductList(Node head) {
		FileWriter pen = null;
		try {
			pen = new FileWriter (new File("Products.txt"), true);
			Node current = head;
			
			while (current != null) {
				String record = current.data + "\n";
				pen.write(record);
				current = current.nextNode;
			}
			pen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveOneProduct(Product p) {
		FileWriter pen = null;
		try {

			pen = new FileWriter("Orders.txt", true);
			
			pen.write(p.toString() + "\n");
			
			pen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadProductFile() {
		try {
			Scanner fileScanner = new Scanner(new File("Products.txt"));
		
			while (fileScanner.hasNext()) {
				int id = fileScanner.nextInt();
				String name = fileScanner.next();
				System.out.println("Product ID: " + id + "\nProduct Name" + name);
			}
			fileScanner.close();
			return;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void retrieveOneProduct() {
		int searchID;
		Scanner scanner = new Scanner(System.in);
		try {
			Scanner fileScanner = new Scanner(new File("Products.txt"));
			System.out.println("Enter the product number to look for: ");
			searchID = scanner.nextInt();
			
			while (fileScanner.hasNext()) {
				int id = fileScanner.nextInt();
				String name = fileScanner.next();
				
				if (searchID == id) {
					System.out.println("Data found!" + "\n" + "Product Name: " + name);
					fileScanner.close();
					scanner.close();
					return;
				}
			}
			System.out.print("Item not found...");
			fileScanner.close();
			scanner.close();
			return;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void saveUserList(Node head) {
		FileWriter pen = null;
		try {
			pen = new FileWriter (new File("Users.txt"), true);
			Node current = head;
			
			while (current != null) {
				String record = current.data + "\n";
				pen.write(record);
				current = current.nextNode;
			}
			pen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveOneUser(User u) {
		FileWriter pen = null;
		try {

			pen = new FileWriter("Orders.txt", true);
			
			pen.write(u.toString() + "\n");
			
			pen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadUserList() {
		try {
			Scanner fileScanner = new Scanner(new File("Users.txt"));
		
			while (fileScanner.hasNext()) {
				int id = fileScanner.nextInt();
				String name = fileScanner.next();
				System.out.println("User ID: " + id + "\nUser Name" + name);
			}
			fileScanner.close();
			return;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void retrieveOneUser() {
		int searchID;
		Scanner scanner = new Scanner(System.in);
		try {
			Scanner fileScanner = new Scanner(new File("Users.txt"));
			System.out.println("Enter the user id to look for: ");
			searchID = scanner.nextInt();
			
			while (fileScanner.hasNext()) {
				int id = fileScanner.nextInt();
				String name = fileScanner.next();
				
				if (searchID == id) {
					System.out.println("Data found!" + "\n" + "User Name: " + name);
					fileScanner.close();
					scanner.close();
					return;
				}
			}
			System.out.print("Item not found...");
			fileScanner.close();
			scanner.close();
			return;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
}
