package problem2_2;

public class Cricle {
    private double radius;
    private double round;
    private double square;
    public Cricle(double radius)//传入r并计算出周长和买面积
    {
        this.radius=radius;
        round=radius*Math.PI*2;
        square=radius*radius*Math.PI;
    }

    public double GetSquare()
    {
        return square;
    }
    public double GetRound()
    {
        return round;
    }
}
