package 常用类.常用类习题;

public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {

        if (!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        int i = start, j = end;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static String reverse(String str) {
        return reverse(str, 0, str.length() - 1);
    }

}
