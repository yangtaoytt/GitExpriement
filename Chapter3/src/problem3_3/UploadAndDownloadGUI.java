package problem3_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UploadAndDownloadGUI
{
    private JFrame jFrame;
    JTextArea jtf1=new JTextArea(5,31);
    public UploadAndDownloadGUI()
    {
        jFrame = new JFrame();
        jFrame.setLayout(null);
        ImageIcon  bg = new ImageIcon("背景图片.jpeg");
        JLabel  label  =  new JLabel(bg);//建立图像文本
        label.setSize(700,500);//设置图片的大小
        jFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到最底层
        JPanel pan =  (JPanel)jFrame.getContentPane();//将内容窗口设为透明
        pan.setOpaque(false);
        pan.setLayout(new FlowLayout());

        jFrame.setTitle("文件上传和下载系统");
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        JLabel k = new JLabel("文件上传下载系统");
        k.setBounds(150,60,300,200);
        Font font = new Font("楷体",Font.BOLD,55);
        k.setFont(font);
        k.setForeground(Color.white);
        p1.add(k);
        jFrame.getContentPane().add(p1, BorderLayout.NORTH);

        Font font1 = new Font("宋体",Font.PLAIN,29);

        jtf1.setFont(font1);
        jtf1.setForeground(Color.BLACK);//字体颜色
        jtf1.setLineWrap(true);
        jtf1.setWrapStyleWord(true);
        jtf1.isEditable();
        JScrollPane j=new JScrollPane(jtf1);

        p2.add(j);
        jFrame.getContentPane().add(p2, BorderLayout.WEST);

        Font font2=new Font("黑体",Font.BOLD,35);
        JToggleButton tb1 = new JToggleButton("退   出");
        tb1.setFont(font2);
        ImageIcon Icon= new ImageIcon("退出.jpeg");
        Icon.setImage(Icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));//设置按钮内照片大小
        tb1.setIcon(Icon);//把照片加入到按钮中
        tb1.setIconTextGap(10);//设置按钮中照片和文字的间隔大小
        ItemListener i1 = new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                JToggleButton tb = (JToggleButton) e.getSource();//取得事件源
                if (tb == tb1)
                {
                    jFrame.setVisible(false);
                }
            }
        };
        tb1.addItemListener(i1);//事件监听器(匿名类）
        p3.add(tb1);
        jFrame.getContentPane().add(p3, BorderLayout.SOUTH);
        jFrame.setSize(600,500);//设置窗口的大小
        jFrame.setLocationRelativeTo(null);//设置窗口的位置
        jFrame.setResizable(false);//设置窗口的大小不能改变
    }
    public void SetData(boolean UploadFile,boolean DownloadFile)
    {
        jtf1.setText("");
        jtf1.append("请在此输入您想要上传的文件：");
        jtf1.append("\n");
        if(UploadFile==true) {
            jtf1.append("文件已经成功上传到服务器！");
        }else{
            jtf1.append("文件上传失败！");
        }
        if(DownloadFile==true) {
            jtf1.append("文件已经成功下载到");
        }else{
            jtf1.append("文件下载失败！");
        }
    }
    public void SetVisible(boolean its)
    {
        jFrame.setVisible(its);
    }
    public static void main(String[] args)
    {
        UploadAndDownloadGUI gui = new UploadAndDownloadGUI();
        gui.SetData(true,true);
        gui.SetVisible(true);
    }
}