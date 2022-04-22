package 网络编程.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");

        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket);

        InputStream inputStream = socket.getInputStream();
        int readLen = 0;
        byte[] bytes = new byte[1024];
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());

        socket.shutdownOutput();//设置结束标记

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
