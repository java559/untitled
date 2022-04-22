package 正则表达式.regexp;

public class Homework01 {
    public static void main(String[] args) {
        String content = "hsp@shu.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        if (content.matches(regStr)) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }
}
