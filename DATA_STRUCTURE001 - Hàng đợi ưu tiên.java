import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getCGPA(){
        return cgpa;
    }
}

class Priorities{
    private PriorityQueue<Student> pq;

    public Priorities(){
        pq = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                if(Double.compare(s1.getCGPA(), s2.getCGPA()) != 0){
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }
                else if(s1.getName().compareTo(s2.getName()) != 0){
                    return s1.getName().compareTo(s2.getName());
                }
                return Integer.compare(s1.getID(), s2.getID());
            }
        });
    }

    public List<Student> getStudents(List<String> events){
        for(String s:events){
            String[] w = s.split("\\s+");
            if(w.length == 1){
                if(!pq.isEmpty()) pq.poll();
            }
            else{
                pq.add(new Student(Integer.parseInt(w[3]), w[1], Double.parseDouble(w[2])));
            }
        }
        List<Student> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}

public class DATA_STRUCTURE001 {
    public static void main(String[] args){
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        List<String> events = new ArrayList<>();
        while(t-- > 0){
            events.add(sc.nextLine());
        }
        List<Student> res = new Priorities().getStudents(events);
        if(res.isEmpty()){
            System.out.println("EMPTY");
        }
        else{
            for(Student s:res){
                System.out.println(s.getName());
            }
        }
        sc.close();
    }
}
