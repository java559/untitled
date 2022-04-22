package 网络编程.Homework;

import 网络编程.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

//        int len;
//        byte[] bytes = new byte[1024];
//        len = inputStream.read(bytes);
//        String s = new String(bytes, 0, len);
//        System.out.println(s);

        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\" + s;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();

        bos.close();
        bis.close();
        br.close();
//        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
