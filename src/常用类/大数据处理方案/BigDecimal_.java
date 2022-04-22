package 常用类.大数据处理方案;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {

        BigDecimal big = new BigDecimal("12.1111111111111111111111111111333333333333333333333333555555555555555555555");
        BigDecimal big1 = new BigDecimal("3.3");
        System.out.println("big=" + big);
        System.out.println("big1=" + big1);

        System.out.println("big+big1=" + big.add(big1));
        System.out.println("big-big1=" + big.subtract(big1));
        System.out.println("big*big1=" + big.multiply(big1));
        System.out.println("big/big1=" + big.divide(big1,BigDecimal.ROUND_CEILING));

    }
}
