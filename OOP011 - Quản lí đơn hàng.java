import java.util.Scanner;

class Product{
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void display(){
        String s = String.format(
            "Sản phẩm: %s (Mã: %s)\nGiá: %.1f\n",
            name, productId, price
        );
        System.out.print(s);
    }

    public double getPrice(){
        return price;
    }
}

class Order{
    private String orderId;
    private Product product;
    private int quantity;

    public Order(String orderId, Product product, int quantity){
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateTotal(){
        return quantity * product.getPrice();
    }

    public void display(){
        System.out.println("--- Thông tin đơn hàng ---");
        System.out.printf("Đơn hàng: %s\n", orderId);
        product.display();
        System.out.printf("Số lượng: %d\n", quantity);
        System.out.printf("Tổng tiền: %.1f", new Order(orderId, product, quantity).calculateTotal());
    }
}

public class OOP011 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);

        String productId = sc.nextLine();
        String name = sc.nextLine();
        double price = sc.nextDouble();
        sc.nextLine();
        String orderId = sc.nextLine();
        int quantity = sc.nextInt();

        Product product = new Product(productId, name, price);
        Order order = new Order(orderId, product, quantity);

        order.display();

        sc.close();
    }
}
