package QQ.QQClient.qqclient.service;

import QQ.QQClient.qqcommon.MessageType;
import QQ.QQClient.qqcommon.User;
import QQ.QQClient.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("all")
public class UserClientService {

    private User u = new User();
    private Socket socket;

    public boolean checkUser(String userId, String pwd) throws IOException, ClassNotFoundException {

        boolean b = false;

        u.setUserId(userId);
        u.setPasswd(pwd);

        socket = new Socket(InetAddress.getByName("10.210.0.33"), 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();

        if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {

            //ClientConnectServerThread
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();

            ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
            b = true;

        } else {
            socket.close();
        }

        return b;
    }

    public void onlineFriendList() throws IOException {

        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        ClientConnectServerThread ccst = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
        Socket socket = ccst.getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);

    }

    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());

        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
