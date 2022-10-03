package AmazonOA;

import java.math.BigInteger;

public class BitProfit {
    public static void main(String[] args) {
        System.out.println(new BigInteger("111101011001010011111111111111", 2).intValue());
        System.out.println(IntegerToBinary(62));
        System.out.println(59|3);
    }

    private static String IntegerToBinary(int num) {
        return Integer.toBinaryString(num);
    }
}
