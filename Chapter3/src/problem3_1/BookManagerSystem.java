package problem3_1;

import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/*设计一个简单的图书管理系统，该系统使用集合保存图书信息，
 * 包括书名、作者、出版社、刊号、出版日期、页数和摘要，实现图书的插入、删除、查找功能。
 * 插入、删除时要显示操作是否正确与否的提示信息；查找时按关键字值进行查找，并显示查找结果 */
public class BookManagerSystem {
    JFrame MainFrame;
    JButton buttonAdd, buttonDelete, buttonFind, buttonPrint;  //选项按钮: 图书的插入、删除、查找、显示
    JPanel buttonPanel, textPanel, inputPanel;  //选项按钮的面板容器 放置选项按钮//文本域的面板容器 放置文本域 //输入的面板容器
    JPanel panelName, panelAuthor, panelPublic, panelNumber, panelDate, panelPages, panelAbstraction;  //书名、作者、出版社、刊号、出版日期、页数和摘要
    JTextArea outputTextArea;  //输出文本域
    JTextField txtName, txtAuthor, txtPublic, txtNumber, txtDate, txtPages, txtAbstraction;  //文本域 输入对应信息
    JScrollPane scrollPane;  //滚动条
    Container contentPane;
    private List<Book> bookStore = new ArrayList<>();//数组，存储书籍的全部信息

