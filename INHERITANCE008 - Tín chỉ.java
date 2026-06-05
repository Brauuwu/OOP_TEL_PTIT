import java.util.*;

class Person{
    private String name;
    private String address;
    
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    
    public String toString(){
        return String.format("%s - %s", name, address);
    }
}

class Student extends Person{
    private int credits;
    
    public Student(String name, String address){
        super(name, address);
        credits = 0;
    }
    
    public void study(){
        credits++;
    }
    
    public int credits(){
        return credits;
    }
}

public class INHERITANCE008{
    public static void main(String[] args){
        Student student = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(student);
        System.out.printf("Study credits %d\n", student.credits());
        student.study();
        System.out.printf("Study credits %d\n", student.credits());
    }
}
