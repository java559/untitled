package 反射.Homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class Homework01 {
    public static void main(String[] args) throws Exception {

        Class<PrivateTest> privateTestClass = PrivateTest.class;
        PrivateTest privateTest = privateTestClass.newInstance();

        Field name = privateTestClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(privateTest));
        name.set(privateTest, "hiKitty");
        System.out.println(name.get(privateTest));

        Method getName = privateTestClass.getDeclaredMethod("getName");
        Object invoke = getName.invoke(privateTest);
        System.out.println(invoke);

    }
}

@SuppressWarnings("all")
class PrivateTest {
    private String name = "helloKitty";

    public String getName() {
        return name;
    }
}
