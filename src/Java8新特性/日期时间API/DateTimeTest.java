package Java8新特性.日期时间API;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateTimeTest {
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23,43);
        System.out.println(localDateTime1);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());

        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime4);

    }

    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        long l = instant.toEpochMilli();
        System.out.println(l);

        Instant instant1 = Instant.ofEpochMilli(1644493939393L);
        System.out.println(instant1);

    }

    @Test
    public void test3(){
        //方式一: 预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();

        //格式化: 日期-->字符串
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析: 字符串-->日期
        TemporalAccessor parse = formatter.parse("2022-02-10T20:02:22.784");
        System.out.println(parse);

        //方式二: 本地化相关的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        //方式三: 自定义的格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str3 = formatter2.format(LocalDateTime.now());
        System.out.println(str3);


    }
}
