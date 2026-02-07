import java.util.Scanner;

class Inventor {
    private String name;
    private String field;
    private String nationality;

    public Inventor(String name, String field, String nationality){
        this.name = name;
        this.field = field;
        this.nationality = nationality;
    }

    public String toString(){
        String s = "Inventor[name=" + name +", field=" + field + ", nationality=" + nationality + "]";
        return s;
    }
}

class Patent{
    private String title;
    private int year;
    private Inventor inventor;

    public Patent(String title, int year, Inventor inventor){
        this.title = title;
        this.year = year;
        this.inventor = inventor;
    }

    public String toString(){
        String s = "Patent[title=" + title + ", year=" + year + ", " + inventor + "]";
        return s;
    }
}

public class OOP002 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);

        String name = sc.nextLine();
        String field = sc.nextLine();
        String nationality = sc.nextLine();
        Inventor inventor = new Inventor(name, field, nationality);

        String title = sc.nextLine();
        int year = sc.nextInt();
        Patent patent = new Patent(title, year, inventor);

        switch (nationality) {
            case "VN":
                System.out.println(patent);
                break;
            case "INT":
                System.out.println(patent);
                break;
            default:
                System.out.println("Invalid nationality. Only 'VN' or 'INT' allowed.");
                break;
        }

        sc.close();
    }
}
