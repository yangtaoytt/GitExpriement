package problem3_3;

import java.net.Socket;
public class Client {//客户端
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",9999);
        Realization.upLoadFile(socket,"c:\\1.jpg");//调用上传方法，需要上传至服务端的文件为D:\\1.jpg
    }
}
