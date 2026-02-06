import java.util.ArrayList;
import java.util.Scanner;

public class BASIC012 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String a = sc.nextLine();
            ArrayList<Integer> arr = new ArrayList<>();
            String[] s = a.split("\\s+");
            for(String c:s){
                arr.add(Integer.parseInt(c));
            }
            int res = 1, cnt = 1;
            for(int i = 0; i < arr.size()-1; i++){
                if(arr.get(i) <= arr.get(i+1)){
                    cnt++;
                    res = Math.max(res, cnt);
                }
                else cnt = 1;
            }
            System.out.println(res);
        }
        sc.close();
    }
}
