import java.util.Scanner;

class Author{
    private String name;
    private String email;
    private char gender;

    private String getName(){
        return name;
    }
    private String getEmail(){
        return email;
    }
    private char getGender(){
        return gender;
    }

    private void setName(String name){
        this.name = name;
    }
    private void setEmail(String email){
        this.email = email;
    }
    private void setGender(char gender){
        this.gender = gender;
    }

    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String toString(){
        String s = "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
        return s;
    }
}

class Book{
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    private String getName(){
        return name;
    }
    private Author getAuthor(){
        return author;
    }
    private double getPrice(){
        return price;
    }
    private double getQty(){
        return qty;
    }
    private void setName(String name){
        this.name = name;
    }
    private void setPrice(double price){
        this.price = price;
    }
    private void setQty(int qty){
        this.qty = qty;
    }

    public Book(String name, Author author, double price, int qty){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String toString(){
        String s = "Book[name=" + name + ", " + author.toString() + ", price=" + price + ", qty=" + qty + "]";
        return s;
    }
}

public class OOP012{
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String BookType = sc.nextLine();
            String BookName = sc.nextLine();
            double BookPrice = sc.nextDouble();
            int BookQty = sc.nextInt();
            
            sc.nextLine();
            String AuthorType = sc.nextLine();
            String AuthorName = sc.nextLine();
            String AuthorEmail = sc.nextLine();
            char AuthorGender = sc.nextLine().charAt(0);

            Author author = new Author(AuthorName, AuthorEmail, AuthorGender);
            Book book = new Book(BookName, author, BookPrice, BookQty);

            String endInput = sc.nextLine();
            System.out.println(book.toString());
        }
        sc.close();
    }
}
