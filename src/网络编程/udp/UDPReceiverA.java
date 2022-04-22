package 网络编程.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[64 * 1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        System.out.println("接收端A 等待接收数据..");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        byte[] data1 = "好的，明天见".getBytes();
        DatagramPacket packet1 =
                new DatagramPacket(data1, data1.length, InetAddress.getByName("10.210.0.33"), 9998);
        socket.send(packet1);

        socket.close();
        System.out.println("A端退出");

    }
}
