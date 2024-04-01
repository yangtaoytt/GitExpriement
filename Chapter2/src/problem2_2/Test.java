package problem2_2;

public class Test {
    public static void main(String[] args) {
        Triangle g1=new Triangle(3,4,5);
        Trapezoid g2=new Trapezoid(2,4,1);
        Cricle g3=new Cricle(2);

        System.out.println(g1.GetRound()+" "+g1.GetSquare());
        System.out.println(g2.GetSquare());
        System.out.println(g3.GetRound()+" "+g3.GetSquare());
    }
}
