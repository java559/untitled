package 面向对象.单例模式;

public class 饿汉式 {
    public static void main(String[] args) {

        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance1);

        System.out.println(instance == instance1);

    }
}

class GirlFriend{
    private String name;

    private GirlFriend(String name){
        System.out.println("构造器被调用");
        this.name = name;
    }

    private static GirlFriend gf = new GirlFriend("小红");

    public static GirlFriend getInstance(){
        return gf;
    }

}

