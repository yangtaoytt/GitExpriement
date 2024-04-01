package problem1_4;

import java.util.Scanner;

public class CommonDivisorAndMultiple {
    public static int GetCommonDivisor(int n,int m){//计算公约数
        for (int i = Math.min(n,m); i >0 ; i--) {
            if(n%i==0&&m%i==0){//如果正好都能出尽说明找到的i为最大公约数
                return i;
            }

        }
        return -1;
    }
    public static int GetCommonMultiple(int n,int m){//计算公倍数

        for (int i = n; i <n*m ; i++) {
            if(i%n==0&&i%m==0){//都能除尽说明i为最小公倍数
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        if(scan.hasNext()){
            int n=scan.nextInt();
            int m=scan.nextInt();
            System.out.println("公倍数： "+CommonDivisorAndMultiple.GetCommonMultiple(m,n));//打印公倍数和公约数
            System.out.println("公约数： "+CommonDivisorAndMultiple.GetCommonDivisor(m,n));
        }
        scan.close();
    }
}
