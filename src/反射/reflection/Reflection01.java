package 反射.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings("all")
public class Reflection01 {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\reflection_\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass());
        Method method1 = cls.getMethod(methodName);
        System.out.println("=============================================");
        method1.invoke(o);

//        Field nameField = cls.getField("name");   //不能获取私有属性
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));

        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);

    }
}
