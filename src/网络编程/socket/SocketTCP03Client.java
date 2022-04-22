package 网络编程.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket = " + socket);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferWriter.write("hello,server 字符流");
        bufferWriter.newLine();//插入一个换行符，表示结束
        bufferWriter.flush();//手动刷新

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        bufferWriter.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
