package problem3_2;

public class Main {
    public static void main(String[] args) {
        RaceHorse r = new RaceHorse();
        r.go();
        RaceHorse.thread1 = new Thread1();
        RaceHorse.thread2 = new Thread2();
        RaceHorse.thread1.setPriority(4);//设置线程1的优先级
        RaceHorse.thread2.setPriority(6);//设置线程2的优先级
        RaceHorse.thread1.start();
        RaceHorse.thread2.start();
    }
}
