import java.util.Scanner;

public class STRING006 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String sentence = sc.nextLine();
            String[] w = sentence.split("\\s+");
            String res = "";
            for(String s:w){
                if(Character.isAlphabetic(s.charAt(0))){
                    res += s.toUpperCase().charAt(0);
                }
            }
            System.err.printf("My initials are: %s\n", res);
        }
        sc.close();
    }
}
