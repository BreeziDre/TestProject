package testproject;
import java.io.*;

public class FileHandler {
	private static final String DATA_DIR = "resources/data/";				//each of these defines a fixed file path constant, so the program can
    private static final String USERS_FILE = DATA_DIR + "passwords.txt";	//read from and write to the correct data files consistently
    private static final String PRODUCTS_FILE = DATA_DIR + "products.txt";
    private static final String ORDERS_FILE = DATA_DIR + "orders.txt";

    
    static {	// Ensure data directory exists
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    

    public static void saveUsers(LinkedList<User> users) {		//Generics used for correctness and safety, as opposed to just "LinkedList users"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {	//Opens the file specified by USERS_FILE for writing
            for (User user : users) {				//Equivalent to "for (int i = 0; i < users.size; i++) {...}"
                StringBuilder line = new StringBuilder();
                line.append(user.getId()).append(",")
                    .append(user.getFirstName()).append(",")
                    .append(user.getLastName()).append(",")
                    .append(user.getEmail()).append(",")
                    .append(user.getPassword()).append(",")
                    .append(user.getRole()).append(",");
                
                // Save password history separated by semicolons
                LinkedList<String> history = user.getPasswordHistory();
                StringBuilder historyStr = new StringBuilder();
                for (String oldPass : history) {
                    historyStr.append(oldPass).append(";");
                }
                line.append(historyStr);
                
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
    

    public static LinkedList<User> loadUsers() {
        LinkedList<User> users = new LinkedList<>();
        File file = new File(USERS_FILE);
        if (!file.exists()) {
        	return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                // ID,First,Last,Email,Pass,Role,History
                if (parts.length < 6) continue;

                String id = parts[0];
                String first = parts[1];
                String last = parts[2];
                String email = parts[3];
                String pass = parts[4];
                String role = parts[5];

                User user;
                if (role.equals("ADMIN")) {
                    user = new Admin(id, first, last, email, pass);
                } else {
                    user = new Customer(id, first, last, email, pass);
                }

                // Load history if exists
                if (parts.length > 6) {
                    String[] history = parts[6].split(";");
                    for (String h : history) {
                        if (!h.isEmpty() && !h.equals(pass)) { 
                            // Avoid adding current password again as constructor adds it
                            user.getPasswordHistory().add(h);
                        }
                    }
                }
                
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    public static void saveProducts(LinkedList<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            for (Product p : products) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getCategory() + "," + 
                           p.getPrice() + "," + p.getStock() + "," + p.getDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    public static LinkedList<Product> loadProducts() {
        LinkedList<Product> products = new LinkedList<>();
        File file = new File(PRODUCTS_FILE);
        if (!file.exists()) return products;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) continue;

                // Handle description that might contain commas
                String description = parts[5];
                if (parts.length > 6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(parts[5]);
                    for (int i = 6; i < parts.length; i++) {
                        sb.append(",").append(parts[i]);
                    }
                    description = sb.toString();
                }

                Product p = new Product(parts[0], parts[1], parts[2], 
                                      Double.parseDouble(parts[3]), 
                                      Integer.parseInt(parts[4]), 
                                      description);
                products.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
        return products;
    }
    
    // Save orders (Queue)
    //public static void saveOrders(Queue<order> orderQueue) {
    
        // Since Queue removes items on dequeue, we should just
    	// rely on the service to pass a LinkedList of orders to save.
    
    //}
    
    // Overloaded for LinkedList (Order History)
    public static void saveOrdersList(LinkedList<order> orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDERS_FILE))) {
            for (order order : orders) {
                StringBuilder sb = new StringBuilder();
                sb.append(order.getOrderId()).append(",")
                  .append(order.getCustomerId()).append(",")
                  .append(order.getTotalAmount()).append(",")
                  .append(order.getStatus()).append(",");
                
                // Save product IDs
                StringBuilder itemsStr = new StringBuilder();
                for (Product p : order.getItems()) {
                    itemsStr.append(p.getId()).append(";");
                }
                sb.append(itemsStr);
                
                writer.write(sb.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving orders: " + e.getMessage());
        }
    }

    // Load ALL orders (PENDING + PROCESSED) as a LinkedList.
    public static LinkedList<order> loadAllOrders(BinarySearchTree<Product> productCatalog) {
        LinkedList<order> allOrders = new LinkedList<>();
        File file = new File(ORDERS_FILE);
        if (!file.exists()) return allOrders;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;	//skips empty line
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String orderId = parts[0];
                String custId  = parts[1];
                double total   = Double.parseDouble(parts[2]);
                String status  = parts[3];

                LinkedList<Product> items = new LinkedList<>();
                String[] itemIds = parts[4].split(";");
                for (String pid : itemIds) {
                    if (pid.isEmpty()) continue;
                    Product searchKey = new Product(pid, "", "", 0, 0, "");
                    Product found = productCatalog.search(searchKey);
                    if (found != null) items.add(found);
                }

                order order = new order(orderId, custId, items, total);
                order.setStatus(status);
                allOrders.add(order);
            }
        } catch (IOException e) {
            System.out.println("Error loading all orders: " + e.getMessage());
        }
        return allOrders;
    }

    // Load orders. Needs product catalog to reconstruct product objects.
    public static Queue<order> loadOrders(BinarySearchTree<Product> productCatalog) {
        Queue<order> orderQueue = new Queue<>();
        File file = new File(ORDERS_FILE);
        if (!file.exists()) return orderQueue;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String orderId = parts[0];
                String custId = parts[1];
                double total = Double.parseDouble(parts[2]);
                String status = parts[3];
                
                LinkedList<Product> items = new LinkedList<>();
                if (parts.length > 4) {
                    String[] itemIds = parts[4].split(";");
                    for (String pid : itemIds) {
                        // Create dummy product for search key
                        // The BST search needs a comparable object.
                        // Our BST search takes data. 
                        // Product compares by ID. So we can create a dummy product with just ID
                        Product searchKey = new Product(pid, "", "", 0, 0, "");
                        Product found = productCatalog.search(searchKey);
                        if (found != null) {
                            items.add(found);
                        }
                    }
                }

                order order = new order(orderId, custId, items, total);
                order.setStatus(status);
                
               
                if (status.equals("PENDING")) {
                    orderQueue.enqueue(order);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }
        return orderQueue;
    }

}
