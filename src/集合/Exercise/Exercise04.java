package 集合.Exercise;

import java.util.TreeSet;

@SuppressWarnings({"all"})
public class Exercise04 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());
        treeSet.add(new Person());
        treeSet.add(new Person());
        treeSet.add(new Person());
        System.out.println(treeSet);
    }
}
class Person implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}