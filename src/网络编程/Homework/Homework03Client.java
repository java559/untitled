package 网络编程.Homework;

import 网络编程.upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws Exception {

        System.out.println("请输入文件名:");
        Scanner input = new Scanner(System.in);
        String next = input.next();

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        OutputStream outputStream = socket.getOutputStream();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
//        bw.write(next);
//        bw.newLine();
//        bw.flush();
        outputStream.write(next.getBytes());
        socket.shutdownOutput();

        //这里没接收到
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String destFilePath = "src\\网络编程\\Homework\\" + next;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        System.out.println("下载完成...");

        bos.close();
        bis.close();
//        bw.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
