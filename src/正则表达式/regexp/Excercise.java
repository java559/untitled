package 正则表达式.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excercise {
    public static void main(String[] args) {
//        String content = "韩顺平教育";
//        String content = "515152";
//        String content = "731822115";
//        String content = "17322514199";
//        String content = "https://www.bilibili.com";
//        String content = "https://www.bilibili.com/video/BV1fh411y7R8?spm_id_from=333.999.0.0";
        String content = "https://www.bilibili.com/video/BV12L411c7ND?spm_id_from=333.1007.extension.content.click";

        //汉字
//        String regStr = "^[\u0391-\uffe5]+$";

        //邮政编码   1-9开头的六位数
//        String regStr = "^[1-9]\\d{5}$";

        //QQ号码    1-9开头的一个(5位数-10位数)
//        String regStr = "^[1-9]\\d{4,9}$";

        //手机号码   13，15，17，18 开头的11位数
//        String regStr = "^1(?:3|5|7|8)\\d{9}$";
//        String regStr = "^1[3|5|7|8]\\d{9}$";

        //URL
        String regStr = "^((https|http)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if(matcher.find()){
            System.out.println("满足格式");
        }else{
            System.out.println("不满足格式");
        }

    }
}
