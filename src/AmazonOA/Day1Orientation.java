package AmazonOA;

import java.util.Arrays;

public class Day1Orientation {
    public static void main(String[] args) {

    }

    public static int getMaxValue(int[] nums) {
        Arrays.sort(nums);
        nums[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) nums[i] = nums[i - 1] + 1;
        }

        return nums[nums.length - 1];
    }
}
