import java.util.*;

interface TacoBox{
    public int tacoRemaining();
    public void eat();
}

class TripleTacoBox implements TacoBox{
    private int tacos;
    
    public TripleTacoBox(){
        tacos = 3;
    }
    
    @Override
    public int tacoRemaining(){
        return tacos;
    }
    
    @Override
    public void eat(){
        tacos--;
        if(tacos < 0) tacos = 0;
    }
}

class CustomTacoBox implements TacoBox{
    private int tacos;
    
    public CustomTacoBox(int tacos){
        this.tacos = tacos;
    }
    
    @Override
    public int tacoRemaining(){
        return tacos;
    }
    
    @Override
    public void eat(){
        tacos--;
        if(tacos < 0) tacos = 0;
    }
}

public class INTERFACE003{
    public static void main(String[] args){
        TripleTacoBox box1 = new TripleTacoBox();
        box1.eat(); box1.eat();
        System.out.printf("Triple taco boxes left: %d\n", box1.tacoRemaining());
        
        CustomTacoBox box2 = new CustomTacoBox(8);
        box2.eat();
        System.out.printf("Custom taco boxes left: %d\n", box2.tacoRemaining());
    }
}
