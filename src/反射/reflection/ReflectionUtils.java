package 反射.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_01() throws Exception {

        Class<?> personCls = Class.forName("反射.reflection.Person");

        System.out.println(personCls.getName());//获取全类名
        System.out.println(personCls.getSimpleName());//获取简单类名
        System.out.println("--------------------------------------------------");

        //获取所有public修饰的属性，包含本类和父类
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类public修饰的属性" + field.getName());
        }
        System.out.println("--------------------------------------------------");

        //获取奔雷总所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类总所有属性" + declaredField.getName());
        }
        System.out.println("--------------------------------------------------");

        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类public修饰的方法" + method.getName());
        }
        System.out.println("--------------------------------------------------");

        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法" + declaredMethod.getName());
        }
        System.out.println("--------------------------------------------------");

        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("本类public修饰的构造器" + constructor.getName());
        }
        System.out.println("--------------------------------------------------");

        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("本类总所有构造器" + declaredConstructor.getName());
        }
        System.out.println("--------------------------------------------------");

        System.out.println(personCls.getPackage());//以Package形式返回 包信息
        System.out.println("--------------------------------------------------");

        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的class对象" + superclass);
        System.out.println("--------------------------------------------------");

        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息" + anInterface);
        }
        System.out.println("--------------------------------------------------");

        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息" + annotation);
        }


    }

    @Test
    public void api_02() throws Exception {
        Class<?> personCls = Class.forName("反射.reflection.Person");

        //默认修饰符 0， public 1， private 2, protected 4, static 8, final 16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类总所有属性" + declaredField.getName()
                    + " 该属性的访问修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }
        System.out.println("--------------------------------------------------");


        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型=" + declaredMethod.getReturnType());

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }
        System.out.println("--------------------------------------------------");

        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("本类总所有构造器=" + declaredConstructor.getName());

            Class[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType.getName());
            }

        }

    }

}


class A {
    public String name;

    public void hi() {
    }

    public A() {
    }
}

interface IA {
}

interface IB {
}

@Deprecated
@SuppressWarnings("all")
class Person extends A implements IA, IB {

    public String name;
    protected int age;
    String job;
    private double sal;

    protected static int price;

    public Person() {
    }

    public Person(String name) {
    }

    private Person(String name, int age) {
    }

    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return " ";
    }

    void m3() {
    }

    private void m4() {
    }

}
