package 常用类.包装类;

public class WrapperExercise {
    public static void main(String[] args) {
        Object obj1 = true? new Integer(1): new Double(2.0);
        System.out.println(obj1);

        Object obj2;
        if (true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2);

    }
}
