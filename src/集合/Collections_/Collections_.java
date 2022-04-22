package 集合.Collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("smith");
        arrayList.add("king");
        arrayList.add("king");
        arrayList.add("milan");
        System.out.println("arratList=" + arrayList);

        Collections.reverse(arrayList);//逆序
        System.out.println(arrayList);
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < 5; i++) {
            Collections.shuffle(arrayList);//随机排序
            System.out.println(arrayList);
        }
        System.out.println("---------------------------------------------------------------");

        Collections.sort(arrayList);//自然排序
        System.out.println(arrayList);
        System.out.println("---------------------------------------------------------------");

        Collections.sort(arrayList, new Comparator() {//自定义排序
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(arrayList);
        System.out.println("---------------------------------------------------------------");

        Collections.swap(arrayList, 1, 3);//交换
        System.out.println(arrayList);
        System.out.println("---------------------------------------------------------------");

        System.out.println(Collections.min(arrayList));
        System.out.println(Collections.max(arrayList));
        System.out.println("长度最大的元素=" + Collections.max(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));
        System.out.println("---------------------------------------------------------------");

        System.out.println("king出现的次数=" + Collections.frequency(arrayList, "king"));
        System.out.println("---------------------------------------------------------------");

        ArrayList dest = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest, arrayList);
        System.out.println("dest=" + dest);
        System.out.println("---------------------------------------------------------------");

        Collections.replaceAll(arrayList, "king", "王");//替换
        System.out.println("arratList=" + arrayList);

    }
}
