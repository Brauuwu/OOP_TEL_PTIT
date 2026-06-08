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
}

public class COLLECTION002{
    public static void main(String[] args){
    	Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 1);
        
        System.out.println("stock:");
        System.out.println("coffee:  " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));
        
        System.out.println("taking coffee " + warehouse.take("coffee"));
        System.out.println("taking coffee " + warehouse.take("coffee"));
        System.out.println("taking sugar " + warehouse.take("sugar"));
        
        System.out.println("stock:");
        System.out.println("coffee:  " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));
    }
}
