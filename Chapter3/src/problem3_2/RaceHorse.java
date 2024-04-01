package problem3_2;

import javax.swing.*;
import java.awt.*;
public class RaceHorse
{
    JFrame jFrame;
    JPanel jPanel;
    JLabel jLabel1, jLabel2;
    static JProgressBar pb1, pb2;//进度条组件对象
    static Thread thread1, thread2;//线程对象
    //yeep,yeep,yeep
    void go()
    {
        jFrame = new JFrame("赛马程序");
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));//2x2网格布局
        jLabel1 = new JLabel("1号黑马");
        jLabel2 = new JLabel("2号白马");
        pb1 = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);//设置水平方向的进度条
        pb2 = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);//min=0,max=100
        jPanel.add(jLabel1);  jPanel.add(pb1);  jPanel.add(jLabel2);  jPanel.add(pb2);//面板添加组件
        jFrame.getContentPane().add(jPanel, BorderLayout.CENTER);//在窗口中间放置面板
        jFrame.setSize(350, 100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口则进程结束
    }

}


