import java.util.Scanner;

class Musician {
    private String name;
    private String nationality;
    private String style;

    public Musician(String name, String nationality, String style){
        this.name = name;
        this.nationality = nationality;
        this.style = style;
    }

    public String toString(){
        String s = "Musician[name=" + name + ", nationality=" + nationality + ", style=" + style + "]";
        return s;
    }
}

class Song{
    private String title;
    private String genre;
    private int year;
    private Musician musician;

    public Song(String title, String genre, int year, Musician musician){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.musician = musician;
    }

    public String toString(){
        String s = "Song[title=" + title + ", genre=" + genre + ", year=" + year + ", " + musician + "]";
        return s;
    }
}

public class OOP003 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        
        String name = sc.nextLine();
        String nationality = sc.nextLine();
        String style = sc.nextLine();
        Musician musician = new Musician(name, nationality, style);

        String title = sc.nextLine();
        String genre = sc.nextLine();
        int year = sc.nextInt();
        Song song = new Song(title, genre, year, musician);

        switch(nationality){
            case "VN":
                System.out.println(song);
                break;
            case "INT":
                System.out.println(song);
                break;
            default:
                System.out.println("Invalid nationality. Only 'VN' or 'INT' allowed.");
        }

        sc.close();
    }
}
