package problem2_2;

public class Trapezoid {
    private double sideUp;
    private double sideDown;
    private double height;
    private double square;
    public Trapezoid(double sideUp,double sideDown,double height)//传入上下底长度和高度，计算出面积
    {
        this.sideUp=sideUp;
        this.sideDown=sideDown;
        this.height=height;
        this.square=0.5*(sideDown+sideUp)*height;
    }

    public double GetSquare()
    {
        return square;
    }


}
