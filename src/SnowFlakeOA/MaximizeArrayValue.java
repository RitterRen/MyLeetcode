package SnowFlakeOA;

public class MaximizeArrayValue {

    public static int solution(int[] arr) {
        int left = 0;
        int right = findMax(arr);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(arr, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private static int findMax(int[] arr) {
        int maxValue = Integer.MIN_VALUE;

        for (int num: arr) {
            maxValue = Math.max(num, maxValue);
        }

        return maxValue;
    }

    private static boolean check(int[] arr, int k) {
        int container = 0;

        for (int num: arr) {
            if (k > num) {
                container += k - num;
            } else {
                if (num > k && num - k > container) return false;
                container -= num - k;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] testCase1 = {1, 5, 7, 6};
        System.out.println(solution(testCase1) == 5);
    }
}
