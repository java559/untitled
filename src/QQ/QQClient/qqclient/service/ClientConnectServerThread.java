package QQ.QQClient.qqclient.service;

import QQ.QQClient.qqcommon.Message;
import QQ.QQClient.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

@SuppressWarnings("all")
public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("客户端线程，等待读取从服务端发送的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {

                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n================当前在线用户列表================");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户: " + onlineUsers[i]);
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {

                    System.out.println("\n" + message.getSender()
                            + " 对 " + message.getGatter() + " 说: " + message.getContent());

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {

                    System.out.println("\n" + message.getSender() + " 对大家说: " + message.getContent());

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {

                    System.out.println("\n" + message.getSender() + " 给 " + message.getGatter()
                            + " 发文件: " + message.getSrc() + " 到我的电脑目录 " + message.getDest());
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("保存文件成功");

                } else {
                    System.out.println("是其他类型的message, 暂时不处理...");
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
