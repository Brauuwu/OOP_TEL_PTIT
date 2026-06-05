import java.util.*;

abstract class Shape{
    protected String name;
    
    public Shape(String name){
        this.name = name;
    }
    
    abstract public double calculateArea();
    public void displayInfo(){
        System.out.printf("Shape:%s|Area:%.2f\n", name, calculateArea());
    }
}

class Rectangle extends Shape{
    private double width;
    private double length;
    
    public Rectangle(String name, double length, double width){
        super(name);
        this.length = length;
        this.width = width;
    }
    
    public double calculateArea(){
        return length * width;
    }
}

class Circle extends Shape{
    private double radius;
    
    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}

public class INHERITANCE007{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split("\\s+");
            switch(s[0]){
                case "Rectangle":
                    Rectangle rec = new Rectangle(s[0], Double.parseDouble(s[2]), Double.parseDouble(s[1]));
                    rec.displayInfo();
                    break;
                case "Circle":
                    Circle cir = new Circle(s[0], Double.parseDouble(s[1]));
                    cir.displayInfo();
                    break;
            }
        }
    }
}
