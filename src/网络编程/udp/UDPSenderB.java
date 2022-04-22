package 网络编程.udp;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        byte[] data = "hello 明天吃火锅~".getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("10.210.0.33"), 9999);

        socket.send(packet);

        byte[] buf = new byte[64 * 1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);

        int len = packet1.getLength();
        byte[] data1 = packet1.getData();
        String s = new String(data1, 0, len);
        System.out.println(s);

        socket.close();
        System.out.println("B端退出");

    }
}