    public BookManagerSystem()//初始化  //构造器
    {
        MainFrame = new JFrame("一个图书管理系统");
        panelName = new JPanel();
        panelAuthor = new JPanel();
        panelPublic = new JPanel();
        panelNumber = new JPanel();
        panelDate = new JPanel();
        panelPages = new JPanel();
        panelAbstraction = new JPanel();

        txtName = new JTextField();
        txtAuthor = new JTextField();
        txtPublic = new JTextField();
        txtNumber = new JTextField();
        txtDate = new JTextField();
        txtPages = new JTextField();
        txtAbstraction = new JTextField();

        Border border = BorderFactory.createEtchedBorder();//创建蚀刻边框
        Border buttonBorder = BorderFactory.createTitledBorder(border, "功能区");//为面板添加标题
        Border inputBorder = BorderFactory.createTitledBorder(border, "操作区");
        Border outputBorder = BorderFactory.createTitledBorder(border, "展示区");

        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        initInputPanel(inputBorder);
        initOutputPanel(outputBorder);
        initButtonPanel(buttonBorder);
        onClickListener();

        contentPane = MainFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(textPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束窗口所在的应用程序。在窗口被关闭的时候会退出JVM。
        MainFrame.setSize(1000, 400);
        MainFrame.setVisible(true);
    }

    public void initInputPanel(Border border) //初始化输入组件
    {
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 20));  //网格模式
        initInputTextField(panelName, "    书名：   ", txtName);
        initInputTextField(panelAuthor, "作者：   ", txtAuthor);
        initInputTextField(panelPublic, "    出版社：", txtPublic);
        initInputTextField(panelNumber, "期刊号：", txtNumber);
        initInputTextField(panelDate, "出版日期：", txtDate);
        initInputTextField(panelPages, "页数：   ", txtPages);
        initInputTextField(panelAbstraction, "    摘要：   ", txtAbstraction);
        inputPanel.setBorder(border);
        textPanel.add(inputPanel, BorderLayout.CENTER);
    }

    public void initOutputPanel(Border border) //初始化输出组件（输出文本域）
    {
        outputTextArea = new JTextArea();
        outputTextArea.setSize(1000, 300);
        scrollPane = new JScrollPane(outputTextArea);//需要时出现 垂直/水平滚动条
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(border);
        textPanel.add(scrollPane);
    }

    public void initButtonPanel(Border border)//初始化按钮组件
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        buttonPanel.setBorder(border);

        buttonAdd = new JButton("添加图书信息");
        buttonDelete = new JButton("删除图书信息");
        buttonFind = new JButton("查找图书");
        buttonPrint = new JButton("显示所有图书信息");

        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonDelete);
        buttonPanel.add(buttonFind);
        buttonPanel.add(buttonPrint);
    }

    public void initInputTextField(JPanel panel, String str, JTextField textField)//初始化输入文本域
    {
        textField.setPreferredSize(new Dimension(60, 5));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel(str, JLabel.CENTER), BorderLayout.EAST);
        panel.add(textField, BorderLayout.WEST);
        panel.setPreferredSize(new Dimension(100, 30));
        inputPanel.add(panel);
    }

    public void onClickListener()//按钮事件监听器
    {
        buttonAdd.addActionListener(e ->//添加图书信息
        {
            if (txtName.getText().equals("") || txtNumber.getText().equals("") ||
                    txtAuthor.getText().equals("") || txtPublic.getText().equals("") ||
                    txtPages.getText().equals("") || txtDate.getText().equals("") ||
                    txtAbstraction.getText().equals(""))//只要所有输入的文本域中，有任意一个或者多个为空，说明图书信息没有填全。
            {
                JOptionPane.showMessageDialog(MainFrame, "请填写完整的图书信息！", "警告", JOptionPane.ERROR_MESSAGE);//缺少图书信息，则弹出错误提示窗口
            } else//如果信息完整就把这本书添加到系统中。
            {
                Book book = new Book();
                book.setName(txtName.getText());
                book.setAuthor(txtAuthor.getText());
                book.setPublics(txtPublic.getText());
                book.setNumber(txtNumber.getText());
                book.setDate(txtDate.getText());
                book.setPages(txtPages.getText());
                book.setAbs(txtAbstraction.getText());
                bookStore.add(book);  //将新书添加进集合
                JOptionPane.showMessageDialog(MainFrame, "图书信息添加成功！", "提示", JOptionPane.PLAIN_MESSAGE);
            }
            //清空输入文本域
            txtName.setText("");
            txtAuthor.setText("");
            txtPublic.setText("");
            txtNumber.setText("");
            txtDate.setText("");
            txtPages.setText("");
            txtAbstraction.setText("");
        });
        buttonDelete.addActionListener((ActionListener) e ->//删除图书信息
        {
            outputTextArea.setText("");//清空输出框内的文本信息
            if (txtName.getText().equals(""))//当关键词为空时
            {
                JOptionPane.showMessageDialog(MainFrame, "请输入需要删除的书名！", "警告", JOptionPane.ERROR_MESSAGE);
            } else //关键字不空
            {
                String bName = txtName.getText();
                boolean isDelete = false;  //是否找到需要删除的书
                for (Book b : bookStore) {
                    if (b.getName().equals(bName)) //如果找到了需要删除的书
                    {
                        isDelete = true;
                        outputTextArea.append("已删除书籍：\n" + "书名:" + b.getName() + ", 作者:" + b.getAuthor() +
                                ", 出版社:" + b.getPublics() + ", 期刊号:" + b.getNumber() + ", 出版日期:" + b.getDate() +
                                ", 页数:" + b.getPages() + "\n" + "  摘要：" + b.getAbs() + "\n");
                        bookStore.remove(b);  //从集合中删去该书
                        JOptionPane.showMessageDialog(MainFrame, "图书删除成功！", "提示", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
                if (!isDelete) //在集合中未找到相关的书
                {
                    JOptionPane.showMessageDialog(MainFrame, "未找到相关图书！", "警告", JOptionPane.ERROR_MESSAGE);//ERROR_MESSAGE会输出带×的图标
                }
            }
        });
        buttonFind.addActionListener((ActionListener) e -> //查找图书
        {
            outputTextArea.setText("");
            if (txtName.getText().equals("")) //如果关键词为空
            {
                JOptionPane.showMessageDialog(MainFrame, "请输入需要查找的书名！", "警告", JOptionPane.ERROR_MESSAGE);
            } else {
                String name = txtName.getText();
                boolean isFound = false;  //是否找到需要查找的书
                outputTextArea.append("包含关键词 \"" + name + "\" 的书：\n");
                for (Book b : bookStore) {
                    if (b.getName().contains(name)) //找到书
                    {
                        isFound = true;
                        outputTextArea.append("书名:《" + b.getName() + "》,  作者: " + b.getAuthor() + ",  出版社: " + b.getPublics() + ",  期刊号: " + b.getNumber() + ",  出版日期: " + b.getDate() + ",  页数: " + b.getPages() + "\n" + "\t 摘要：" + b.getAbs() + "\n");
                        //break;  //相关图书可能不止一本
                    }
                }
                if (!isFound) //如果在集合中未找到相关的书
                {
                    JOptionPane.showMessageDialog(MainFrame, "未找到相关图书！", "警告", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPrint.addActionListener((ActionListener) e -> //打印所有的图书信息
        {
            outputTextArea.setText("");
            for (Book b : bookStore) //直接遍历，逐条打印图书信息。
            {
                outputTextArea.append("书名:《" + b.getName() + "》,  作者:" + b.getAuthor() + ",  出版社:" + b.getPublics() + ",  期刊号:" + b.getNumber() + ",  出版日期:" + b.getDate() + ",  页数:" + b.getPages() + "\n" + "\t 摘要：" + b.getAbs() + "\n");
            }
        });
    }


}

