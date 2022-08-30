package GoldmanSacha_OA;

import java.util.Arrays;
import java.util.Comparator;

public class CardinalitySorting {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(cardinalitySorting(nums1)));
    }

    public static Integer[] cardinalitySorting(int[] nums) {
        Integer[] integerArr = Arrays.stream(nums)
                                            .boxed()
                                            .toArray(Integer[]::new);

        Arrays.sort(integerArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int binaryOne_o1 = getBinaryOne(o1);
                int binaryOne_o2 = getBinaryOne(o2);

                if (binaryOne_o1 != binaryOne_o2) {
                    return binaryOne_o1 - binaryOne_o2;
                }else {
                    return o1 - o2;
                }
            }
        });

        return integerArr;
    }

    private static int getBinaryOne(int num) {
        int one_times = 0;

        while (num > 0) {
            if (num % 2 != 0) one_times++;
            num /= 2;
        }

        return one_times;
    }
}
