import java.util.Scanner;

class NotContainVowelException extends Exception{
    public NotContainVowelException(String msg){
        super(msg);
    }
}

public class Main {
    public static boolean check(String s) throws NotContainVowelException{
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o' || c == 'A' || c == 'E' || c == 'U' || c == 'I' || c == 'O') return true;
        }
        throw new NotContainVowelException("String not contain vowels");
    }
    public static void main(String[] args) throws NotContainVowelException {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            try {
                if(check(s) == true) System.out.println("String has vowels");
            } catch (NotContainVowelException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close(); 
    }
}
