package 数据结构.哈希表;

import java.util.HashMap;

public class HashMap_ {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"hanmeimei");
        map.put(2,"lihua");
        map.put(3,"siyangyuan");
        System.out.println(map);

        map.put(1,"bishi");
        System.out.println(map);

        System.out.println(map.get(1));

        map.remove(2);
        System.out.println(map);

        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue("siyangyuan"));

        System.out.println(map.size());

        System.out.println(map.isEmpty());

    }
}
