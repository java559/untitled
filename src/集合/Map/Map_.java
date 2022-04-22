package 集合.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        System.out.println(map.put("no1", "hsp"));
        System.out.println(map.put("no2", "zs"));
        System.out.println(map.put("no2", "zs"));
        System.out.println(map.put(3, "z4s"));
        System.out.println(map.put(3, "z5s"));
        System.out.println(map.put(4, "z5s"));
        System.out.println(map.put(null, "z5s"));
        System.out.println(map.put(new Object(), 13456));

        System.out.println(map);
        System.out.println(map.get(null));
        System.out.println(map.get("no2"));

        map.remove("no2");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println("-------------------------------------------------");

        Map map_ = new HashMap();
        map_.put("no1", "tom");
        map_.put("no2", "tom1");
        map_.put("no3", "tom2");
        Set set = map_.entrySet();
        System.out.println(set.getClass());
        for (Object obj : set) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("-------------------------------------------------");


    }
}
