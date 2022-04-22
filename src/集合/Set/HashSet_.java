package 集合.Set;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {

        Set set = new HashSet();
        System.out.println(set.add(null));
        System.out.println(set.add(1));
        System.out.println(set.add(null));
        System.out.println(set.add(1));
        System.out.println(set.add("asd"));

        System.out.println(set.remove(1));
        System.out.println(set);

        System.out.println("-----------------------------------------------------");
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add("lucy"));
        System.out.println(hashSet.add("lucy"));
        System.out.println(hashSet.add(new Dog("tom")));
        System.out.println(hashSet.add(new Dog("tom")));
        System.out.println(hashSet);

        System.out.println("-----------------------------------------------------");
        System.out.println(hashSet.add(new String("hsp")));
        System.out.println(hashSet.add(new String("hsp")));
        System.out.println(hashSet);

    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
