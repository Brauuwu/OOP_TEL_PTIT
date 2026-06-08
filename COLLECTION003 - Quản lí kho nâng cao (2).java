import java.util.*;
import java.io.*;
import java.math.*;

class Warehouse{
    private HashMap<String, Integer> productsPrice;
    private HashMap<String, Integer> productsStock;
    
    public Warehouse(){
        productsPrice = new HashMap<>();
        productsStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        productsStock.put(product, stock);
    }
    
    public int price(String product){
        return productsPrice.containsKey(product) ? productsPrice.get(product) : -99;
    }
    
    public int stock(String product){
        return productsStock.containsKey(product) ? productsStock.get(product) : 0;
    }
    
    public boolean take(String product){
        int current = stock(product);
        productsStock.replace(product, (current - 1) >= 0 ? current - 1 : 0);
        return current > 0;
    }
    
    public Set<String> products(){
        Set<String> s = new HashSet<>();
        for(String key : productsStock.keySet()){
            if(stock(key) > 0) s.add(key);
        }
        return s;
    }
}

public class COLLECTION003{
    public static void main(String[] args){
    	Warehouse warehouse = new Warehouse();
        
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 1);
        warehouse.addProduct("buttermilk", 2, 2);
        warehouse.addProduct("yogurt", 2, 20);
        
        boolean take1 = warehouse.take("buttermilk");
        boolean take2 = warehouse.take("milk");
        boolean take3 = warehouse.take("buttermilk");
        
        warehouse.products().forEach(System.out::println);
    }
}
