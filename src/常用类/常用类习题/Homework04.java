package 常用类.常用类习题;

public class Homework04 {
    public static void main(String[] args) {
        String str = "asdfghs41g5fd3ESGDSsda5gf4SD";
        printMessage(str);
    }

    public static void printMessage(String str) {
        int BCount = 0, SCount = 0, NCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                NCount++;
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                SCount++;
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                BCount++;
        }
        System.out.println("大写字母：" + BCount + " 小写字母：" + SCount + " 数字：" + NCount);
    }
}
