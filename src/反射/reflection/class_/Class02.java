package 反射.reflection.class_;

import 反射.reflection.Car;

import java.lang.reflect.Field;

@SuppressWarnings("all")
public class Class02 {
    public static void main(String[] args) throws Exception {

        String classAllPath = "reflection_.reflection.Car";
        Class<?> cls = Class.forName(classAllPath);

        System.out.println(cls);

        System.out.println(cls.getClasses());

        System.out.println(cls.getPackage().getName());

        System.out.println(cls.getName());

        Car car = (Car) cls.newInstance();
        System.out.println(car);

        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        brand.set(car, "BengChi");
        System.out.println(brand.get(car));

        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName() + " = " + f.get(car));
        }


    }
}
