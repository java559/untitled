package 集合.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("john");
        set.add("jack");
        set.add("aaaa");
        set.add("john");
        set.add(null);
        set.add(123);
        set.add(122);
        set.add(121);
        System.out.println(set);

        System.out.println("-------------------------------");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        System.out.println("-------------------------------");
        for (Object o : set) {
            System.out.println(o);
        }

    }
}
