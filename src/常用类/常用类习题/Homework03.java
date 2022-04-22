package 常用类.常用类习题;

import java.util.Arrays;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Han shun Ping";
        printName(name);
    }

    public static void printName(String name) {

        if (name == null) {
            System.out.println("输入的字符串不能为空");
            return;
        }

        String[] strs = name.split(" ");
        if (strs.length != 3) {
            System.out.println("字符串格式不正确");
            return;
        }

//        String newName = strs[2] + "," + strs[0] + " ." + strs[1].substring(0, 1).toUpperCase();
        String newName = String.format("%s,%s .%s", strs[2], strs[0], strs[1].substring(0, 1).toUpperCase());
        System.out.println(newName);
    }
}
