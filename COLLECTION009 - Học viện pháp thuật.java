import java.util.*;
import java.io.*;
import java.math.*;

abstract class Spell{
    private String name;
    private int power;
    
    public Spell(String name, int power){
        this.name = name;
        this.power = power;
    }
    
    public int getPower(){
        return power;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPower(int power){
        this.power = power;
    }
    
    abstract String getElement();
}

class FireSpell extends Spell{
    public FireSpell(String name, int power){
        super(name, power);
    }
    
    @Override
    public String getElement(){
        return "FireSpell";
    }
}

class WaterSpell extends Spell{
    public WaterSpell(String name, int power){
        super(name, power);
    }
    
    @Override
    public String getElement(){
        return "WaterSpell";
    }
}

class EarthSpell extends Spell{
    public EarthSpell(String name, int power){
        super(name, power);
    }
    
    @Override
    public String getElement(){
        return "EarthSpell";
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int competitionPoints;
    private List<Spell> library;
    
    public String getName(){
        return name;
    }
    
    public Student(String name){
        this.name = name;
        competitionPoints = 0;
        library = new ArrayList<>();
    }
    
    public void addSpell(Spell spell){
        library.add(spell);
    }
    
    public void changeCompetitionPoints(String element){
        String elementType = element + "Spell";
        boolean hasElement = library.stream().anyMatch(l -> l.getElement().equals(elementType));
        if(hasElement) competitionPoints++;
        else{
            library.forEach(l -> l.setPower(l.getPower() - 20));
            library.removeIf(l -> l.getPower() <= 0);
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s %d %d", name, competitionPoints, library.size());
    }
    
    @Override
    public int compareTo(Student other){
        return Integer.compare(other.competitionPoints, this.competitionPoints);
    }
}

public class COLLECTION009 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("Trial")) break;
            
            String[] s = line.trim().split("\\s+");
            
            Student student = students.stream().filter(
                st -> st.getName().equals(s[0])
            ).findFirst().orElseGet(
                () -> {
                    Student st = new Student(s[0]);
                    students.add(st);
                    return st;
                }
            );
            
            switch(s[1]){
                case "FireSpell":
                    student.addSpell(new FireSpell(s[2], Integer.parseInt(s[3])));
                    break;
                case "WaterSpell":
                    student.addSpell(new WaterSpell(s[2], Integer.parseInt(s[3])));
                    break;
                case "EarthSpell":
                    student.addSpell(new EarthSpell(s[2], Integer.parseInt(s[3])));
                    break;
            }
        }
        
        while(sc.hasNextLine()){
            String element = sc.nextLine();
            if(element.equals("Graduation")) break;
            
            students.forEach(st -> st.changeCompetitionPoints(element));
            
        }
        
        Collections.sort(students);
        students.forEach(System.out::println);
        
        sc.close();
    }
}
