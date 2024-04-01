package problem2_1;

public class Test {
    public static void main(String[] args) {
        Pay p1=new Pay(1);
        Pay p2=new Pay(2);
        Pay p3=new Pay(3);

        p1.computePayment(1);
        p2.computePayment(2,0.2);
        p3.computePayment(3,0.3,0.3);

        System.out.println(p1.payment);
        System.out.println(p2.payment);
        System.out.println(p3.payment);
    }
}
