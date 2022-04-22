package 文件.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings({"all"})
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Java\\韩顺平 2021零基础学Java 【软件 资料 代码 笔记】\\资料\\分享资料\\Utility.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();

    }
}
