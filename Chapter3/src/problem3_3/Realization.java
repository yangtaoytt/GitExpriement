package problem3_3;

import java.io.*;
import java.net.Socket;
public class Realization
{//实现方法类
    public static void downLoadFile(Socket socket, String filename){
        //该方法用于服务端,下载文件
        try {
            InputStream is = socket.getInputStream();//获取到网络字节输入流对象
            File file = new File("d:\\homeworkJava");//创建d:\\homeworkJava文件夹
            if(!file.exists())
                file.mkdirs();
            FileOutputStream fos = new FileOutputStream(file+"\\"+filename);//创建一个输出文件,并指明要输出的地址。
            int len = 0;
            byte []arr = new byte[1024];
            while ((len=is.read(arr))!=-1){// 判断是否到了文件末尾
                fos.write(arr,0,len);//把读取到的文件写入到文件中，实现文件下载
            }
            socket.getOutputStream().write(("文件已经成功下载到"+file+"文件夹下").getBytes());//提示用户下载完成，展示文件下载路径
            socket.getOutputStream().write(("下载的文件名为："+filename).getBytes());//展示文件名
            fos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean upLoadFile(Socket socket, String filename){//用于客户端,上传文件
        try {
            FileInputStream fis = new FileInputStream(filename);//读取源文件并输出到服务器
            OutputStream os = socket.getOutputStream();
            int len =0;
            byte arr[] = new byte[1024];
            while ((len=fis.read(arr))!=-1){
                os.write(arr,0,len);//把读取的文件上传到服务器
            }
            System.out.println("文件已经成功上传至服务器！");//提示用户上传成功
            socket.shutdownOutput();//上传完文件,标记结束
            InputStream is = socket.getInputStream();//读取回写的内容,相应之前的"上传成功"
            while ((len=is.read(arr))!=-1)
                System.out.println(new String(arr,0,len));
            fis.close();
            socket.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

