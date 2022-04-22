package 常用类.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_ {
    public static void main(String[] args) throws ParseException {

        Date d1 = new Date();
        System.out.println("当前日期：" + d1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1);
        System.out.println("当前日期：" + format);

        String s = "2021年11月18日 10:20:33 星期四";
        Date parse = sdf.parse(s);
        System.out.println("parse = "+parse);

    }
}
