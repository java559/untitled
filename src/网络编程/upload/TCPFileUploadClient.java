package 网络编程.upload;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 888);
        System.out.println("客户端 socket = " + socket);

        String filePath = "D:\\Java\\韩顺平 2021零基础学Java 【软件 资料 代码 笔记】\\资料\\分享资料\\bhg.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        inputStream.close();

        bos.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
