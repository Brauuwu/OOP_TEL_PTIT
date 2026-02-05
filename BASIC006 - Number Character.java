import java.util.Scanner;

public class BASIC006 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String str = sc.nextLine();
            int cnt = 0;
            for(int i = 0; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
