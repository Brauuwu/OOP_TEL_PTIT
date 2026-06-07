import java.util.*;
import java.io.*;

class FileNameFormatExeption extends Exception{
    public FileNameFormatExeption(String msg){
        super(msg);
    }
}

class Test {
    public static void open_file(String s){
        try {
            // Gọi phương thức f() ném ngoại lệ
            f(s);
        } catch (FileNameFormatExeption fname) {
            System.out.println(fname.getMessage());
        } catch (Exception e){
            System.out.println("Exception");
        }
    }

    public static void f(String s) throws FileNameFormatExeption{
        if(s.contains(" ")){
            throw new FileNameFormatExeption("File name format");
        }
        System.out.println("File opened");
    }
}

public class EXCEPTION008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Test.open_file(s);
        sc.close();
    }
}
