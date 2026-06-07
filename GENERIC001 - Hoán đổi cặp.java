import java.util.*;
import java.io.*;

class Pair<T>{
    private T first;
    private T second;
    
    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    
    public T getFirst(){
        return first;
    }
    
    public T getSecond(){
        return second;
    }
    
    public void setFirst(T first){
        this.first = first;
    }
    
    public void setSecond(T second){
        this.second = second;
    }
    
    public void swap(){
        T tmp = first;
        first = second;
        second = tmp;
    }
    
    @Override
    public String toString(){
        String f = first.toString();
        String s = second.toString();
        
        if(!f.matches("\\d+")) f = "'" + f + "'";
        if(!s.matches("\\d+")) s = "'" + s + "'";
        
        return f + " " + s;
    }
}

public class GENERIC001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split("\\s+");
            Pair<String> pair = new Pair(s[0], s[1]);
            pair.swap();
            System.out.println(pair);
        }
    }
}
