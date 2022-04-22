package QQ.QQServer.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings("all")
public class ManageClientThreads {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    public static String getOnlineUser() {
        String onlineUserList = "";
//        Set<String> strings = hm.keySet();
//        for (String str : strings) {
//            onlineUserList += hm.get(str) + " ";
//        }

        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;

    }

}
