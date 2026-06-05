import java.util.*;

class Item{
    private String name;
    private double price;
    private double discount;
    
    public Item(String name, double price, double discount){
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    
    public double getPrice(){
        return price;
    }
    
    public double getDiscount(){
        return discount;
    }
    
    public String toString(){
        return String.format("%s $%.2f (-$%.2f)", name, price, discount);
    }
}

class Employee{
    private String name;
    
    public Employee(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}

class GroceryBill{
    private Employee clerk;
    private ArrayList<Item> receipt;
    private double total;
    
    public GroceryBill(Employee clerk){
        this.clerk = clerk;
        receipt = new ArrayList<Item>();
        total = 0;
    }
    
    public void add(Item i){
        total += i.getPrice() - i.getDiscount();
        receipt.add(i);
    }
    
    public double getTotal(){
        return total;
    }
    
    public Employee getClerk(){
        return clerk;
    }
    
    @Override
    public String toString(){
        String res = "items:\n";
        for(Item i : receipt){
            res += String.format("   %s\n", i);
        }
        res += String.format("total: $%.2f\n", total);
        res += String.format("Clerk: %s", clerk.getName());
        return res;
    }
}

class DiscountBill extends GroceryBill{
    private double discountAmount;
    private double total;
    private ArrayList<Item> receipt;
    
    public DiscountBill(Employee clerk){
        super(clerk);
        discountAmount = 0;
        total = 0;
        receipt = new ArrayList<Item>();
    }
    
    @Override
    public void add(Item i){
        total += i.getPrice();
        discountAmount += i.getDiscount();
        receipt.add(i);
    }
    
    @Override
    public String toString(){
        String res = "items:\n";
        for(Item i : receipt){
            res += String.format("   %s\n", i);
        }
        res += String.format("sub-total: $%.2f\n", total);
        res += String.format("discount: $%.2f\n", discountAmount);
        res += String.format("total: $%.2f\n", total - discountAmount);
        res += String.format("Clerk: %s\n", getClerk().getName());
        return res;
    }
}

public class INHERITANCE009{
    public static void main(String[] args){
        Employee clerk1 = new Employee("Grocery Bill");
        GroceryBill gb = new GroceryBill(clerk1);
        gb.add(new Item("item 1", 2.3, 0));
        gb.add(new Item("item 2", 3.45, 0));
        System.out.println(gb);
        
        System.out.println();
        
        Employee clerk2 = new Employee("Discount Bill");
        DiscountBill db = new DiscountBill(clerk2);
        db.add(new Item("item 3", 20, 15));
        db.add(new Item("item 4", 40, 35));
        db.add(new Item("item 5", 50, 35));
        System.out.println(db);
    }
}
