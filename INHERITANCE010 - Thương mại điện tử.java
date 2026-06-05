import java.util.*;

abstract class Product{
    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    abstract public double calculateCost(int quantity);
    
    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
    }
}

class Book extends Product{
    private String author;
    
    public Book(String name, double price, int quantity, String author){
        super(name, price, quantity);
        this.author = author;
    }
    
    @Override
    public double calculateCost(int quantity){
        return getPrice() * quantity;
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Author: " + author);
    }
}

class Electronics extends Product{
    private String brand;
    
    public Electronics(String name, double price, int quantity, String brand){
        super(name, price, quantity);
        this.brand = brand;
    }
    
    @Override
    public double calculateCost(int quantity){
        return getPrice() * quantity * 1.1;
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Brand: " + brand);
    }
}

class User{
    private String name;
    private double totalSpent;
    
    public User(String name){
        this.name = name;
        this.totalSpent = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public double getTotalSpent(){
        return totalSpent;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setTotalSpent(double totalSpent){
        this.totalSpent = totalSpent;
    }
    
    public void buyProduct(Product product, int quantity){
        if(quantity <= product.getQuantity()){
            double cost = product.calculateCost(quantity);
            totalSpent += cost;
            product.setQuantity(product.getQuantity() - quantity);
            System.out.printf("User: %s bought %d %s for $%.1f\n", name, quantity, product.getName(), cost);
        }
        else{
            System.out.printf("Insufficient quantity of %s available.\n", product.getName());
        }
    }
}

public class INHERITANCE010{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            Electronics e = new Electronics("laptop", 20, 10, "Dell");
            Book b = new Book("Harry Potter", 10, 12, "camnh");

            User user1 = new User("Alice");
            User user2 = new User("Bob");
            User user3 = new User("Charlie");

            user1.buyProduct(e, 3);
            user1.buyProduct(b, 10);
            user2.buyProduct(e, 1);
            user3.buyProduct(b, 5);

            System.out.println("====");

            System.out.println("Users with Highest Total Spent:");
            User[] users = {user1, user2, user3};
            for(int i = 0; i < users.length; i++){
                for(int j = i+1; j < users.length; j++){
                    if(users[i].getTotalSpent() < users[j].getTotalSpent()){
                        User tmp = users[i];
                        users[i] = users[j];
                        users[j] = tmp;
                    }
                }
            }
            for(int i = 0; i < users.length; i++){
                System.out.printf("%d. %s: $%.1f\n", i + 1, users[i].getName(), users[i].getTotalSpent());
            }
            
            System.out.println("====");
            e.displayDetails();
            System.out.println("---");
            b.displayDetails();
        }
        sc.close();
    }
}
