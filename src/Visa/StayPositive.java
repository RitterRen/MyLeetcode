package Visa;

import java.util.List;

public class StayPositive {
    public static void main(String[] args) {
        int[] num = {3, -6, 5, -2, 1};
        System.out.println(minStart(num));
    }

    public static long minStart(int[] arr) {
        if (arr.length == 1) return 1;
        long accumulate = 0;
        long result = 0;

        for (Integer num : arr) {
            accumulate += num;
            if (accumulate < 1) {
                result += 1 - accumulate;
                accumulate = 1;
            }
        }

        return result;
    }
}
