package 常用类.包装类;

public class WrapperVSString {
    public static void main(String[] args) {
        Integer i = 100;
        String str1 = i + "";
        String str2 = i.toString();
        String str3 = String.valueOf(i);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        String str = "12345";
        Integer i1 = Integer.parseInt(str);
        Integer i2 = new Integer(str);
        System.out.println(i1);
        System.out.println(i2);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
