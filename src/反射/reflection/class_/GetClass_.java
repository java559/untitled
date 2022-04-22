package 反射.reflection.class_;

import 反射.reflection.Car;

public class GetClass_ {
    public static void main(String[] args) throws Exception {
        String classAllPath = "reflection_.reflection.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);
        System.out.println(characterClass);
        System.out.println(booleanClass);

        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        System.out.println(type1);
        System.out.println(type2);

        System.out.println(integerClass.hashCode() == type1.hashCode());

    }
}
