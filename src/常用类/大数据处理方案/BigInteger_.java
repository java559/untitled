package 常用类.大数据处理方案;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {

        BigInteger big = new BigInteger("440582200104163999");
        BigInteger big1 = new BigInteger("440582200104163999");
        BigInteger big2 = new BigInteger("100");
        System.out.println("big=" + big);
        System.out.println("big1=" + big1);

        System.out.println("big+big1=" + big.add(big1));
        System.out.println("big-big2=" + big.subtract(big2));
        System.out.println("big*big1=" + big.multiply(big1));
        System.out.println("big/big2=" + big.divide(big2));


    }
}

