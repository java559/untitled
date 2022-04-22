//package tankGame.tankGame06;
//
//import java.io.*;
//import java.util.Vector;
//
//@SuppressWarnings({"all"})
//public class Recorder {
//    private static int allEnemyTankNum = 0;
//    private static BufferedWriter bw = null;
//    private static BufferedReader br = null;
//    private static String recordFile = "src\\tankGame\\myRecord.txt";
//    private static Vector<EnemyTank> enemyTanks = null;
//    private static Vector<Node> nodes = new Vector<>();
//
//    public static Vector<Node> getNodesAndEnemyTankRecord() throws IOException {
//
//        br = new BufferedReader(new FileReader(recordFile));
//        allEnemyTankNum = Integer.parseInt(br.readLine());
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            String[] xyd = line.split(" ");
//            Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
//            nodes.add(node);
//        }
//        if (br != null) {
//            br.close();
//        }
//
//        return nodes;
//    }
//
//    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
//        Recorder.enemyTanks = enemyTanks;
//    }
//
//    public static String getRecordFile() {
//        return recordFile;
//    }
//
//    public static void keepRecord() throws IOException {
//        bw = new BufferedWriter(new FileWriter(recordFile));
//        bw.write(allEnemyTankNum + "");
//        bw.newLine();
//
//        for (int i = 0; i < enemyTanks.size(); i++) {
//            EnemyTank enemyTank = enemyTanks.get(i);
//            if (enemyTank.isLive) {
//                String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
//                bw.write(record);
//                bw.newLine();
//            }
//        }
//
//        if (bw != null) {
//            bw.close();
//        }
//    }
//
//    public static int getAllEnemyTankNum() {
//        return allEnemyTankNum;
//    }
//
//    public static void setAllEnemyTankNum(int allEnemyTankNum) {
//        Recorder.allEnemyTankNum = allEnemyTankNum;
//    }
//
//    public static void addAllEnemyTankNum() {
//        Recorder.allEnemyTankNum++;
//    }
//}
