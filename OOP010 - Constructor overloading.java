class Product{
    private String name;
    private String location;
    private int weight;

    public Product(String name){
        this.name = name;
        this.weight = 1;
        this.location = "shelf";
    }
    public Product(String name, String location){
        this.name = name;
        this.location = location;
        this.weight = 1;
    }
    public Product(String name, int weigth){
        this.name = name;
        this.weight = weigth;
        this.location = "shelf";
    }

    public String toString(){
        return String.format("%s (%dkg) can be found from the %s", name, weight, location);
    }
}

public class OOP010 {
    public static void main(String[] args) {
        Product p1 = new Product("Tape measure");
        System.out.println(p1);

        Product p2 = new Product("Plaster", "home improvement section");
        System.out.println(p2);

        Product p3 = new Product("Tyre", 5);
        System.out.println(p3);
    }
}
