package 网络编程.Homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

@SuppressWarnings({"all"})
public class Homework02Receiver {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buf = new byte[64 * 1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        String answer = "";
        if (s.equals("四大名著是哪些")) {
            answer = "四大名著是....";
        }

        data = answer.getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getByName("10.210.0.33"), 8889);
        socket.send(packet);

        socket.close();

    }
}
