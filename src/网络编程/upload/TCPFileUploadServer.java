package 网络编程.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(888);
        System.out.println("服务端，在888端口监听，等待连接...");

        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket);

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String destFilePath = "src\\网络编程\\bhg.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();
        bufferedWriter.close();

        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
