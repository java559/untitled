package 网络编程.Homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        String answer;
        if (s.equals("name")){
            answer = "nova";
//            System.out.println("nova");
        }else if (s.equals("hobby")){
            answer = "编写java程序";
//            System.out.println("编写java程序");
        }else{
            answer = "你说啥呢";
//            System.out.println("你说啥呢");
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
