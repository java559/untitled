package 集合.Map;

import java.util.*;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("dc", "sl");
        map.put("wbq", "mr");
        map.put("sz", "mr");
        map.put("llb", null);
        map.put(null, "lyf");
        map.put("lh", "gxt");
        System.out.println(map);
        System.out.println("----------------------------------------------");

        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("----------------------------------------------");

        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("----------------------------------------------");

        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println("----------------------------------------------");

        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }
        System.out.println("----------------------------------------------");

        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        System.out.println("----------------------------------------------");

        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry = iterator2.next();
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());

        }
        System.out.println("----------------------------------------------");


    }
}
