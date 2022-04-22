package 反射.Homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class Homework02 {
    public static void main(String[] args) throws Exception {

        Class<?> fileCls = Class.forName("java.io.File");

        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("-----------------------------------------------");

        Constructor<?> declaredConstructor = fileCls.getDeclaredConstructor(String.class);
        String fileAllPath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ggg.txt";
        Object file = declaredConstructor.newInstance(fileAllPath);
        Method createNewFile = fileCls.getMethod("createNewFile");
        createNewFile.invoke(file);

        System.out.println(file.getClass());
        System.out.println("创建文件成功");

    }
}
