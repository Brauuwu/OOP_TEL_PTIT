import java.util.*;

interface Identifiable{
    public String getId();
}

interface Birthable{
    public String getBirthDate();
}

class Citizen implements Identifiable, Birthable{
    private String name;
    private int age;
    private String id;
    private String birthDate;
    
    public Citizen(String name, int age, String id, String birthDate){
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    @Override
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    @Override
    public String getBirthDate(){
        return birthDate;
    }
    
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
}

class Pet implements Birthable{
    private String name;
    private String birthDate;
    
    public Pet(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String getBirthDate(){
        return birthDate;
    }
    
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
}

public class INTERFACE005{
    public static boolean isFilterDate(String date, String year){
        return date.charAt(6) == year.charAt(0) && date.charAt(7) == year.charAt(1) && date.charAt(8) == year.charAt(2) && date.charAt(9) == year.charAt(3);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            ArrayList<Citizen> citizens = new ArrayList<Citizen>();
            ArrayList<Pet> pets = new ArrayList<Pet>();
            
            while(sc.hasNextLine()){
                String q = sc.nextLine();
                
                if(q.equals("End")){
                    break;
                }
                
                String[] s = q.split("\\s+");
                switch(s[0]){
                    case "Citizen":
                        Citizen citizen = new Citizen(s[1], Integer.parseInt(s[2]), s[3], s[4]);
                        citizens.add(citizen);
                        break;
                    case "Pet":
                        Pet pet = new Pet(s[1], s[2]);
                        pets.add(pet);
                        break;
                }
            }
            
            String year = sc.nextLine();
            
            for(Citizen x : citizens){
                String date = x.getBirthDate();
                if(isFilterDate(date, year)){
                    System.out.println(date);
                }
            }

            for(Pet x : pets){
                String date = x.getBirthDate();
                if(isFilterDate(date, year)){
                    System.out.println(date);
                }
            }
        }
    }
}
