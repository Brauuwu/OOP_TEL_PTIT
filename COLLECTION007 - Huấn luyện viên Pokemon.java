import java.util.*;
import java.io.*;
import java.math.*;

class Pokemon{
    private String name, element;
    private int health;
    
    public Pokemon(String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }
    
    public String getName(){
        return name;
    }
    
    public String getElement(){
        return element;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setElement(String element){
        this.element = element;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
}

class Trainer implements Comparable<Trainer>{
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;
    
    public Trainer(String name){
        this.name = name;
        numberOfBadges = 0;
        pokemons = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }
    
    public void changeNumberOfBadges(String element){
        boolean hasElement = pokemons.stream().anyMatch(p -> p.getElement().equals(element));
        if(hasElement) numberOfBadges++;
        else{
            pokemons.forEach(p -> p.setHealth(p.getHealth() - 10));
            pokemons.removeIf(p -> p.getHealth() <= 0);
        }
    }
	
    @Override
    public String toString(){
        return String.format("%s %d %d", name, numberOfBadges, pokemons.size());
    }
    
    @Override
    public int compareTo(Trainer other){
        return Integer.compare(other.numberOfBadges, this.numberOfBadges);
    }
}

public class COLLECTION007{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Trainer> trainers = new ArrayList<>();
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            
            if(line.equals("Tournament")) break;
            
            String[] s = line.trim().split("\\s+");
            Trainer trainer = trainers.stream().filter(
                t -> t.getName().equals(s[0])
            ).findFirst().orElseGet(
                () -> {
                    Trainer t = new Trainer(s[0]);
                    trainers.add(t);
                    return t;
                }
            );
            
            trainer.addPokemon(new Pokemon(s[1], s[2], Integer.parseInt(s[3])));
        }
        
        while(sc.hasNextLine()){
            String element = sc.nextLine();
            
            if(element.equals("End")) break;
            
            trainers.forEach(t -> t.changeNumberOfBadges(element));
        }
        Collections.sort(trainers);
            
        trainers.forEach(System.out::println);
    }
}
