package 常用类.System;

import java.util.Arrays;

public class System01 {
    public static void main(String[] args) {
//        System.out.println("ok1");
//        System.exit(0);
//        System.out.println("ok2");

        int[] src = {1, 2, 3};
        int[] dest = new int[3];
        /**
         * @param      src      the source array.
         * @param      srcPos   starting position in the source array.
         * @param      dest     the destination array.
         * @param      destPos  starting position in the destination data.
         * @param      length   the number of array elements to be copied.
         */
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println(Arrays.toString(dest));

        /**
         * @return the difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC.
         */
        System.out.println(System.currentTimeMillis());

    }
}
