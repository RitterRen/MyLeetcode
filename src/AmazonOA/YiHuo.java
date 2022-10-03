package AmazonOA;

import java.util.Arrays;
import java.util.Comparator;

public class YiHuo {
    public static void main(String[] args) {
        System.out.println(~(7 ^ 2));
        System.out.println(2 | 4);
        //System.out.println(Math.atan2(0, -1));

        int[] weight = {1, 4, 3};
        int[] value = {15, 30, 20};

        System.out.println(bagDP(weight, value, 4));
    }

    public static int bagDP(int[] weight, int[] value, int bagWeight) {
        int[][] dp = new int[weight.length][bagWeight + 1];
        for (int j = 1; j < bagWeight + 1; j++) {
            if (j >= weight[0]) dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagWeight + 1; j++) {
                int weigh = weight[i];
                int val = value[i];

                if (weigh > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weigh] + val);
                }
            }
        }

        System.out.println(4 & 1);

        return dp[weight.length - 1][bagWeight];
    }
}
