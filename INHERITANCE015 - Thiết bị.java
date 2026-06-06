import java.util.*;

abstract class Device{
    private double basePrice;
    
    public Device(double basePrice){
        this.basePrice = basePrice;
    }
    
    abstract public double calculateWarrantyCost();
    
    public double getBasePrice(){
        return basePrice;
    }
    
    public String getType(){
        return "";
    }
}

class Laptop extends Device{
    private int ramSize;
    
    public Laptop(double basePrice, int ramSize){
        super(basePrice);
        this.ramSize = ramSize;
    }
    
    @Override
    public double calculateWarrantyCost(){
        return getBasePrice() * 0.07;
    }
}

class Smartphone extends Device{
    private double screenSize;
    
    public Smartphone(double basePrice, double screenSize){
        super(basePrice);
        this.screenSize = screenSize;
    }
    
    @Override
    public double calculateWarrantyCost(){
        return getBasePrice() * 0.05 + screenSize * 50;
    }
}

public class INHERITANCE015{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        double totalCost = 0.0;
        System.out.println("Danh sách thiết bị và chi phí bảo hành:");
        while(t-- > 0){
            String[] s = sc.nextLine().split("\\s+");
            switch(s[0]){
                case "Laptop":
                    double priceLaptop = Double.parseDouble(s[1]);
                    int ramSize = Integer.parseInt(s[2]);
                    Laptop laptop = new Laptop(priceLaptop, ramSize);
                    totalCost += laptop.calculateWarrantyCost();
                    System.out.printf("Laptop - Giá gốc: %.2f, Dung lượng RAM: %d GB, Chi phí bảo hành: %.2f\n", priceLaptop, ramSize, laptop.calculateWarrantyCost());
                    break;
                case "Smartphone":
                    double pricePhone = Double.parseDouble(s[1]);
                    double screenSize = Double.parseDouble(s[2]);
                    Smartphone phone = new Smartphone(pricePhone, screenSize);
                    totalCost += phone.calculateWarrantyCost();
                    System.out.printf("Smartphone - Giá gốc: %.2f, Kích thước màn hình: %.2f inch, Chi phí bảo hành: %.2f\n", pricePhone, screenSize, phone.calculateWarrantyCost());
                    break;
            }
        }
        System.out.printf("Tổng chi phí bảo hành: %.2f", totalCost);
    }
}
