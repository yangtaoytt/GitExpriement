package problem1_1;

import java.util.Scanner;
//this is a motify
public class PrimeNumber {
    public static void GetPrime(int n){
        if(n<=2)return;
        for(int i=2;i<=n;i++) {
            boolean flag=true;//用一个布尔值保存当前值是否为素数
            for (int j = 2; j < i; j++) {
                if(i%j==0) {
                    flag=false;
                    break;//不是素数了，直接break出去
                }
            }
            if(flag) {
                System.out.println(i);//如果flag为true说明是素数需要打印
            }
        }
    }
    public static void main(String[] args) {
        /*


        bool is_prime(int x)
        {
            if (x < 2) return false;
            for (int i = 2; i <= x / i; i ++ )
                if (x % i == 0)
                    return false;
            return true;
        }

        int main()
        {
            int n;
            cin >> n;

            while (n -- )
            {
                int x;
                cin >> x;
                if (is_prime(x)) puts("Yes");
                else puts("No");
            }

            return 0;
        }

         */
        Scanner scan=new Scanner(System.in);

        System.out.print("输入一个正整数：");
        if(scan.hasNext()){
            int n=scan.nextInt();
            PrimeNumber.GetPrime(n);
        }
        scan.close();//及时关闭scaner

    }
}
