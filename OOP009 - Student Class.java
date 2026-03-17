import java.util.Scanner;;

class Student{
    private String name;
    private int age;
    public static int numberOfStudent = 0;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
        numberOfStudent++;
    }

    public void display(){
        if(age >= 18) System.out.println(name);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc;
        sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String name = sc.nextLine();
            if(!sc.hasNextLine()) break;
            int age = Integer.parseInt(sc.nextLine());
            Student s = new Student(name, age);
            s.display();
        }
        System.out.println(Student.numberOfStudent);
        sc.close();
    }
}
