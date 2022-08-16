package AmazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AmazonOA0818 {
    // 5, 8, 4, 4, 8, 2
    /*
    8 + 5 + 4 + 2 + 1 + 1
     */
    public static long findTotalExecutionTime(List<Integer> execution) {
        long result = 0;
        HashMap<Integer, Integer> dict = new HashMap<>();

        for (Integer num : execution) {
            putIntoDict(num, dict, 1);
        }

        while (dict.size() > 0) {
            for (int num : dict.keySet()) {
                int times = dict.get(num);
                dict.remove(num);
                if (times > 0) {
                    result += num;
                    times--;
                    if (times > 0) {
                        int newNum = (int)Math.ceil(num / 2);
                        putIntoDict(newNum, dict, times);
                    }
                }
                System.out.println("result = " + result);
                System.out.println("dict = " + dict);
            }
        }

        return result;
    }

    private static boolean putIntoDict(int num, HashMap<Integer, Integer> dict, int times) {
        if (!dict.containsKey(num)) {
            dict.put(num, times);
            return true;
        } else {
            int temp = dict.get(num);
            dict.put(num, temp + times);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 8, 4, 4, 8, 2};
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }

        System.out.println(findTotalExecutionTime(list1));

    }
}
