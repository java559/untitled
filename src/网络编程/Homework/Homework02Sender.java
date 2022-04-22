package 网络编程.Homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Homework02Sender {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8889);

        System.out.println("请输入你的问题:");
        Scanner input = new Scanner(System.in);
        String next = input.next();

        byte[] data = next.getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("10.210.0.33"), 8888);
        socket.send(packet);

        byte[] buf = new byte[64 * 1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        int length = packet.getLength();
        data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        socket.close();



    }
}
