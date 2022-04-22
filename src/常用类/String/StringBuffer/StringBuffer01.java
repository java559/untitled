package 常用类.String.StringBuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        String str = "asd";
        StringBuffer str1 = new StringBuffer();
        str1.append(str);
        System.out.println(str1);

        StringBuffer stringBuffer2 = new StringBuffer("hello");
        String str2 = stringBuffer2.toString();
        System.out.println(str2);

        String str3 = new String(stringBuffer2);
        System.out.println(str3);

        System.out.println("-----------------------------------------------------");

        StringBuffer strBuf1 = new StringBuffer();
        strBuf1.append("张三");
        strBuf1.append(",");
        strBuf1.append("hello");
        System.out.println(strBuf1);

        strBuf1.delete(1,3);
        System.out.println(strBuf1);

        strBuf1.replace(0,1,"李四,");
        System.out.println(strBuf1);

        strBuf1.insert(3,"小明,");
        System.out.println(strBuf1);

        System.out.println(strBuf1.length());
    }
}
