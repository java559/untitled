package 常用类.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Arrays01 {
    public static void main(String[] args) {
        Integer[] integers = {1, 9, 8, 4};
        System.out.println(Arrays.toString(integers));

//        Arrays.sort(integers);
//        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;
            }
        });
        System.out.println(Arrays.toString(integers));

        //要求该数组有序
        int index = Arrays.binarySearch(integers, 805);
        System.out.println("index = " + index);

        Integer[] newArr = Arrays.copyOf(integers, integers.length + 1);
        System.out.println(Arrays.toString(newArr));

        Arrays.fill(newArr, 999);
        System.out.println(Arrays.toString(newArr));

        Integer[] newarr = {999, 999, 999, 999, 999};
        System.out.println(newArr.equals(newArr));
        System.out.println(Arrays.equals(newArr, newarr));

        List aslist = Arrays.asList(1, 2, 3, 4, 5, 8);
        System.out.println(aslist);
        System.out.println(aslist.getClass());

    }
}
