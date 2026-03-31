import java.util.Scanner;

class NotJavaException extends Exception{
    public NotJavaException(String message){
        super(message);
    }
}

public class EXCEPTION002 {
    public static int checkFileExtension(String filename) throws NotJavaException{
        if(filename == null || filename.isEmpty()) throw new NotJavaException("Not java file exception.Mark is -1");
        if(filename.endsWith(".java")) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            try{
                String s = sc.nextLine();
                System.out.println(checkFileExtension(s));
            }
            catch(NotJavaException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
