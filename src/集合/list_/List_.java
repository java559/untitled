package 集合.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add(1,"c");
        System.out.println(list);
        System.out.println(list.get(1));

        List list2 = new ArrayList();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list.addAll(list2);
        list.add(list2);
        System.out.println(list);

        list.remove(1);
        list.remove("a");
        System.out.println(list);

        list.set(2,"b");
        System.out.println(list);

        List returnlist = list.subList(0,2);
        System.out.println(returnlist);

    }
}
