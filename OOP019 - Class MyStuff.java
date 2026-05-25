import java.util.*;

class MyStuff {
    private String name;

    MyStuff(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof MyStuff == false){
            return false;
        }
        MyStuff ms = (MyStuff) obj;
        return this.getName().equals(ms.getName());
    }
}
public class OOP019 {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");
        
        // a.
        System.out.print("value compared: ");
        if (m2.equals(m1))
            System.out.println("same");
        else
            System.out.println("different");

        // b. Viết thêm code vào dấu ...
        System.out.print("reference compared: ");
        if (m2 == m1)
            System.out.println("same");
        else
            System.out.println("different");
    }
}
