package 集合.Map;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "jieke");
        treeMap.put("tom", "tangmu");
        treeMap.put("kristina", "krstn");
        treeMap.put("smith", "shimisi");
        treeMap.put("hsp","hanshunping");
        System.out.println(treeMap);
    }
}
