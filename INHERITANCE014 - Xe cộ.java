import java.util.*;

abstract class Vehicle{
    private double price;
    
    public Vehicle(double price){
        this.price = price;
    }
    
    abstract public double calculateTax();
    
    public double getPrice(){
        return price;
    }
    
    public String getType(){
        return "";
    }
}

class Car extends Vehicle{
    private int numberOfSeats;
    
    public Car(double price, int numberOfSeats){
        super(price);
        this.numberOfSeats = numberOfSeats;
    }
    
    @Override
    public double calculateTax(){
        return getPrice() * 0.05;
    }
}

class Truck extends Vehicle{
    private double loadCapacity;
    
    public Truck(double price, double loadCapacity){
        super(price);
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    public double calculateTax(){
        return getPrice() * 0.1 + loadCapacity * 1000;
    }
}

public class INHERITANCE014{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        double totalTax = 0.0;
        System.out.println("Danh sách phương tiện và thuế:");
        while(t-- > 0){
            String[] s = sc.nextLine().split("\\s+");
            switch(s[0]){
                case "Car":
                    double priceCar = Double.parseDouble(s[1]);
                    int numberOfSeats = Integer.parseInt(s[2]);
                    Car car = new Car(priceCar, numberOfSeats);
                    totalTax += car.calculateTax();
                    System.out.printf("Car - Giá: %.2f, Số ghế: %d, Thuế: %.2f\n", priceCar, numberOfSeats, car.calculateTax());
                    break;
                case "Truck":
                    double priceTruck = Double.parseDouble(s[1]);
                    double loadCapacity = Double.parseDouble(s[2]);
                    Truck truck = new Truck(priceTruck, loadCapacity);
                    totalTax += truck.calculateTax();
                    System.out.printf("Truck - Giá: %.2f, Tải trọng: %.2f tấn, Thuế: %.2f\n", priceTruck, loadCapacity, truck.calculateTax());
                    break;
            }
        }
        System.out.printf("Tổng thuế phải đóng: %.2f", totalTax);
    }
}
