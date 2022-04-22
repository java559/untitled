//package 文件.writer_;
//
//import java.io.*;
//
//public class BufferedCopy_ {
//    public static void main(String[] args) throws IOException {//只能拷贝纯文本文件
//        String srcFilePath = "C:\\Users\\destiny\\PycharmProjects\\untitled2\\爬取豆瓣图书.py";
//        String destFilePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\爬取豆瓣图书.txt";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFilePath));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
//        String line;
//        while ((line = bufferedReader.readLine()) != null){
//            bufferedWriter.write(line);
//            bufferedWriter.newLine();
//        }
//        bufferedReader.close();
//        bufferedWriter.close();
//        System.out.println("拷贝完毕");
//    }
//}
