package problem2_2;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    private boolean isRight;
    public Triangle(double sideA,double sideB,double sideC)//传入三边长度，计算出是否是三角形
    {
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
        isRight= !(sideB + sideA <= sideC) && !(sideB + sideC <= sideA) && !(sideC + sideA <= sideB);
    }

    public void Modify(double sideA,double sideB,double sideC)//修改边长度
    {
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
        isRight= !(sideB + sideA <= sideC) && !(sideB + sideC <= sideA) && !(sideC + sideA <= sideB);
    }

    public double GetSquare()//返回面积
    {
        if(!isRight)
            return -1;
        double p=0.5*(sideA+sideB+sideC);
        return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
    }
    public double GetRound()//返回周长
    {
        if(!isRight)
            return -1;
        return sideA+sideB+sideC;
    }
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
