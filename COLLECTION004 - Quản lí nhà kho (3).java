import java.util.*;
import java.io.*;
import java.math.*;

class Item{
    private String product;
    private int quantity;
    private int unitPrice;
    private int originalQuantity;
    
    public Item(String product, int quantity, int price){
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = price;
        this.originalQuantity = quantity;
    }
    
    public Item(String product, int quantity){
        this(product, quantity, 0);
    }
    
    public String getProduct(){
        return product;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public int getUnitPrice(){
        return unitPrice;
    }
    
    public int getOriginalQuantity(){
        return originalQuantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getTotalPrice(){
        return quantity * unitPrice;
    }
    
    public void printItemInfo(){
        System.out.printf("Product: %s has quantity %d with price: %d\n", product, quantity, getTotalPrice());
    }
}

class Warehouse{
    private HashMap<String, Item> items;
    
    public Warehouse(){
        items = new HashMap<>();
    }
    
    public void importProduct(Item item){
        items.put(item.getProduct(), item);
    }
    
    public Item getItem(String product){
        return items.get(product);
    }
    
    public void removeProduct(String product, int amount){
        if(items.containsKey(product)){
            int currentQuantity = items.get(product).getQuantity();
            currentQuantity -= amount;
            items.get(product).setQuantity(currentQuantity);
            if(currentQuantity < 0) items.get(product).setQuantity(0);
        }
    }
    
    public void decreaseQuantityInWarehouseByOne(){
        for(String x : items.keySet()){
            items.get(x).setQuantity(items.get(x).getQuantity() - 1);
        }
    }
    
    public void takeFromItemToWarehouse(List<Item> itemsToCheck, String product, int quantity){
        Item item = items.get(product);
        if(item == null) return;
        for(Item x : itemsToCheck){
            if(x.getProduct().equals(product)){
                int amount = Math.min(quantity, x.getQuantity());
                item.setQuantity(item.getQuantity() + amount);
                break;
            }
        }
    }
    
    public void printWarehouseInfo() {
        for (Item item : items.values()) {
            item.printItemInfo();
        }
    }
}

public class COLLECTION004{
    public static void main(String[] args){
    	Warehouse warehouse = new Warehouse();
        
        Item milk = new Item("milk", 4, 2);
        Item buttermilk = new Item("buttermilk", 10 ,2);
        
        warehouse.importProduct(milk);
        warehouse.importProduct(buttermilk);
        
        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();
        
        warehouse.removeProduct("milk", 1);
        warehouse.removeProduct("buttermilk", 3);
        
        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();
        
        warehouse.decreaseQuantityInWarehouseByOne();
        
        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();
        
        List<Item> itemsToCheck = new ArrayList<>();
        itemsToCheck.add(new Item("milk", 2));
        itemsToCheck.add(new Item("buttermilk", 6));
        
        warehouse.takeFromItemToWarehouse(itemsToCheck, "milk", 5);
        warehouse.takeFromItemToWarehouse(itemsToCheck, "buttermilk", 1);
        
        warehouse.getItem("milk").printItemInfo();
        warehouse.getItem("buttermilk").printItemInfo();
    }
}
