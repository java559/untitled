package 网络编程.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket = " + socket);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());

        socket.shutdownOutput();//设置结束标记

        InputStream inputStream = socket.getInputStream();
        int readLen = 0;
        byte[] bytes = new byte[1024];
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
