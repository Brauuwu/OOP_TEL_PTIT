import java.util.Scanner;

class Song{
    private String name;
    private String author;
    private int duration;

    public Song(String name, String author, int duration){
        this.name = name;
        this.author = author;
        this.duration = duration;
    }

    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getDuration(){
        return duration;
    }

    @Override
    public boolean equals(Object song){
        if(song instanceof Song == false) return false;
        Song other = (Song)song;
        return this.getName().equals(other.getName()) && this.getAuthor().equals(other.getAuthor()) && this.getDuration() == other.getDuration();
    }
}

public class OBJECT_REFERENCES002 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0){
            String[] w1 = sc.nextLine().split("\\s+");
            Song song1 = new Song(w1[0], w1[1], Integer.parseInt(w1[2]));
            
            String[] w2 = sc.nextLine().split("\\s+");
            Song song2 = new Song(w2[0], w2[1], Integer.parseInt(w2[2]));

            System.out.println(song1.equals(song2));
        }
        sc.close();
    }
}
