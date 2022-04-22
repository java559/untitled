package 正则表达式.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp03 {
    public static void main(String[] args) {
        String content = "uhanshunping uuhan sshan";
//        String regStr = "[a-z]";
//        String regStr = "[A-Z]";
//        String regStr = "abc";
//        String regStr = "(?i)abc";
//        String regStr = "[^0-9]";
//        String regStr = "^[0-9]\\-[a-z]+$";
//        String regStr = "han\\b";
        String regStr = "han\\B";

//        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到 "+matcher.group(0));
        }
    }
}
