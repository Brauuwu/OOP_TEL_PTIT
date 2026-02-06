import java.util.Scanner;

class Vector2D{
    private int dx;
    private int dy;

    public int getDX(){
        return dx;
    }
    public int getDY(){
        return dy;
    }
    public void setDX(int dx){
        this.dx = dx;
    }
    public void setDY(int dy){
        this.dy = dy;
    }
    public void translate(int tx, int ty){
        dx += tx;
        dy += ty;
    }
    public double magnitude(){
        return 1.0 * Math.sqrt(dx*dx + dy*dy);
    }
}

public class OOP014 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Vector2D v = new Vector2D();
            int dx = sc.nextInt();
            int dy = sc.nextInt();
            v.setDX(dx);
            v.setDY(dy);
            v.translate(-2, 3);
            System.out.printf("%.3f\n", v.magnitude());
        }
        sc.close();
    }
}
