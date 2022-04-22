package 数据结构.集合;

import java.util.HashSet;

public class HashSet_ {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(10));
        System.out.println(set.add(3));
        System.out.println(set.add(3));
        System.out.println(set.add(6));
        System.out.println(set);

        System.out.println(set.contains(2));
        System.out.println(set.contains(3));

        System.out.println(set.remove(3));
        System.out.println(set.remove(2));

        System.out.println(set);
        System.out.println(set.size());
    }
}
