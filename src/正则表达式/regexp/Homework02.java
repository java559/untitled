package 正则表达式.regexp;

public class Homework02 {
    public static void main(String[] args) {
        String content = "-0.086";
        String regStr = "[-+]?([1-9]\\d*|0)(\\.\\d+)?";
        if (content.matches(regStr)) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }
}
