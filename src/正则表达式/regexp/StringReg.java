package 正则表达式.regexp;

public class StringReg {
    public static void main(String[] args) {

        String content = "2000 年 5 月，JDK1.3、JDK1.4 和 J2SE1.3 相继发布，几周后其" +
                "获得了 Apple 公司 Mac OS X 的工业标准的支持。2001 年 9 月 24 日，J2EE1.3 发" +
                "布。2002 年 2 月 26 日，J2SE1.4 发布。自此 Java 的计算能力有了大幅提升";
        content = content.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println("content = " + content);

        content = "13988889999";
        if (content.matches("1(38|39)\\d{8}")) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }

        System.out.println("===================================");

        content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }


    }
}
