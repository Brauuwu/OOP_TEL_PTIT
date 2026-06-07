import java.util.*;
import java.io.*;

public class Main {
    public static <T> int findFirstMatch(T[] array, T target){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(target)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String line = sc.nextLine();
            
            String[] parts = line.split("\\|");
            String[] array = parts[0].trim().split("\\s+");
            String target = parts[1].trim();
            
            System.out.println(findFirstMatch(array, target));
        }
    }
}
