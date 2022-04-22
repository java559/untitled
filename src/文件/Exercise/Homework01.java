//package 文件.Exercise;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Homework01 {
//    public static void main(String[] args) throws IOException {
//        String directoryPath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\a\\b\\d";
//        File file = new File(directoryPath);
//        if (file.exists()) {
//            System.out.println(directoryPath + "存在");
//        } else {
//            if (file.mkdirs()) {
//                System.out.println(directoryPath + "创建成功");
//            } else {
//                System.out.println(directoryPath + "创建失败");
//            }
//        }
//        String filePath = directoryPath + "\\hello.txt";
//        file = new File(filePath);
//        if (!file.exists()) {
//            if (file.createNewFile()) {
//                System.out.println(filePath + "创建成功");
//
//                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//                bw.write("hello,world~~~~");
//                bw.close();
//            } else {
//                System.out.println(filePath + "创建失败");
//            }
//        }else{
//            System.out.println(filePath + "存在");
//        }
//
//    }
//}
