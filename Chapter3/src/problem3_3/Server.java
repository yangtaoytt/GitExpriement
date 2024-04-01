package problem3_3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
public class Server {//服务端
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);//创建服务端,端口号9999
        System.out.println("服务器连接成功！");//与客户端连接
        Socket socket = serverSocket.accept();
        String fileName = "我的下载文件"+".jpg";//输出的文件名
        Realization.downLoadFile(socket,fileName); //从服务端下载文件
    }
}

