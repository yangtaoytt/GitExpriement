package problem2_1;

public class Pay {
    private double price;//价格
    private double withhold_rate;//口扣费率
    private double pat_rate;//工资率
    public double payment;//薪水

    public Pay(double price)//构造函数，必须传入一个价格
    {
        withhold_rate=0.15;
        pat_rate=0.0465;
        this.price=price;
    }
    public void computePayment(int hours,double withhold_rate,double pat_rate)//第一种计算方式
    {
        this.withhold_rate=withhold_rate;
        this.pat_rate=pat_rate;
        CalculatePayment(hours);
    }
    public void computePayment(int hours,double pat_rate)//第二种计算方式
    {
        this.pat_rate=pat_rate;
        CalculatePayment(hours);
    }
    public void computePayment(int hours)//第三种计算方式
    {
        CalculatePayment(hours);
    }
    private void CalculatePayment(int hours)
    {
        payment=hours*price*(1-withhold_rate)*(1-pat_rate);
    }//封装的尖酸函数
}
