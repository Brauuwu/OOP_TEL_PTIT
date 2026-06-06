import java.util.*;

interface Callable{
    public String call();
}

interface Browsable{
    public String browse();
}

class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;
    
    public Smartphone(List<String> numbers, List<String> urls){
        this.numbers = numbers;
        this.urls = urls;
    }
    
    private boolean isNumber(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    private boolean isUrls(String s){
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String call(){
        String res = "";
        for(String x : numbers){
            if(isNumber(x)) res += "Calling... " + x + "\n";
            else res += "Invalid number!\n";
        }
        return res;
    }
    
    @Override
    public String browse(){
        String res = "";
        for(String x : urls){
            if(isUrls(x)) res += "Browsing: " + x + "!\n";
            else res += "Invalid URL!\n";
        }
        return res;
    }
}

public class INTERFACE016{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            List<String> numbers = new ArrayList<>();
            List<String> urls = new ArrayList<>();
            
            String[] s1 = sc.nextLine().split("\\s+");
            for(String x : s1){
                numbers.add(x);
            }
            
            String[] s2 = sc.nextLine().split("\\s+");
            for(String x : s2){
                urls.add(x);
            }
            
            Smartphone phone = new Smartphone(numbers, urls);
            System.out.print(phone.call());
            System.out.print(phone.browse());
        }
    }
}
