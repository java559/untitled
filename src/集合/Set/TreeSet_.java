package 集合.Set;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add("abc");
        System.out.println(treeSet);
    }
}
