package QQ.QQServer.qqserver.service;

import QQ.QQClient.qqcommon.MessageType;
import QQ.QQClient.qqcommon.Message;
import QQ.QQClient.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

@SuppressWarnings("all")
public class QQServer {

    private ServerSocket ss = null;
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("tom", new User("tom", "123456"));
        validUsers.put("jack", new User("jack", "123456"));
        validUsers.put("mike", new User("mike", "123456"));
    }

    private boolean checkUser(String userId, String passwd) {
        User user = validUsers.get(userId);
        if (user == null) {
            return false;
        }
        if (!(user.getPasswd().equals(passwd))) {
            return false;
        }
        return true;
    }

    public QQServer() {

        System.out.println("服务端在9999端口监听...");

        new Thread(new SendNewsToAllService()).start();

        try {
            ss = new ServerSocket(9999);
            while (true) {

                Socket socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();

                Message message = new Message();

                if (checkUser(u.getUserId(), u.getPasswd())) {

                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start();

                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);

                } else {
                    System.out.println("用户 id=" + u.getUserId() + " pwd=" + u.getPasswd() + "验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
