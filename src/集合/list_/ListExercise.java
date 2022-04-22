package 集合.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.add("ggg");
        list.add("hhh");
        list.add("iii");
        list.add("jjj");
        System.out.println(list);

        list.add(2, "韩顺平教育");
        System.out.println(list);

        System.out.println(list.get(4));

        list.remove(5);
        System.out.println(list);

        list.set(6, "asd");
        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }

    }
}
