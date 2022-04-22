package 常用类.String.StringBuffer;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("12121211123434534654512324123456.7815364587541");
        int index = str.indexOf(".");
        for (int i = 0; i < index - 3; i += 3) {
            str.insert(index - i - 3, ",");
        }
        System.out.println(str);
    }
}
