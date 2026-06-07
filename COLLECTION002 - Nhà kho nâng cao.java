import java.util.*;

class Warehouse {
    private HashMap<String, Integer> prices;
    private HashMap<String, Integer> stocks;

    public Warehouse() {
        prices = new HashMap<>();
        stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }

    public int price(String product) {
        if (prices.containsKey(product))
            return prices.get(product);
        return -99;
    }

    public int stock(String product) {
        if (stocks.containsKey(product))
            return stocks.get(product);
        return 0;
    }

    public boolean take(String product) {
        if (!stocks.containsKey(product) || stocks.get(product) <= 0)
            return false;

        stocks.put(product, stocks.get(product) - 1);
        return true;
    }
}

public class COLLECTION002 {
    public static void main(String[] args) {
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
