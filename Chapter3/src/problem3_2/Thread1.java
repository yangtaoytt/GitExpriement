package problem3_2;

import javax.swing.*;

class Thread1 extends Thread//线程1
{
    public void run()
    {
        while (RaceHorse.pb1.getValue() < 100 && RaceHorse.pb2.getValue() < 100)
        {
            RaceHorse.pb1.setValue(RaceHorse.pb1.getValue()+(int)(Math.random()*2));
            try
            {
                Thread.sleep((int)(Math.random()*50));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(RaceHorse.pb1.getValue() == 100 && RaceHorse.pb2.getValue() != 100)//制定比赛规则，先为100的胜出。
            {
                JOptionPane.showMessageDialog(null,"1号黑马胜出！");
                break;
            }
            else if(RaceHorse.pb2.getValue() == 100 && RaceHorse.pb1.getValue() != 100)
            {
                JOptionPane.showMessageDialog(null,"2号白马胜出！");
                break;
            }
            else if(RaceHorse.pb1.getValue() == 100 && RaceHorse.pb2.getValue() == 100)
            {
                JOptionPane.showMessageDialog(null,"双方平局！");
                break;
            }
        }
    }
}
