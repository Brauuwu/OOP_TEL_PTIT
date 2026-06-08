import java.util.*;
import java.io.*;
import java.math.*;

abstract class Equipment{
    private String name;
    private int durability;
    
    public Equipment(String name, int durability){
        this.name = name;
        this.durability = durability;
    }
    
    abstract public String getElement();
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getDurability(){
        return durability;
    }
    
    public void setDurability(int durability){
        this.durability = durability;
    }
}

class Tool extends Equipment{
    public Tool(String name, int durability){
        super(name, durability);
    }
    
    @Override
    public String getElement(){
        return "Tool";
    }
}

class Food extends Equipment{
    public Food(String name, int durability){
        super(name, durability);
    }
    
    @Override
    public String getElement(){
        return "Food";
    }
}

class Medicine extends Equipment{
    public Medicine(String name, int durability){
        super(name, durability);
    }
    
    @Override
    public String getElement(){
        return "Medicine";
    }
}

class Astronaut implements Comparable<Astronaut>{
    private String name;
    private int missionPoints;
    private List<Equipment> bag;
    
    public Astronaut(String name){
        this.name = name;
        missionPoints = 0;
        bag = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public void addBag(Equipment equipment){
        bag.add(equipment);
    }
    
    public void launch(String mission){
        StringBuffer equipment = new StringBuffer();
        switch(mission){
            case "Repair":
                equipment.append("Tool");
                break;
            case "Nutrition":
                equipment.append("Food");
                break;
            case "Heal":
                equipment.append("Medicine");
                break;
        }
        
        String element = equipment.toString();
        
        boolean hasElement = bag.stream().anyMatch(b -> b.getElement().equals(element));
        if(hasElement) missionPoints++;
        else{
            bag.forEach(b -> b.setDurability(b.getDurability() - 15));
            bag.removeIf(b -> b.getDurability() <= 0);
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s %d %d", name, missionPoints, bag.size());
    }
    
    @Override
    public int compareTo(Astronaut other){
        return other.missionPoints - this.missionPoints;
    }
}

public class COLLECTION008 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Astronaut> astronauts = new LinkedList<>();
        
        while(true){
            String line = sc.nextLine();
            if(line.equals("Launch")) break;
            String[] s = line.trim().split("\\s+");
            
            Astronaut astronaut = astronauts.stream().filter(
                a -> a.getName().equals(s[0])
            ).findFirst().orElseGet(
                () -> {
                    Astronaut a = new Astronaut(s[0]);
                    astronauts.add(a);
                    return a;
                }
            );
            switch(s[1]){
                case "Tool":
                    astronaut.addBag(new Tool(s[2], Integer.parseInt(s[3])));
                    break;
                case "Food":
                    astronaut.addBag(new Food(s[2], Integer.parseInt(s[3])));
                    break;
                case "Medicine":
                    astronaut.addBag(new Medicine(s[2], Integer.parseInt(s[3])));
                    break;
            }
        }
        
        while(true){
            String mission = sc.nextLine();
            
            if(mission.equals("Return")) break;
            
            astronauts.forEach(a -> a.launch(mission));
        }
                                     
        Collections.sort(astronauts);
                                     
        astronauts.forEach(System.out::println);
        
        sc.close();
    }
}
