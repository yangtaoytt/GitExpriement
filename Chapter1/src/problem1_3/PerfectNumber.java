package problem1_3;
import java.util.Scanner;
public class PerfectNumber {
    private static int Getfactor(int i){//给传入的i找到所有因子并返回因子的和
        int res=0;
        for (int j = 1; j <i ; j++) {
            if(i%j==0){
                res+=j;
            }
        }
        return res;
    }
    public static void GetPerfect(int n){//利用定义，如果因子和为本身即为完美数
        for (int i = 1; i <=n ; i++) {
            if(Getfactor(i)==i){
                System.out.println(i);
            }

        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        if(scan.hasNext()) {
            int n = scan.nextInt();
            PerfectNumber.GetPerfect(n);//调用静态函数
        }
        scan.close();
    }
}
