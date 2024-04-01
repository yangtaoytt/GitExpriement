package problem1_2;

public class NarcissisticNumber {
    public static  void GetNarcissistic(){
        for (int i = 100; i <1000 ; i++) {
            int a=i%10,b=i/100,c=(i/10)%10;
            if(a*a*a+b*b*b+c*c*c==i) {//如果每一位三次方和等于本身说明它就是要找的水仙花数
                System.out.println(i);//输出这个数
            }
        }

    }
    public static void main(String[] args) {
        NarcissisticNumber.GetNarcissistic();//调用自己写的静态函数
    }
}
