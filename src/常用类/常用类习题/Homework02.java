package 常用类.常用类习题;

public class Homework02 {
    public static void main(String[] args) {
        String username = "aaa";
        String password = "123456";
        String email = "asds@asd.asdwd.q";
        try {
            userRegister(username, password, email);
            System.out.println("恭喜你，注册成功~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void userRegister(String username, String password, String email) {
        if (username.length() < 2 || username.length() > 4)
            throw new RuntimeException("用户名长度不正确");

        if (!(password.length() == 6 && isDigital(password)))
        throw new RuntimeException("密码格式不正确");

        int i1 = email.indexOf("@");
        int i2 = email.lastIndexOf("@");
        int i3 = email.indexOf(".");
        if (!(i1 == i2 && i1 < i3))
            throw new RuntimeException("邮件格式不正确");

    }

    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9')
                return false;
        }
        return true;
    }

}
