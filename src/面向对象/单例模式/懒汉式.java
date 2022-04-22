package 面向对象.单例模式;

public class 懒汉式 {
    public static void main(String[] args) {
        System.out.println(Wife.n1);

        Wife instance = Wife.getInstance();
        System.out.println(instance);

        Wife instance1 = Wife.getInstance();
        System.out.println(instance1);
    }
}

class Wife{
    private String name;
    public static int n1 = 999;
    private static Wife wife;

    private Wife(String name){
        System.out.println("构造器被调用");
        this.name = name;
    }

    public static Wife getInstance(){
        if (wife==null)
            wife = new Wife("ziMing");
        return wife;
    }
}

