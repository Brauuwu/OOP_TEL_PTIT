import java.util.*;

interface Moveable{
    public void move(int dx, int dy);
}

class Organism implements Moveable{
    private int x;
    private int y;
    
    public Organism(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public String toString(){
        return String.format("x:%d;y:%d", x, y);
    }
}

class Herd{
    private ArrayList<Moveable> moveables;
    
    public Herd(){
        moveables = new ArrayList<Moveable>();
    }
    
    public void addToHerd(Moveable moveable){
        moveables.add(moveable);
    }
    
    public void move(int dx, int dy){
        for(Moveable m : moveables){
            m.move(dx, dy);
        }
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Moveable m : moveables){
            sb.append(m).append("\n");
        }
        return sb.toString();
    }
}

public class INTERFACE002{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Herd herd = new Herd();
        while(t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Organism organism = new Organism(x, y);
            herd.addToHerd(organism);
        }
        herd.move(1, 1);
        System.out.println(herd);
    }
}
