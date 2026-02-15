import java.util.Scanner;

public class Main {
    public static String findLongestWord(String sentence){
        String[] w = sentence.split("\\s+");
        String res = "";
        for(String s:w){
            if(res.length() <= s.length()){
                res = s;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String sentence = sc.nextLine();
            System.out.println(findLongestWord(sentence));
        }
        sc.close();
    }
}
