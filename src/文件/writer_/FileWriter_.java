//package 文件.writer_;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class FileWriter_ {
//    public static void main(String[] args) throws IOException {
//        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ccc.txt";
//        FileWriter fileWriter = new FileWriter(filePath);
//
//        fileWriter.write('H');
//
//        char[] chars = {'a', 'b', 'c'};
//        fileWriter.write(chars);
//
//        fileWriter.write("韩顺平教育".toCharArray(),0,4);
//        fileWriter.write("你好北京~");
//        fileWriter.write("广州深圳",0,3);
//
//        fileWriter.close();
//    }
//}
