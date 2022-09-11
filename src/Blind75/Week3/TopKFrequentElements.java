package Blind75.Week3;

//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 10971 👎 411

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequncyDict = new HashMap<>(); // num - frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return frequncyDict.get(o1) - frequncyDict.get(o2);
            }
        });
        //HashSet<Integer> heapCheck = new HashSet<>();

        for (int num: nums) {
            frequncyDict.put(num, frequncyDict.getOrDefault(num, 0) + 1);
        }

        for (int key: frequncyDict.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else {
                int freq1 = frequncyDict.get(key);
                int freq2 = frequncyDict.get(minHeap.peek());

                if (freq1 > freq2) {
                    minHeap.poll();
                    minHeap.add(key);
                }
            }
        }

        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}