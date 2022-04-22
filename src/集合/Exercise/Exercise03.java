package 集合.Exercise;

import java.util.*;

@SuppressWarnings({"all"})
public class Exercise03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println(hashMap);

        hashMap.put("jack", 2600);
        System.out.println(hashMap);

        Set set = hashMap.keySet();
        for (Object key : set) {
            hashMap.put(key, (Integer) hashMap.get(key) + 100);
        }
        System.out.println(hashMap);

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object entry = iterator.next();
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m);
        }

        Collection values = hashMap.values();
        for (Object value :values) {
            System.out.println(value);
        }


    }
}
